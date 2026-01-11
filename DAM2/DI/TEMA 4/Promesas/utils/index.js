const seleccionPaises = document.getElementById("paises");
const seleccionEquipos = document.getElementById("equipos");
const listaJugadores = document.getElementById("jugadores");

console.log("Pidiendo países a la API");

fetch("https://www.thesportsdb.com/api/v1/json/123/all_countries.php")
  .then(respuesta => {
    console.log("Respuesta países:", respuesta);
    return respuesta.json();
  })
  .then(datos => {
    console.log("Datos recibidos de países:", datos);

    if (!datos.countries) {
      console.log("No se han recibido países");
      return;
    }

    datos.countries.forEach(pais => {
      console.log("Añadiendo país:", pais.name_en);

      const opcionPais = document.createElement("option");
      opcionPais.value = pais.name_en;
      opcionPais.textContent = pais.name_en;
      seleccionPaises.appendChild(opcionPais);
    });
  })
  .catch(() => console.log("Error en la conexión de países"));

seleccionPaises.addEventListener("change", () => {
  const paisSeleccionado = seleccionPaises.value;
  console.log("País seleccionado:", paisSeleccionado);

  seleccionEquipos.innerHTML = "";
  listaJugadores.innerHTML = "";

  if (!paisSeleccionado) {
    console.log("No se ha seleccionado ningún país");
    return;
  }

  console.log("Pidiendo equipos del país:", paisSeleccionado);

  fetch(
    `https://www.thesportsdb.com/api/v1/json/123/search_all_teams.php?s=Soccer&c=${paisSeleccionado}`
  )
    .then(respuesta => {
      console.log("Respuesta equipos:", respuesta);
      return respuesta.json();
    })
    .then(datos => {
      console.log("Datos recibidos de equipos:", datos);

      if (!datos.teams) {
        console.log("No hay equipos para este país");
        seleccionEquipos.textContent = "No hay equipos para este país";
        return;
      }

      datos.teams.forEach(equipo => {
        console.log("Equipo encontrado:", equipo.strTeam);

        const cartaEquipo = document.createElement("div");
        cartaEquipo.className = "card";
        cartaEquipo.textContent = equipo.strTeam;
        cartaEquipo.style.cursor = "pointer";

        cartaEquipo.addEventListener("click", () => {
          console.log("Equipo seleccionado:", equipo.strTeam);
          cargarPlantilla(equipo.idTeam);
        });

        seleccionEquipos.appendChild(cartaEquipo);
      });
    })
    .catch(() => console.log("Error en la conexión de equipos"));
});

function cargarPlantilla(idEquipo) {
  console.log("Cargando plantilla del equipo con id:", idEquipo);

  listaJugadores.innerHTML = "";

  fetch(
    `https://www.thesportsdb.com/api/v1/json/123/lookup_all_players.php?id=${idEquipo}`
  )
    .then(respuesta => {
      console.log("Respuesta plantilla:", respuesta);
      return respuesta.json();
    })
    .then(datos => {
      console.log("Datos recibidos de plantilla:", datos);

      if (!datos.player) {
        console.log("No hay jugadores para este equipo");
        listaJugadores.innerHTML = "<li>No hay jugadores</li>";
        return;
      }

      datos.player.forEach(jugador => {
        console.log("Jugador encontrado:", jugador.strPlayer);

        const cartaJugador = document.createElement("li");
        cartaJugador.className = "card";
        cartaJugador.textContent = jugador.strPlayer;

        listaJugadores.appendChild(cartaJugador);
      });
    })
    .catch(() => console.log("Error en la conexión de la plantilla"));
}

