package edu.javeriana.gestionturnos.batch;
/*import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CargaInicialJobRunner implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job cargaInicialJob;

    public CargaInicialJobRunner(JobLauncher jobLauncher, Job cargaInicialJob) {
        this.jobLauncher = jobLauncher;
        this.cargaInicialJob = cargaInicialJob;
    }

    @Override
    public void run(String... args) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();

        JobExecution execution = jobLauncher.run(cargaInicialJob, jobParameters);

        System.out.println("==========================================");
        System.out.println("ESTADO DEL JOB DE CARGA INICIAL: " + execution.getStatus());
        System.out.println("==========================================");
    }
}*/