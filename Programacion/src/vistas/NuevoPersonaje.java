
package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControlNuevoPersonaje;
import modelo.Miembro;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * Esta clase representa la vista para la creación de un nuevo personaje.
 * Permite al usuario ingresar información como el nombre, raza, clase y nivel
 * de experiencia del personaje.
 */
public class NuevoPersonaje extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textoNombre;
	private JComboBox<String> comboRaza;
	private JComboBox<String> comboExperiencia;
	private JComboBox<String> comboClase;
	private Miembro miembro;
	private JLabel labelNombrePersonaje;
	private JLabel labelRaza;
	private JLabel labelClase;
	private JLabel labelNivelExperiencia;
	private JButton botonAceptar;
	private JLabel labelNuevoPersonaje;

	/**
	 * Constructor de la clase NuevoPersonaje.
	 * 
	 * @param miembro Objeto Miembro que representa al usuario que está creando el
	 *                personaje.
	 */
	public NuevoPersonaje(Miembro miembro) {
		setToolTipText("");
		this.miembro = miembro;
		configuracionInicial();
		inicializarComponentes();
	}

	/**
	 * Realiza la configuración inicial de la interfaz gráfica.
	 */
	public void configuracionInicial() {
		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1300, 660);
	}

	/**
	 * Inicializa y agrega todos los componentes de la interfaz gráfica.
	 */
	public void inicializarComponentes() {
		// Campo de texto para el nombre del personaje
		textoNombre = new JTextField();
		textoNombre.setToolTipText("");
		textoNombre.setFont(new Font("Verdana", Font.PLAIN, 20));
		textoNombre.setLocation(372, 132);
		textoNombre.setSize(335, 64);
		textoNombre.setForeground(new Color(0, 0, 0));
		add(textoNombre, BorderLayout.EAST);
		textoNombre.setColumns(10);

		// Etiqueta para el nombre del personaje
		labelNombrePersonaje = new JLabel("Nombre Personaje:");
		labelNombrePersonaje.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNombrePersonaje.setForeground(new Color(255, 255, 255));
		add(labelNombrePersonaje, BorderLayout.NORTH);
		labelNombrePersonaje.setBounds(37, 127, 319, 75);

		// Etiqueta para la raza
		labelRaza = new JLabel("Raza:");
		labelRaza.setFont(new Font("Verdana", Font.BOLD, 25));
		labelRaza.setForeground(new Color(255, 255, 255));
		add(labelRaza, BorderLayout.NORTH);
		labelRaza.setBounds(769, 125, 109, 75);

		// Etiqueta para la clase
		labelClase = new JLabel("Clase:");
		labelClase.setFont(new Font("Verdana", Font.BOLD, 25));
		labelClase.setForeground(new Color(255, 255, 255));
		add(labelClase, BorderLayout.NORTH);
		labelClase.setBounds(769, 253, 127, 75);

		// Etiqueta para el nivel de experiencia
		labelNivelExperiencia = new JLabel("Nivel de Experiencia:");
		labelNivelExperiencia.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNivelExperiencia.setForeground(new Color(255, 255, 255));
		add(labelNivelExperiencia, BorderLayout.NORTH);
		labelNivelExperiencia.setBounds(37, 253, 319, 75);

		// Boton Aceptar
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(new Color(37, 34, 81));
		botonAceptar.setBackground(new Color(135, 206, 235));
		botonAceptar.setFont(new Font("Verdana", Font.BOLD, 25));
		botonAceptar.setBounds(615, 427, 221, 56);
		botonAceptar.addActionListener(new ControlNuevoPersonaje(this));
		add(botonAceptar);

		// Etiqueta para el título "NUEVO PERSONAJE"
		labelNuevoPersonaje = new JLabel("NUEVO PERSONAJE");
		labelNuevoPersonaje.setForeground(new Color(255, 255, 255));
		labelNuevoPersonaje.setFont(new Font("Verdana", Font.BOLD, 40));
		labelNuevoPersonaje.setBounds(518, 23, 467, 46);
		add(labelNuevoPersonaje);

		// ComboBox para la selección de la raza
		comboRaza = new JComboBox<>();
		comboRaza.setFont(new Font("Verdana", Font.PLAIN, 20));
		comboRaza.setBounds(888, 132, 327, 64);
		comboRaza.addItem(" --Seleccione la Raza--");
		comboRaza.addItem("Draconido");
		comboRaza.addItem("Elfo");
		comboRaza.addItem("Enano");
		comboRaza.addItem("Hobbit");
		comboRaza.addItem("Humano");
		comboRaza.addItem("Mediano");
		comboRaza.addItem("Semiorco");
		add(comboRaza);

		// ComboBox para la selección de la experiencia
		comboExperiencia = new JComboBox<>();
		comboExperiencia.setFont(new Font("Verdana", Font.PLAIN, 20));
		comboExperiencia.setBounds(372, 260, 335, 64);
		comboExperiencia.addItem(" --Seleccione la Experiencia--");
		comboExperiencia.addItem("1");
		comboExperiencia.addItem("2");
		comboExperiencia.addItem("3");
		comboExperiencia.addItem("4");
		comboExperiencia.addItem("5");
		comboExperiencia.addItem("0");
		add(comboExperiencia);

		// ComboBox para la selección de la clase
		comboClase = new JComboBox<>();
		comboClase.setFont(new Font("Verdana", Font.PLAIN, 20));
		comboClase.setBounds(888, 260, 327, 64);
		comboClase.addItem(" --Seleccione la Clase--");
		comboClase.addItem("Contrabandista");
		comboClase.addItem("Guardian");
		comboClase.addItem("Guerrero");
		comboClase.addItem("Heroe");
		comboClase.addItem("Mago");
		comboClase.addItem("Paladin");
		comboClase.addItem("Picaro");
		add(comboClase);
	}

	/**
	 * Muestra un mensaje de éxito o error según el resultado de la operación.
	 * 
	 * @param exitoso true si la operación fue exitosa, false de lo contrario.
	 * @param mensaje el mensaje a mostrar.
	 */
	public void mensaje(boolean exitoso, String mensaje) {

		if (exitoso) {
			JOptionPane.showMessageDialog(this, mensaje);
		} else {
			JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Limpia los campos del formulario.
	 */
	public void limpiarCampos() {
		textoNombre.setText("");
		comboClase.setSelectedIndex(0);
	    comboExperiencia.setSelectedIndex(0);
	    comboRaza.setSelectedIndex(0);
		
	}

	// Getters and Setters.
	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public void setTextoNombre(JTextField textoNombre) {
		this.textoNombre = textoNombre;
	}

	public JComboBox<String> getComboRaza() {
		return comboRaza;
	}

	public void setComboRaza(JComboBox<String> comboRaza) {
		this.comboRaza = comboRaza;
	}

	public JComboBox<String> getComboExperiencia() {
		return comboExperiencia;
	}

	public void setComboExperiencia(JComboBox<String> comoboExperiencia) {
		this.comboExperiencia = comoboExperiencia;
	}

	public JComboBox<String> getComboClase() {
		return comboClase;
	}

	public void setComboClase(JComboBox<String> comboClase) {
		this.comboClase = comboClase;
	}

	public Miembro getMiembro() {
		return miembro;
	}

}