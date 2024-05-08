/**
 * 
 */
package modelo;

import static modelo.Miembro.ID_MIEMBRO;
import static modelo.Miembro.NOMBRE_APELLIDOS;
import static modelo.Miembro.NUMERO_EXPEDIENTE;
import static modelo.Miembro.NOMBRE_ESTUDIO;
import static modelo.Miembro.NOMBRE_USUARIO;
import static modelo.Miembro.CLAVE_USUARIO;

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

	private String url = "jdbc:mysql://localhost:3306/proyectointegrador";
	private Connection conn = null;
	private static final String FIND_USER_QUERY = "SELECT * FROM miembro WHERE nombre_usuario = '%s' AND clave_usuario = %d";
	private static final String FIND_MASTER_QUERY = "SELECT * FROM gamemaster WHERE id_miembro = '%s'";
	private static final String INSERT_MASTER = "INSERT INTO GameMaster (id_miembro, alias) VALUES ('%s', '%s');";

	public Connection conectar() {

//		if (conn != null) {
//			return conn;
//		}

		try {
			// Indicamos la clase a la que vamos a acceder
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Damos ubicacion en MySql
			return DriverManager.getConnection(url, "root", "1590");
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

	public ArrayList<Miembro> obtenerMiembros() {
		ArrayList<Miembro> miembros = new ArrayList<>();
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_miembro, nombre_apellidos, numero_expediente FROM miembro");
			while (rs.next()) {
				String idMiembro = rs.getString("id_miembro");
				String nombreApellidos = rs.getString("nombre_apellidos");

				// Ejemplo de como meter numero.
				int numeroExpediente = rs.getInt("numero_expediente");
				Miembro miembro = new Miembro(idMiembro, nombreApellidos, numeroExpediente);
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

	public ArrayList<Personaje> obtenerPersonaje(String idMiembro) {
		ArrayList<Personaje> personajes = new ArrayList<>();
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT nombre, nivel_experiencia FROM Personaje WHERE id_miembro=" + idMiembro);
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				int nivelExperiencia = rs.getInt("nivel_experiencia");

				Personaje personaje = new Personaje(nombre, nivelExperiencia);
				personajes.add(personaje);
			}
			rs.close();
			stmt.close();
			cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personajes;

	}

	public ArrayList<Partida> consultarPartida() {
		ArrayList<Partida> partidas = new ArrayList<>();
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Partida");
			while (rs.next()) {
				String idPartida = String.valueOf(rs.getInt("id_partida"));
				String nombre = rs.getString("nombre");
				String dia_hora = rs.getString("dia_hora");
				String numeroSesion = String.valueOf(rs.getInt("numero_sesion"));
				String duracion_sesion = rs.getString("duracion_sesion");
				String ambientacion = rs.getString("ambientacion");
				String finalizada = rs.getString("finalizada");
				String idGameMaster = rs.getString("id_gameMaster");

				Partida partida = new Partida(idPartida, nombre, dia_hora, numeroSesion, ambientacion, finalizada, duracion_sesion, idGameMaster);
				partidas.add(partida);
			}
			rs.close();
			stmt.close();
			cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partidas;
	}

	public Miembro obtenerMiembro(String usuario, String clave) {

		Miembro miembro = null;
		ResultSet resultSet;

		// Ejecuto la consulta
		try {

			int claveNum = Integer.parseInt(clave);
			Statement statement = conectar().createStatement();
			resultSet = statement.executeQuery(String.format(FIND_USER_QUERY, usuario, claveNum));
			if (resultSet.next()) {
				miembro = new Miembro(String.valueOf(resultSet.getInt(ID_MIEMBRO)),
						resultSet.getString(NOMBRE_APELLIDOS), resultSet.getInt(NUMERO_EXPEDIENTE),
						resultSet.getString(NOMBRE_ESTUDIO), resultSet.getString(NOMBRE_USUARIO),
						String.valueOf(resultSet.getInt(CLAVE_USUARIO)));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		cerrar();
		return miembro;
	}

	public boolean isGameMaster(String id_miembro) {

		boolean isMaster = false;
		ResultSet resultSet;

		try {
			Statement statement = conectar().createStatement();
			resultSet = statement.executeQuery(String.format(FIND_MASTER_QUERY, id_miembro));
			isMaster = resultSet.next();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		cerrar();
		return isMaster;
	}

	public void convertIntoGameMaster(String id_miembro, String alias) {

		try {
			Statement statement = conectar().createStatement();
			statement.executeUpdate(String.format(INSERT_MASTER, id_miembro, alias));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		cerrar();
	}
	
	public ArrayList<Personaje> cargarTodosPersonajes(String id_partida) {
		ArrayList<Personaje> personajes = new ArrayList<>();
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT p.id_partida, per.nombre, per.raza, per.clase, per.nivel_experiencia \r\n"
							+ "FROM Partida p\r\n"
							+ "JOIN Personaje per ON p.id_partida = per.id_personaje\r\n"
							+ "WHERE p.id_partida = "+ id_partida);
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String raza = rs.getString("raza");
				String clase = rs.getString("clase");
				int nivelExperiencia = rs.getInt("nivel_experiencia");

				Personaje personaje = new Personaje(nombre, nivelExperiencia, raza, clase);
				personajes.add(personaje);
			}
			rs.close();
			stmt.close();
			cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personajes;

	}
	
}
