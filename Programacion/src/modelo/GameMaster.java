/**
 * 
 */
package modelo;

/**
 * 
 */
public class GameMaster {

	private int idGameMaster;
	private String alias;
	private int idMiembro;

	public GameMaster(int idGameMaster, String alias, int idMiembro) {
		this.idGameMaster = idGameMaster;
		this.alias = alias;
		this.idMiembro = idMiembro;
	}

	public int getIdGameMaster() {
		return idGameMaster;
	}

	public String getAlias() {
		return alias;
	}

	public int getIdMiembro() {
		return idMiembro;
	}

}
