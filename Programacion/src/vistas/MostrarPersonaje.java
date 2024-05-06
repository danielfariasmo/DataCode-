/**
 * 
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Personaje;

public class MostrarPersonaje extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<Personaje> mostrarPersonaje;

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

	public void insertarPersonaje(ArrayList<Personaje> array) {
		DefaultComboBoxModel<Personaje> dcbm = new DefaultComboBoxModel<Personaje>();
		dcbm.addAll(array);
		mostrarPersonaje.setModel(dcbm);
	}

	public void inicializarComponentes() {

		mostrarPersonaje = new JComboBox<Personaje>();
		mostrarPersonaje.setBackground(new Color(255, 255, 255));
		mostrarPersonaje.setForeground(new Color(37, 34, 81));
		mostrarPersonaje.setFont(new Font("Verdana", Font.PLAIN, 17));
		mostrarPersonaje.setBounds(301, 195, 682, 66);
		add(mostrarPersonaje);

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
