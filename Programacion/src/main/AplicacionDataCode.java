/**
 * 
 */
package main;

import java.awt.EventQueue;
import control.ControlMenuPrincipalUsuario;
import vistas.ConsultarPartida;
import vistas.CrearPartida;
import vistas.EditarPartida;
import vistas.MenuPrincipalUsuario;
import vistas.MiembroClub;
import vistas.ModificarPersonaje;
import vistas.MostrarPersonaje;
import vistas.NuevoPersonaje;

public class AplicacionDataCode {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				// Inicializamos las ventanas.
				MenuPrincipalUsuario menuPrincipal = new MenuPrincipalUsuario();
				NuevoPersonaje nuevoPersonaje = new NuevoPersonaje();
				ConsultarPartida consultarPArtida = new ConsultarPartida();
				CrearPartida crearPartida = new CrearPartida();
				EditarPartida editarPartida = new EditarPartida();
				MiembroClub miembroClub = new MiembroClub();
				ModificarPersonaje modificarPersonaje = new ModificarPersonaje();
				MostrarPersonaje mostrarPersonaje = new MostrarPersonaje();

				ControlMenuPrincipalUsuario listener = new ControlMenuPrincipalUsuario(menuPrincipal, nuevoPersonaje,
						consultarPArtida, crearPartida, editarPartida, miembroClub, modificarPersonaje,
						mostrarPersonaje);

				// Se muestra el menu principal.
				menuPrincipal.setListener(listener);
				menuPrincipal.hacerVisible();

			}
		}

		);

	}

}