/**
 * 
 */
package vistas;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class EditarPartida extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
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

	public EditarPartida() {

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

		// Etiquetas para introducir la información
		JLabel labelIdentificador = new JLabel("Identificador único:");
		labelIdentificador.setFont(new Font("Verdana", Font.BOLD, 25));
		labelIdentificador.setForeground(Color.WHITE);
		labelIdentificador.setBounds(260, 35, 336, 40);
		add(labelIdentificador);

		JLabel labelNombrePartida = new JLabel("Nombre de la partida:");
		labelNombrePartida.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNombrePartida.setForeground(Color.WHITE);
		labelNombrePartida.setBounds(260, 92, 352, 40);
		add(labelNombrePartida);

		JLabel labelIdGameMaster = new JLabel("ID Game Master:");
		labelIdGameMaster.setFont(new Font("Verdana", Font.BOLD, 25));
		labelIdGameMaster.setForeground(Color.WHITE);
		labelIdGameMaster.setBounds(260, 148, 258, 40);
		add(labelIdGameMaster);

		JLabel labelAmbientacion = new JLabel("Ambientación:");
		labelAmbientacion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelAmbientacion.setForeground(Color.WHITE);
		labelAmbientacion.setBounds(260, 199, 400, 30);
		add(labelAmbientacion);

		JLabel labelPersonajes = new JLabel("Personajes que participan:");
		labelPersonajes.setFont(new Font("Verdana", Font.BOLD, 25));
		labelPersonajes.setForeground(Color.WHITE);
		labelPersonajes.setBounds(260, 245, 400, 40);
		add(labelPersonajes);

		JLabel labelDiaHora = new JLabel("Día y hora de la semana:");
		labelDiaHora.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDiaHora.setForeground(Color.WHITE);
		labelDiaHora.setBounds(260, 296, 400, 38);
		add(labelDiaHora);

		JLabel labelDuracionSesion = new JLabel("Duración de la sesión (horas):");
		labelDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDuracionSesion.setForeground(Color.WHITE);
		labelDuracionSesion.setBounds(260, 345, 471, 46);
		add(labelDuracionSesion);

		JLabel labelNumeroSesion = new JLabel("Número de la sesión:");
		labelNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNumeroSesion.setForeground(Color.WHITE);
		labelNumeroSesion.setBounds(260, 395, 400, 48);
		add(labelNumeroSesion);

		JLabel labelEstado = new JLabel("¿Está en curso o terminada?:");
		labelEstado.setFont(new Font("Verdana", Font.BOLD, 25));
		labelEstado.setForeground(Color.WHITE);
		labelEstado.setBounds(260, 454, 429, 30);
		add(labelEstado);

		// Botón para registrarse
		JButton botonCrearPartida = new JButton("Editar Partida");
		botonCrearPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		botonCrearPartida.setForeground(new Color(37, 34, 81));
		botonCrearPartida.setBackground(new Color(135, 206, 235));
		botonCrearPartida.setBounds(452, 508, 400, 50);
		add(botonCrearPartida);

		// Botones de seleccion
		JRadioButton radioSi = new JRadioButton("Si");
		JRadioButton radioNo = new JRadioButton("No");
		ButtonGroup group = new ButtonGroup();
		group.add(radioSi);
		group.add(radioNo);

		radioSi.setFont(new Font("Verdana", Font.PLAIN, 20));
		radioSi.setForeground(Color.WHITE);
		radioSi.setBackground(new Color(37, 34, 81));
		radioSi.setBounds(754, 456, 70, 30);
		add(radioSi);

		radioNo.setFont(new Font("Verdana", Font.PLAIN, 20));
		radioNo.setForeground(Color.WHITE);
		radioNo.setBackground(new Color(37, 34, 81));
		radioNo.setBounds(889, 456, 70, 30);
		add(radioNo);

		textField = new JTextField();
		textField.setBounds(728, 41, 258, 40);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(728, 92, 258, 40);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(728, 141, 258, 40);
		add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(728, 192, 258, 40);
		add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(728, 243, 258, 40);
		add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(728, 294, 258, 40);
		add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(728, 345, 258, 40);
		add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(728, 395, 258, 40);
		add(textField_7);
		textField_7.setColumns(10);
	}
	
}
