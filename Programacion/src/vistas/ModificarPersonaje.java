/**
 * 
 */
package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificarPersonaje extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	

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

		// Id personaje
		JLabel labelIdPersonaje = new JLabel("ID Personaje:");
		labelIdPersonaje.setFont(new Font("Verdana", Font.BOLD, 17));
		labelIdPersonaje.setForeground(new Color(255, 255, 255));
		add(labelIdPersonaje, BorderLayout.NORTH);
		labelIdPersonaje.setBounds(225, 110, 192, 75);

		textField = new JTextField();
		textField.setLocation(530, 192);
		textField.setSize(277, 46);
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textField, BorderLayout.EAST);
		textField.setColumns(10);

		// Nombre del personaje
		JLabel labelNombrePersonaje = new JLabel("Nombre Personaje:");
		labelNombrePersonaje.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNombrePersonaje.setForeground(new Color(255, 255, 255));
		add(labelNombrePersonaje, BorderLayout.NORTH);
		labelNombrePersonaje.setBounds(225, 179, 192, 75);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setSize(277, 46);
		textField_1.setLocation(530, 123);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textField_1, BorderLayout.EAST);
		textField_1.setColumns(10);

		// Raza personaje
		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setFont(new Font("Verdana", Font.BOLD, 17));
		labelRaza.setForeground(new Color(255, 255, 255));
		add(labelRaza, BorderLayout.NORTH);
		labelRaza.setBounds(225, 259, 192, 75);

		textField_2 = new JTextField();
		textField_2.setSize(277, 46);
		textField_2.setLocation(530, 272);
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textField_2, BorderLayout.EAST);
		textField_2.setColumns(10);

		// Clase
		JLabel labelClase = new JLabel("Clase:");
		labelClase.setFont(new Font("Verdana", Font.BOLD, 17));
		labelClase.setForeground(new Color(255, 255, 255));
		add(labelClase, BorderLayout.NORTH);
		labelClase.setBounds(225, 331, 192, 75);

		textField_3 = new JTextField();
		textField_3.setSize(277, 46);
		textField_3.setLocation(530, 344);
		textField_3.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textField_3, BorderLayout.EAST);
		textField_3.setColumns(10);

		// Nivel de experiencia
		JLabel labelNivelExperiencia = new JLabel("Nivel de Experiencia:");
		labelNivelExperiencia.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNivelExperiencia.setForeground(new Color(255, 255, 255));
		add(labelNivelExperiencia, BorderLayout.NORTH);
		labelNivelExperiencia.setBounds(225, 407, 221, 75);

		textField_4 = new JTextField();
		textField_4.setSize(277, 46);
		textField_4.setLocation(530, 420);
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 20));
		add(textField_4, BorderLayout.EAST);
		textField_4.setColumns(10);

		// Boton Actualizar
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setForeground(new Color(37, 34, 81));
		botonActualizar.setBackground(new Color(135, 206, 235));
		botonActualizar.setFont(new Font("Verdana", Font.BOLD, 17));
		botonActualizar.setBounds(578, 520, 198, 38);
		add(botonActualizar);

		// Crear un cuadro de diálogo personalizado
		botonActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String identificador = textField_1.getText();
				// Mensaje del cuadro de dialogo , con la información del identificador
				// introducido por el usuario
				JOptionPane.showMessageDialog(ModificarPersonaje.this,
						"El personaje con id " + identificador + ", ha sido actualizado correctamente");
			}
		});
	}
}
