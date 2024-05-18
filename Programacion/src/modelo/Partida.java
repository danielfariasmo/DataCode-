
package modelo;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
public class Partida {

	private String idPartida;
	private String nombre;
	private String diaHora;
	private String numeroSesion;
	private String ambientacion;
	private String finalizada;
	private String duracionSesion;
	private String idGameMaster;

	public Partida(String idPartida, String nombre, String diaHora, String numeroSesion, String ambientacion,
			String finalizada, String duracionSesion, String idGameMaster) {
		this.idPartida = idPartida;
		this.nombre = nombre;
		this.diaHora = diaHora;
		this.numeroSesion = numeroSesion;
		this.ambientacion = ambientacion;
		this.finalizada = finalizada;
		this.duracionSesion = duracionSesion;
		this.idGameMaster = idGameMaster;
	}
	
	public Partida (String nombre, String diaHora, String finalizada, String duracionSesion, String ambientacion) {
		this.nombre = nombre;
		this.diaHora = diaHora;
		this.ambientacion = ambientacion;
		this.finalizada = finalizada;
		this.duracionSesion = duracionSesion;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public String getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(String idPartida) {
		this.idPartida = idPartida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDiaHora() {
		return diaHora;
	}

	public void setDiaHora(String diaHora) {
		this.diaHora = diaHora;
	}

	public String getNumeroSesion() {
		return numeroSesion;
	}

	public void setNumeroSesion(String numeroSesion) {
		this.numeroSesion = numeroSesion;
	}

	public String getAmbientacion() {
		return ambientacion;
	}

	public void setAmbientacion(String ambientacion) {
		this.ambientacion = ambientacion;
	}

	public String getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(String finalizada) {
		this.finalizada = finalizada;
	}

	public String getDuracionSesion() {
		return duracionSesion;
	}

	public void setDuracionSesion(String duracionSesion) {
		this.duracionSesion = duracionSesion;
	}

	public String getIdGameMaster() {
		return idGameMaster;
	}

	public void setIdGameMaster(String idGameMaster) {
		this.idGameMaster = idGameMaster;
	}

}
