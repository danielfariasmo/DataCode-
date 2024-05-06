package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class CaracteristicasPersonajes extends JPanel {
	
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	public CaracteristicasPersonajes() {

		configuracionInicial();
		inicializarComponentes();

	}

	public void configuracionInicial() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null); 
		setSize(1300, 660); 
		
		JLabel labelPersonajeCaracteristicas = new JLabel("Personaje:");
		labelPersonajeCaracteristicas.setForeground(new Color(255, 255, 255));
		labelPersonajeCaracteristicas.setFont(new Font("Verdana", Font.BOLD, 20));
		labelPersonajeCaracteristicas.setBounds(345, 70, 121, 50);
		add(labelPersonajeCaracteristicas);
		
		JComboBox SeleccionPersonajes = new JComboBox();
		SeleccionPersonajes.setBounds(548, 227, 232, 50);
		add(SeleccionPersonajes);
		
		JLabel labelClaseCaracteristicas = new JLabel("Clase:");
		labelClaseCaracteristicas.setForeground(new Color(255, 255, 255));
		labelClaseCaracteristicas.setFont(new Font("Verdana", Font.BOLD, 20));
		labelClaseCaracteristicas.setBounds(40, 223, 121, 50);
		add(labelClaseCaracteristicas);
		
		JComboBox SeleccionClase = new JComboBox();
		SeleccionClase.setBounds(132, 227, 232, 50);
		add(SeleccionClase);
		
		JLabel labelRazaCaracteristicas = new JLabel("Raza:");
		labelRazaCaracteristicas.setForeground(new Color(255, 255, 255));
		labelRazaCaracteristicas.setFont(new Font("Verdana", Font.BOLD, 20));
		labelRazaCaracteristicas.setBounds(463, 223, 121, 50);
		add(labelRazaCaracteristicas);
		
		JComboBox SeleccionRaza = new JComboBox();
		SeleccionRaza.setBounds(294, 138, 232, 50);
		add(SeleccionRaza);
		
		JLabel lblNewLabel = new JLabel("Carisma");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(211, 318, 49, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fuerza");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(211, 369, 49, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Destreza");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(211, 416, 49, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Constitución");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(572, 318, 65, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sabiduria");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(572, 369, 49, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Inteligencia");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(572, 416, 65, 14);
		add(lblNewLabel_5);
		
		JSpinner spinnerCarisma = new JSpinner();
		spinnerCarisma.setBounds(294, 316, 49, 17);
		add(spinnerCarisma);
		
		JSpinner spinnerFuerza = new JSpinner();
		spinnerFuerza.setBounds(294, 366, 49, 20);
		add(spinnerFuerza);
		
		JSpinner spinnerDestreza = new JSpinner();
		spinnerDestreza.setBounds(294, 413, 49, 20);
		add(spinnerDestreza);
		
		JSpinner spinnerConstitucion = new JSpinner();
		spinnerConstitucion.setBounds(663, 315, 49, 20);
		add(spinnerConstitucion);
		
		JSpinner spinnerSabiduria = new JSpinner();
		spinnerSabiduria.setBounds(663, 366, 49, 20);
		add(spinnerSabiduria);
		
		JSpinner spinnerInteligencia = new JSpinner();
		spinnerInteligencia.setBounds(663, 413, 49, 20);
		add(spinnerInteligencia);

	}
	
	public void inicializarComponentes() {

	
	
	
	}
}
