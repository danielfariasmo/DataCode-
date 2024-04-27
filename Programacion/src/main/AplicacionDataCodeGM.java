/**
 * 
 */
package main;

import java.awt.EventQueue;

import control.ControlMenuPrincipalGM;
import vistas.ConsultarPartida;
import vistas.CrearPartida;
import vistas.EditarPartida;
import vistas.MenuPrincipalGameMaster;
import vistas.MiembroClub;
import vistas.TextoMenuPrincipal;

public class AplicacionDataCodeGM {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				// Inicializamos las ventanas.
				MenuPrincipalGameMaster menuPrincipalGameMaster = new MenuPrincipalGameMaster();
				EditarPartida editarPartida = new EditarPartida();
				CrearPartida crearPartida = new CrearPartida();
				ConsultarPartida consultarPartida = new ConsultarPartida();
				MiembroClub miembroClub = new MiembroClub();
				TextoMenuPrincipal textoMenuPrincipal = new TextoMenuPrincipal();

				ControlMenuPrincipalGM  listener = new ControlMenuPrincipalGM(menuPrincipalGameMaster, consultarPartida, crearPartida, editarPartida, miembroClub, textoMenuPrincipal);

				// Se muestra el menu principal.
				menuPrincipalGameMaster.setListener(listener);
				menuPrincipalGameMaster.hacerVisible();

			}
		}

		);

	}

}