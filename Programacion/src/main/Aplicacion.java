/**
 * 
 */
package main;

import vistas.Login;
import vistas.MenuPrincipal;

/**
 * 
 */
public class Aplicacion {

	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				// AQUI DENTRO es donde vamos a ejecutar nuestra ventana
				
				Login inicioSesion = new Login ();
				inicioSesion.hacerVisible();
				
				MenuPrincipal  menuPrincipal= new MenuPrincipal ();
				menuPrincipal.hacerVisible();
				
			}
		}

		);

	}

}