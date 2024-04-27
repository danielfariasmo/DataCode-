
package modelo;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

public class Miembro {

	private String idMiembro;
	private String nombreApellidos;
	private String numeroExpediente;
	private String nombreEstudio;
	private String nombreUsuario;
	private String claveUsuario;

	public Miembro(String idMiembro, String nombreApellidos, String numeroExpediente, String nombreEstudio,
			String nombreUsuario, String claveUsuario) {
		this.idMiembro = idMiembro;
		this.nombreApellidos = nombreApellidos;
		this.numeroExpediente = numeroExpediente;
		this.nombreEstudio = nombreEstudio;
		this.nombreUsuario = nombreUsuario;
		this.claveUsuario = claveUsuario;
	}

	@Override
	public String toString() {
		return nombreApellidos + ". [Expediente: " + numeroExpediente + "]";
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

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
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

}