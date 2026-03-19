# Gestion_Turnos

##Casos de Uso##

CU-01. Gestionar docentes

-Objetivo: Permitir al administrador registrar, consultar, actualizar y eliminar docentes del sistema.
-Actor principal: Administrador del sistema.
-Actores secundarios: Ninguno.
-Precondiciones: El administrador accede al módulo de gestión institucional.
-Postcondiciones: El docente queda creado, actualizado o eliminado en la base de datos.

Flujo principal

1. El administrador ingresa al módulo de docentes.
2. El sistema muestra el listado de docentes registrados.
3. El administrador selecciona la opción “Nuevo docente”.
4. El sistema muestra el formulario de registro.
5. El administrador diligencia nombre, apellido, correo, estado activo y carga de turnos.
6. El administrador confirma el registro.
7. El sistema valida la información.
8. El sistema guarda el docente.
9. El sistema muestra mensaje de confirmación.

Flujos alternos

7A. Si el correo ya existe, el sistema rechaza el registro e informa el error.
7B. Si faltan campos obligatorios, el sistema solicita completarlos.
3A. El administrador también puede seleccionar un docente existente para editarlo o eliminarlo.

Reglas de negocio

-El correo del docente debe ser único.
-La carga de turnos no puede ser negativa.

CU-02. Gestionar zonas de vigilancia

-Objetivo: Permitir al administrador definir las zonas o sectores del campus donde habrá vigilancia.
-Actor principal: Administrador del sistema.
-Precondiciones: El administrador ha iniciado sesión en el sistema o accede al módulo correspondiente en la fase de diseño.
-Postcondiciones: La zona queda registrada y disponible para asignación de turnos e incidentes.

Flujo principal

1. El administrador ingresa al módulo de zonas.
2. El sistema muestra las zonas existentes.
3. El administrador selecciona “Nueva zona”.
4. El sistema despliega el formulario.
5. El administrador ingresa nombre, descripción, bloque y estado.
6. El administrador guarda la información.
7. El sistema valida y registra la zona.
8. El sistema actualiza el listado.

Flujos alternos

-Si el nombre de la zona ya existe, el sistema informa duplicidad.
-Si la zona está inactiva, no podrá usarse en nuevos turnos.

Reglas de negocio

-El nombre de la zona debe ser único.
-Toda zona debe poder asociarse a turnos e incidentes.

CU-03. Cargar turnos y asignaciones

-Objetivo: Permitir al administrador registrar la programación de turnos por docente, fecha, franja horaria y zona.
-Actor principal: Administrador del sistema.
-Precondiciones: Existen docentes y zonas registradas.
-Postcondiciones: El turno queda creado y visible en el calendario.

Flujo principal

1. El administrador accede al módulo de turnos.
2. El sistema muestra el calendario o listado de turnos.
3. El administrador selecciona “Nuevo turno”.
4. El sistema muestra el formulario de asignación.
5. El administrador selecciona fecha, hora inicio, hora fin, docente, zona y estado.
6. El administrador guarda el turno.
7. El sistema valida la información.
8. El sistema registra el turno y lo añade al calendario.

Flujos alternos

-Si el docente ya tiene un turno en la misma franja, el sistema rechaza la asignación.
Si la zona no está activa, el sistema no permite asignarla.

Reglas de negocio

-Un docente no puede tener dos turnos simultáneos.
-Todo turno debe tener una zona y un docente asociados.

CU-04. Consultar calendario de turnos

-Objetivo: Permitir consultar la programación de turnos de forma visual y ordenada.
-Actores principales: Docente en turno, Coordinador de nivel, Administrador.
-Precondiciones: Existen turnos cargados en el sistema.
-Postcondiciones: El actor visualiza los turnos filtrados o completos.

Flujo principal

1. El actor ingresa al módulo de calendario.
2. El sistema muestra los turnos programados.
3. El actor filtra por fecha, zona o docente.
4. El sistema actualiza la vista.
5. El actor consulta el detalle del turno seleccionado.

Flujos alternos

