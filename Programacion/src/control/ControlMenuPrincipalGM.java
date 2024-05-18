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

public class ControlMenuPrincipalGM implements ActionListener {

	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */

	private MenuPrincipalGameMaster menuPrincipalGameMaster;
	private ConsultarPartidaGameMaster consultarPartida;
	private CrearPartida crearPartida;
	private EditarPartida editarPartida;
	private MiembroClub miembroClub;
	private TextoMenuPrincipal textoMenuPrincipal;
	private ConexionBBDD conexionbbdd;
	private InfoPartidaGameMaster infoPartidaGameMaster;
	private GameMaster gameMaster;

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

	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() instanceof JMenuItem) {
			if (evento.getActionCommand().equals("Crear Partida")) {
				menuPrincipalGameMaster.cambiarPanel(crearPartida);

			} else if (evento.getActionCommand().equals("Consultar Partida")) {
				consultarPartida();
			} else if (evento.getActionCommand().equals("Mostrar Miembros")) {
				menuPrincipalGameMaster.cambiarPanel(miembroClub);

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
				editarPartida();

			} else if (evento.getActionCommand().equals("Menú Principal")) {
				menuPrincipalGameMaster.cambiarPanel(textoMenuPrincipal);

			}
		}

	}

	private void consultarPartida() {
		menuPrincipalGameMaster.cambiarPanel(consultarPartida);
		conexionbbdd = new ConexionBBDD();

		ArrayList<Partida> partidas = conexionbbdd.consultarPartidaGameMaster(gameMaster.getIdGameMaster());
		consultarPartida.cargarPartida(partidas);
	}

	private void inicializarGameMaster(String idMiembro) {

		conexionbbdd = new ConexionBBDD();

		gameMaster = conexionbbdd.buscarID(Integer.valueOf(idMiembro));
	}

	public void cambiarInfoPartidaJugador(Partida partida) {
		menuPrincipalGameMaster.cambiarPanel(infoPartidaGameMaster);

		conexionbbdd = new ConexionBBDD();
		ArrayList<Personaje> todosPersonajes = conexionbbdd.cargarTodosPersonajes(partida.getIdPartida());

		infoPartidaGameMaster.cargarInfoPartida(partida, todosPersonajes);

	}

	public void actualizarExperiencia(String idPersonaje, int nuevaExperiencia) {

		conexionbbdd = new ConexionBBDD();

		conexionbbdd.actualizarExperiencia(idPersonaje, nuevaExperiencia);
	}

	public void creacionPartida() {

		String nombre = crearPartida.getTextoNombrePartida();
		String ambientacion = crearPartida.getTextoAmbientacion();
		String duracion = crearPartida.getTextoDuracionSesion();
		String numeroSesion = crearPartida.getTextoNumeroSesion();
		String fechaHora = crearPartida.getFechaHora();

		if (!nombre.trim().isEmpty() && !ambientacion.trim().isEmpty() && !duracion.trim().isEmpty()
				&& !numeroSesion.trim().isEmpty()) {

			if (validarNumero(duracion) && validarNumero(numeroSesion)) {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				try {
					Date dia = formato.parse(fechaHora);
					if (new Date().after(dia)) {
						crearPartida.mensaje(false, "La fecha no puede ser anterior.");
					} else {
						Partida partida = new Partida(" ", nombre, fechaHora, numeroSesion, ambientacion, "No", duracion,
								String.valueOf(gameMaster.getIdGameMaster()));

						conexionbbdd = new ConexionBBDD();

						conexionbbdd.crearPartida(partida);
						crearPartida.mensaje(true, "Se ha creado la partida " + nombre);
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

	private boolean validarNumero(String numero) {
		try {
			Integer.valueOf(numero);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void editarPartida() {

		ArrayList<Partida> partidas = new ArrayList<Partida>();

		menuPrincipalGameMaster.cambiarPanel(editarPartida);

		conexionbbdd = new ConexionBBDD();

		partidas = conexionbbdd.consultarPartidaGameMaster(gameMaster.getIdGameMaster());

		editarPartida.insertarPartida(partidas);
	}

	public void actualizarPartida(Partida partida) {

		if (!partida.getAmbientacion().trim().isEmpty() && !partida.getDuracionSesion().trim().isEmpty()
				&& !partida.getNumeroSesion().trim().isEmpty()) {

			if (validarNumero(partida.getDuracionSesion()) && validarNumero(partida.getNumeroSesion())) {

				conexionbbdd = new ConexionBBDD();

				conexionbbdd.editarPartida(partida);
				editarPartida.mensaje(true, "Se ha editado la partida " + partida.getNombre());
				editarPartida.limpiarCampos();
				editarPartida();
			} else {
				editarPartida.mensaje(false, "La duración y número de sesión deben ser numéricos.");
			}

		} else {
			editarPartida.mensaje(false, "Los datos no son correctos.");
		}
	}
}
