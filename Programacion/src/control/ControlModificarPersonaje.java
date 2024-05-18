package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.ConexionBBDD;
import modelo.Personaje;
import vistas.ModificarPersonaje;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * Controlador para la modificación de personajes en interfaz gráfica Gestiona
 * las acciones realizadas en la vista ModificarPersonaje Implementa
 * ActionListener para manejar eventos de usuario
 */
public class ControlModificarPersonaje implements ActionListener {

	private ModificarPersonaje modificarPersonaje;

	private ConexionBBDD conexionbbdd;

	/**
	 * Constructor que recibe una instancia de ModificarPersonaje
	 * 
	 * @param modificarPersonaje
	 */

	public ControlModificarPersonaje(ModificarPersonaje modificarPersonaje) {
		this.modificarPersonaje = modificarPersonaje;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Se crea un nuevo objeto de tipo Personaje.
		Personaje personaje = new Personaje();

		// Se establecen los atributos del personaje con los valores de los elementos de
		// la vista.
		personaje.setNombre(modificarPersonaje.getComboNombrePersonaje().getSelectedItem().toString());
		personaje.setClase(modificarPersonaje.getComboClase().getSelectedItem().toString());
		personaje.setNivelExperiencia((int) modificarPersonaje.getSpinnerExperiencia().getValue());
		personaje.setRaza(modificarPersonaje.getComboRaza().getSelectedItem().toString());

		// Se instancia la conexión a la base de datos.
		conexionbbdd = new ConexionBBDD();

		// Se actualiza el personaje en la base de datos.
		conexionbbdd.actualizarPersonaje(personaje);

	}

	/**
	 * Carga los personajes asociados a un miembro y los inserta en la vista
	 * ModificarPersonaje.
	 */
	public void cargarPersonaje() {
		conexionbbdd = new ConexionBBDD();

		// Se obtienen los personajes asociados al miembro
		ArrayList<Personaje> personajes = conexionbbdd.obtenerPersonaje(modificarPersonaje.getMiembro().getIdMiembro());

		// Se insertan los personajes en la vista ModificarPersonaje.
		modificarPersonaje.insertarPersonaje(personajes);
	}

	/**
	 * Actualiza un personaje en la base de datos con los datos ingresados en la
	 * vista.
	 * 
	 * @param personaje El personaje a actualizar.
	 */
	public void actualizarPersonaje(Personaje personaje) {

		conexionbbdd = new ConexionBBDD();

		try {
			// Se actualizan los atributos del personaje con los valores de la vista.
			personaje.setRaza(modificarPersonaje.getComboRaza().getSelectedItem().toString());
			personaje.setClase(modificarPersonaje.getComboClase().getSelectedItem().toString());
			personaje.setNivelExperiencia(
					Integer.valueOf(modificarPersonaje.getSpinnerExperiencia().getValue().toString()));

			// Se actualiza el personaje en la base de datos.
			conexionbbdd.actualizarPersonaje(personaje);
			modificarPersonaje.mensaje(true, "Se ha actualizado el personaje " + personaje.getNombre());
		} catch (Exception e) {
			modificarPersonaje.mensaje(false, "No se han rellenado los campos correctamente");
		}

	}

}
