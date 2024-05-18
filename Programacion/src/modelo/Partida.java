
package modelo;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * La clase Partida representa una partida en un juego de rol (RPG).
 * 
 * Cada partida tiene un identificador único, un nombre, una fecha y hora de
 * inicio, un número de sesión, una ambientación, un estado de finalización, una
 * duración de sesión y está asociada a un Game Master específico.
 * 
 * Los constructores de la clase permiten crear una partida con diferentes
 * combinaciones de atributos. Además, se proporciona un constructor por
 * defecto.
 * 
 * El método toString() de esta clase permite obtener una representación en
 * forma de cadena del nombre de la partida.
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

	/**
	 * Constructor completo para la clase Partida.
	 * 
	 * @param idPartida      El identificador único de la partida.
	 * @param nombre         El nombre de la partida.
	 * @param diaHora        La fecha y hora de inicio de la partida.
	 * @param numeroSesion   El número de sesión de la partida.
	 * @param ambientacion   La ambientación de la partida.
	 * @param finalizada     El estado de finalización de la partida.
	 * @param duracionSesion La duración de sesión de la partida.
	 * @param idGameMaster   El identificador del Game Master que controla esta
	 *                       partida.
	 */
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

	/**
	 * Constructor alternativo para la clase Partida, proporcionando solo los
	 * atributos básicos.
	 * 
	 * @param nombre         El nombre de la partida.
	 * @param diaHora        La fecha y hora de inicio de la partida.
	 * @param finalizada     El estado de finalización de la partida.
	 * @param duracionSesion La duración de sesión de la partida.
	 * @param ambientacion   La ambientación de la partida.
	 */
	public Partida(String nombre, String diaHora, String finalizada, String duracionSesion, String ambientacion) {
		this.nombre = nombre;
		this.diaHora = diaHora;
		this.ambientacion = ambientacion;
		this.finalizada = finalizada;
		this.duracionSesion = duracionSesion;
	}

	/**
	 * Genera una representación en forma de cadena del nombre de la partida.
	 * 
	 * @return Una cadena que representa el nombre de la partida.
	 */
	@Override
	public String toString() {
		return nombre;
	}

	// Getter y Setter
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
