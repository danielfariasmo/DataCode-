/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JMenuItem;

import modelo.ConexionBBDD;
import modelo.Juega;
import modelo.Miembro;
import modelo.Partida;
import modelo.Personaje;
import vistas.ConsultarPartida;
import vistas.InfoPartidaJugador;
import vistas.JugarPersonaje;
import vistas.MenuPrincipalUsuario;
import vistas.MiembroClub;
import vistas.ModificarPersonaje;
import vistas.MostrarPersonaje;
import vistas.NuevoPersonaje;
import vistas.PartidaActual;
import vistas.TextoMenuPrincipal;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Clase ControlMenuPrincipalUsuario implementa ActionListener para manejar los
 * eventos del menú principal.
 */
public class ControlMenuPrincipalUsuario implements ActionListener {

	private MenuPrincipalUsuario menuPrincipal;
	private NuevoPersonaje nuevoPersonaje;
	private ConsultarPartida consultarPartida;
	private MiembroClub miembroClub;
	private ModificarPersonaje modificarPersonaje;
	private MostrarPersonaje mostrarPersonaje;
	private TextoMenuPrincipal textoMenuPrincipal;
	private Miembro miembro;
	private JugarPersonaje jugarPersonaje;
	private ConexionBBDD conexionbbdd;
	private InfoPartidaJugador infoPartidaJugador;
	private PartidaActual partidaActual;
	private ControlJugarPersonaje controlJugarPersonaje;

	/**
	 * Constructor para inicializar los componentes del menú principal.
	 *
	 * @param menuPrincipal      el menú principal
	 * @param nuevoPersonaje     el panel para crear un nuevo personaje
	 * @param miembroClub        el panel para mostrar los miembros del club
	 * @param modificarPersonaje el panel para modificar un personaje
	 * @param textoMenuPrincipal el texto del menú principal
	 * @param partidaActual      el panel de la partida actual
	 * @param miembro            el miembro actual
	 */
	public ControlMenuPrincipalUsuario(MenuPrincipalUsuario menuPrincipal, NuevoPersonaje nuevoPersonaje,
			MiembroClub miembroClub, ModificarPersonaje modificarPersonaje, TextoMenuPrincipal textoMenuPrincipal,
			PartidaActual partidaActual, Miembro miembro) {
		this.controlJugarPersonaje = new ControlJugarPersonaje(miembro, this);
		this.menuPrincipal = menuPrincipal;
		this.nuevoPersonaje = nuevoPersonaje;
		this.consultarPartida = new ConsultarPartida(this);
		this.miembroClub = miembroClub;
		this.modificarPersonaje = modificarPersonaje;
		this.mostrarPersonaje = new MostrarPersonaje(this);
		this.textoMenuPrincipal = textoMenuPrincipal;
		this.jugarPersonaje = controlJugarPersonaje.getJugarPersonaje();
		this.partidaActual = partidaActual;
		this.miembro = miembro;
		this.infoPartidaJugador = new InfoPartidaJugador(this);
	}

	/**
	 * Maneja los eventos de acción realizados en el menú principal.
	 *
	 * @param evento el evento de acción
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		// Cambia el panel al de creación de nuevo personaje
		if (evento.getSource() instanceof JMenuItem) {
			if (evento.getActionCommand().equals("Nuevo Personaje")) {
				menuPrincipal.cambiarPanel(nuevoPersonaje);
				// Muestra la pantalla de consulta de partida
			} else if (evento.getActionCommand().equals("Consultar Partida")) {
				consultarPartida();
				// Cambia el panel al de mostrar miembros
			} else if (evento.getActionCommand().equals("Mostrar Miembros")) {
				menuPrincipal.cambiarPanel(miembroClub);

				ConexionBBDD conexionBBDD = new ConexionBBDD();
				ArrayList<Miembro> miembros = conexionBBDD.obtenerMiembros();

				if (miembros != null) {
					for (Miembro miembro : miembros) {
						System.out.println(miembro);
					}

					miembroClub.insertarMiembros(miembros);

				} else {
					System.out.println("No se pudieron obtener los miembros.");
				}
				// Cambia el panel al de modificar personaje
			} else if (evento.getActionCommand().equals("Modificar Personaje")) {
				menuPrincipal.cambiarPanel(modificarPersonaje);
				// Muestra los personajes del miembro actual
			} else if (evento.getActionCommand().equals("Mostrar Personajes")) {
				mostrarPersonajes();
				// Cambia el panel al de jugar con personaje
			} else if (evento.getActionCommand().equals("Jugar")) {
				menuPrincipal.cambiarPanel(jugarPersonaje);
				// Muestra las partidas actuales
			} else if (evento.getActionCommand().equals("Partidas Actuales")) {
				cambioPanelPartidaActual();
				// Cambia al panel del menú principal
			} else if (evento.getActionCommand().equals("Menú")) {
				menuPrincipal.cambiarPanel(textoMenuPrincipal);

			}
		}

	}

	/**
	 * Elimina un personaje de la base de datos.
	 *
	 * @param personaje el personaje a eliminar
	 */
	public void eliminarPersonaje(Personaje personaje) {
		// Crea una nueva instancia de la conexión a la base de datos.
		conexionbbdd = new ConexionBBDD();

		try {
			// Intenta eliminar el personaje utilizando su ID.
			conexionbbdd.elminarPersonaje(personaje.getIdPersonaje());
			// Si la eliminación es exitosa, muestra un mensaje indicando que el personaje
			// ha sido eliminado.
			mostrarPersonaje.mensaje(true, "Se ha elminiado el personaje " + personaje.getNombre());
			// Llama al método para actualizar la lista de personajes mostrados.
			mostrarPersonajes();
		} catch (Exception e) {
			// Si ocurre un error (por ejemplo, si no se selecciona un personaje), muestra
			// un mensaje de error.
			mostrarPersonaje.mensaje(false, "Debes seleecionar un personaje.");
		}

	}

