/**
 * 
 */
package vistas;

import javax.swing.*;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 * 
 */
public class MiembroClub extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiembroClub() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setTitle("DataCode++ (Miembros del club)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
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

		// Configuramos la barra de menú al JFrame
		setJMenuBar(barraMenu);

		// Listado de miembros:

		JComboBox<String> MostrarMiembros = new JComboBox<String>();
		MostrarMiembros.setBackground(new Color(255, 255, 255));
		MostrarMiembros.setForeground(new Color(37, 34, 81));
		MostrarMiembros.setFont(new Font("Verdana", Font.PLAIN, 19));
		String[] Personajes = { "Nacho Moreno", "Daniel Farías", "Daniel Gonzalez", "Sara Villanueva",
				"Irene del Rincón", "Raúl Rodriguez" };
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>(Personajes);
		MostrarMiembros.setModel(dcbm);
		MostrarMiembros.setBounds(622, 228, 273, 67);
		getContentPane().add(MostrarMiembros);

		// Contenedor de imagen
		JPanel contenedorSlogan = new JPanel();
		contenedorSlogan.setBounds(596, 422, 328, 80);
		getContentPane().add(contenedorSlogan);

		// Imagen
		JLabel labelSlogan = new JLabel("");
		contenedorSlogan.add(labelSlogan);
		labelSlogan.setIcon(new ImageIcon("img/SloganDC1.png"));

		// Titulo
		JLabel labelTitulo = new JLabel("Miembros");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 40));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(649, 83, 275, 89);
		getContentPane().add(labelTitulo);

		// Contenedor de informacion adicional
		JPanel contenedorInformacion = new JPanel();
		contenedorInformacion.setBackground(new Color(37, 34, 81));
		contenedorInformacion.setBounds(511, 0, 525, 575);
		getContentPane().add(contenedorInformacion);
		getContentPane().setLayout(null);
		contenedorInformacion.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// Titulo informacion extra
		JLabel labelTituloInformacion = new JLabel("Jugadores de Rol Famosos");
		labelTituloInformacion.setForeground(new Color(37, 34, 81));
		labelTituloInformacion.setFont(new Font("Verdana", Font.BOLD, 30));
		labelTituloInformacion.setBounds(22, 10, 479, 59);
		getContentPane().add(labelTituloInformacion);
		
		// VIN DIESEL
		JLabel labelVinDiesel = new JLabel("Vin Diesel");
		labelVinDiesel.setForeground(new Color(37, 34, 81));
		labelVinDiesel.setFont(new Font("Verdana", Font.BOLD, 20));
		labelVinDiesel.setBounds(57, 263, 114, 26);
		getContentPane().add(labelVinDiesel);
		
		JLabel labelImagenVin = new JLabel("");
		labelImagenVin.setIcon(new ImageIcon("img/Vin_Diesel.png"));
		labelImagenVin.setBounds(32, 79, 173, 160);
		getContentPane().add(labelImagenVin);
		
		// DAWYNE JOHNSE
		JLabel labelLaRoca = new JLabel("Dawyne Johnse");
		labelLaRoca.setForeground(new Color(37, 34, 81));
		labelLaRoca.setFont(new Font("Verdana", Font.BOLD, 20));
		labelLaRoca.setBounds(289, 258, 183, 37);
		getContentPane().add(labelLaRoca);
		
		JLabel labelImagenDawyne = new JLabel("");
		labelImagenDawyne.setIcon(new ImageIcon("img/the_rock.png"));
		labelImagenDawyne.setBounds(289, 79, 173, 160);
		getContentPane().add(labelImagenDawyne);
		
		// MIKE MYERS
		JLabel labelMikeMyers = new JLabel("Mike Myers");
		labelMikeMyers.setForeground(new Color(37, 34, 81));
		labelMikeMyers.setFont(new Font("Verdana", Font.BOLD, 20));
		labelMikeMyers.setBounds(54, 486, 128, 37);
		getContentPane().add(labelMikeMyers);
		
		JLabel labelImagenMike = new JLabel("");
		labelImagenMike.setIcon(new ImageIcon("img/mike_myers.png"));
		labelImagenMike.setBounds(32, 317, 173, 160);
		getContentPane().add(labelImagenMike);
		
		// TIM DUCAN
		JLabel labelTimDuncan = new JLabel("Tim Duncan");
		labelTimDuncan.setForeground(new Color(37, 34, 81));
		labelTimDuncan.setFont(new Font("Verdana", Font.BOLD, 20));
		labelTimDuncan.setBounds(311, 486, 139, 37);
		getContentPane().add(labelTimDuncan);
		
		JLabel labelImagenTim = new JLabel("");
		labelImagenTim.setIcon(new ImageIcon("img/tim_duncan.png"));
		labelImagenTim.setBounds(289, 317, 173, 160);
		getContentPane().add(labelImagenTim);

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
				new MiembroClub();
			}
		});
	}

}