-Si no existen turnos en el filtro aplicado, el sistema muestra mensaje de “sin resultados”.

Reglas de negocio

-El calendario debe mostrar estado del turno: pendiente, en curso o cerrado, según el enunciado.

CU-05. Enviar notificaciones previas al turno

Objetivo: Recordar al docente que debe iniciar su turno.
Actor principal: Sistema.
Actor secundario: Docente en turno.
Precondiciones: Existe un turno próximo al horario actual.
Postcondiciones: El docente recibe la notificación correspondiente.

Flujo principal

El sistema identifica turnos próximos a iniciar.

El sistema genera una notificación faltando 10 minutos.

El sistema genera una segunda notificación faltando 5 minutos.

La notificación incluye hora exacta, lugar exacto y acceso directo a abrir turno.

El docente visualiza la notificación.

Flujos alternos

Si el turno fue cancelado, no se envía notificación.

Si el docente ya inició el turno, se omiten notificaciones posteriores.

Reglas de negocio

Deben existir recordatorios automáticos previos de 10 y 5 minutos.

CU-06. Registrar inicio de turno / check-in

Objetivo: Permitir al docente confirmar el inicio efectivo de la vigilancia.
Actor principal: Docente en turno.
Actor secundario: Sistema.
Precondiciones: El docente tiene un turno programado y vigente.
Postcondiciones: El turno pasa a estado cubierto o en curso y queda trazabilidad del registro.

Flujo principal

El docente abre su turno desde la notificación o desde el calendario.

El sistema muestra la pantalla del turno con zona, ventana de inicio y estado.

El docente ejecuta el check-in.

El sistema registra fecha y hora del check-in.

El sistema cambia el estado del turno.

El tablero del coordinador actualiza la zona como cubierta.

Flujos alternos

Si el check-in se intenta fuera de la ventana permitida, el sistema genera advertencia.

Si falla el método principal, se puede usar alternativa como PIN o NFC según el diseño completo.

Reglas de negocio

El registro debe dejar evidencia temporal.

La cobertura visible del tablero cambia a verde tras el registro.

CU-07. Visualizar tablero en vivo de cobertura

Objetivo: Permitir al coordinador monitorear el estado de las zonas en tiempo real.
Actor principal: Coordinador de nivel.
Precondiciones: Existen turnos activos o por iniciar.
Postcondiciones: El coordinador visualiza el estado de cobertura y puede actuar.

Flujo principal

El coordinador abre el tablero en vivo.

El sistema muestra estados por zona:

verde: cubierta,

amarillo: por iniciar,

rojo: sin cobertura.

El coordinador filtra por franja horaria o zona.

El sistema muestra docente asignado, hora de registro, estado de recorrido y acceso rápido a reasignar.

El coordinador identifica zonas críticas y toma decisiones.

Flujos alternos

Si no hay turnos activos en la franja, el tablero informa que no existen datos.

Reglas de negocio

Debe existir una vista operativa mínima con filtros y estado de cobertura.

CU-08. Generar alerta por ausencia de cobertura

Objetivo: Alertar cuando una zona queda sin registro de inicio de turno después del umbral definido.
Actor principal: Sistema.
Actor secundario: Coordinador de nivel.
Precondiciones: El turno no ha sido iniciado dentro del tiempo esperado.
Postcondiciones: Se genera una alerta visible y accionable.

Flujo principal

El sistema monitorea el tiempo transcurrido desde el inicio del turno.

Si pasan 2 minutos sin check-in, el sistema genera la alerta.

El sistema notifica al coordinador con zona, docente, tiempo transcurrido y botón “Reasignar”.

El coordinador revisa la alerta y decide actuar.

Flujos alternos

Si el docente registra check-in antes del umbral, no se genera la alerta.

Si la alerta ya fue atendida, el sistema la marca como gestionada.

Reglas de negocio

El disparo automático de la alerta ocurre tras 2 minutos sin inicio.

CU-09. Confirmar recorrido activo

