package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class JugarPersonaje extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	public JugarPersonaje() {
		configuracionInicial();
		inicializarComponentes();

	}

	public void configuracionInicial() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1300, 660);

	}

	public void inicializarComponentes() {

		JLabel labelPersonaje = new JLabel("Personaje");
		labelPersonaje.setForeground(new Color(255, 255, 255));
		labelPersonaje.setFont(new Font("Verdana", Font.BOLD, 25));
		labelPersonaje.setBounds(341, 70, 152, 50);
		add(labelPersonaje);

		JComboBox<Object> seleccionPartida = new JComboBox<Object>();
		seleccionPartida.setBounds(595, 130, 306, 50);
		add(seleccionPartida);

		JLabel labelPartida = new JLabel("Partida");
		labelPartida.setForeground(new Color(255, 255, 255));
		labelPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		labelPartida.setBounds(701, 70, 109, 50);
		add(labelPartida);

		JComboBox<Object> seleccionPersonaje = new JComboBox<Object>();
		seleccionPersonaje.setBounds(294, 130, 232, 50);
		add(seleccionPersonaje);

		// Carisma
		JLabel labelCarisma = new JLabel("Carisma");
		labelCarisma.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		labelCarisma.setForeground(new Color(255, 255, 255));
		labelCarisma.setBounds(294, 256, 114, 32);
		add(labelCarisma);

		JSpinner spinnerCarisma = new JSpinner();
		spinnerCarisma.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerCarisma.setBounds(419, 252, 74, 41);
		add(spinnerCarisma);
		
		// Fuerza
		JLabel labelFuerza = new JLabel("Fuerza");
		labelFuerza.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		labelFuerza.setForeground(new Color(255, 255, 255));
		labelFuerza.setBounds(294, 339, 88, 30);
		add(labelFuerza);
		
		JSpinner spinnerFuerza = new JSpinner();
		spinnerFuerza.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerFuerza.setBounds(419, 334, 74, 41);
		add(spinnerFuerza);

		// Destreza 
		JLabel labelDestreza = new JLabel("Destreza");
		labelDestreza.setFont(new Font("Verdana", Font.PLAIN, 20));
				labelDestreza.setForeground(new Color(255, 255, 255));
		labelDestreza.setBounds(294, 409, 123, 28);
		add(labelDestreza);
		
		JSpinner spinnerDestreza = new JSpinner();
		spinnerDestreza.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerDestreza.setBounds(419, 403, 74, 41);
		add(spinnerDestreza);

		// Constitución
		JLabel labelConstitucion = new JLabel("Constitución");
		labelConstitucion.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelConstitucion.setForeground(new Color(255, 255, 255));
		labelConstitucion.setBounds(595, 253, 140, 38);
		add(labelConstitucion);
		
		JSpinner spinnerConstitucion = new JSpinner();
		spinnerConstitucion.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerConstitucion.setBounds(758, 252, 74, 41);
		add(spinnerConstitucion);

		// Sabiduria
		JLabel labelSabiduria = new JLabel("Sabiduria");
		labelSabiduria.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelSabiduria.setForeground(new Color(255, 255, 255));
		labelSabiduria.setBounds(595, 338, 123, 32);
		add(labelSabiduria);
		
		JSpinner spinnerSabiduria = new JSpinner();
		spinnerSabiduria.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerSabiduria.setBounds(758, 334, 74, 41);
		add(spinnerSabiduria);

		// Inteligencia
		JLabel labelInteligencia = new JLabel("Inteligencia");
		labelInteligencia.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelInteligencia.setForeground(new Color(255, 255, 255));
		labelInteligencia.setBounds(595, 404, 123, 38);
		add(labelInteligencia);
		
		JSpinner spinnerInteligencia = new JSpinner();
		spinnerInteligencia.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerInteligencia.setBounds(758, 403, 74, 41);
		add(spinnerInteligencia);
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(135, 206, 235));
		botonActualizar.setForeground(new Color(37, 34, 81));
		botonActualizar.setFont(new Font("Verdana", Font.BOLD, 25));
		botonActualizar.setBounds(481, 501, 181, 65);
		add(botonActualizar);

		

	

		

		

		

	

	}
}
