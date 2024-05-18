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

public class ControlMenuPrincipalUsuario implements ActionListener {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */

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

	public ControlMenuPrincipalUsuario(MenuPrincipalUsuario menuPrincipal, NuevoPersonaje nuevoPersonaje,
			MiembroClub miembroClub, ModificarPersonaje modificarPersonaje,
			TextoMenuPrincipal textoMenuPrincipal, PartidaActual partidaActual,
			Miembro miembro) {
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

	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() instanceof JMenuItem) {
			if (evento.getActionCommand().equals("Nuevo Personaje")) {
				menuPrincipal.cambiarPanel(nuevoPersonaje);

			} else if (evento.getActionCommand().equals("Consultar Partida")) {
				consultarPartida();

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

			} else if (evento.getActionCommand().equals("Modificar Personaje")) {
				menuPrincipal.cambiarPanel(modificarPersonaje);

			} else if (evento.getActionCommand().equals("Mostrar Personajes")) {
				mostrarPersonajes();
			} else if (evento.getActionCommand().equals("Jugar")) {
				menuPrincipal.cambiarPanel(jugarPersonaje);

			} else if (evento.getActionCommand().equals("Partidas Actuales")) {
				cambioPanelPartidaActual();

			} else if (evento.getActionCommand().equals("Menú")) {
				menuPrincipal.cambiarPanel(textoMenuPrincipal);

			}
		}

	}

	public void eliminarPersonaje(Personaje personaje) {
		conexionbbdd = new ConexionBBDD();
		
		try {
			conexionbbdd.elminarPersonaje(personaje.getIdPersonaje());
			mostrarPersonaje.mensaje(true, "Se ha elminiado el personaje " + personaje.getNombre());
			mostrarPersonajes();
		} catch (Exception e) {
			mostrarPersonaje.mensaje(false, "Debes seleecionar un personaje.");
		}
		
	}
	
	private void mostrarPersonajes() {
		menuPrincipal.cambiarPanel(mostrarPersonaje);
		conexionbbdd = new ConexionBBDD();

		ArrayList<Personaje> personajes = conexionbbdd.obtenerPersonaje(miembro.getIdMiembro());
		mostrarPersonaje.insertarPersonaje(personajes);
	}

	private void consultarPartida() {
		menuPrincipal.cambiarPanel(consultarPartida);
		conexionbbdd = new ConexionBBDD();

		ArrayList<Partida> partidas = conexionbbdd.consultarPartida();
		consultarPartida.cargarPartida(partidas);
	}

	public void cambiarInfoPartidaJugador(Partida partida) {
		menuPrincipal.cambiarPanel(infoPartidaJugador);

		conexionbbdd = new ConexionBBDD();
		ArrayList<Personaje> misPersonajes = conexionbbdd.obtenerPersonaje(miembro.getIdMiembro());
		ArrayList<Personaje> todosPersonajes = conexionbbdd.cargarTodosPersonajes(partida.getIdPartida());

		infoPartidaJugador.cargarInfoPartida(partida, misPersonajes, todosPersonajes);

	}

	public void agregarPartida(Partida partida, Personaje personaje, String descripcion) {

		Random aleatorio = new Random();
		conexionbbdd = new ConexionBBDD();

		Juega partidasActuales = new Juega(Integer.parseInt(personaje.getIdPersonaje()),
				Integer.parseInt(partida.getIdPartida()), descripcion, aleatorio.nextInt(100), aleatorio.nextInt(100),
				aleatorio.nextInt(100), aleatorio.nextInt(100), aleatorio.nextInt(100), aleatorio.nextInt(100));
		
		conexionbbdd.agregarPartida(partidasActuales);

		cambioPanelPartidaActual();
	}
	
	public void cambioPanelPartidaActual() {
		
		conexionbbdd = new ConexionBBDD();
		
		ArrayList <String[]> partidas = conexionbbdd.obtenerPartidasActuales(miembro.getIdMiembro());
	
		
		menuPrincipal.cambiarPanel(partidaActual);
		partidaActual.cargarPartida(partidas);
	}
	
}
