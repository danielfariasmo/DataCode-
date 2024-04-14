/**
 * 
 */
package vistas;

import javax.swing.*;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.BorderLayout;

/**
 * 
 */
public class Modificar_Personaje extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;

	public Modificar_Personaje() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setTitle("DataCode++ (Editar Personaje)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(37, 34, 81));
		getContentPane().setLayout(null);

		
		// Titulo MODIFICAR PERSONAJE
		JLabel labelModificarPersonaje = new JLabel("Modificar Personaje");
		labelModificarPersonaje.setFont(new Font("Verdana", Font.BOLD, 40));
		labelModificarPersonaje.setForeground(new Color(255, 255, 255));
		labelModificarPersonaje.setBounds(299, 24, 612, 43);
		getContentPane().add(labelModificarPersonaje);

		// Id personaje
		JLabel labelIdPersonaje = new JLabel("ID Personaje:");
		labelIdPersonaje.setFont(new Font("Verdana", Font.BOLD, 17));
		labelIdPersonaje.setForeground(new Color(255, 255, 255));
		getContentPane().add(labelIdPersonaje, BorderLayout.NORTH);
		labelIdPersonaje.setBounds(195, 78, 192, 75);

		textField = new JTextField();
		textField.setLocation(458, 164);
		textField.setSize(277, 46);
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(textField, BorderLayout.EAST);
		textField.setColumns(10);

		// Nombre del personaje
		JLabel labelNombrePersonaje = new JLabel("Nombre Personaje:");
		labelNombrePersonaje.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNombrePersonaje.setForeground(new Color(255, 255, 255));
		getContentPane().add(labelNombrePersonaje, BorderLayout.NORTH);
		labelNombrePersonaje.setBounds(195, 147, 192, 75);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setSize(277, 46);
		textField_1.setLocation(458, 95);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(textField_1, BorderLayout.EAST);
		textField_1.setColumns(10);

		// Raza personaje
		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setFont(new Font("Verdana", Font.BOLD, 17));
		labelRaza.setForeground(new Color(255, 255, 255));
		getContentPane().add(labelRaza, BorderLayout.NORTH);
		labelRaza.setBounds(195, 227, 192, 75);

		textField_2 = new JTextField();
		textField_2.setSize(277, 46);
		textField_2.setLocation(458, 244);
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(textField_2, BorderLayout.EAST);
		textField_2.setColumns(10);

		// Clase
		JLabel labelClase = new JLabel("Clase:");
		labelClase.setFont(new Font("Verdana", Font.BOLD, 17));
		labelClase.setForeground(new Color(255, 255, 255));
		getContentPane().add(labelClase, BorderLayout.NORTH);
		labelClase.setBounds(195, 299, 192, 75);

		textField_3 = new JTextField();
		textField_3.setSize(277, 46);
		textField_3.setLocation(458, 316);
		textField_3.setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(textField_3, BorderLayout.EAST);
		textField_3.setColumns(10);

		// Nivel de experiencia
		JLabel labelNivelExperiencia = new JLabel("Nivel de Experiencia:");
		labelNivelExperiencia.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNivelExperiencia.setForeground(new Color(255, 255, 255));
		getContentPane().add(labelNivelExperiencia, BorderLayout.NORTH);
		labelNivelExperiencia.setBounds(195, 370, 221, 75);

		textField_4 = new JTextField();
		textField_4.setSize(277, 46);
		textField_4.setLocation(458, 387);
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(textField_4, BorderLayout.EAST);
		textField_4.setColumns(10);

		// Boton Actualizar
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setForeground(new Color(37, 34, 81));
		botonActualizar.setBackground(new Color(135, 206, 235));
		botonActualizar.setFont(new Font("Verdana", Font.BOLD, 17));
		botonActualizar.setBounds(458, 475, 277, 49);
		getContentPane().add(botonActualizar);

		 // Crear un cuadro de diálogo personalizado
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String identificador = textField_1.getText();
                //Mensaje del cuadro de dialogo , con la información del identificador introducido por el usuario
                JOptionPane.showMessageDialog(Modificar_Personaje.this, "El personaje con id " + identificador + ", ha sido actualizado correctamente");
            }
        });
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
				new Modificar_Personaje();
			}
		});
	}
}
