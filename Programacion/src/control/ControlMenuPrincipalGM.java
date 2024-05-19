/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JMenuItem;

import modelo.ConexionBBDD;
import modelo.GameMaster;
import modelo.Miembro;
import modelo.Partida;
import modelo.Personaje;
import vistas.ConsultarPartidaGameMaster;
import vistas.CrearPartida;
import vistas.EditarPartida;
import vistas.InfoPartidaGameMaster;
import vistas.MenuPrincipalGameMaster;
import vistas.MiembroClub;
import vistas.TextoMenuPrincipal;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
public class ControlMenuPrincipalGM implements ActionListener {

	private MenuPrincipalGameMaster menuPrincipalGameMaster;
	private ConsultarPartidaGameMaster consultarPartida;
	private CrearPartida crearPartida;
	private EditarPartida editarPartida;
	private MiembroClub miembroClub;
	private TextoMenuPrincipal textoMenuPrincipal;
	private ConexionBBDD conexionbbdd;
	private InfoPartidaGameMaster infoPartidaGameMaster;
	private GameMaster gameMaster;

	/**
	 * Constructor para inicializar el controlador del menú principal del Game
	 * Master.
	 *
	 * @param menuPrincipalGameMaster la vista del menú principal del Game Master
	 * @param miembroClub             la vista para mostrar los miembros del club
	 * @param textoMenuPrincipal      el texto del menú principal
	 * @param miembro                 el miembro actual
	 */
	public ControlMenuPrincipalGM(MenuPrincipalGameMaster menuPrincipalGameMaster, MiembroClub miembroClub,
			TextoMenuPrincipal textoMenuPrincipal, Miembro miembro) {
		this.menuPrincipalGameMaster = menuPrincipalGameMaster;
		this.consultarPartida = new ConsultarPartidaGameMaster(this);
		this.miembroClub = miembroClub;
		this.textoMenuPrincipal = textoMenuPrincipal;
		this.infoPartidaGameMaster = new InfoPartidaGameMaster(this);
		this.inicializarGameMaster(miembro.getIdMiembro());
		this.crearPartida = new CrearPartida(this);
		this.editarPartida = new EditarPartida(this);
	}

	/**
	 * Maneja los eventos de acción realizados en el menú principal del Game Master.
	 *
	 * @param evento el evento de acción
	 */
	public void actionPerformed(ActionEvent evento) {
		// Verifica si el evento proviene de un JMenuItem
		if (evento.getSource() instanceof JMenuItem) {
			// Comprueba la acción realizada y ejecuta la correspondiente
			if (evento.getActionCommand().equals("Crear Partida")) {
				// Cambia al panel de creación de partida
				menuPrincipalGameMaster.cambiarPanel(crearPartida);

			} else if (evento.getActionCommand().equals("Consultar Partida")) {
				// Realiza la consulta de partidas disponibles
				consultarPartida();
			} else if (evento.getActionCommand().equals("Mostrar Miembros")) {
				// Cambia al panel de visualización de miembros
				menuPrincipalGameMaster.cambiarPanel(miembroClub);

				// Obtiene y muestra la lista de miembros
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

			} else if (evento.getActionCommand().equals("Editar Partida")) {
				// Inicia el proceso de edición de partidas
				editarPartida();

			} else if (evento.getActionCommand().equals("Menú Principal")) {
				// Cambia al panel del menú principal
				menuPrincipalGameMaster.cambiarPanel(textoMenuPrincipal);

			}
		}

	}

	/**
	 * Consulta las partidas disponibles para el Game Master.
	 */
	private void consultarPartida() {
		// Cambia al panel de consulta de partida
		menuPrincipalGameMaster.cambiarPanel(consultarPartida);
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Consulta las partidas disponibles para el Game Master actual
		ArrayList<Partida> partidas = conexionbbdd.consultarPartidaGameMaster(gameMaster.getIdGameMaster());
		// Carga las partidas obtenidas en el panel de consulta de partida
		consultarPartida.cargarPartida(partidas);
	}

	/**
	 * Inicializa los datos del Game Master.
	 *
	 * @param idMiembro el ID del miembro actual
	 */
	private void inicializarGameMaster(String idMiembro) {
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Busca al Game Master asociado al ID de miembro proporcionado
		gameMaster = conexionbbdd.buscarID(Integer.valueOf(idMiembro));
	}

	/**
	 * Cambia la información de la partida del jugador.
	 *
	 * @param partida la partida seleccionada
	 */
	public void cambiarInfoPartidaJugador(Partida partida) {
		// Cambia al panel de información de partida del Game Master
		menuPrincipalGameMaster.cambiarPanel(infoPartidaGameMaster);
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Obtiene todos los personajes asociados a la partida proporcionada
		ArrayList<Personaje> todosPersonajes = conexionbbdd.cargarTodosPersonajes(partida.getIdPartida());
		// Carga la información de la partida y los personajes en el panel de
		// información de partida
		infoPartidaGameMaster.cargarInfoPartida(partida, todosPersonajes);

	}

