/**
 * 
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import control.ControlMenuPrincipalGM;
import modelo.Partida;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * Clase que representa la interfaz gráfica para la edición de una partida.
 */
public class EditarPartida extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textAmbiente;
	private JTextField textDuracion;
	private JTextField textNumeroSesion;
	private JRadioButton radioSi;
	private JRadioButton radioNo;
	private JComboBox<Partida> misPartidas;
	private JFormattedTextField ftf;
	private JButton botonCrearPartida;
	private ArrayList<Partida> partidas;
	private ButtonGroup group;
	private ControlMenuPrincipalGM control;

	/**
	 * Constructor de la clase EditarPartida.
	 * 
	 * @param control El controlador que manejará las acciones de esta vista.
	 */
	public EditarPartida(ControlMenuPrincipalGM control) {
		this.control = control;
		configuracionInicial();
		inicializarComponentes();
	}

	/**
	 * Configuración inicial del panel.
	 */
	public void configuracionInicial() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1300, 660);
	}

	/**
	 * Inicialización de los componentes del panel.
	 */
	public void inicializarComponentes() {

		// Etiquetas para los campos de entrada
		JLabel labelNombrePartida = new JLabel("Nombre de la partida:");
		labelNombrePartida.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNombrePartida.setForeground(Color.WHITE);
		labelNombrePartida.setBounds(260, 61, 352, 40);
		add(labelNombrePartida);

		JLabel labelAmbientacion = new JLabel("Ambientación:");
		labelAmbientacion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelAmbientacion.setForeground(Color.WHITE);
		labelAmbientacion.setBounds(260, 141, 400, 30);
		add(labelAmbientacion);

		JLabel labelDiaHora = new JLabel("Día y hora de la semana:");
		labelDiaHora.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDiaHora.setForeground(Color.WHITE);
		labelDiaHora.setBounds(260, 221, 400, 38);
		add(labelDiaHora);

		JLabel labelDuracionSesion = new JLabel("Duración de la sesión (horas):");
		labelDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelDuracionSesion.setForeground(Color.WHITE);
		labelDuracionSesion.setBounds(260, 301, 471, 46);
		add(labelDuracionSesion);

		JLabel labelNumeroSesion = new JLabel("Número de la sesión:");
		labelNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelNumeroSesion.setForeground(Color.WHITE);
		labelNumeroSesion.setBounds(260, 381, 400, 48);
		add(labelNumeroSesion);

		JLabel labelEstado = new JLabel("¿Está en curso o terminada?:");
		labelEstado.setFont(new Font("Verdana", Font.BOLD, 25));
		labelEstado.setForeground(Color.WHITE);
		labelEstado.setBounds(260, 461, 429, 30);
		add(labelEstado);

		// Botón para editar la partida
		botonCrearPartida = new JButton("Editar Partida");
		botonCrearPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		botonCrearPartida.setForeground(new Color(37, 34, 81));
		botonCrearPartida.setBackground(new Color(135, 206, 235));
		botonCrearPartida.setBounds(452, 502, 400, 50);
		botonCrearPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPartida();
			}
		});
		add(botonCrearPartida);

		// Radio buttons para seleccionar si la partida está en curso o terminada
		radioSi = new JRadioButton("Si");
		radioNo = new JRadioButton("No");
		group = new ButtonGroup();
		group.add(radioSi);
		group.add(radioNo);

		radioSi.setFont(new Font("Verdana", Font.BOLD, 25));
		radioSi.setForeground(Color.WHITE);
		radioSi.setBackground(new Color(37, 34, 81));
		radioSi.setBounds(754, 461, 70, 30);
		add(radioSi);

		radioNo.setFont(new Font("Verdana", Font.BOLD, 25));
		radioNo.setForeground(Color.WHITE);
		radioNo.setBackground(new Color(37, 34, 81));
		radioNo.setBounds(893, 461, 70, 30);
		add(radioNo);

		// Campos de texto para los datos de la partida
		textAmbiente = new JTextField();
		textAmbiente.setFont(new Font("Verdana", Font.PLAIN, 20));
		textAmbiente.setBounds(724, 141, 258, 40);
		add(textAmbiente);
		textAmbiente.setColumns(10);

		textDuracion = new JTextField();
		textDuracion.setFont(new Font("Verdana", Font.PLAIN, 20));
		textDuracion.setBounds(724, 301, 258, 40);
		add(textDuracion);
		textDuracion.setColumns(10);

		textNumeroSesion = new JTextField();
		textNumeroSesion.setFont(new Font("Verdana", Font.PLAIN, 20));
		textNumeroSesion.setBounds(724, 381, 258, 40);
		add(textNumeroSesion);
		textNumeroSesion.setColumns(10);

		// ComboBox para seleccionar la partida a editar
		misPartidas = new JComboBox<Partida>();
		misPartidas.setFont(new Font("Verdana", Font.PLAIN, 20));
		misPartidas.setBounds(724, 61, 258, 37);
		misPartidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionPartidaCombo(e);
			}
		});
		add(misPartidas);

		// Campo formateado para la fecha y hora
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DateFormatter formatter = new DateFormatter(format);
		format.setLenient(false);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);

		ftf = new JFormattedTextField(formatter);
		ftf.setFont(new Font("Verdana", Font.PLAIN, 20));
		ftf.setValue(new Date());
		ftf.setBounds(724, 221, 258, 41);
		add(ftf);
	}

	/**
	 * Inserta las partidas en el comboBox.
	 * 
	 * @param array Lista de partidas a insertar.
	 */
	public void insertarPartida(ArrayList<Partida> array) {
		DefaultComboBoxModel<Partida> dcbm = new DefaultComboBoxModel<Partida>();
		dcbm.addAll(array);
		misPartidas.setModel(dcbm);

		partidas = array;
	}

	/**
	 * Selecciona una partida del comboBox y llena los campos con sus datos.
	 * 
	 * @param e El evento de acción.
	 */
	private void seleccionPartidaCombo(ActionEvent e) {

		// Obtener la partida seleccionada
		Partida partida = partidas.get(misPartidas.getSelectedIndex());

		// Llenar los campos con los datos de la partida seleccionada
		textAmbiente.setText(partida.getAmbientacion());
		ftf.setText(partida.getDiaHora());
		textDuracion.setText(partida.getDuracionSesion());
		textNumeroSesion.setText(partida.getNumeroSesion());
		group.clearSelection();
		if (partida.getFinalizada().equals("Si")) {
			radioSi.setSelected(true);
		} else {
			radioNo.setSelected(true);
		}

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

		textAmbiente.setText(null);
		textDuracion.setText(null);
		textNumeroSesion.setText(null);
		ftf.setValue(new Date());
		group.clearSelection();

	}

	/**
	 * Edita la partida seleccionada con los nuevos datos.
	 */
	public void editarPartida() {

		// Obtener la partida seleccionada
		Partida partida = partidas.get(misPartidas.getSelectedIndex());

		// Actualizar los datos de la partida con los valores de los campos
		partida.setAmbientacion(textAmbiente.getText());
		partida.setDuracionSesion(textDuracion.getText());
		partida.setNumeroSesion(textNumeroSesion.getText());
		partida.setDiaHora(ftf.getText());

		// Actualizar el estado de la partida
		if (radioSi.isSelected()) {
			partida.setFinalizada("Si");
		} else {
			partida.setFinalizada("No");
		}

		control.actualizarPartida(partida);
	}

}