	/**
	 * Muestra los personajes del miembro actual.
	 */
	private void mostrarPersonajes() {
		menuPrincipal.cambiarPanel(mostrarPersonaje);
		conexionbbdd = new ConexionBBDD();

		ArrayList<Personaje> personajes = conexionbbdd.obtenerPersonaje(miembro.getIdMiembro());
		mostrarPersonaje.insertarPersonaje(personajes);
	}

	/**
	 * Consulta las partidas disponibles.
	 */
	private void consultarPartida() {
		// Cambia el panel actual del menú principal al panel de mostrar personajes.
		menuPrincipal.cambiarPanel(consultarPartida);
		// Crea una nueva instancia de la conexión a la base de datos.
		conexionbbdd = new ConexionBBDD();
		// Obtiene la lista de personajes asociados al miembro actual usando su ID.
		ArrayList<Partida> partidas = conexionbbdd.consultarPartida();
		// Inserta la lista de personajes obtenidos en el panel de mostrar personajes.
		consultarPartida.cargarPartida(partidas);
	}

	/**
	 * Cambia la información de la partida del jugador.
	 *
	 * @param partida la partida seleccionada
	 */
	public void cambiarInfoPartidaJugador(Partida partida) {
		// Cambia el panel actual del menú principal al panel de información de la
		// partida del jugador.
		menuPrincipal.cambiarPanel(infoPartidaJugador);
		// Crea una nueva instancia de la conexión a la base de datos.
		conexionbbdd = new ConexionBBDD();
		// Obtiene la lista de personajes asociados al miembro actual usando su ID.
		ArrayList<Personaje> misPersonajes = conexionbbdd.obtenerPersonaje(miembro.getIdMiembro());
		// Carga todos los personajes asociados a la partida seleccionada usando el ID
		// de la partida.
		ArrayList<Personaje> todosPersonajes = conexionbbdd.cargarTodosPersonajes(partida.getIdPartida());
		// Carga la información de la partida en el panel de información de la partida
		// del jugador,
		// incluyendo los personajes del miembro actual y todos los personajes de la
		// partida.
		infoPartidaJugador.cargarInfoPartida(partida, misPersonajes, todosPersonajes);

	}

	/**
	 * Agrega una nueva partida a la base de datos.
	 *
	 * @param partida     la partida a agregar
	 * @param personaje   el personaje asociado a la partida
	 * @param descripcion la descripción de la partida
	 */
	public void agregarPartida(Partida partida, Personaje personaje, String descripcion) {
		// Se crea una instancia de Random para generar valores aleatorios.
		Random aleatorio = new Random();
		// Se instancia una conexión a la base de datos.
		conexionbbdd = new ConexionBBDD();
		// Se crea una instancia de Juega con los datos de la partida, el personaje y
		// valores aleatorios.
		Juega partidasActuales = new Juega(Integer.parseInt(personaje.getIdPersonaje()),
				Integer.parseInt(partida.getIdPartida()), descripcion, aleatorio.nextInt(100), aleatorio.nextInt(100),
				aleatorio.nextInt(100), aleatorio.nextInt(100), aleatorio.nextInt(100), aleatorio.nextInt(100));
		// Se agrega la partida a la base de datos.
		conexionbbdd.agregarPartida(partidasActuales);
		// Se actualiza la vista de las partidas actuales.
		cambioPanelPartidaActual();
	}

	/**
	 * Cambia el panel a la vista de las partidas actuales.
	 */
	public void cambioPanelPartidaActual() {
		// Se instancia una conexión a la base de datos.
		conexionbbdd = new ConexionBBDD();
		// Se obtienen las partidas actuales del miembro actual.
		ArrayList<String[]> partidas = conexionbbdd.obtenerPartidasActuales(miembro.getIdMiembro());

		// Se cambia el panel de la vista principal al panel de las partidas actuales.
		menuPrincipal.cambiarPanel(partidaActual);
		// Se carga la información de las partidas actuales en el panel correspondiente.
		partidaActual.cargarPartida(partidas);
	}

}
