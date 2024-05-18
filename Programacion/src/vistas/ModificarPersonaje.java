/**
 * 
 */
package vistas;

import java.awt.BorderLayout;
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
import javax.swing.JSpinner;

import control.ControlModificarPersonaje;
import modelo.Miembro;
import modelo.Personaje;

public class ModificarPersonaje extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */

	private static final long serialVersionUID = 1L;
	private JComboBox<Personaje> comboNombrePersonaje;
	private JComboBox<String> comboRaza;
	private JComboBox<String> comboClase;
	private JSpinner spinnerExperiencia;
	private ControlModificarPersonaje control;
	private Miembro miembro;

	public ModificarPersonaje(Miembro miembro) {
		this.miembro = miembro;
		this.control = new ControlModificarPersonaje(this);
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

		// Nombre del personaje
		JLabel labelNombrePersonaje = new JLabel("Nombre Personaje:");
		labelNombrePersonaje.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNombrePersonaje.setForeground(new Color(255, 255, 255));
		add(labelNombrePersonaje, BorderLayout.NORTH);
		labelNombrePersonaje.setBounds(74, 115, 324, 75);

		// Raza personaje
		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setFont(new Font("Verdana", Font.BOLD, 25));
		labelRaza.setForeground(new Color(255, 255, 255));
		add(labelRaza, BorderLayout.NORTH);
		labelRaza.setBounds(753, 115, 192, 75);

		// Clase
		JLabel labelClase = new JLabel("Clase:");
		labelClase.setFont(new Font("Verdana", Font.BOLD, 25));
		labelClase.setForeground(new Color(255, 255, 255));
		add(labelClase, BorderLayout.NORTH);
		labelClase.setBounds(753, 257, 192, 75);

		// Nivel de experiencia
		JLabel labelNivelExperiencia = new JLabel("Nivel de Experiencia:");
		labelNivelExperiencia.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNivelExperiencia.setForeground(new Color(255, 255, 255));
		add(labelNivelExperiencia, BorderLayout.NORTH);
		labelNivelExperiencia.setBounds(74, 257, 353, 75);

		// Boton Actualizar
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setForeground(new Color(37, 34, 81));
		botonActualizar.setBackground(new Color(135, 206, 235));
		botonActualizar.setFont(new Font("Verdana", Font.BOLD, 25));
		botonActualizar.setBounds(567, 454, 198, 38);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPersonaje();
			}
		});
		add(botonActualizar);
		
		comboNombrePersonaje = new JComboBox<>();
		comboNombrePersonaje.setFont(new Font("Verdana", Font.PLAIN, 20));
		comboNombrePersonaje.setBounds(401, 135, 277, 46);
		add(comboNombrePersonaje);
		
		comboRaza = new JComboBox<>();
		comboRaza.setFont(new Font("Verdana", Font.PLAIN, 20));
		comboRaza.setBounds(865, 136, 277, 44);
		comboRaza.addItem(" --Seleccione la Raza--");
        comboRaza.addItem("Draconido");
        comboRaza.addItem("Elfo");
        comboRaza.addItem("Enano");
        comboRaza.addItem("Hobbit");
        comboRaza.addItem("Humano");
        comboRaza.addItem("Mediano");
        comboRaza.addItem("Semiorco");
        add(comboRaza);
		
		comboClase = new JComboBox<>();
		comboClase.setFont(new Font("Verdana", Font.PLAIN, 20));
		comboClase.setBounds(865, 277, 277, 46);
		comboClase.addItem(" --Seleccione la Clase--");
		comboClase.addItem("Contrabandista");
		comboClase.addItem("Guardian");
		comboClase.addItem("Guerrero");
		comboClase.addItem("Heroe");
		comboClase.addItem("Mago");
		comboClase.addItem("Paladin");
		comboClase.addItem("Picaro");
		add(comboClase);
		
		spinnerExperiencia = new JSpinner();
		spinnerExperiencia.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerExperiencia.setBounds(401, 281, 132, 38);
		add(spinnerExperiencia);

		control.cargarPersonaje();
	}

	public void insertarPersonaje(ArrayList<Personaje> array) {
		DefaultComboBoxModel<Personaje> dcbm = new DefaultComboBoxModel<Personaje>();
		dcbm.addAll(array);
		comboNombrePersonaje.setModel(dcbm);
	}
	
	public void modificarPersonaje() {
		
		Personaje personaje = (Personaje) comboNombrePersonaje.getSelectedItem();
		
		control.actualizarPersonaje(personaje);
		
	}
	
	public void mensaje(boolean exitoso, String mensaje) {

		if (exitoso) {
			JOptionPane.showMessageDialog(this, mensaje);
		} else {
			JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ControlModificarPersonaje getControl() {
		return control;
	}

	public Miembro getMiembro() {
		return miembro;
	}

	public JComboBox<Personaje> getComboNombrePersonaje() {
		return comboNombrePersonaje;
	}

	public JComboBox<String> getComboRaza() {
		return comboRaza;
	}

	public void setComboRaza(JComboBox<String> comboRaza) {
		this.comboRaza = comboRaza;
	}

	public JComboBox<String> getComboClase() {
		return comboClase;
	}

	public void setComboClase(JComboBox<String> comboClase) {
		this.comboClase = comboClase;
	}

	public JSpinner getSpinnerExperiencia() {
		return spinnerExperiencia;
	}

	public void setSpinnerExperiencia(JSpinner spinnerExperiencia) {
		this.spinnerExperiencia = spinnerExperiencia;
	}
	
	
}

