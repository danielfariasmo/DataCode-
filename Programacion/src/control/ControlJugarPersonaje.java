/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.ConexionBBDD;
import modelo.Juega;
import modelo.Miembro;
import modelo.Personaje;
import vistas.JugarPersonaje;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Controlador para manejar la interfaz de juego de personajes. Implementa
 * ActionListener para gestionar eventos de acción en la interfaz.
 */
public class ControlJugarPersonaje implements ActionListener {
	// Referencia a la vista de juego de personajes
	private JugarPersonaje jugarPersonaje;
	// Referencia al miembro actual
	private Miembro miembro;
	// Instancia de la clase de conexión a la base de datos
	private ConexionBBDD conexionbbdd;
	// Referencia al controlador del menú principal del usuario
	private ControlMenuPrincipalUsuario controlMenu;

	/**
	 * Constructor para inicializar el controlador con el miembro actual y el
	 * controlador del menú principal del usuario.
	 *
	 * @param miembro     el miembro actual
	 * @param controlMenu el controlador del menú principal del usuario
	 */
	public ControlJugarPersonaje(Miembro miembro, ControlMenuPrincipalUsuario controlMenu) {
		this.controlMenu = controlMenu;
		this.miembro = miembro;
		// Inicializa la vista de juego de personajes y muestra los personajes del
		// miembro actual
		jugarPersonaje = new JugarPersonaje(this);
		mostrarPersonajes();
	}

	/**
	 * Maneja los eventos de acción en la interfaz de juego de personajes.
	 *
	 * @param e el evento de acción
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(e.getActionCommand());

	}

	/**
	 * Muestra los personajes del miembro actual en la interfaz.
	 */
	private void mostrarPersonajes() {
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Obtiene los personajes del miembro actual
		ArrayList<Personaje> personajes = conexionbbdd.obtenerPersonaje(miembro.getIdMiembro());
		// Inserta los personajes en la interfaz de juego de personajes
		jugarPersonaje.insertarPersonaje(personajes);
	}

	/**
	 * Carga las partidas asociadas a un personaje en la interfaz.
	 *
	 * @param personaje el personaje seleccionado
	 */
	public void cargarPartidas(Personaje personaje) {
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Obtiene las características de las partidas asociadas al personaje
		ArrayList<String[]> partidas = conexionbbdd.obtenerCaracteristicasPartida(personaje.getIdPersonaje());
		// Inserta las partidas en la interfaz de juego de personajes
		jugarPersonaje.insertarPartida(partidas);
	}

	/**
	 * Obtiene las características de una partida asociada a un personaje y las
	 * carga en la interfaz.
	 *
	 * @param personaje el personaje seleccionado
	 * @param idPartida el ID de la partida seleccionada
	 */
	public void obtenerCaracteristicas(Personaje personaje, String idPartida) {
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Consulta las características de la partida asociada al personaje
		Juega caracteristicas = conexionbbdd.consultarCaracteristicas(Integer.valueOf(personaje.getIdPersonaje()),
				Integer.valueOf(idPartida));
		// Carga las características en la interfaz de juego de personajes
		jugarPersonaje.cargarSpinner(caracteristicas);

	}

	/**
	 * Método getter para obtener la vista de juego de personajes.
	 *
	 * @return la vista de juego de personajes
	 */
	public JugarPersonaje getJugarPersonaje() {
		return jugarPersonaje;
	}

	/**
	 * Actualiza las características del personaje en la base de datos.
	 *
	 * @param juega las características actualizadas del personaje
	 */
	public void actualizarPersonajeCaracteristicas(Juega juega) {
		// Inicializa la conexión a la base de datos y actualiza las características del
		// personaje
		conexionbbdd = new ConexionBBDD();
		conexionbbdd.actualizarCaracteristicasPersonaje(juega);
	}

	/**
	 * Finaliza la sesión y cambia al panel de partidas actuales en el menú
	 * principal del usuario.
	 */
	public void finalizarSesionCambio() {
		controlMenu.cambioPanelPartidaActual();
	}

}
