package edu.javeriana.gestionturnos.config;

import edu.javeriana.gestionturnos.batch.DocenteItemProcessor;
import edu.javeriana.gestionturnos.batch.TurnoCsvRow;
import edu.javeriana.gestionturnos.batch.TurnoItemProcessor;
import edu.javeriana.gestionturnos.batch.ZonaItemProcessor;
import edu.javeriana.gestionturnos.entity.Docente;
import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.entity.Zona;
import edu.javeriana.gestionturnos.repository.DocenteRepository;
import edu.javeriana.gestionturnos.repository.TurnoRepository;
import edu.javeriana.gestionturnos.repository.ZonaRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public FlatFileItemReader<Docente> docenteReader() {
        return new FlatFileItemReaderBuilder<Docente>()
                .name("docenteReader")
                .resource(new ClassPathResource("data/docentes.csv"))
                .linesToSkip(1)
                .recordSeparatorPolicy(new DefaultRecordSeparatorPolicy())
                .delimited()
                .delimiter(",")
                .names("nombre", "apellido", "correo", "activo", "cargaTurnos")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Docente.class);
                }})
                .build();
    }

    @Bean
    public FlatFileItemReader<Zona> zonaReader() {
        return new FlatFileItemReaderBuilder<Zona>()
                .name("zonaReader")
                .resource(new ClassPathResource("data/zonas.csv"))
                .linesToSkip(1)
                .recordSeparatorPolicy(new DefaultRecordSeparatorPolicy())
                .delimited()
                .delimiter(",")
                .names("nombre", "descripcion", "bloque", "activa")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Zona.class);
                }})
                .build();
    }

    @Bean
    public FlatFileItemReader<TurnoCsvRow> turnoReader() {
        return new FlatFileItemReaderBuilder<TurnoCsvRow>()
                .name("turnoReader")
                .resource(new ClassPathResource("data/turnos.csv"))
                .linesToSkip(1)
                .recordSeparatorPolicy(new DefaultRecordSeparatorPolicy())
                .delimited()
                .delimiter(",")
                .names("fecha", "horaInicio", "horaFin", "estado", "correoDocente", "nombreZona")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(TurnoCsvRow.class);
                }})
                .build();
    }

    @Bean
    public RepositoryItemWriter<Docente> docenteWriter(DocenteRepository docenteRepository) {
        RepositoryItemWriter<Docente> writer = new RepositoryItemWriter<>();
        writer.setRepository(docenteRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public RepositoryItemWriter<Zona> zonaWriter(ZonaRepository zonaRepository) {
        RepositoryItemWriter<Zona> writer = new RepositoryItemWriter<>();
        writer.setRepository(zonaRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public RepositoryItemWriter<Turno> turnoWriter(TurnoRepository turnoRepository) {
        RepositoryItemWriter<Turno> writer = new RepositoryItemWriter<>();
        writer.setRepository(turnoRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step docenteStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<Docente> docenteReader,
            DocenteItemProcessor docenteItemProcessor,
            RepositoryItemWriter<Docente> docenteWriter
    ) {
        return new StepBuilder("docenteStep", jobRepository)
                .<Docente, Docente>chunk(10, transactionManager)
                .reader(docenteReader)
                .processor(docenteItemProcessor)
                .writer(docenteWriter)
                .build();
    }

    @Bean
    public Step zonaStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<Zona> zonaReader,
            ZonaItemProcessor zonaItemProcessor,
            RepositoryItemWriter<Zona> zonaWriter
    ) {
        return new StepBuilder("zonaStep", jobRepository)
                .<Zona, Zona>chunk(10, transactionManager)
                .reader(zonaReader)
                .processor(zonaItemProcessor)
                .writer(zonaWriter)
                .build();
    }

    @Bean
    public Step turnoStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<TurnoCsvRow> turnoReader,
            TurnoItemProcessor turnoItemProcessor,
            RepositoryItemWriter<Turno> turnoWriter
    ) {
        return new StepBuilder("turnoStep", jobRepository)
                .<TurnoCsvRow, Turno>chunk(10, transactionManager)
                .reader(turnoReader)
                .processor(turnoItemProcessor)
                .writer(turnoWriter)
                .build();
    }

    @Bean
    public Job cargaInicialJob(
            JobRepository jobRepository,
            @Qualifier("docenteStep") Step docenteStep,
            @Qualifier("zonaStep") Step zonaStep,
            @Qualifier("turnoStep") Step turnoStep
    ) {
        return new JobBuilder("cargaInicialJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(docenteStep)
                .next(zonaStep)
                .next(turnoStep)
                .build();
    }
}