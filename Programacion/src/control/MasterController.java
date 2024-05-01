package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import modelo.ConexionBBDD;
import modelo.Miembro;
import vistas.Login;

public class MasterController implements ActionListener {

	private ConexionBBDD conexionbbdd;
	
	private Miembro miembro;

	public MasterController(Miembro miembro) {
		this.miembro = miembro;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Conexion con BBDD
		conexionbbdd = new ConexionBBDD();
		Connection conn = conexionbbdd.conectar();

		boolean isGameMaster = conexionbbdd.isGameMaster(conn, miembro.getIdMiembro());

		if (!isGameMaster) {
			conexionbbdd.convertIntoGameMaster(conn, miembro.getIdMiembro());
		} 
		
		// Cierro BBDD
		conexionbbdd.cerrar();
	}

}
