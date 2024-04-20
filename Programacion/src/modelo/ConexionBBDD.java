/**
 * 
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
public class ConexionBBDD {

	// Ruta de conexion.
	private static String url = "jdbc:mysql://localhost:3306/datacode";
	private static Connection conn = null;

	public static Connection conectar() {

		if (conn != null) {
			return conn;
		}

		try {
			// Indicamos la clase a la que vamos a acceder
			Class.forName("com.mysql.jdbc.Driver");

			// Damos ubicacion en MySql
			conn = DriverManager.getConnection(url, "root", "1590");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void cerrar() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}