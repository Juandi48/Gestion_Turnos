/* ========================= */
/* FILTROS DE TABLAS */
/* ========================= */

function filtrarTabla(inputId, tableId) {

    let input = document.getElementById(inputId);
    let filter = input.value.toLowerCase();
    let table = document.getElementById(tableId);

    let tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {

        let tds = tr[i].getElementsByTagName("td");
        let mostrar = false;

        for (let j = 0; j < tds.length; j++) {

            if (tds[j]) {
                let texto = tds[j].textContent || tds[j].innerText;

                if (texto.toLowerCase().indexOf(filter) > -1) {
                    mostrar = true;
                }
            }
        }

        tr[i].style.display = mostrar ? "" : "none";
    }
}