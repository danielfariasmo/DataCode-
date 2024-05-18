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

/**
 * Clase que representa la interfaz gráfica para la creación de una partida.
 */
/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

public class CrearPartida extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textoNombrePartida;
	private JTextField textoAmbientacion;
	private JTextField textoDuracionSesion;
	private JTextField textoNumeroSesion;
	private JFormattedTextField fechaHora;
	private ControlMenuPrincipalGM control;

	/**
	 * Constructor de la clase CrearPartida.
	 * 
	 * @param control El controlador que manejará las acciones de esta vista.
	 */
	public CrearPartida(ControlMenuPrincipalGM control) {
		this.control = control;
		configuracionInicial();
		inicializarComponentes();

	}

	/**
	 * Configuración inicial del panel.
	 */
	public void configuracionInicial() {

		// Configuración inicial del panel
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1300, 660);

	}

	/**
	 * Inicialización de los componentes del panel.
	 */
	public void inicializarComponentes() {

		// Etiqueta para el nombre de la partida
		JLabel labelNombrePartida = new JLabel("Nombre de la partida:");
		labelNombrePartida.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNombrePartida.setForeground(Color.WHITE);
		labelNombrePartida.setBounds(189, 91, 400, 30);
		add(labelNombrePartida);

		// Etiqueta para la ambientación de la partida
		JLabel labelAmbientacion = new JLabel("Ambientación:");
		labelAmbientacion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelAmbientacion.setForeground(Color.WHITE);
		labelAmbientacion.setBounds(189, 171, 400, 30);
		add(labelAmbientacion);

		// Etiqueta para el día y hora de la semana
		JLabel labelDiaHora = new JLabel("Día y hora de la semana:");
		labelDiaHora.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDiaHora.setForeground(Color.WHITE);
		labelDiaHora.setBounds(189, 251, 400, 30);
		add(labelDiaHora);

		// Etiqueta para la duración de la sesión
		JLabel labelDuracionSesion = new JLabel("Duración de la sesión (horas):");
		labelDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDuracionSesion.setForeground(Color.WHITE);
		labelDuracionSesion.setBounds(189, 331, 484, 30);
		add(labelDuracionSesion);

		// Etiqueta para el número de la sesión
		JLabel labelNumeroSesion = new JLabel("Número de la sesión:");
		labelNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNumeroSesion.setForeground(Color.WHITE);
		labelNumeroSesion.setBounds(189, 411, 400, 30);
		add(labelNumeroSesion);

		// Campo de texto para el nombre de la partida
		textoNombrePartida = new JTextField();
		textoNombrePartida.setFont(new Font("Verdana", Font.BOLD, 20));
		textoNombrePartida.setBounds(639, 88, 400, 41);
		add(textoNombrePartida);

		// Campo de texto para la ambientación de la partida
		textoAmbientacion = new JTextField();
		textoAmbientacion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoAmbientacion.setBounds(639, 168, 400, 41);
		add(textoAmbientacion);

		// Campo de texto para la duración de la sesión
		textoDuracionSesion = new JTextField();
		textoDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoDuracionSesion.setBounds(639, 328, 400, 41);
		add(textoDuracionSesion);

		// Campo de texto para el número de la sesión
		textoNumeroSesion = new JTextField();
		textoNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 20));
		textoNumeroSesion.setBounds(639, 408, 400, 41);
		add(textoNumeroSesion);

		// Botón para crear la partida
		JButton botonCrearPartida = new JButton("Crear Partida");
		botonCrearPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		botonCrearPartida.setForeground(new Color(37, 34, 81));
		botonCrearPartida.setBackground(new Color(135, 206, 235));
		botonCrearPartida.setBounds(639, 488, 400, 50);
		add(botonCrearPartida);

		// Formateador de fecha y hora
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DateFormatter formatter = new DateFormatter(format);
		format.setLenient(false);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);

		fechaHora = new JFormattedTextField(formatter);
		fechaHora.setFont(new Font("Verdana", Font.PLAIN, 20));
		fechaHora.setValue(new Date());
		fechaHora.setBounds(639, 248, 400, 41);
		add(fechaHora);

		// Acción del botón para crear la partida
		botonCrearPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.creacionPartida();
			}
		});
	}

	/**
	 * Muestra un mensaje en un cuadro de diálogo.
	 * 
	 * @param exitoso Indica si la operación fue exitosa.
	 * @param mensaje El mensaje a mostrar.
	 */
	public void mensaje(boolean exitoso, String mensaje) {

		if (exitoso) {
			JOptionPane.showMessageDialog(this, mensaje);
		} else {
			JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Limpia los campos del formulario.
	 */
	public void limpiarCampos() {
		textoNombrePartida.setText("");
		textoAmbientacion.setText("");
		textoDuracionSesion.setText("");
		textoNumeroSesion.setText("");
		fechaHora.setValue(new Date());
	}

	// Métodos getters
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
