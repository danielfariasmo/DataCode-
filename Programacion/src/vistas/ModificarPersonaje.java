/**
 * 
 */
package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificarPersonaje extends JPanel {
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
	

	public ModificarPersonaje() {

		configuracionInicial();
		inicializarComponentes();

	}

	public void configuracionInicial() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setSize(1300, 660);
		setLayout(null);
	}

	public void inicializarComponentes() {

		// Titulo MODIFICAR PERSONAJE
		JLabel labelModificarPersonaje = new JLabel("Modificar Personaje");
		labelModificarPersonaje.setFont(new Font("Verdana", Font.BOLD, 40));
		labelModificarPersonaje.setForeground(new Color(255, 255, 255));
		labelModificarPersonaje.setBounds(428, 28, 460, 46);
		add(labelModificarPersonaje);

		textoNombre = new JTextField();
		textoNombre.setLocation(530, 108);
		textoNombre.setSize(277, 46);
		textoNombre.setForeground(new Color(0, 0, 0));
		textoNombre.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textoNombre, BorderLayout.EAST);
		textoNombre.setColumns(10);

		// Nombre del personaje
		JLabel labelNombrePersonaje = new JLabel("Nombre Personaje:");
		labelNombrePersonaje.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNombrePersonaje.setForeground(new Color(255, 255, 255));
		add(labelNombrePersonaje, BorderLayout.NORTH);
		labelNombrePersonaje.setBounds(225, 95, 192, 75);

		// Raza personaje
		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setFont(new Font("Verdana", Font.BOLD, 17));
		labelRaza.setForeground(new Color(255, 255, 255));
		add(labelRaza, BorderLayout.NORTH);
		labelRaza.setBounds(225, 180, 192, 75);

		textoRaza = new JTextField();
		textoRaza.setSize(277, 46);
		textoRaza.setLocation(530, 193);
		textoRaza.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textoRaza, BorderLayout.EAST);
		textoRaza.setColumns(10);

		// Clase
		JLabel labelClase = new JLabel("Clase:");
		labelClase.setFont(new Font("Verdana", Font.BOLD, 17));
		labelClase.setForeground(new Color(255, 255, 255));
		add(labelClase, BorderLayout.NORTH);
		labelClase.setBounds(225, 265, 192, 75);

		textoClase = new JTextField();
		textoClase.setSize(277, 46);
		textoClase.setLocation(530, 275);
		textoClase.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textoClase, BorderLayout.EAST);
		textoClase.setColumns(10);

		// Nivel de experiencia
		JLabel labelNivelExperiencia = new JLabel("Nivel de Experiencia:");
		labelNivelExperiencia.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNivelExperiencia.setForeground(new Color(255, 255, 255));
		add(labelNivelExperiencia, BorderLayout.NORTH);
		labelNivelExperiencia.setBounds(225, 344, 221, 75);

		textoExperiencia = new JTextField();
		textoExperiencia.setSize(277, 46);
		textoExperiencia.setLocation(530, 357);
		textoExperiencia.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textoExperiencia, BorderLayout.EAST);
		textoExperiencia.setColumns(10);

		// Boton Actualizar
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setForeground(new Color(37, 34, 81));
		botonActualizar.setBackground(new Color(135, 206, 235));
		botonActualizar.setFont(new Font("Verdana", Font.BOLD, 17));
		botonActualizar.setBounds(567, 454, 198, 38);
		add(botonActualizar);

	}
}
