/**
 * 
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
public class ConexionBBDD {

	// Ruta de conexion.
	private String url = "jdbc:mysql://localhost:3306/proyectointegrador";
	private Connection conn = null;

	public Connection conectar() {

		if (conn != null) {
			return conn;
		}

		try {
			// Indicamos la clase a la que vamos a acceder
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Damos ubicacion en MySql
			conn = DriverManager.getConnection(url, "root", "1590");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void cerrar() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Miembro> obtenerMiembro() {
		ArrayList<Miembro> miembros = new ArrayList<>();
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombre_apellidos FROM miembro");
			while (rs.next()) {
				String nombreApellidos = rs.getString("nombre_apellidos");
				Miembro miembro = new Miembro(nombreApellidos);
				miembros.add(miembro);
			}
			rs.close();
			stmt.close();
			cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return miembros;

	}
}
