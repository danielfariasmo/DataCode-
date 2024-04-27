/**
 * 
 */
package vistas;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;

public class NuevoPersonaje extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;

	public NuevoPersonaje() {

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

		// Id personaje
		JLabel labelIdPersonaje = new JLabel("ID Personaje:");
		labelIdPersonaje.setFont(new Font("Verdana", Font.BOLD, 17));
		labelIdPersonaje.setForeground(new Color(255, 255, 255));
		add(labelIdPersonaje, BorderLayout.NORTH);
		labelIdPersonaje.setBounds(195, 102, 192, 75);

		textField = new JTextField();
		textField.setLocation(530, 190);
		textField.setSize(277, 46);
		textField.setForeground(new Color(0, 0, 0));
		add(textField, BorderLayout.EAST);
		textField.setColumns(10);

		// Nombre del personaje
		JLabel labelNombrePersonaje = new JLabel("Nombre Personaje:");
		labelNombrePersonaje.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNombrePersonaje.setForeground(new Color(255, 255, 255));
		add(labelNombrePersonaje, BorderLayout.NORTH);
		labelNombrePersonaje.setBounds(195, 173, 192, 75);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setSize(277, 46);
		textField_1.setLocation(530, 119);
		add(textField_1, BorderLayout.EAST);
		textField_1.setColumns(10);

		// Raza
		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setFont(new Font("Verdana", Font.BOLD, 17));
		labelRaza.setForeground(new Color(255, 255, 255));
		add(labelRaza, BorderLayout.NORTH);
		labelRaza.setBounds(195, 249, 192, 75);

		textField_2 = new JTextField();
		textField_2.setSize(277, 46);
		textField_2.setLocation(530, 266);
		add(textField_2, BorderLayout.EAST);
		textField_2.setColumns(10);

		// Clase
		JLabel labelClase = new JLabel("Clase:");
		labelClase.setFont(new Font("Verdana", Font.BOLD, 17));
		labelClase.setForeground(new Color(255, 255, 255));
		add(labelClase, BorderLayout.NORTH);
		labelClase.setBounds(195, 324, 192, 75);

		textField_3 = new JTextField();
		textField_3.setSize(277, 46);
		textField_3.setLocation(530, 341);
		add(textField_3, BorderLayout.EAST);
		textField_3.setColumns(10);

		// Nivel de experiencia
		JLabel labelNivelExperiencia = new JLabel("Nivel de Experiencia:");
		labelNivelExperiencia.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNivelExperiencia.setForeground(new Color(255, 255, 255));
		add(labelNivelExperiencia, BorderLayout.NORTH);
		labelNivelExperiencia.setBounds(195, 403, 221, 75);

		textField_4 = new JTextField();
		textField_4.setSize(277, 46);
		textField_4.setLocation(530, 420);
		add(textField_4, BorderLayout.EAST);
		textField_4.setColumns(10);

		// Boton Aceptar
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(new Color(37, 34, 81));
		botonAceptar.setBackground(new Color(135, 206, 235));
		botonAceptar.setFont(new Font("Verdana", Font.BOLD, 17));
		botonAceptar.setBounds(571, 515, 197, 38);
		add(botonAceptar);
		
		JLabel labelNuevoPersonaje = new JLabel("Nuevo Personaje");
		labelNuevoPersonaje.setForeground(new Color(255, 255, 255));
		labelNuevoPersonaje.setFont(new Font("Verdana", Font.BOLD, 40));
		labelNuevoPersonaje.setBounds(466, 24, 460, 46);
		add(labelNuevoPersonaje);
	}
}
