package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import modelo.ConexionBBDD;
import vistas.Login;

public class ControlLogin implements ActionListener {

	private Login login;
	private ConexionBBDD conexionbbdd;

	public ControlLogin(Login login) {
		this.login = login;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String usuario = login.getTextoUsuarioLogin();
		String contraseña = login.getClaveContraseñaLogin();

		// Variable para guardar la informacion de la consulta
		boolean loginExitoso = false;

		// Conexion con BBDD
		conexionbbdd = new ConexionBBDD();
		Connection conn = conexionbbdd.conectar();

		// Metodo en Conexion de BBDD
		loginExitoso = conexionbbdd.hacerLogin(conn, usuario, contraseña);
		System.out.println("USUARIO: "+ usuario + " / PASS: "+ contraseña);

		// Cierro BBDD
		conexionbbdd.cerrar();

		if (loginExitoso) {
			login.mostrarDialogoExito();
		} else {
			login.mostrarDialogoError();
		}
	}

}
