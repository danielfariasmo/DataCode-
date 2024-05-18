/**
 * 
 */
package modelo;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * La clase Personaje representa a un personaje en un juego de rol (RPG).
 * 
 * Cada personaje tiene un identificador único, un nombre, una raza, un nivel de
 * experiencia, y una clase. Además, está asociado a un miembro específico que
 * lo controla.
 * 
 * Los constructores de la clase permiten crear un personaje con diferentes
 * combinaciones de atributos. Además, se proporciona un constructor por
 * defecto.
 *
 * Los métodos de esta clase permiten acceder y modificar los atributos del
 * personaje, así como generar una representación en forma de cadena del mismo.
 */

public class Personaje {

	private String idPersonaje;
	private String nombre;
	private String raza;
	private int nivelExperiencia;
	private String clase;
	private String id_miembro;

	/**
	 * Constructor completo para la clase Personaje.
	 * 
	 * @param idPersonaje      El identificador único del personaje.
	 * @param nombre           El nombre del personaje.
	 * @param raza             La raza del personaje.
	 * @param nivelExperiencia El nivel de experiencia del personaje.
	 * @param clase            La clase del personaje.
	 * @param id_miembro       El identificador del miembro que controla este
	 *                         personaje.
	 */
	public Personaje(String idPersonaje, String nombre, String raza, int nivelExperiencia, String clase,
			String id_miembro) {
		this.idPersonaje = idPersonaje;
		this.nombre = nombre;
		this.raza = raza;
		this.nivelExperiencia = nivelExperiencia;
		this.clase = clase;
		this.id_miembro = id_miembro;
	}

	/**
	 * Constructor alternativo para la clase Personaje, proporcionando solo el
	 * nombre y nivel de experiencia.
	 * 
	 * @param nombre           El nombre del personaje.
	 * @param nivelExperiencia El nivel de experiencia del personaje.
	 */
	public Personaje(String nombre, int nivelExperiencia) {
		this.nombre = nombre;
		this.nivelExperiencia = nivelExperiencia;
	}

	/**
	 * Constructor alternativo para la clase Personaje, proporcionando el nombre,
	 * nivel de experiencia, raza y clase.
	 * 
	 * @param nombre           El nombre del personaje.
	 * @param nivelExperiencia El nivel de experiencia del personaje.
	 * @param raza             La raza del personaje.
	 * @param clase            La clase del personaje.
	 */
	public Personaje(String nombre, int nivelExperiencia, String raza, String clase) {
		this.nombre = nombre;
		this.nivelExperiencia = nivelExperiencia;
		this.clase = clase;
		this.raza = raza;
	}

	/**
	 * Genera una representación en forma de cadena del personaje.
	 * 
	 * @return Una cadena que representa el personaje.
	 */
	@Override
	public String toString() {
		return "Personaje: " + nombre + ". [Experiencia: " + nivelExperiencia + "]";
	}

	// Getter y Setter
	public String getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(String idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getNivelExperiencia() {
		return nivelExperiencia;
	}

	public void setNivelExperiencia(int nivelExperiencia) {
		this.nivelExperiencia = nivelExperiencia;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getId_miembro() {
		return id_miembro;
	}

	public void setId_miembro(String id_miembro) {
		this.id_miembro = id_miembro;
	}

}