/**
 * 
 */
package main;

import java.awt.EventQueue;

import vistas.Login;

public class AplicacionDataCode {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				Login login = new Login();
				login.setVisible(true);
			}
		}

		);

	}

}

