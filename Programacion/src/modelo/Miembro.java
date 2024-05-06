
package modelo;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

public class Miembro {
	
	public static final String ID_MIEMBRO = "id_miembro";
	public static final String NOMBRE_APELLIDOS = "nombre_apellidos";
	public static final String NUMERO_EXPEDIENTE = "numero_expediente";
	public static final String NOMBRE_ESTUDIO = "nombre_estudio";
	public static final String NOMBRE_USUARIO = "nombre_usuario";
	public static final String CLAVE_USUARIO = "clave_usuario";

	private String idMiembro;
	private String nombreApellidos;
	private int numeroExpediente;
	private String nombreEstudio;
	private String nombreUsuario;
	private String claveUsuario;
	private String alias;

	public Miembro(String idMiembro, String nombreApellidos, int numeroExpediente, String nombreEstudio,
			String nombreUsuario, String claveUsuario) {
		this.idMiembro = idMiembro;
		this.nombreApellidos = nombreApellidos;
		this.numeroExpediente = numeroExpediente;
		this.nombreEstudio = nombreEstudio;
		this.nombreUsuario = nombreUsuario;
		this.claveUsuario = claveUsuario;
	}
	
	// EJEMPLO LLAMAR CONSTRUCTOR
	public Miembro(String idMiembro, String nombreApellidos, int numeroExpediente) {
		this.idMiembro = idMiembro;
		this.nombreApellidos = nombreApellidos;
		this.numeroExpediente = numeroExpediente;
	}

	@Override
	public String toString() {
		return nombreApellidos + ". [Expediente: " + numeroExpediente + "]";
	}
	
	// EJEMPLO PARA IMPRIMIR.
	public String paraPartidas() {
		return "info miembro para partidas";
	}
	
	public boolean esMaster() {
		
		ConexionBBDD conn = new ConexionBBDD();
	
		return conn.isGameMaster(idMiembro);
	}

	public String getIdMiembro() {
		return idMiembro;
	}

	public void setIdMiembro(String idMiembro) {
		this.idMiembro = idMiembro;
	}

	public String getNombre_apelidos() {
		return nombreApellidos;
	}

	public void setNombre_apelidos(String nombre_apelidos) {
		this.nombreApellidos = nombre_apelidos;
	}

	public int getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(int numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public String getNombreEstudio() {
		return nombreEstudio;
	}

	public void setNombreEstudio(String nombreEstudio) {
		this.nombreEstudio = nombreEstudio;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	
}