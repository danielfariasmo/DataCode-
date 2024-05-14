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
		
		personaje.setNombre(nuevoPersonaje.getTextoNombre().getText());
		personaje.setClase(nuevoPersonaje.getComboClase().getSelectedItem().toString());
		personaje.setNivelExperiencia(nuevoPersonaje.getComboExperiencia().getSelectedIndex());
		personaje.setRaza(nuevoPersonaje.getComboRaza().getSelectedItem().toString());
	
		conexionBBDD = new ConexionBBDD();
		
		personaje = conexionBBDD.guardarPersonaje(personaje);
	}
}
