package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ConexionBBDD;
import modelo.Personaje;
import vistas.NuevoPersonaje;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * Controlador para la creación de nuevos personajes en la interfaz gráfica.
 * Gestiona las acciones realizadas en la vista NuevoPersonaje. Implementa
 * ActionListener para manejar eventos de usuario.
 */

public class ControlNuevoPersonaje implements ActionListener {

	private NuevoPersonaje nuevoPersonaje;

	private ConexionBBDD conexionBBDD;

	/**
	 * Constructor que recibe una instancia de NuevoPersonaje.
	 * 
	 * @param nuevo La vista NuevoPersonaje asociada al controlador.
	 */
	public ControlNuevoPersonaje(NuevoPersonaje nuevo) {

		this.nuevoPersonaje = nuevo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Se crea un nuevo objeto de tipo Personaje.
		Personaje personaje = new Personaje();
		
		try {

			// Se establecen los atributos del personaje con los valores de los elementos de
			// la vista.
			personaje.setNombre(nuevoPersonaje.getTextoNombre().getText());
			personaje.setClase(nuevoPersonaje.getComboClase().getSelectedItem().toString());
			personaje.setNivelExperiencia(nuevoPersonaje.getComboExperiencia().getSelectedIndex());
			personaje.setRaza(nuevoPersonaje.getComboRaza().getSelectedItem().toString());

			// Se asigna el ID del miembro asociado al personaje.
			personaje.setId_miembro(nuevoPersonaje.getMiembro().getIdMiembro());

			conexionBBDD = new ConexionBBDD();
			// Se verifica que los campos obligatorios no estén vacíos antes de guardar el
			// personaje.
			if (!personaje.getNombre().trim().isEmpty() && !personaje.getRaza().isEmpty()
				    && !personaje.getClase().isEmpty()) {
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
