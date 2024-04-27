/**
 * 
 */
package vistas;

import javax.swing.*;

import control.ControlMenuPrincipalUsuario;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

/**
 * 
 */
public class MenuPrincipalUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private JScrollPane scrollPrincipal;
	private JMenuItem nuevoPersonaje;
	private JMenuItem mostrarPersonajes;
	private JMenuItem modificarPersonaje;
	private JMenuItem consultarPartida;
	private JMenuItem mostrarMiembros;
	private JMenuItem volverMenuPrincipal;

	public MenuPrincipalUsuario() {

		configuracionInicial();
		inicializarComponentes();
	}

	public void configuracionInicial() {
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

		// Tamaño y posición de la ventana.
		setSize(1300, 660);
		setLocationRelativeTo(null);

		cambiarPanel(panelPrincipal);
		// Hacemos visible la ventana para que se ejecute.
		setVisible(true);
	}

	public void inicializarComponentes() {

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
		 */
		JMenu personajes = new JMenu("Personajes");
		personajes.setForeground(new Color(37, 34, 81));
		personajes.setFont(new Font("Verdana", Font.BOLD, 25));

		// Nuevo Personaje
		nuevoPersonaje = new JMenuItem("Nuevo Personaje");
		nuevoPersonaje.setForeground(new Color(37, 34, 81));
		nuevoPersonaje.setFont(new Font("Verdana", Font.PLAIN, 25));

		// Mostrar Personaje
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

		// Consultar Partida
		consultarPartida = new JMenuItem("Consultar Partida");
		consultarPartida.setForeground(new Color(37, 34, 81));
		consultarPartida.setFont(new Font("Verdana", Font.PLAIN, 25));

		// Añadimos a la barra las opciones.
		partidas.add(consultarPartida);
		partidas.add(new JSeparator());

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

		/*
		 * Opcion Volver a Menu Principal.
		 */

		JMenu volverMenu = new JMenu("");
		volverMenu.setIcon(new ImageIcon("img/home.png"));
		volverMenu.setForeground(new Color(37, 34, 81));
		volverMenu.setFont(new Font("Verdana", Font.BOLD, 25));

		// Añadimos opción a parte del menu Volver a menu
		volverMenuPrincipal = new JMenuItem("Menú Principal");
		volverMenuPrincipal.setForeground(new Color(37, 34, 81));
		volverMenuPrincipal.setFont(new Font("Verdana", Font.PLAIN, 25));
		volverMenu.add(volverMenuPrincipal);

		// Añadimos a la barra principal las opciones.
		barraMenu.add(new JSeparator());
		barraMenu.add(personajes);
		barraMenu.add(new JSeparator());
		barraMenu.add(partidas);
		barraMenu.add(new JSeparator());
		barraMenu.add(miembros);
		barraMenu.add(new JSeparator());
		barraMenu.add(volverMenu);
		barraMenu.add(new JSeparator());

		// Configuramos la barra de menú al JFrame
		setJMenuBar(barraMenu);
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void cambiarPanel(JPanel panel) {
		scrollPrincipal.setViewportView(panel);
	}

	public void setListener(ControlMenuPrincipalUsuario listener) {
		nuevoPersonaje.addActionListener(listener);
		mostrarPersonajes.addActionListener(listener);
		modificarPersonaje.addActionListener(listener);
		consultarPartida.addActionListener(listener);
		mostrarMiembros.addActionListener(listener);
		volverMenuPrincipal.addActionListener(listener);
	}

}
