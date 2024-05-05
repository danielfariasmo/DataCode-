package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		conexionbbdd = new ConexionBBDD();

		System.out.println("USUARIO: "+ usuario + " / PASS: "+ contraseña);
		Miembro miembro = conexionbbdd.obtenerMiembro(usuario, contraseña);

		if (miembro != null) {
			login.mostrarDialogoExito(miembro);
		} else {
			login.mostrarDialogoError();
		}
	}

}
