package vistas;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class CrearPartida extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;

	public CrearPartida() {

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
		labelIdentificador.setBounds(189, 35, 400, 30);
		add(labelIdentificador);

		JLabel labelNombrePartida = new JLabel("Nombre de la partida:");
		labelNombrePartida.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNombrePartida.setForeground(Color.WHITE);
		labelNombrePartida.setBounds(189, 91, 400, 30);
		add(labelNombrePartida);

		JLabel labelIdGameMaster = new JLabel("ID Game Master:");
		labelIdGameMaster.setFont(new Font("Verdana", Font.BOLD, 25));
		labelIdGameMaster.setForeground(Color.WHITE);
		labelIdGameMaster.setBounds(189, 143, 400, 30);
		add(labelIdGameMaster);

		JLabel labelAmbientacion = new JLabel("Ambientación:");
		labelAmbientacion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelAmbientacion.setForeground(Color.WHITE);
		labelAmbientacion.setBounds(189, 193, 400, 30);
		add(labelAmbientacion);

		JLabel labelPersonajes = new JLabel("Personajes que participan:");
		labelPersonajes.setFont(new Font("Verdana", Font.BOLD, 25));
		labelPersonajes.setForeground(Color.WHITE);
		labelPersonajes.setBounds(187, 245, 400, 30);
		add(labelPersonajes);

		JLabel labelDiaHora = new JLabel("Día y hora de la semana:");
		labelDiaHora.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDiaHora.setForeground(Color.WHITE);
		labelDiaHora.setBounds(187, 297, 400, 30);
		add(labelDiaHora);

		JLabel labelDuracionSesion = new JLabel("Duración de la sesión (horas):");
		labelDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDuracionSesion.setForeground(Color.WHITE);
		labelDuracionSesion.setBounds(187, 350, 484, 30);
		add(labelDuracionSesion);

		JLabel labelNumeroSesion = new JLabel("Número de la sesión:");
		labelNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNumeroSesion.setForeground(Color.WHITE);
		labelNumeroSesion.setBounds(187, 402, 400, 30);
		add(labelNumeroSesion);

		JLabel labelEstado = new JLabel("¿Está en curso o terminada? :");
		labelEstado.setFont(new Font("Verdana", Font.BOLD, 25));
		labelEstado.setForeground(Color.WHITE);
		labelEstado.setBounds(184, 454, 432, 30);
		add(labelEstado);

		// Campos de texto para introducir la información
		JTextField textoIdentificador = new JTextField();
		textoIdentificador.setFont(new Font("Verdana", Font.BOLD, 20));
		textoIdentificador.setBounds(639, 32, 400, 41);
		add(textoIdentificador);

		JTextField textoNombrePartida = new JTextField();
		textoNombrePartida.setFont(new Font("Verdana", Font.BOLD, 20));
		textoNombrePartida.setBounds(639, 88, 400, 41);
		add(textoNombrePartida);

		JTextField textoIdGameMaster = new JTextField();
		textoIdGameMaster.setFont(new Font("Verdana", Font.BOLD, 20));
		textoIdGameMaster.setBounds(639, 140, 400, 41);
		add(textoIdGameMaster);

		JTextField textoAmbientacion = new JTextField();
		textoAmbientacion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoAmbientacion.setBounds(639, 190, 400, 41);
		add(textoAmbientacion);

		JTextField textoPersonajes = new JTextField();
		textoPersonajes.setFont(new Font("Verdana", Font.BOLD, 20));
		textoPersonajes.setBounds(639, 242, 400, 41);
		add(textoPersonajes);

		JTextField textoDiaHora = new JTextField();
		textoDiaHora.setFont(new Font("Verdana", Font.BOLD, 20));
		textoDiaHora.setBounds(639, 294, 400, 41);
		add(textoDiaHora);

		JTextField textoDuracionSesion = new JTextField();
		textoDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoDuracionSesion.setBounds(639, 347, 400, 41);
		add(textoDuracionSesion);

		JTextField textoNumeroSesion = new JTextField();
		textoNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoNumeroSesion.setBounds(639, 399, 400, 41);
		add(textoNumeroSesion);

		// Botones de opción para el estado
		JRadioButton radioSi = new JRadioButton("Si");
		JRadioButton radioNo = new JRadioButton("No");
		ButtonGroup group = new ButtonGroup();
		group.add(radioSi);
		group.add(radioNo);

		radioSi.setFont(new Font("Verdana", Font.PLAIN, 20));
		radioSi.setForeground(Color.WHITE);
		radioSi.setBackground(new Color(37, 34, 81));
		radioSi.setBounds(740, 454, 70, 30);
		add(radioSi);

		radioNo.setFont(new Font("Verdana", Font.PLAIN, 20));
		radioNo.setForeground(Color.WHITE);
		radioNo.setBackground(new Color(37, 34, 81));
		radioNo.setBounds(908, 454, 70, 30);
		add(radioNo);

		// Botón para registrarse
		JButton botonCrearPartida = new JButton("Crear Partida");
		botonCrearPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		botonCrearPartida.setForeground(new Color(37, 34, 81));
		botonCrearPartida.setBackground(new Color(135, 206, 235));
		botonCrearPartida.setBounds(639, 490, 400, 50);
		add(botonCrearPartida);

		// Crear un cuadro de diálogo personalizado
		botonCrearPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String identificador = textoIdentificador.getText();
				// Mensaje del cuadro de dialogo , con la información del identificador
				// introducido por el usuario
				JOptionPane.showMessageDialog(CrearPartida.this,
						"La partida con identificador " + identificador + ": ha sido creada correctamente");
			}
		});
	}
}
