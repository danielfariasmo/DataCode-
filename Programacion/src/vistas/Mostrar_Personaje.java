/**
 * 
 */
package vistas;

import javax.swing.*;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

/**
 * 
 */
public class Mostrar_Personaje extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Mostrar_Personaje() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setTitle("DataCode++ (Mostrar Personaje)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(37, 34, 81));
		getContentPane().setLayout(null);

		JComboBox<String> MostrarPersonajes = new JComboBox<String>();
		MostrarPersonajes.setBackground(new Color(255, 255, 255));
		MostrarPersonajes.setForeground(new Color(37, 34, 81));
		MostrarPersonajes.setFont(new Font("Verdana", Font.PLAIN, 17));
		String[] Personajes = { "Aragorn - Guerrero", "Drako el Sabio - Mago", "Thranduil - Guerrero",
				"Han Solo - Contrabandista", "Frodo Bolson - Héroe", "Bofur Barbillas - Pícaro", "Sam - Guardián",
				"Grimnir - Paladín" };
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>(Personajes);
		MostrarPersonajes.setModel(dcbm);
		MostrarPersonajes.setBounds(413, 191, 240, 66);
		getContentPane().add(MostrarPersonajes);

		JLabel lblNewLabel = new JLabel("PERSONAJES:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 28));
		lblNewLabel.setBounds(429, 89, 320, 52);
		getContentPane().add(lblNewLabel);

		// Boton Aceptar
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(new Color(37, 34, 81));
		botonAceptar.setBackground(new Color(135, 206, 235));
		botonAceptar.setFont(new Font("Verdana", Font.BOLD, 14));
		botonAceptar.setBounds(201, 391, 155, 37);
		getContentPane().add(botonAceptar);
		
		JButton botonConsultar = new JButton("Consultar stats");
		botonConsultar.setBackground(new Color(135, 206, 235));
		botonConsultar.setForeground(new Color(37, 34, 81));
		botonConsultar.setFont(new Font("Verdana", Font.BOLD, 14));
		botonConsultar.setBounds(457, 391, 175, 37);
		getContentPane().add(botonConsultar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setForeground(new Color(37, 34, 81));
		botonEliminar.setBackground(new Color(135, 206, 235));
		botonEliminar.setFont(new Font("Verdana", Font.BOLD, 14));
		botonEliminar.setBounds(715, 391, 155, 37);
		getContentPane().add(botonEliminar);
		/*
		 * Menu.
		 */
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setFont(new Font("Verdana", Font.PLAIN, 30));
		barraMenu.setBackground(new Color(135, 206, 235));

		// Opcion Personaje.
		JMenu personajes = new JMenu("Personajes");
		personajes.setForeground(new Color(37, 34, 81));
		personajes.setFont(new Font("Verdana", Font.BOLD, 25));
		JMenuItem nuevoPersonaje = new JMenuItem("Nuevo Personaje");
		nuevoPersonaje.setForeground(new Color(37, 34, 81));
		nuevoPersonaje.setFont(new Font("Verdana", Font.PLAIN, 25));
		JMenuItem mostrarPersonajes = new JMenuItem("Mostrar Personajes");
		mostrarPersonajes.setForeground(new Color(37, 34, 81));
		mostrarPersonajes.setFont(new Font("Verdana", Font.PLAIN, 25));
		JMenuItem modificarPersonaje = new JMenuItem("Modificar Personaje");
		modificarPersonaje.setForeground(new Color(37, 34, 81));
		modificarPersonaje.setFont(new Font("Verdana", Font.PLAIN, 25));
		personajes.add(nuevoPersonaje);
		personajes.add(new JSeparator());
		personajes.add(mostrarPersonajes);
		personajes.add(new JSeparator());
		personajes.add(modificarPersonaje);

		// Opcion Partidas.
		JMenu partidas = new JMenu("Partidas");
		partidas.setForeground(new Color(37, 34, 81));
		partidas.setFont(new Font("Verdana", Font.BOLD, 25));
		JMenuItem crearPartida = new JMenuItem("Crear Partida");
		crearPartida.setForeground(new Color(37, 34, 81));
		crearPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
		JMenuItem consultarPartida = new JMenuItem("Consultar Partida");
		consultarPartida.setForeground(new Color(37, 34, 81));
		consultarPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
		JMenuItem editarPartida = new JMenuItem("Editar Partida");
		editarPartida.setForeground(new Color(37, 34, 81));
		editarPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
		partidas.add(crearPartida);
		partidas.add(new JSeparator());
		partidas.add(consultarPartida);
		partidas.add(new JSeparator());
		partidas.add(editarPartida);

		// Opcion Miembros.
		JMenu miembros = new JMenu("Miembros");
		miembros.setForeground(new Color(37, 34, 81));
		miembros.setFont(new Font("Verdana", Font.BOLD, 25));
		JMenuItem mostrarMiembros = new JMenuItem("Mostrar Miembros");
		mostrarMiembros.setForeground(new Color(37, 34, 81));
		mostrarMiembros.setFont(new Font("Verdana", Font.PLAIN, 25));
		miembros.add(mostrarMiembros);

		// Añadimos a la barra las opciones.

		barraMenu.add(new JSeparator());
		barraMenu.add(personajes);
		barraMenu.add(new JSeparator());
		barraMenu.add(partidas);
		barraMenu.add(new JSeparator());
		barraMenu.add(miembros);
		barraMenu.add(new JSeparator());

		// Configuramos la barra de menú al JFrame
		setJMenuBar(barraMenu);

		// Tamaño y posición de la ventana.
		setSize(1050, 650);
		setLocationRelativeTo(null);

		// Hacemos visible la ventana para que se ejecute.
		setVisible(true);
	}

	// Main de prueba.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Mostrar_Personaje();
			}
		});
	}
}
