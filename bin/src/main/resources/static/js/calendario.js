/* ========================= */
/* CALENDARIO DE TURNOS */
/* ========================= */

document.addEventListener("DOMContentLoaded", function () {

    let calendarEl = document.getElementById("calendar");

    if (!calendarEl) return;

    fetch("/turnos/calendario")
        .then(response => response.json())
        .then(data => {

            let eventos = data.map(turno => ({
                title: turno.docente + " - " + turno.zona,
                start: turno.fecha + "T" + turno.horaInicio,
                end: turno.fecha + "T" + turno.horaFin
            }));

            let calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: "dayGridMonth",
                locale: "es",
                events: eventos
            });

            calendar.render();
        });
});