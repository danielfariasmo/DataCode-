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

public class EditarPartida extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */

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

	public EditarPartida(ControlMenuPrincipalGM control) {
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
		labelNombrePartida.setBounds(260, 92, 352, 40);
		add(labelNombrePartida);

		JLabel labelAmbientacion = new JLabel("Ambientación:");
		labelAmbientacion.setFont(new Font("Verdana", Font.BOLD, 25));
		labelAmbientacion.setForeground(Color.WHITE);
		labelAmbientacion.setBounds(260, 199, 400, 30);
		add(labelAmbientacion);

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
		botonCrearPartida = new JButton("Editar Partida");
		botonCrearPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		botonCrearPartida.setForeground(new Color(37, 34, 81));
		botonCrearPartida.setBackground(new Color(135, 206, 235));
		botonCrearPartida.setBounds(452, 508, 400, 50);
		botonCrearPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPartida();
			}
		});
		add(botonCrearPartida);

		// Botones de seleccion
		radioSi = new JRadioButton("Si");
		radioNo = new JRadioButton("No");
		group = new ButtonGroup();
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

		textAmbiente = new JTextField();
		textAmbiente.setBounds(728, 192, 258, 40);
		add(textAmbiente);
		textAmbiente.setColumns(10);

		textDuracion = new JTextField();
		textDuracion.setBounds(728, 345, 258, 40);
		add(textDuracion);
		textDuracion.setColumns(10);

		textNumeroSesion = new JTextField();
		textNumeroSesion.setBounds(728, 395, 258, 40);
		add(textNumeroSesion);
		textNumeroSesion.setColumns(10);

		misPartidas = new JComboBox<Partida>();
		misPartidas.setBounds(724, 92, 258, 37);
		misPartidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionPartidaCombo(e);
			}
		});
		add(misPartidas);

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DateFormatter formatter = new DateFormatter(format);
		format.setLenient(false);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);

		ftf = new JFormattedTextField(formatter);
		ftf.setValue(new Date());
		ftf.setBounds(719, 281, 258, 41);
		add(ftf);
	}

	public void insertarPartida(ArrayList<Partida> array) {
		DefaultComboBoxModel<Partida> dcbm = new DefaultComboBoxModel<Partida>();
		dcbm.addAll(array);
		misPartidas.setModel(dcbm);

		partidas = array;
	}

	private void seleccionPartidaCombo(ActionEvent e) {

		Partida partida = partidas.get(misPartidas.getSelectedIndex());

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

	public void mensaje(boolean exitoso, String mensaje) {

		if (exitoso) {
			JOptionPane.showMessageDialog(this, mensaje);
		} else {
			JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void limpiarCampos() {

		textAmbiente.setText(null);
		textDuracion.setText(null);
		textNumeroSesion.setText(null);
		ftf.setValue(new Date());
		group.clearSelection();

	}
	
	public void editarPartida() {
		
		Partida partida = partidas.get(misPartidas.getSelectedIndex());

		partida.setAmbientacion(textAmbiente.getText());
		partida.setDuracionSesion(textDuracion.getText());
		partida.setNumeroSesion(textNumeroSesion.getText());
		partida.setDiaHora(ftf.getText());
		
		if(radioSi.isSelected()) {
			partida.setFinalizada("Si");
		} else {
			partida.setFinalizada("No");
		}
		
		control.actualizarPartida(partida);
	}

}
