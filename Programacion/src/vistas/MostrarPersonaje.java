/**
 * 
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.ControlMenuPrincipalUsuario;
import modelo.Personaje;

public class MostrarPersonaje extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Personaje> mostrarPersonaje;
	private ControlMenuPrincipalUsuario control;
	
	public MostrarPersonaje(ControlMenuPrincipalUsuario control) {
		this.control = control;
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
		mostrarPersonaje.setBounds(433, 195, 465, 66);
		add(mostrarPersonaje);

		JLabel lblNewLabel = new JLabel("PERSONAJES:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 40));
		lblNewLabel.setBounds(500, 88, 320, 52);
		add(lblNewLabel);

		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setForeground(new Color(37, 34, 81));
		botonEliminar.setBackground(new Color(135, 206, 235));
		botonEliminar.setFont(new Font("Verdana", Font.BOLD, 25));
		botonEliminar.setBounds(560, 370, 208, 37);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elminarPersonaje();
			}
		});
		add(botonEliminar);
	}

	public void elminarPersonaje() {

		Personaje personaje = (Personaje) mostrarPersonaje.getSelectedItem();

		control.eliminarPersonaje(personaje);

	}
	
	public void mensaje(boolean exitoso, String mensaje) {

		if (exitoso) {
			JOptionPane.showMessageDialog(this, mensaje);
		} else {
			JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	
}
