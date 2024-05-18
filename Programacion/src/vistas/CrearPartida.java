package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import control.ControlMenuPrincipalGM;

public class CrearPartida extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoNombrePartida;
	private JTextField textoAmbientacion;
	private JTextField textoDuracionSesion;
	private JTextField textoNumeroSesion;
	private JFormattedTextField fechaHora;
	private ControlMenuPrincipalGM control;

	public CrearPartida(ControlMenuPrincipalGM control) {
		this.control = control;
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

		JLabel labelNombrePartida = new JLabel("Nombre de la partida:");
		labelNombrePartida.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNombrePartida.setForeground(Color.WHITE);
		labelNombrePartida.setBounds(189, 91, 400, 30);
		add(labelNombrePartida);

		JLabel labelAmbientacion = new JLabel("Ambientación:");
		labelAmbientacion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelAmbientacion.setForeground(Color.WHITE);
		labelAmbientacion.setBounds(189, 193, 400, 30);
		add(labelAmbientacion);

		JLabel labelDiaHora = new JLabel("Día y hora de la semana:");
		labelDiaHora.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDiaHora.setForeground(Color.WHITE);
		labelDiaHora.setBounds(189, 278, 400, 30);
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

		textoNombrePartida = new JTextField();
		textoNombrePartida.setFont(new Font("Verdana", Font.BOLD, 20));
		textoNombrePartida.setBounds(639, 88, 400, 41);
		add(textoNombrePartida);

		textoAmbientacion = new JTextField();
		textoAmbientacion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoAmbientacion.setBounds(639, 190, 400, 41);
		add(textoAmbientacion);

		textoDuracionSesion = new JTextField();
		textoDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoDuracionSesion.setBounds(639, 347, 400, 41);
		add(textoDuracionSesion);

		textoNumeroSesion = new JTextField();
		textoNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoNumeroSesion.setBounds(639, 399, 400, 41);
		add(textoNumeroSesion);

		// Botón para registrarse
		JButton botonCrearPartida = new JButton("Crear Partida");
		botonCrearPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		botonCrearPartida.setForeground(new Color(37, 34, 81));
		botonCrearPartida.setBackground(new Color(135, 206, 235));
		botonCrearPartida.setBounds(639, 490, 400, 50);
		add(botonCrearPartida);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DateFormatter formatter = new DateFormatter(format);
		format.setLenient(false);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);
		  
		fechaHora = new JFormattedTextField(formatter);
		fechaHora.setValue(new Date());
		fechaHora.setBounds(639, 267, 400, 41);
		add(fechaHora);

		// Crear un cuadro de diálogo personalizado
		botonCrearPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.creacionPartida();
			}
		});
	}

	public void mensaje(boolean exitoso, String mensaje) {
		
		if(exitoso) {
			JOptionPane.showMessageDialog(this, mensaje);
		} else {
			JOptionPane.showMessageDialog(this, mensaje, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void limpiarCampos() {
		textoNombrePartida.setText("");
		textoAmbientacion.setText("");
		textoDuracionSesion.setText("");
		textoNumeroSesion.setText("");
		fechaHora.setValue(new Date());
	}
	
	public String getTextoNombrePartida() {
		return textoNombrePartida.getText();
	}

	public String getTextoAmbientacion() {
		return textoAmbientacion.getText();
	}

	public String getTextoDuracionSesion() {
		return textoDuracionSesion.getText();
	}

	public String getTextoNumeroSesion() {
		return textoNumeroSesion.getText();
	}

	public String getFechaHora() {
		return fechaHora.getText();
	}
	
	
	
}
