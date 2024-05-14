/**
 * 
 */
package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NuevoPersonaje extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoNombre;

	public NuevoPersonaje() {
		setToolTipText("");

		configuracionInicial();
		inicializarComponentes();

	}

	public void configuracionInicial() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1300, 660);

	}

	public void inicializarComponentes() {

		textoNombre = new JTextField();
		textoNombre.setToolTipText("");
		textoNombre.setFont(new Font("Verdana", Font.PLAIN, 20));
		textoNombre.setLocation(372, 132);
		textoNombre.setSize(335, 64);
		textoNombre.setForeground(new Color(0, 0, 0));
		add(textoNombre, BorderLayout.EAST);
		textoNombre.setColumns(10);

		// Nombre del personaje
		JLabel labelNombrePersonaje = new JLabel("Nombre Personaje:");
		labelNombrePersonaje.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNombrePersonaje.setForeground(new Color(255, 255, 255));
		add(labelNombrePersonaje, BorderLayout.NORTH);
		labelNombrePersonaje.setBounds(60, 127, 296, 75);

		// Raza
		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setFont(new Font("Verdana", Font.BOLD, 25));
		labelRaza.setForeground(new Color(255, 255, 255));
		add(labelRaza, BorderLayout.NORTH);
		labelRaza.setBounds(769, 125, 109, 75);

		// Clase
		JLabel labelClase = new JLabel("Clase:");
		labelClase.setFont(new Font("Verdana", Font.BOLD, 25));
		labelClase.setForeground(new Color(255, 255, 255));
		add(labelClase, BorderLayout.NORTH);
		labelClase.setBounds(769, 253, 127, 75);

		// Nivel de experiencia
		JLabel labelNivelExperiencia = new JLabel("Nivel de Experiencia:");
		labelNivelExperiencia.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNivelExperiencia.setForeground(new Color(255, 255, 255));
		add(labelNivelExperiencia, BorderLayout.NORTH);
		labelNivelExperiencia.setBounds(60, 253, 296, 75);

		// Boton Aceptar
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(new Color(37, 34, 81));
		botonAceptar.setBackground(new Color(135, 206, 235));
		botonAceptar.setFont(new Font("Verdana", Font.BOLD, 25));
		botonAceptar.setBounds(577, 427, 221, 56);
		add(botonAceptar);
		
		JLabel labelNuevoPersonaje = new JLabel("NUEVO PERSONAJE");
		labelNuevoPersonaje.setForeground(new Color(255, 255, 255));
		labelNuevoPersonaje.setFont(new Font("Verdana", Font.BOLD, 40));
		labelNuevoPersonaje.setBounds(518, 23, 467, 46);
		add(labelNuevoPersonaje);
		
		JComboBox<String> comboRaza = new JComboBox<>();
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
		
		JComboBox<String> comoboExperiencia = new JComboBox<>();
		comoboExperiencia.setFont(new Font("Verdana", Font.PLAIN, 20));
		comoboExperiencia.setBounds(372, 260, 335, 64);
		
		comoboExperiencia.addItem(" --Seleccione la Experiencia--");
		comoboExperiencia.addItem("1");
		comoboExperiencia.addItem("2");
		comoboExperiencia.addItem("3");
		comoboExperiencia.addItem("4");
		comoboExperiencia.addItem("5");
		comoboExperiencia.addItem("0");
        add(comoboExperiencia);
		
		JComboBox<String> comboClase = new JComboBox<>();
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
}
