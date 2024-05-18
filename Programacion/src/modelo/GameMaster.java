/**
 * Clase que representa un Game Master en el sistema.
 */
package modelo;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * Clase que modela un Game Master, quien tiene el control y supervisión del
 * juego.
 */
public class GameMaster {

	private int idGameMaster;
	private String alias;
	private int idMiembro;

	/**
	 * Constructor de la clase GameMaster.
	 * 
	 * @param idGameMaster El ID del Game Master.
	 * @param alias        El alias o nombre del Game Master.
	 * @param idMiembro    El ID del miembro asociado al Game Master.
	 */
	public GameMaster(int idGameMaster, String alias, int idMiembro) {
		this.idGameMaster = idGameMaster;
		this.alias = alias;
		this.idMiembro = idMiembro;
	}

	/**
	 * Obtiene el ID del Game Master.
	 * 
	 * @return El ID del Game Master.
	 */
	public int getIdGameMaster() {
		return idGameMaster;
	}

	/**
	 * Obtiene el alias o nombre del Game Master.
	 * 
	 * @return El alias o nombre del Game Master.
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Obtiene el ID del miembro asociado al Game Master.
	 * 
	 * @return El ID del miembro asociado al Game Master.
	 */
	public int getIdMiembro() {
		return idMiembro;
	}

}
