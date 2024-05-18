package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.ConexionBBDD;
import modelo.Personaje;
import vistas.ModificarPersonaje;

public class ControlModificarPersonaje implements ActionListener{

	private ModificarPersonaje modificarPersonaje;
	
	private ConexionBBDD conexionbbdd;

	
	public ControlModificarPersonaje(ModificarPersonaje modificarPersonaje) {
		this.modificarPersonaje = modificarPersonaje;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Personaje personaje = new Personaje();
		
		personaje.setNombre(modificarPersonaje.getComboNombrePersonaje().getSelectedItem().toString());
		personaje.setClase(modificarPersonaje.getComboClase().getSelectedItem().toString());
		personaje.setNivelExperiencia((int) modificarPersonaje.getSpinnerExperiencia().getValue());
		personaje.setRaza(modificarPersonaje.getComboRaza().getSelectedItem().toString());
	
		conexionbbdd = new ConexionBBDD();
		
		conexionbbdd.actualizarPersonaje(personaje);
		
	}
	
	public void cargarPersonaje() {
		conexionbbdd = new ConexionBBDD();
		
		ArrayList<Personaje> personajes = conexionbbdd.obtenerPersonaje(modificarPersonaje.getMiembro().getIdMiembro());
		
		modificarPersonaje.insertarPersonaje(personajes);
	}
	
	public void actualizarPersonaje(Personaje personaje) {
		
		conexionbbdd = new ConexionBBDD();
		
		try {
			personaje.setRaza(modificarPersonaje.getComboRaza().getSelectedItem().toString());
			personaje.setClase(modificarPersonaje.getComboClase().getSelectedItem().toString());
			personaje.setNivelExperiencia(Integer.valueOf(modificarPersonaje.getSpinnerExperiencia().getValue().toString()));
			
			conexionbbdd.actualizarPersonaje(personaje);
			modificarPersonaje.mensaje(true, "Se ha elminiado el personaje " + personaje.getNombre());
		} catch (Exception e) {
			modificarPersonaje.mensaje(false, "No se han rellenado los campos correctamente");
		}
		
		
	}

}
