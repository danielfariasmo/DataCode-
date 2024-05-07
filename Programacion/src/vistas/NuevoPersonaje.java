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
	private JTextField textoNombre;
	private JTextField textoExperiencia;
	private JTextField textoClase;
	private JTextField textoRaza;

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

		textoNombre = new JTextField();
		textoNombre.setLocation(530, 134);
		textoNombre.setSize(277, 46);
		textoNombre.setForeground(new Color(0, 0, 0));
		add(textoNombre, BorderLayout.EAST);
		textoNombre.setColumns(10);

		// Nombre del personaje
		JLabel labelNombrePersonaje = new JLabel("Nombre Personaje:");
		labelNombrePersonaje.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNombrePersonaje.setForeground(new Color(255, 255, 255));
		add(labelNombrePersonaje, BorderLayout.NORTH);
		labelNombrePersonaje.setBounds(195, 116, 192, 75);

		// Raza
		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setFont(new Font("Verdana", Font.BOLD, 17));
		labelRaza.setForeground(new Color(255, 255, 255));
		add(labelRaza, BorderLayout.NORTH);
		labelRaza.setBounds(195, 208, 192, 75);

		textoRaza = new JTextField();
		textoRaza.setSize(277, 46);
		textoRaza.setLocation(530, 226);
		add(textoRaza, BorderLayout.EAST);
		textoRaza.setColumns(10);

		// Clase
		JLabel labelClase = new JLabel("Clase:");
		labelClase.setFont(new Font("Verdana", Font.BOLD, 17));
		labelClase.setForeground(new Color(255, 255, 255));
		add(labelClase, BorderLayout.NORTH);
		labelClase.setBounds(195, 293, 192, 75);

		textoClase = new JTextField();
		textoClase.setSize(277, 46);
		textoClase.setLocation(530, 311);
		add(textoClase, BorderLayout.EAST);
		textoClase.setColumns(10);

		// Nivel de experiencia
		JLabel labelNivelExperiencia = new JLabel("Nivel de Experiencia:");
		labelNivelExperiencia.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNivelExperiencia.setForeground(new Color(255, 255, 255));
		add(labelNivelExperiencia, BorderLayout.NORTH);
		labelNivelExperiencia.setBounds(195, 385, 221, 75);

		textoExperiencia = new JTextField();
		textoExperiencia.setSize(277, 46);
		textoExperiencia.setLocation(530, 403);
		add(textoExperiencia, BorderLayout.EAST);
		textoExperiencia.setColumns(10);

		// Boton Aceptar
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(new Color(37, 34, 81));
		botonAceptar.setBackground(new Color(135, 206, 235));
		botonAceptar.setFont(new Font("Verdana", Font.BOLD, 17));
		botonAceptar.setBounds(571, 478, 197, 38);
		add(botonAceptar);
		
		JLabel labelNuevoPersonaje = new JLabel("Nuevo Personaje");
		labelNuevoPersonaje.setForeground(new Color(255, 255, 255));
		labelNuevoPersonaje.setFont(new Font("Verdana", Font.BOLD, 40));
		labelNuevoPersonaje.setBounds(466, 24, 460, 46);
		add(labelNuevoPersonaje);
	}
}
