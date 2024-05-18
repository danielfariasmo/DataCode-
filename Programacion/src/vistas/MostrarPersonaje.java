/**
 * 
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.ControlMenuPrincipalUsuario;
import modelo.Personaje;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Panel para mostrar y eliminar personajes.
 */
public class MostrarPersonaje extends JPanel {
	/**
	 * Serial version UID para la serialización.
	 */
	private static final long serialVersionUID = 1L;
	// Componentes de la interfaz de usuario
	private JComboBox<Personaje> mostrarPersonaje;
	private ControlMenuPrincipalUsuario control;

	/**
	 * Constructor de la clase MostrarPersonaje.
	 * 
	 * @param control ControlMenuPrincipalUsuario para manejar las acciones del
	 *                panel.
	 */
	public MostrarPersonaje(ControlMenuPrincipalUsuario control) {
		this.control = control;
		configuracionInicial();
		inicializarComponentes();
	}

	/**
	 * Configuración inicial del panel.
	 */
	public void configuracionInicial() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setSize(1300, 660);
		setLayout(null);// Diseño nulo para ubicar los componentes manualmente

	}

	/**
	 * Inserta los personajes en el JComboBox.
	 * 
	 * @param array ArrayList de Personaje a insertar en el JComboBox.
	 */
	public void insertarPersonaje(ArrayList<Personaje> array) {
		DefaultComboBoxModel<Personaje> dcbm = new DefaultComboBoxModel<Personaje>();
		dcbm.addAll(array);
		mostrarPersonaje.setModel(dcbm);
	}

	/**
	 * Inicializa los componentes del panel.
	 */
	public void inicializarComponentes() {
		// JComboBox para mostrar los personajes
		mostrarPersonaje = new JComboBox<Personaje>();
		mostrarPersonaje.setBackground(new Color(255, 255, 255));
		mostrarPersonaje.setForeground(new Color(37, 34, 81));
		mostrarPersonaje.setFont(new Font("Verdana", Font.PLAIN, 17));
		mostrarPersonaje.setBounds(433, 195, 465, 66);
		add(mostrarPersonaje);
		// Etiqueta para indicar que se muestran personajes
		JLabel lblNewLabel = new JLabel("PERSONAJES:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 40));
		lblNewLabel.setBounds(500, 88, 320, 52);
		add(lblNewLabel);
		// Botón para eliminar un personaje
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setForeground(new Color(37, 34, 81));
		botonEliminar.setBackground(new Color(135, 206, 235));
		botonEliminar.setFont(new Font("Verdana", Font.BOLD, 25));
		botonEliminar.setBounds(560, 370, 208, 37);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción al hacer clic en el botón
				elminarPersonaje();
			}
		});
		// Agrega el botón al panel
		add(botonEliminar);
	}

	/**
	 * Elimina el personaje seleccionado.
	 */
	public void elminarPersonaje() {
		// Obtiene el personaje seleccionado del JComboBox
		Personaje personaje = (Personaje) mostrarPersonaje.getSelectedItem();
		// Notifica al controlador para eliminar el personaje
		control.eliminarPersonaje(personaje);

	}

	/**
	 * Muestra un mensaje en una ventana emergente.
	 * 
	 * @param exitoso true si la operación fue exitosa, false si hubo un error.
	 * @param mensaje mensaje a mostrar en la ventana emergente.
	 */
	public void mensaje(boolean exitoso, String mensaje) {

		if (exitoso) {
			// Muestra un mensaje de éxito
			JOptionPane.showMessageDialog(this, mensaje);
		} else {
			// Muestra un mensaje de error
			JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
