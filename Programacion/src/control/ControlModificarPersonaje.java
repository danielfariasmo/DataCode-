package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ConexionBBDD;
import modelo.Personaje;
import vistas.ModificarPersonaje;

public class ControlModificarPersonaje implements ActionListener{

	private ModificarPersonaje modificarPersonaje;
	
	private ConexionBBDD conexionBBDD;
	
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
	
		conexionBBDD = new ConexionBBDD();
		
		personaje = conexionBBDD.actualizarPersonaje(personaje);
		
	}

}
