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
 * 
 */
public class ControlJugarPersonaje implements ActionListener {

	private JugarPersonaje jugarPersonaje;
	private Miembro miembro;
	private ConexionBBDD conexionbbdd;
	private ControlMenuPrincipalUsuario controlMenu;
	
	public ControlJugarPersonaje(Miembro miembro,ControlMenuPrincipalUsuario controlMenu) {
		this.controlMenu = controlMenu;
		this.miembro = miembro;
		jugarPersonaje = new JugarPersonaje(this);
		mostrarPersonajes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(e.getActionCommand());

	}

	private void mostrarPersonajes() {
		conexionbbdd = new ConexionBBDD();

		ArrayList<Personaje> personajes = conexionbbdd.obtenerPersonaje(miembro.getIdMiembro());
		jugarPersonaje.insertarPersonaje(personajes);
	}

	public void cargarPartidas(Personaje personaje) {

		conexionbbdd = new ConexionBBDD();

		ArrayList<String[]> partidas = conexionbbdd.obtenerCaracteristicasPartida(personaje.getIdPersonaje());
		jugarPersonaje.insertarPartida(partidas);
	}

	public void obtenerCaracteristicas(Personaje personaje, String idPartida) {
		conexionbbdd = new ConexionBBDD();

		Juega caracteristicas = conexionbbdd.consultarCaracteristicas(Integer.valueOf(personaje.getIdPersonaje()),
				Integer.valueOf(idPartida));

		jugarPersonaje.cargarSpinner(caracteristicas);

	}

	public JugarPersonaje getJugarPersonaje() {
		return jugarPersonaje;
	}

	public void actualizarPersonajeCaracteristicas(Juega juega) {

		conexionbbdd = new ConexionBBDD();
		conexionbbdd.actualizarCaracteristicasPersonaje(juega);
	}
	
	public void finalizarSesionCambio() {
		controlMenu.cambioPanelPartidaActual();
	}

}
