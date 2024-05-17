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

		try {
			// Indicamos la clase a la que vamos a acceder
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Damos ubicacion en MySql
			return DriverManager.getConnection(url, "root", "Villafranca1");
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Personaje WHERE id_miembro=" + idMiembro);
			while (rs.next()) {
				String idPersonaje = String.valueOf(rs.getInt("id_personaje"));
				String nombre = rs.getString("nombre");
				String raza = rs.getString("raza");
				int nivelExperiencia = rs.getInt("nivel_experiencia");
				String clase = rs.getString("clase");

				Personaje personaje = new Personaje(idPersonaje, nombre, raza, nivelExperiencia, clase, idMiembro);
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Partida");
			while (rs.next()) {
				String idPartida = String.valueOf(rs.getInt("id_partida"));
				String nombre = rs.getString("nombre");
				String dia_hora = rs.getString("dia_hora");
				String numeroSesion = String.valueOf(rs.getInt("numero_sesion"));
				String duracion_sesion = rs.getString("duracion_sesion");
				String ambientacion = rs.getString("ambientacion");
				String finalizada = rs.getString("finalizada");
				String idGameMaster = rs.getString("id_gameMaster");

				Partida partida = new Partida(idPartida, nombre, dia_hora, numeroSesion, ambientacion, finalizada,
						duracion_sesion, idGameMaster);
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
		} catch (NumberFormatException e) {
			System.out.println("Error convirtiendo a entero la clave."); 
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
					.executeQuery("SELECT j.id_partida, per.nombre, per.raza, per.clase, per.nivel_experiencia "
							+ "FROM Juega j " + "JOIN Personaje per ON j.id_personaje = per.id_personaje "
							+ "WHERE j.id_partida = " + id_partida);
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

	public void agregarPartida(Juega partidaActual) {

		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(
					"INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma) "
							+ "VALUES (" + partidaActual.getIdPersonaje() + ", " + partidaActual.getId_partida() + ", '"
							+ partidaActual.getDescripcion() + "', " + partidaActual.getFuerza() + ", "
							+ partidaActual.getDestreza() + ", " + partidaActual.getConstitucion() + ", "
							+ partidaActual.getInteligencia() + ", " + partidaActual.getSabiduria() + ", "
							+ partidaActual.getCarisma() + ");");

			stmt.close();
			cerrar();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String[]> obtenerPartidasActuales(String id_miembro) {

		ArrayList<String[]> obtenerPatida = new ArrayList<String[]>();
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			// TODO: error en consulta
			ResultSet rs = stmt.executeQuery(
					"SELECT p.nombre, p.finalizada, per.nombre AS nombre_personaje, j.fuerza, j.destreza, j.constitucion, j.inteligencia, j.sabiduria, j.carisma  FROM Juega j "
							+ "JOIN Personaje per ON j.id_personaje = per.id_personaje "
							+ "JOIN Partida p ON p.id_partida = j.id_partida WHERE per.id_miembro = " + id_miembro);
			while (rs.next()) {
				String nombrePartida = rs.getString("nombre");
				String finalizada = rs.getString("finalizada");
				String nombrePersonaje = rs.getString("nombre_personaje");
				String fuerza = String.valueOf(rs.getInt("fuerza"));
				String destreza = String.valueOf(rs.getInt("destreza"));
				String constitucion = String.valueOf(rs.getInt("constitucion"));
				String inteligencia = String.valueOf(rs.getInt("inteligencia"));
				String sabiduria = String.valueOf(rs.getInt("sabiduria"));
				String carisma = String.valueOf(rs.getInt("carisma"));

				String[] registro = new String[] { nombrePartida, finalizada, nombrePersonaje, fuerza, destreza,
						constitucion, inteligencia, sabiduria, carisma };

				obtenerPatida.add(registro);
			}
			rs.close();
			stmt.close();
			cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obtenerPatida;
	}

	public ArrayList<String[]> obtenerCaracteristicasPartida(String idPersonaje) {

		ArrayList<String[]> obtenerPatida = new ArrayList<String[]>();
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			// TODO: error en consulta
			ResultSet rs = stmt.executeQuery("SELECT p.nombre, p.id_partida  "
					+ "FROM Juega j JOIN Personaje per ON j.id_personaje = per.id_personaje "
					+ "JOIN Partida p ON p.id_partida = j.id_partida WHERE per.id_personaje =" + idPersonaje);
			while (rs.next()) {
				String nombrePartida = rs.getString("nombre");
				String idPartida = String.valueOf(rs.getInt("id_partida"));

				String[] registro = new String[] { nombrePartida, idPartida };

				obtenerPatida.add(registro);
			}
			rs.close();
			stmt.close();
			cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obtenerPatida;
	}

	public Juega consultarCaracteristicas(int idPersonaje, int idPartida) {

		Juega caracteristicas = null;

		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			// TODO: error en consulta
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM juega WHERE id_personaje = " + idPersonaje + " AND id_partida = " + idPartida);
			while (rs.next()) {
				String descripcion = rs.getString("descripcion");
				int fuerza = rs.getInt("fuerza");
				int destreza = rs.getInt("destreza");
				int constitucion = rs.getInt("constitucion");
				int inteligencia = rs.getInt("inteligencia");
				int sabiduria = rs.getInt("sabiduria");
				int carisma = rs.getInt("carisma");

				caracteristicas = new Juega(idPersonaje, idPartida, descripcion, fuerza, destreza, constitucion,
						inteligencia, sabiduria, carisma);

			}
			rs.close();
			stmt.close();
			cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return caracteristicas;

	}

	public void actualizarCaracteristicasPersonaje(Juega juega) {

		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			String sentencia = ("UPDATE Juega SET fuerza = " + juega.getFuerza() + ", destreza = " + juega.getDestreza()
			+ ", constitucion = " + juega.getConstitucion() + ", inteligencia = " + juega.getInteligencia()
			+ ", sabiduria = " + juega.getSabiduria() + ", carisma = " + juega.getCarisma()
			+ " WHERE id_personaje = " + juega.getIdPersonaje() + " AND id_partida = " + juega.getId_partida());
			
			stmt.executeUpdate(sentencia);

			stmt.close();
			cerrar();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Personaje guardarPersonaje(Personaje personaje) {
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO Personaje(id_personaje, nombre"
					+ ",raza, nivel_experiencia, clase, id_miembro) values(" + personaje.getIdPersonaje() + "," + ""
					+ personaje.getNombre() + "," + personaje.getRaza() + "," + "" + personaje.getNivelExperiencia()
					+ "," + "" + personaje.getClase() + "," + "" + personaje.getId_miembro() + ")");
			Personaje personajeSaved = null;
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String raza = rs.getString("raza");
				String clase = rs.getString("clase");
				int nivelExperiencia = rs.getInt("nivel_experiencia");

				personajeSaved = new Personaje(nombre, nivelExperiencia, raza, clase);
			}
			rs.close();
			stmt.close();
			cerrar();
			return personajeSaved;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Personaje actualizarPersonaje(Personaje personaje) {
		try {
			Connection conn = conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE Personaje SET " + "id_personaje = " + personaje.getIdPersonaje()
					+ ", " + "nombre = " + personaje.getNombre() + "" + ",raza = " + personaje.getRaza() + ", "
					+ "nivel_experiencia = " + personaje.getNivelExperiencia() + ", " + "clase = "
					+ personaje.getClase() + ", " + "id_miembro = " + personaje.getId_miembro() + " "
					+ "WHERE id_personaje = " + personaje.getIdPersonaje() + "");
			Personaje personajeUpdated = null;
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String raza = rs.getString("raza");
				String clase = rs.getString("clase");
				int nivelExperiencia = rs.getInt("nivel_experiencia");

				personajeUpdated = new Personaje(nombre, nivelExperiencia, raza, clase);
			}
			rs.close();
			stmt.close();
			cerrar();
			return personajeUpdated;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}