Objetivo: Verificar que el docente no permanezca estático y realice vigilancia activa.
Actor principal: Docente en turno.
Actor secundario: Sistema.
Precondiciones: El turno se encuentra en curso.
Postcondiciones: El sistema registra evidencia de recorrido.

Flujo principal

El sistema detecta ausencia de evidencia de recorrido durante X minutos.

El sistema muestra la opción “Confirmar recorrido”.

El docente registra el recorrido mediante escaneo de checkpoint o confirmación rápida.

El sistema guarda la evidencia.

El sistema actualiza el estado de recorrido del turno.

Flujos alternos

Si el docente no confirma, el sistema puede generar alerta de baja actividad.

Si el checkpoint falla, puede usarse confirmación rápida según configuración.

Reglas de negocio

La confirmación rápida no debe reemplazar sistemáticamente el recorrido real.

CU-10. Registrar incidente

Objetivo: Permitir al docente registrar rápidamente una situación ocurrida durante el turno.
Actor principal: Docente en turno.
Actores secundarios: Coordinador, Sistema.
Precondiciones: Existe un turno en curso o una observación asociable a una zona.
Postcondiciones: El incidente queda registrado y disponible para reportes y analítica.

Flujo principal

El docente accede al módulo de incidentes.

El sistema muestra un formulario de registro rápido.

El docente selecciona el tipo de incidente desde una lista desplegable.

El docente selecciona la severidad.

El docente registra la descripción.

El docente selecciona la zona y el turno asociado.

El docente confirma el envío.

El sistema valida la información.

El sistema guarda el incidente.

El sistema actualiza reportes y estadísticas.

Flujos alternos

Si faltan datos obligatorios, el sistema no permite guardar.

Si el tipo o severidad no son válidos, el sistema solicita corrección.

Reglas de negocio

El registro debe poder realizarse en máximo 3 pasos.

El tipo de incidente debe clasificarse por categorías.

La severidad se define como S1, S2 o S3 en el diseño funcional original.

CU-11. Registrar limpieza al cierre del turno

Objetivo: Permitir al docente registrar el estado de limpieza observado al finalizar el turno.
Actor principal: Docente en turno.
Precondiciones: El turno está próximo a cerrarse o ha finalizado.
Postcondiciones: Queda registrada la calificación de limpieza.

Flujo principal

El docente accede al cierre del turno.

El sistema muestra la escala de limpieza de 1 a 4.

El docente selecciona el nivel correspondiente.

El docente confirma el registro.

El sistema guarda la información y cierra el turno.

Flujos alternos

Si el docente intenta cerrar el turno sin calificar limpieza, el sistema lo solicita como obligatorio.

Reglas de negocio

La escala es obligatoria y va de 1 a 4.

CU-12. Solicitar reasignación por impedimento

Objetivo: Permitir al docente informar que no podrá cubrir su turno.
Actor principal: Docente en turno.
Actores secundarios: Sistema, Coordinador.
Precondiciones: Existe un turno pendiente o por iniciar.
Postcondiciones: Se inicia el flujo de reemplazo.

Flujo principal

El docente ingresa a su turno.

El docente selecciona el botón “No puedo llegar al turno”.

El sistema solicita motivo del impedimento.

El docente confirma la solicitud.

El sistema registra la solicitud y activa la búsqueda de reemplazo.

El coordinador visualiza el caso en el tablero.

Flujos alternos

Si el turno ya fue iniciado, el sistema limita o modifica la operación.

Si el docente cancela la solicitud, no se genera reemplazo.

Reglas de negocio

Debe existir trazabilidad de quién activó la reasignación y cuándo.

CU-13. Proponer reemplazos automáticos

Objetivo: Sugerir automáticamente docentes disponibles para cubrir un turno desatendido o liberado.
Actor principal: Sistema.
Actor secundario: Coordinador de nivel.
Precondiciones: Existe un turno sin cobertura o con solicitud de reemplazo.
Postcondiciones: Se genera una lista de candidatos sugeridos.

Flujo principal

El sistema identifica el turno que requiere reemplazo.

El sistema consulta los docentes disponibles.

