/**
 * 
 */
package vistas;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class MostrarPersonaje extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;

	public MostrarPersonaje() {

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

		JComboBox<String> MostrarPersonajes = new JComboBox<String>();
		MostrarPersonajes.setBackground(new Color(255, 255, 255));
		MostrarPersonajes.setForeground(new Color(37, 34, 81));
		MostrarPersonajes.setFont(new Font("Verdana", Font.PLAIN, 17));
		String[] Personajes = { "Aragorn - Guerrero", "Drako el Sabio - Mago", "Thranduil - Guerrero",
				"Han Solo - Contrabandista", "Frodo Bolson - Héroe", "Bofur Barbillas - Pícaro", "Sam - Guardián",
				"Grimnir - Paladín" };
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>(Personajes);
		MostrarPersonajes.setModel(dcbm);
		MostrarPersonajes.setBounds(536, 195, 240, 66);
		add(MostrarPersonajes);

		JLabel lblNewLabel = new JLabel("PERSONAJES:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 40));
		lblNewLabel.setBounds(500, 88, 320, 52);
		add(lblNewLabel);

		// Boton Aceptar
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(new Color(37, 34, 81));
		botonAceptar.setBackground(new Color(135, 206, 235));
		botonAceptar.setFont(new Font("Verdana", Font.BOLD, 14));
		botonAceptar.setBounds(157, 430, 155, 37);
		add(botonAceptar);

		JButton botonConsultar = new JButton("Consultar stats");
		botonConsultar.setBackground(new Color(135, 206, 235));
		botonConsultar.setForeground(new Color(37, 34, 81));
		botonConsultar.setFont(new Font("Verdana", Font.BOLD, 14));
		botonConsultar.setBounds(687, 430, 175, 37);
		add(botonConsultar);

		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setForeground(new Color(37, 34, 81));
		botonEliminar.setBackground(new Color(135, 206, 235));
		botonEliminar.setFont(new Font("Verdana", Font.BOLD, 14));
		botonEliminar.setBounds(961, 430, 155, 37);
		add(botonEliminar);

		JButton botonAñadirPersonaje = new JButton("Añadir Personaje");
		botonAñadirPersonaje.setForeground(new Color(37, 34, 81));
		botonAñadirPersonaje.setBackground(new Color(135, 206, 235));
		botonAñadirPersonaje.setFont(new Font("Verdana", Font.BOLD, 14));
		botonAñadirPersonaje.setBounds(411, 430, 177, 37);
		add(botonAñadirPersonaje);
	}
}
