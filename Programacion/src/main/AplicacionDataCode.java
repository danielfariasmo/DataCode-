/**
 * 
 */
package main;

import java.awt.EventQueue;
import control.ControladorMenuPrincipal;
import vistas.Consultar_Partida;
import vistas.Crear_Partida;
import vistas.Editar_Partida;
import vistas.MenuPrincipal;
import vistas.MiembroClub;
import vistas.Modificar_Personaje;
import vistas.Mostrar_Personaje;
import vistas.Nuevo_Personaje;

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
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				Nuevo_Personaje nuevoPersonaje = new Nuevo_Personaje();
				Consultar_Partida consultarPArtida = new Consultar_Partida();
				Crear_Partida crearPartida = new Crear_Partida();
				Editar_Partida editarPartida = new Editar_Partida();
				MiembroClub miembroClub = new MiembroClub();
				Modificar_Personaje modificarPersonaje = new Modificar_Personaje();
				Mostrar_Personaje mostrarPersonaje = new Mostrar_Personaje();

				ControladorMenuPrincipal listener = new ControladorMenuPrincipal(menuPrincipal, nuevoPersonaje,
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