El sistema filtra docentes sin turno en el bloque.

El sistema prioriza por menor carga y cercanía.

El sistema presenta las sugerencias al coordinador.

El coordinador selecciona una opción o deja que el sistema notifique al candidato.

Flujos alternos

Si no hay candidatos disponibles, el sistema informa al coordinador.

Si varios candidatos tienen condiciones similares, el sistema los muestra ordenados por prioridad.

Reglas de negocio

La propuesta debe considerar disponibilidad, menor carga y cercanía.

CU-14. Aceptar o rechazar reemplazo

Objetivo: Permitir que el docente candidato responda a una propuesta de reemplazo.
Actor principal: Docente candidato a reemplazo.
Actores secundarios: Sistema, Coordinador.
Precondiciones: Existe una propuesta de reemplazo activa.
Postcondiciones: La reasignación queda aceptada o rechazada.

Flujo principal

El sistema envía una notificación de reemplazo al docente candidato.

El sistema muestra datos del turno y el tiempo disponible para responder.

El docente acepta o rechaza la propuesta.

El sistema registra la respuesta.

Si acepta, el turno se reasigna.

El coordinador visualiza el resultado en el tablero.

Flujos alternos

Si el docente no responde dentro del tiempo, la propuesta expira.

Si rechaza, el sistema busca el siguiente candidato.

Reglas de negocio

La ventana de aceptación debe estar entre 30 y 60 segundos.

CU-15. Consultar mapas de calor y reportes

Objetivo: Permitir al coordinador analizar zonas y franjas con mayor incidencia.
Actor principal: Coordinador de nivel.
Actor secundario: Administrador.
Precondiciones: Existen incidentes registrados.
Postcondiciones: El actor obtiene información útil para prevención y toma de decisiones.

Flujo principal

El actor accede al módulo de analítica.

El sistema muestra mapa de calor por zona.

El actor filtra por franja horaria o tipo de incidente.

El sistema actualiza la visualización.

El actor consulta indicadores de puntualidad, cobertura, retrasos y tiempos de respuesta.

El actor interpreta la información para ajustar vigilancia y operación.

Flujos alternos

Si no existen incidentes en el periodo, el sistema muestra reporte vacío.

Si el usuario cambia filtros, el sistema recalcula los indicadores.

Reglas de negocio

Los mapas de calor deben considerar zona, franja y tipo de incidente.

Deben existir indicadores mínimos de puntualidad, cobertura, retrasos, actividad de recorrido y tiempos de respuesta.

CU-16. Exportar reportes

Objetivo: Permitir extraer información consolidada para análisis externo o seguimiento institucional.
Actor principal: Coordinador de nivel.
Actor secundario: Administrador.
Precondiciones: Existen reportes generados o datos consolidados.
Postcondiciones: El sistema genera un archivo descargable.

Flujo principal

El actor accede al módulo de reportes.

El actor selecciona filtros y periodo.

El actor elige formato de exportación.

El sistema procesa la información.

El sistema genera el archivo.

El actor descarga el reporte.

Flujos alternos

Si no hay datos en el periodo, el sistema informa que no hay información exportable.

Reglas de negocio

Debe permitirse exportación a CSV o Excel y generación de reportes semanales.

CU-17. Configurar reglas operativas del sistema

Objetivo: Permitir al administrador ajustar parámetros de operación del sistema.
Actor principal: Administrador del sistema.
Precondiciones: El administrador accede al módulo de configuración.
Postcondiciones: Las reglas quedan almacenadas y aplican a la operación posterior.

Flujo principal

El administrador ingresa a configuración.

El sistema muestra los parámetros actuales.

El administrador modifica tiempos, umbrales y escalamiento.

El administrador guarda los cambios.

El sistema valida y actualiza la configuración.

Flujos alternos

Si el valor ingresado es inválido, el sistema rechaza el cambio.

Si el cambio afecta reglas críticas, el sistema solicita confirmación.

Reglas de negocio

El administrador define reglas operativas como tiempos, umbrales y escalamiento.