	/**
	 * Actualiza la experiencia de un personaje.
	 *
	 * @param idPersonaje      el ID del personaje
	 * @param nuevaExperiencia la nueva experiencia del personaje
	 */
	public void actualizarExperiencia(String idPersonaje, int nuevaExperiencia) {
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Actualiza la experiencia del personaje en la base de datos
		conexionbbdd.actualizarExperiencia(idPersonaje, nuevaExperiencia);
	}

	/**
	 * Crea una nueva partida.
	 */
	public void creacionPartida() {
		// Obtiene la información de la partida desde la vista
		String nombre = crearPartida.getTextoNombrePartida();
		String ambientacion = crearPartida.getTextoAmbientacion();
		String duracion = crearPartida.getTextoDuracionSesion();
		String numeroSesion = crearPartida.getTextoNumeroSesion();
		String fechaHora = crearPartida.getFechaHora();
		// Verifica que los campos necesarios no estén vacíos
		if (!nombre.trim().isEmpty() && !ambientacion.trim().isEmpty() && !duracion.trim().isEmpty()
				&& !numeroSesion.trim().isEmpty()) {
			// Verifica que la duración y el número de sesión sean valores numéricos
			if (validarNumero(duracion) && validarNumero(numeroSesion)) {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				try {
					Date dia = formato.parse(fechaHora);
					// Verifica que la fecha no sea anterior a la actual
					if (new Date().after(dia)) {
						crearPartida.mensaje(false, "La fecha no puede ser anterior.");
					} else {
						// Crea un objeto Partida con la información proporcionada
						Partida partida = new Partida(" ", nombre, fechaHora, numeroSesion, ambientacion, "No",
								duracion, String.valueOf(gameMaster.getIdGameMaster()));
						// Inicializa la conexión a la base de datos
						conexionbbdd = new ConexionBBDD();
						// Inserta la nueva partida en la base de datos
						conexionbbdd.crearPartida(partida);
						// Muestra un mensaje de éxito en la vista
						crearPartida.mensaje(true, "Se ha creado la partida " + nombre);
						// Limpia los campos del formulario de creación de partida en la vista
						crearPartida.limpiarCampos();
					}
				} catch (ParseException e) {
					crearPartida.mensaje(false, "La fecha es inválida.");
				}

			} else {
				crearPartida.mensaje(false, "La duración y número de sesión deben ser numéricos.");
			}

		} else {
			crearPartida.mensaje(false, "Los datos no son correctos.");
		}

	}

	/**
	 * Verifica si una cadena puede ser convertida a un número entero.
	 *
	 * @param numero la cadena que se intentará convertir
	 * @return true si la cadena puede ser convertida a un número entero, de lo
	 *         contrario false
	 */
	private boolean validarNumero(String numero) {
		try {
			Integer.valueOf(numero);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Abre la vista de edición de partidas y carga las partidas disponibles en la
	 * base de datos.
	 */
	public void editarPartida() {
		// Crea una lista para almacenar las partidas consultadas
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		// Cambia el panel de la vista al formulario de edición de partidas
		menuPrincipalGameMaster.cambiarPanel(editarPartida);
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Consulta las partidas disponibles para el game master actual
		partidas = conexionbbdd.consultarPartidaGameMaster(gameMaster.getIdGameMaster());
		// Inserta las partidas consultadas en la vista de edición de partidas
		editarPartida.insertarPartida(partidas);
	}

	/**
	 * Actualiza la información de una partida en la base de datos con los datos
	 * proporcionados.
	 *
	 * @param partida la partida con la información actualizada
	 */
	public void actualizarPartida(Partida partida) {

		// Verifica que los campos esenciales no estén vacíos
		if (!partida.getAmbientacion().trim().isEmpty() && !partida.getDuracionSesion().trim().isEmpty()
				&& !partida.getNumeroSesion().trim().isEmpty()) {
			// Verifica que la duración y el número de sesión sean valores numéricos
			if (validarNumero(partida.getDuracionSesion()) && validarNumero(partida.getNumeroSesion())) {
				// Inicializa la conexión a la base de datos
				conexionbbdd = new ConexionBBDD();
				// Actualiza la partida en la base de datos con la información proporcionada
				conexionbbdd.editarPartida(partida);
				// Muestra un mensaje de éxito en la vista de edición de partidas
				editarPartida.mensaje(true, "Se ha editado la partida " + partida.getNombre());
				// Limpia los campos del formulario de edición de partidas en la vista
				editarPartida.limpiarCampos();
				// Recarga la lista de partidas en la vista de edición de partidas
				editarPartida();
			} else {
				// Muestra un mensaje de error si la duración y el número de sesión no son
				// numéricos
				editarPartida.mensaje(false, "La duración y número de sesión deben ser numéricos.");
			}

		} else {
			// Muestra un mensaje de error si algún campo esencial está vacío
			editarPartida.mensaje(false, "Los datos no son correctos.");
		}
	}
}
