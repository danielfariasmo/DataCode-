/**
 * 
 */
package modelo;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

public class Personaje {

	private String idPersonaje;
	private String nombre;
	private String raza;
	private int nivelExperiencia;
	private String clase;
	private String id_miembro;

	public Personaje(String idPersonaje, String nombre, String raza, int nivelExperiencia, String clase,
			String id_miembro) {
		this.idPersonaje = idPersonaje;
		this.nombre = nombre;
		this.raza = raza;
		this.nivelExperiencia = nivelExperiencia;
		this.clase = clase;
		this.id_miembro = id_miembro;
	}
	
	public Personaje (String nombre, int nivelExperiencia) {
		this.nombre = nombre;
		this.nivelExperiencia = nivelExperiencia;
	}

	@Override
	public String toString() {
		return "Personaje: " + nombre + ". [Nivel Experiencia: " + nivelExperiencia +"]";
	}

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
