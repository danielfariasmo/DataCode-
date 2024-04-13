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
public class Editar_Partida extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	public Editar_Partida() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setTitle("DataCode++ (Editar Partida)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(37, 34, 81));
		getContentPane().setLayout(null);

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

		// Etiquetas para introducir la información
		JLabel labelIdentificador = new JLabel("Identificador único:");
		labelIdentificador.setFont(new Font("Verdana", Font.BOLD, 19));
		labelIdentificador.setForeground(Color.WHITE);
		labelIdentificador.setBounds(50, 35, 258, 40);
		getContentPane().add(labelIdentificador);

		JLabel labelNombrePartida = new JLabel("Nombre de la partida:");
		labelNombrePartida.setFont(new Font("Verdana", Font.BOLD, 19));
		labelNombrePartida.setForeground(Color.WHITE);
		labelNombrePartida.setBounds(50, 91, 258, 40);
		getContentPane().add(labelNombrePartida);

		JLabel labelIdGameMaster = new JLabel("ID Game Master:");
		labelIdGameMaster.setFont(new Font("Verdana", Font.BOLD, 19));
		labelIdGameMaster.setForeground(Color.WHITE);
		labelIdGameMaster.setBounds(50, 143, 258, 40);
		getContentPane().add(labelIdGameMaster);

		JLabel labelAmbientacion = new JLabel("Ambientación:");
		labelAmbientacion.setFont(new Font("Verdana", Font.BOLD, 19));
		labelAmbientacion.setForeground(Color.WHITE);
		labelAmbientacion.setBounds(50, 199, 400, 30);
		getContentPane().add(labelAmbientacion);

		JLabel labelPersonajes = new JLabel("Personajes que participan:");
		labelPersonajes.setFont(new Font("Verdana", Font.BOLD, 19));
		labelPersonajes.setForeground(Color.WHITE);
		labelPersonajes.setBounds(50, 255, 400, 30);
		getContentPane().add(labelPersonajes);

		JLabel labelDiaHora = new JLabel("Día y hora de la semana:");
		labelDiaHora.setFont(new Font("Verdana", Font.BOLD, 19));
		labelDiaHora.setForeground(Color.WHITE);
		labelDiaHora.setBounds(50, 304, 400, 30);
		getContentPane().add(labelDiaHora);

		JLabel labelDuracionSesion = new JLabel("Duración de la sesión (horas):");
		labelDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 19));
		labelDuracionSesion.setForeground(Color.WHITE);
		labelDuracionSesion.setBounds(50, 350, 400, 30);
		getContentPane().add(labelDuracionSesion);

		JLabel labelNumeroSesion = new JLabel("Número de la sesión:");
		labelNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 19));
		labelNumeroSesion.setForeground(Color.WHITE);
		labelNumeroSesion.setBounds(50, 402, 400, 30);
		getContentPane().add(labelNumeroSesion);

		JLabel labelEstado = new JLabel("¿Está en curso o terminada? (Si/No):");
		labelEstado.setFont(new Font("Verdana", Font.BOLD, 19));
		labelEstado.setForeground(Color.WHITE);
		labelEstado.setBounds(50, 454, 407, 30);
		getContentPane().add(labelEstado);

		// Botón para registrarse
		JButton botonCrearPartida = new JButton("Editar Partida");
		botonCrearPartida.setFont(new Font("Verdana", Font.BOLD, 20));
		botonCrearPartida.setForeground(new Color(37, 34, 81));
		botonCrearPartida.setBackground(new Color(135, 206, 235));
		botonCrearPartida.setBounds(500, 514, 400, 50);
		getContentPane().add(botonCrearPartida);

		// Botones de seleccion
		JRadioButton radioSi = new JRadioButton("Si");
		JRadioButton radioNo = new JRadioButton("No");
		ButtonGroup group = new ButtonGroup();
		group.add(radioSi);
		group.add(radioNo);

		radioSi.setFont(new Font("Verdana", Font.PLAIN, 20));
		radioSi.setForeground(Color.WHITE);
		radioSi.setBackground(new Color(37, 34, 81));
		radioSi.setBounds(539, 454, 70, 30);
		getContentPane().add(radioSi);

		radioNo.setFont(new Font("Verdana", Font.PLAIN, 20));
		radioNo.setForeground(Color.WHITE);
		radioNo.setBackground(new Color(37, 34, 81));
		radioNo.setBounds(707, 454, 70, 30);
		getContentPane().add(radioNo);
		
		textField = new JTextField();
		textField.setBounds(531, 39, 258, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(531, 91, 258, 40);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(531, 143, 258, 40);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(531, 198, 258, 40);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(531, 254, 258, 40);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(531, 308, 258, 40);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(531, 359, 258, 40);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(531, 411, 258, 40);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);

		// Configuramos la barra de menú al JFrame
		setJMenuBar(barraMenu);

		// Tamaño y posición de la ventana.
		setSize(1050, 650);
		setLocationRelativeTo(null);

		// Hacemos visible la ventana para que se ejecute.
		setVisible(true);

		System.out.println("daniel f");
	}

	// Main de prueba.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Editar_Partida();
			}
		});
	}
}
