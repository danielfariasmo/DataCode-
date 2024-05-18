/**
 * Clase principal que inicia la aplicación DataCode.
 */
package main;

import java.awt.EventQueue;

import vistas.Login;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * Clase principal que contiene el método main para iniciar la aplicación.
 */

public class AplicacionDataCode {

	/**
	 * Método principal que inicia la aplicación.
	 * 
	 * @param args Los argumentos de la línea de comandos (no se utilizan en esta
	 *             aplicación).
	 */

	public static void main(String[] args) {

		// Se inicia la interfaz de usuario en el hilo de eventos de la interfaz
		// gráfica.
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				// Se crea una instancia de la ventana de inicio de sesión y se hace visible.
				Login login = new Login();
				login.setVisible(true);
			}
		}

		);

	}

}
