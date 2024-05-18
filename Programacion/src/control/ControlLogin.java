package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ConexionBBDD;
import modelo.Miembro;
import vistas.Login;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Controlador para gestionar la autenticación de usuarios en el sistema.
 * Implementa ActionListener para manejar eventos de acción en la vista de
 * login.
 */
public class ControlLogin implements ActionListener {
	// Referencia a la vista de login
	private Login login;
	// Instancia de la clase de conexión a la base de datos
	private ConexionBBDD conexionbbdd;

	/**
	 * Constructor para inicializar el controlador con la vista de login.
	 *
	 * @param login la vista de login
	 */
	public ControlLogin(Login login) {
		this.login = login;
	}

	/**
	 * Maneja los eventos de acción en la vista de login, como el intento de inicio
	 * de sesión.
	 *
	 * @param e el evento de acción
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Obtiene el nombre de usuario y la contraseña ingresados en la vista de login
		String usuario = login.getTextoUsuarioLogin();
		String contrasenha = login.getClaveContrasenhaLogin();
		// Inicializa la conexión a la base de datos
		conexionbbdd = new ConexionBBDD();
		// Imprime en la consola el nombre de usuario y la contraseña para propósitos de
		// depuración
		System.out.println("USUARIO: " + usuario + " / PASS: " + contrasenha);
		// Realiza la autenticación del usuario consultando la base de datos
		Miembro miembro = conexionbbdd.obtenerMiembro(usuario, contrasenha);
		// Si se encuentra un miembro correspondiente a las credenciales proporcionadas,
		// muestra un mensaje de éxito
		// en la vista de login, de lo contrario, muestra un mensaje de error.
		if (miembro != null) {
			login.mostrarDialogoExito(miembro);
		} else {
			login.mostrarDialogoError();
		}
	}

}
