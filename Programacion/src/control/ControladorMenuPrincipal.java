/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import vistas.Consultar_Partida;
import vistas.Crear_Partida;
import vistas.Editar_Partida;
import vistas.MenuPrincipal;
import vistas.MiembroClub;
import vistas.Modificar_Personaje;
import vistas.Mostrar_Personaje;
import vistas.Nuevo_Personaje;

public class ControladorMenuPrincipal implements ActionListener {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */

	private MenuPrincipal menuPrincipal;
	private Nuevo_Personaje nuevoPersonaje;
	private Consultar_Partida consultarPartida;
	private Crear_Partida crearPartida;
	private Editar_Partida editarPartida;
	private MiembroClub miembroClub;
	private Modificar_Personaje modificarPersonaje;
	private Mostrar_Personaje mostrarPersonaje;

	public ControladorMenuPrincipal(MenuPrincipal menuPrincipal, Nuevo_Personaje nuevoPersonaje,
			Consultar_Partida consultarPartida, Crear_Partida crearPartida, Editar_Partida editarPartida,
			MiembroClub miembroClub, Modificar_Personaje modificarPersonaje, Mostrar_Personaje mostrarPersonaje) {
		this.menuPrincipal = menuPrincipal;
		this.nuevoPersonaje = nuevoPersonaje;
		this.consultarPartida = consultarPartida;
		this.crearPartida = crearPartida;
		this.editarPartida = editarPartida;
		this.miembroClub = miembroClub;
		this.modificarPersonaje = modificarPersonaje;
		this.mostrarPersonaje = mostrarPersonaje;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() instanceof JMenuItem) {
			if (evento.getActionCommand().equals("Nuevo Personaje")) {
				menuPrincipal.cambiarPanel(nuevoPersonaje);

			} else if (evento.getActionCommand().equals("Consultar Partida")) {
				menuPrincipal.cambiarPanel(consultarPartida);

			} else if (evento.getActionCommand().equals("Crear Partida")) {
				menuPrincipal.cambiarPanel(crearPartida);

			} else if (evento.getActionCommand().equals("Editar Partida")) {
				menuPrincipal.cambiarPanel(editarPartida);

			} else if (evento.getActionCommand().equals("Mostrar Miembros")) {
				menuPrincipal.cambiarPanel(miembroClub);

			} else if (evento.getActionCommand().equals("Modificar Personaje")) {
				menuPrincipal.cambiarPanel(modificarPersonaje);
				
			} else if (evento.getActionCommand().equals("Mostrar Personajes")) {
				menuPrincipal.cambiarPanel(mostrarPersonaje);
			
			}
		}

	}

}
