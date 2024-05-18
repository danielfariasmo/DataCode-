/**
 * Clase que representa la participación de un personaje en una partida.
 */
package modelo;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * Clase que modela la participación de un personaje en una partida de juego.
 */
public class Juega {

	private int idPersonaje;
	private int id_partida;
	private String descripcion;
	private int fuerza;
	private int destreza;
	private int constitucion;
	private int inteligencia;
	private int sabiduria;
	private int carisma;

	/**
	 * Constructor de la clase Juega.
	 * 
	 * @param idPersonaje  El ID del personaje que participa en la partida.
	 * @param id_partida   El ID de la partida en la que participa el personaje.
	 * @param descripcion  Una descripción de la participación del personaje en la
	 *                     partida.
	 * @param fuerza       La fuerza del personaje durante la partida.
	 * @param destreza     La destreza del personaje durante la partida.
	 * @param constitucion La constitución del personaje durante la partida.
	 * @param inteligencia La inteligencia del personaje durante la partida.
	 * @param sabiduria    La sabiduría del personaje durante la partida.
	 * @param carisma      El carisma del personaje durante la partida.
	 */
	public Juega(int idPersonaje, int id_partida, String descripcion, int fuerza, int destreza, int constitucion,
			int inteligencia, int sabiduria, int carisma) {
		this.idPersonaje = idPersonaje;
		this.id_partida = id_partida;
		this.descripcion = descripcion;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.constitucion = constitucion;
		this.inteligencia = inteligencia;
		this.sabiduria = sabiduria;
		this.carisma = carisma;
	}

	// getters y setters
	public int getIdPersonaje() {
		return idPersonaje;
	}

	public int getId_partida() {
		return id_partida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public int getConstitucion() {
		return constitucion;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getSabiduria() {
		return sabiduria;
	}

	public int getCarisma() {
		return carisma;
	}

}
