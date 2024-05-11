/**
 * 
 */
package modelo;

/**
 * 
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
