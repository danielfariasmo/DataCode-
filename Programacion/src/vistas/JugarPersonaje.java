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
import javax.swing.JSpinner;

import control.ControlJugarPersonaje;
import modelo.Juega;
import modelo.Personaje;

public class JugarPersonaje extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<Personaje> seleccionPersonaje;
	private ControlJugarPersonaje control;
	private JComboBox<String> seleccionPartida;
	private ArrayList<String[]> partidas;
	private Personaje personaje;
	private JSpinner spinnerInteligencia;
	private JSpinner spinnerCarisma;
	private JSpinner spinnerFuerza;
	private JSpinner spinnerDestreza;
	private JSpinner spinnerConstitucion;
	private JSpinner spinnerSabiduria;
	private JButton botonActualizar;
	private JButton botonFinSession;
	private String idPartida;
	private Juega juega;

	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	public JugarPersonaje(ControlJugarPersonaje control) {
		this.control = control;
		configuracionInicial();
		inicializarComponentes();

	}
	
	public void insertarPersonaje(ArrayList<Personaje> array) {
		DefaultComboBoxModel<Personaje> dcbm = new DefaultComboBoxModel<Personaje>();
		dcbm.addAll(array);
		seleccionPersonaje.setModel(dcbm);
	}
	
	public void insertarPartida(ArrayList<String[]> array) {
		
		partidas = array;
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		ArrayList <String> contenedor = new ArrayList<String>();
		
		for (String[] strings : array) {
			contenedor.add(strings[0]);
		}
		dcbm.addAll(contenedor);
		seleccionPartida.setModel(dcbm);
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

		seleccionPartida = new JComboBox<String>();
		seleccionPartida.setBounds(595, 130, 306, 50);
		seleccionPartida.addItem("--Seleccione la Partida--");
		seleccionPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionPartidaCombo(e);
			}
		});
		add(seleccionPartida);

		JLabel labelPartida = new JLabel("Partida");
		labelPartida.setForeground(new Color(255, 255, 255));
		labelPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		labelPartida.setBounds(701, 70, 109, 50);
		add(labelPartida);

		seleccionPersonaje = new JComboBox<Personaje>();
		seleccionPersonaje.setBounds(294, 130, 232, 50);
		seleccionPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				seleccionPersonajeCombo(e);
			}
		});
		add(seleccionPersonaje);

		// Carisma
		JLabel labelCarisma = new JLabel("Carisma");
		labelCarisma.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		labelCarisma.setForeground(new Color(255, 255, 255));
		labelCarisma.setBounds(294, 256, 114, 32);
		add(labelCarisma);

		spinnerCarisma = new JSpinner();
		spinnerCarisma.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerCarisma.setBounds(419, 252, 74, 41);
		add(spinnerCarisma);
		
		// Fuerza
		JLabel labelFuerza = new JLabel("Fuerza");
		labelFuerza.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		labelFuerza.setForeground(new Color(255, 255, 255));
		labelFuerza.setBounds(294, 339, 88, 30);
		add(labelFuerza);
		
		spinnerFuerza = new JSpinner();
		spinnerFuerza.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerFuerza.setBounds(419, 334, 74, 41);
		add(spinnerFuerza);

		// Destreza 
		JLabel labelDestreza = new JLabel("Destreza");
		labelDestreza.setFont(new Font("Verdana", Font.PLAIN, 20));
				labelDestreza.setForeground(new Color(255, 255, 255));
		labelDestreza.setBounds(294, 409, 123, 28);
		add(labelDestreza);
		
		spinnerDestreza = new JSpinner();
		spinnerDestreza.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerDestreza.setBounds(419, 403, 74, 41);
		add(spinnerDestreza);

		// Constitución
		JLabel labelConstitucion = new JLabel("Constitución");
		labelConstitucion.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelConstitucion.setForeground(new Color(255, 255, 255));
		labelConstitucion.setBounds(595, 253, 140, 38);
		add(labelConstitucion);
		
		spinnerConstitucion = new JSpinner();
		spinnerConstitucion.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerConstitucion.setBounds(758, 252, 74, 41);
		add(spinnerConstitucion);

		// Sabiduria
		JLabel labelSabiduria = new JLabel("Sabiduria");
		labelSabiduria.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelSabiduria.setForeground(new Color(255, 255, 255));
		labelSabiduria.setBounds(595, 338, 123, 32);
		add(labelSabiduria);
		
		spinnerSabiduria = new JSpinner();
		spinnerSabiduria.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerSabiduria.setBounds(758, 334, 74, 41);
		add(spinnerSabiduria);

		// Inteligencia
		JLabel labelInteligencia = new JLabel("Inteligencia");
		labelInteligencia.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelInteligencia.setForeground(new Color(255, 255, 255));
		labelInteligencia.setBounds(595, 404, 123, 38);
		add(labelInteligencia);
		
		spinnerInteligencia = new JSpinner();
		spinnerInteligencia.setFont(new Font("Verdana", Font.PLAIN, 20));
		spinnerInteligencia.setBounds(758, 403, 74, 41);
		add(spinnerInteligencia);
		
		botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(135, 206, 235));
		botonActualizar.setForeground(new Color(37, 34, 81));
		botonActualizar.setFont(new Font("Verdana", Font.BOLD, 25));
		botonActualizar.setBounds(294, 483, 232, 65);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				actualizarPersonaje(evt);
			}
		});
		add(botonActualizar);
		
		botonFinSession = new JButton("Finalizar Sesión");
		botonFinSession.setForeground(new Color(37, 34, 81));
		botonFinSession.setFont(new Font("Verdana", Font.BOLD, 25));
		botonFinSession.setBackground(new Color(135, 206, 235));
		botonFinSession.setBounds(595, 483, 306, 65);
		botonFinSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				finalizarSesion(evt);
			}
		});
		add(botonFinSession);

	}
	
	private void seleccionPersonajeCombo (ActionEvent e) {
		
		personaje = (Personaje) seleccionPersonaje.getSelectedItem();
		control.cargarPartidas(personaje);
	}
	
	private void seleccionPartidaCombo (ActionEvent e) {
		
		idPartida = partidas.get(seleccionPartida.getSelectedIndex())[1];
		control.obtenerCaracteristicas(personaje, idPartida);

	}
	
	public void cargarSpinner(Juega juega) {
		
		this.juega = juega;
		spinnerInteligencia.setValue(juega.getInteligencia());
		spinnerCarisma.setValue(juega.getCarisma());
		spinnerFuerza.setValue(juega.getFuerza());
		spinnerDestreza.setValue(juega.getDestreza());
		spinnerConstitucion.setValue(juega.getConstitucion());
		spinnerSabiduria.setValue(juega.getCarisma());
		
	}
	
	public void actualizarPersonaje(ActionEvent ev) {
		
		System.out.println("Funciona evento actualizar");
		if(personaje != null && idPartida != null && juega != null) {
			control.actualizarPersonajeCaracteristicas(juega);
			String nombrePartida = " ";
			
			for (String[] recorrer : partidas) {
				if(recorrer[1].equals(String.valueOf(juega.getId_partida()))) {
					nombrePartida = recorrer[0];
					break;
				}
			}
			
			JOptionPane.showMessageDialog(this, "Se ha actualizado el personaje " + personaje.getNombre() + ", en la partida " + nombrePartida);
		} else {
			JOptionPane.showMessageDialog(this, "Debes rellenar los datos correctamente");
		}
		
	}
	
	public void finalizarSesion(ActionEvent ev) {
		
		JOptionPane.showMessageDialog(this, "Se ha finalizado la sesión.");
		control.finalizarSesionCambio();
	}
}
