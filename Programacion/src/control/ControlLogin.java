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
		String contrasenha = login.getClaveContrasenhaLogin();
		
		conexionbbdd = new ConexionBBDD();

		System.out.println("USUARIO: "+ usuario + " / PASS: "+ contrasenha);
		Miembro miembro = conexionbbdd.obtenerMiembro(usuario, contrasenha);

		if (miembro != null) {
			login.mostrarDialogoExito(miembro);
		} else {
			login.mostrarDialogoError();
		}
	}

}
