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
 * 
 */
public class ControlGameMasterAlias implements ActionListener {

	private GameMasterAlias aliasMaster;
	private Miembro miembro;
	private ConexionBBDD conexionbbdd;

	public ControlGameMasterAlias(Miembro miembro) {
		this.aliasMaster = new GameMasterAlias(this);
		this.miembro = miembro;
		this.aliasMaster.setVisible(true);
		this.conexionbbdd = new ConexionBBDD();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == aliasMaster.getBotonRegistrarse()) {
			miembro.setAlias(aliasMaster.getTextoAlias());
			JOptionPane.showMessageDialog(aliasMaster,
					"Has sido registrado correctamente como GameMaster con el alias: " + miembro.getAlias());
			conexionbbdd.convertIntoGameMaster(miembro.getIdMiembro(), miembro.getAlias());
			aliasMaster.setVisible(false);
			new Login().mostrarMenuPrincipalGameMaster(miembro);
			
		}
	}

}
