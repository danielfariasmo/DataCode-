
package modelo;



public class Miembro {
	
	private String nombre_apelidos;

	public Miembro(String nombre_apelidos) {
		this.nombre_apelidos = nombre_apelidos;
	}

	public String getNombre_apelidos() {
		return nombre_apelidos;
	}

	public void setNombre_apelidos(String nombre_apelidos) {
		this.nombre_apelidos = nombre_apelidos;
	}

	@Override
	public String toString() {
		return nombre_apelidos;
	}
	
	
	

}