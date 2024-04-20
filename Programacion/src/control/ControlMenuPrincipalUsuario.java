/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import vistas.ConsultarPartida;
import vistas.CrearPartida;
import vistas.EditarPartida;
import vistas.MenuPrincipalUsuario;
import vistas.MiembroClub;
import vistas.ModificarPersonaje;
import vistas.MostrarPersonaje;
import vistas.NuevoPersonaje;

public class ControlMenuPrincipalUsuario implements ActionListener {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */

	private MenuPrincipalUsuario menuPrincipal;
	private NuevoPersonaje nuevoPersonaje;
	private ConsultarPartida consultarPartida;
	private CrearPartida crearPartida;
	private EditarPartida editarPartida;
	private MiembroClub miembroClub;
	private ModificarPersonaje modificarPersonaje;
	private MostrarPersonaje mostrarPersonaje;

	public ControlMenuPrincipalUsuario(MenuPrincipalUsuario menuPrincipal, NuevoPersonaje nuevoPersonaje,
			ConsultarPartida consultarPartida, CrearPartida crearPartida, EditarPartida editarPartida,
			MiembroClub miembroClub, ModificarPersonaje modificarPersonaje, MostrarPersonaje mostrarPersonaje) {
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
