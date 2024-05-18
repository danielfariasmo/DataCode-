/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ConexionBBDD;
import modelo.Miembro;
import vistas.GameMasterAlias;
import vistas.Login;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Controlador para gestionar la asignación de un alias al GameMaster.
 * Implementa ActionListener para manejar eventos de acción en la interfaz.
 */
public class ControlGameMasterAlias implements ActionListener {
	// Referencia a la vista de asignación de alias para el GameMaster
	private GameMasterAlias aliasMaster;
	// Referencia al miembro actual
	private Miembro miembro;
	// Instancia de la clase de conexión a la base de datos
	private ConexionBBDD conexionbbdd;

	/**
	 * Constructor para inicializar el controlador con el miembro actual.
	 *
	 * @param miembro el miembro actual
	 */
	public ControlGameMasterAlias(Miembro miembro) {
		// Inicializa la vista de asignación de alias
		this.aliasMaster = new GameMasterAlias(this);
		this.miembro = miembro;
		// Hace visible la vista de asignación de alias
		this.aliasMaster.setVisible(true);
		// Inicializa la conexión a la base de datos
		this.conexionbbdd = new ConexionBBDD();
	}

	/**
	 * Maneja los eventos de acción en la interfaz.
	 *
	 * @param e el evento de acción
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Verifica si el evento proviene del botón de registro
		if (e.getSource() == aliasMaster.getBotonRegistrarse()) {
			// Obtiene el alias ingresado por el GameMaster
			miembro.setAlias(aliasMaster.getTextoAlias());
			// Muestra un mensaje de confirmación con el alias registrado
			JOptionPane.showMessageDialog(aliasMaster,
					"Has sido registrado correctamente como GameMaster con el alias: " + miembro.getAlias());
			// Convierte al miembro en un GameMaster en la base de datos y cierra la ventana
			// de asignación de alias
			conexionbbdd.convertIntoGameMaster(miembro.getIdMiembro(), miembro.getAlias());
			aliasMaster.setVisible(false);
			// Muestra el menú principal del GameMaster
			new Login().mostrarMenuPrincipalGameMaster(miembro);

		}
	}

}
