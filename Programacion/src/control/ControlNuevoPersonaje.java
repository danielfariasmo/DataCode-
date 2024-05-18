package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ConexionBBDD;
import modelo.Personaje;
import vistas.NuevoPersonaje;

public class ControlNuevoPersonaje implements ActionListener {

	private NuevoPersonaje nuevoPersonaje;
	
	private ConexionBBDD conexionBBDD;
	
	public ControlNuevoPersonaje(NuevoPersonaje nuevo) {
		
		this.nuevoPersonaje = nuevo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Personaje personaje = new Personaje();
		
		try {
			personaje.setNombre(nuevoPersonaje.getTextoNombre().getText());
			personaje.setClase(nuevoPersonaje.getComboClase().getSelectedItem().toString());
			personaje.setNivelExperiencia(nuevoPersonaje.getComboExperiencia().getSelectedIndex());
			personaje.setRaza(nuevoPersonaje.getComboRaza().getSelectedItem().toString());
			
			personaje.setId_miembro(nuevoPersonaje.getMiembro().getIdMiembro());
		
			conexionBBDD = new ConexionBBDD();
			if(!personaje.getNombre().trim().isEmpty() && !personaje.getRaza().isEmpty() && personaje.getRaza().isEmpty()) {
				conexionBBDD.guardarPersonaje(personaje);
				nuevoPersonaje.mensaje(true, "Se ha creado tu personaje " + personaje.getNombre());
			} else {
				nuevoPersonaje.mensaje(false, "No se ha podido crear el personaje.");
			}
			
			
		} catch (Exception e2) {
			nuevoPersonaje.mensaje(false, "No se ha podido crear el personaje.");
		}
		
		
		
	}
	
}
