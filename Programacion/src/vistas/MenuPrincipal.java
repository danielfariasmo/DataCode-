/**
 * 
 */
package vistas;

import javax.swing.*;

import control.ControladorMenuPrincipal;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

/**
 * 
 */
public class MenuPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panelPrincipal;
	JScrollPane scrollPrincipal;
	JMenuItem nuevoPersonaje;
	JMenuItem mostrarPersonajes;
	JMenuItem modificarPersonaje;
	JMenuItem crearPartida;
	JMenuItem consultarPartida;
	JMenuItem editarPartida;
	JMenuItem mostrarMiembros;

	public MenuPrincipal() {

		panelPrincipal = new JPanel();
		scrollPrincipal = new JScrollPane();
		getContentPane().add(scrollPrincipal);
		
		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setTitle("DataCode++");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelPrincipal.setBackground(new Color(37, 34, 81));
		panelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 50));

		// Logo
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("img\\DataCode.Logo.png"));
		panelPrincipal.add(labelLogo, BorderLayout.WEST);

		// Introduccion
		JLabel labelTexto = new JLabel(
				"<html><div style='text-align: center; width: 350px;'>Adéntrate en el mundo del Club de Rol DataCode++ de la UEM, donde la imaginación cobra vida a través de épicas aventuras. Nuestra aplicación de gestión de personajes te permite crear y dirigir héroes en sus peligrosos viajes, mientras los Game Masters dan forma a mundos llenos de misterio y emoción. Con un simple clic, podrás explorar tierras desconocidas, forjar alianzas y enfrentarte a desafíos que pondrán a prueba tu valentía. ¿Estás listo para sumergirte en un universo donde solo la imaginación es el límite? Entonces únete a nosotros y deja que la aventura comience.</div></html>");
		labelTexto.setForeground(new Color(255, 255, 255));
		labelTexto.setFont(new Font("Verdana", Font.PLAIN, 20));
		panelPrincipal.add(labelTexto, BorderLayout.EAST);

		/*
		 * Menu.
		 */
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBackground(new Color(135, 206, 235));
		barraMenu.setFont(new Font("Verdana", Font.PLAIN, 30));

		/* 
		 * Opcion Personaje.
		 * */
		JMenu personajes = new JMenu("Personajes");
		personajes.setForeground(new Color(37, 34, 81));
		personajes.setFont(new Font("Verdana", Font.BOLD, 25));
		
		// Nuevo Personaje
		nuevoPersonaje = new JMenuItem("Nuevo Personaje");
		nuevoPersonaje.setForeground(new Color(37, 34, 81));
		nuevoPersonaje.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		//Mostrar Personaje
		mostrarPersonajes = new JMenuItem("Mostrar Personajes");
		mostrarPersonajes.setForeground(new Color(37, 34, 81));
		mostrarPersonajes.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		// Modificar Personaje
		modificarPersonaje = new JMenuItem("Modificar Personaje");
		modificarPersonaje.setForeground(new Color(37, 34, 81));
		modificarPersonaje.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		// Añadimos a la barra las opciones.
		personajes.add(nuevoPersonaje);
		personajes.add(new JSeparator());
		personajes.add(mostrarPersonajes);
		personajes.add(new JSeparator());
		personajes.add(modificarPersonaje);

		/*
		 * Opcion Partidas.
		 */
		JMenu partidas = new JMenu("Partidas");
		partidas.setForeground(new Color(37, 34, 81));
		partidas.setFont(new Font("Verdana", Font.BOLD, 25));
		
		// Crear Partida
		crearPartida = new JMenuItem("Crear Partida");
		crearPartida.setForeground(new Color(37, 34, 81));
		crearPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		// Consultar Partida
		consultarPartida = new JMenuItem("Consultar Partida");
		consultarPartida.setForeground(new Color(37, 34, 81));
		consultarPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		// Editar Partida
		editarPartida = new JMenuItem("Editar Partida");
		editarPartida.setForeground(new Color(37, 34, 81));
		editarPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		// Añadimos a la barra las opciones.
		partidas.add(crearPartida);
		partidas.add(new JSeparator());
		partidas.add(consultarPartida);
		partidas.add(new JSeparator());
		partidas.add(editarPartida);

		/* 
		 * Opcion Miembros.
		 */
		
		JMenu miembros = new JMenu("Miembros");
		miembros.setForeground(new Color(37, 34, 81));
		miembros.setFont(new Font("Verdana", Font.BOLD, 25));
		
		// Mostrar miembros.
		mostrarMiembros = new JMenuItem("Mostrar Miembros");
		mostrarMiembros.setForeground(new Color(37, 34, 81));
		mostrarMiembros.setFont(new Font("Verdana", Font.PLAIN, 25));
		
		// Añadimos opcion a parte del menu Miembros.
		miembros.add(mostrarMiembros);

		// Añadimos a la barra principal las opciones.
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
		setSize(1065, 660);
		setLocationRelativeTo(null);

		
		cambiarPanel(panelPrincipal);
		// Hacemos visible la ventana para que se ejecute.
		setVisible(true);

	}

	public void hacerVisible() {
		setVisible(true);
	}

	
	public void cambiarPanel(JPanel panel) {
		scrollPrincipal.setViewportView(panel);
	}
	
	public void setListener (ControladorMenuPrincipal listener) {
		nuevoPersonaje.addActionListener(listener);
		mostrarPersonajes.addActionListener(listener);
		modificarPersonaje.addActionListener(listener);
		crearPartida.addActionListener(listener);
		consultarPartida.addActionListener(listener);
		editarPartida.addActionListener(listener);
		mostrarMiembros.addActionListener(listener);
	}

}
