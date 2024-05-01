package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import modelo.ConexionBBDD;
import modelo.Miembro;
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

//		// Variable para guardar la informacion de la consulta
//		 miembro;

		// Conexion con BBDD
		conexionbbdd = new ConexionBBDD();
		Connection conn = conexionbbdd.conectar();

		// Metodo en Conexion de BBDD
		System.out.println("USUARIO: "+ usuario + " / PASS: "+ contraseña);
		Miembro miembro = conexionbbdd.obtenerMiembro(conn, usuario, contraseña);

		// Cierro BBDD
		conexionbbdd.cerrar();

		if (miembro != null) {
			login.mostrarDialogoExito(miembro);
		} else {
			login.mostrarDialogoError();
		}
	}

}
