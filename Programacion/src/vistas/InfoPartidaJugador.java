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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlMenuPrincipalUsuario;
import modelo.Partida;
import modelo.Personaje;

public class InfoPartidaJugador extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Personaje> boxPersonaje;
	private JLabel labelTitulo;
	private JLabel labelIdentificadorPartida;
	private JLabel labelInfoMaxJugadores;
	private JLabel labelInfoGameMaster;
	private JTable tablaPersonajes;
	private Partida partidaClase;
	private ControlMenuPrincipalUsuario control;

	public InfoPartidaJugador(ControlMenuPrincipalUsuario control) {
		this.control = control;
		configuracionInicial();
		inicializarComponentes();
	}

	public void configuracionInicial() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1302, 660);
		setForeground(new Color(255, 255, 255));
	}

	public void inicializarComponentes() {

		// Titulo de la partida
		labelTitulo = new JLabel("");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 40));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(350, 35, 1200, 60);
		add(labelTitulo);

		// Tabla Personajes
		tablaPersonajes = new JTable(new DefaultTableModel(new Object[][] { },
				new String[] { "Nombre", "Raza", "Clase", "Nivel" }));
		// Tabla Personajes
		tablaPersonajes.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablaPersonajes.setForeground(new Color(255, 255, 255));
		tablaPersonajes.setBackground(new Color(37, 34, 81));
		tablaPersonajes.setBounds(-15, 25, 939, 77);
		add(tablaPersonajes);

		// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
		tablaPersonajes.getColumnModel().getColumn(0).setPreferredWidth(150);
		tablaPersonajes.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaPersonajes.getColumnModel().getColumn(2).setPreferredWidth(60);
		tablaPersonajes.getColumnModel().getColumn(3).setPreferredWidth(35);

		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		JScrollPane scrollPane = new JScrollPane(tablaPersonajes);
		scrollPane.setBounds(181, 219, 958, 153);
		add(scrollPane);

		// Boton unirme a la partida
		JButton botonUnirmePartida = new JButton("Unirme a la partida");
		botonUnirmePartida.setBackground(new Color(135, 206, 235));
		botonUnirmePartida.setForeground(new Color(37, 34, 81));
		botonUnirmePartida.setFont(new Font("Verdana", Font.BOLD, 20));
		botonUnirmePartida.setBounds(711, 453, 272, 43);
		botonUnirmePartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				itemSeleccionado(evt);
			}
		});
		add(botonUnirmePartida);

		// Id Partida
		JLabel labelIdPartida = new JLabel("ID Partida");
		labelIdPartida.setFont(new Font("Verdana", Font.BOLD, 17));
		labelIdPartida.setForeground(new Color(255, 255, 255));
		labelIdPartida.setBounds(181, 139, 156, 14);
		add(labelIdPartida);

		labelIdentificadorPartida = new JLabel("");
		labelIdentificadorPartida.setFont(new Font("Verdana", Font.BOLD, 17));
		labelIdentificadorPartida.setForeground(new Color(255, 255, 255));
		labelIdentificadorPartida.setBounds(471, 139, 139, 14);
		add(labelIdentificadorPartida);

		// Maximo Jugadores
		JLabel labelMaximoJugadores = new JLabel("Máximo de Jugadores");
		labelMaximoJugadores.setFont(new Font("Verdana", Font.BOLD, 17));
		labelMaximoJugadores.setForeground(new Color(255, 255, 255));
		labelMaximoJugadores.setBounds(181, 163, 219, 22);
		add(labelMaximoJugadores);

		labelInfoMaxJugadores = new JLabel("New label");
		labelInfoMaxJugadores.setFont(new Font("Verdana", Font.BOLD, 17));
		labelInfoMaxJugadores.setForeground(new Color(255, 255, 255));
		labelInfoMaxJugadores.setBounds(470, 167, 101, 14);
		add(labelInfoMaxJugadores);

		// Game Master
		JLabel labelGameMaster = new JLabel("GameMaster");
		labelGameMaster.setFont(new Font("Verdana", Font.BOLD, 17));
		labelGameMaster.setForeground(new Color(255, 255, 255));
		labelGameMaster.setBounds(181, 195, 156, 14);
		add(labelGameMaster);

		labelInfoGameMaster = new JLabel("New label");
		labelInfoGameMaster.setFont(new Font("Verdana", Font.BOLD, 17));
		labelInfoGameMaster.setForeground(new Color(255, 255, 255));
		labelInfoGameMaster.setBounds(471, 195, 130, 14);
		add(labelInfoGameMaster);

		boxPersonaje = new JComboBox<Personaje>();
		boxPersonaje.setFont(new Font("Verdana", Font.PLAIN, 20));
		boxPersonaje.setBounds(157, 436, 444, 84);
		add(boxPersonaje);

		JLabel tituloPersonaje = new JLabel("Personajes");
		tituloPersonaje.setFont(new Font("Verdana", Font.BOLD, 25));
		tituloPersonaje.setForeground(new Color(255, 255, 255));
		tituloPersonaje.setBounds(298, 383, 170, 44);
		add(tituloPersonaje);
	}

	public JComboBox<Personaje> getBoxPersonaje() {
		return boxPersonaje;
	}

	public void cargarInfoPartida(Partida partida, ArrayList<Personaje> misPersonajes,
			ArrayList<Personaje> todosPersonajes) {

		labelTitulo.setText(partida.getNombre());
		labelIdentificadorPartida.setText(partida.getIdPartida());
		labelInfoMaxJugadores.setText(partida.getDuracionSesion() + " horas.");
		labelInfoGameMaster.setText(partida.getIdGameMaster());

		DefaultTableModel modelo = (DefaultTableModel) tablaPersonajes.getModel();
		modelo.setNumRows(0);

		for (Personaje personaje : todosPersonajes) {
			ArrayList<String> registro = new ArrayList<String>();
			registro.add(personaje.getNombre());
			registro.add(personaje.getRaza());
			registro.add(personaje.getClase());
			registro.add(String.valueOf(personaje.getNivelExperiencia()));

			modelo.addRow(registro.toArray());
		}

		DefaultComboBoxModel<Personaje> dcbm = new DefaultComboBoxModel<Personaje>();
		dcbm.addAll(misPersonajes);
		boxPersonaje.setModel(dcbm);
		
		partidaClase = partida;

	}
	
	private void itemSeleccionado (ActionEvent e) {
		
		Personaje personaje = (Personaje) boxPersonaje.getSelectedItem();
		System.out.println(personaje);
		
		if (personaje != null) {
			
			String descripcion = JOptionPane.showInputDialog("Indica la descripción de tu personaje: ");
			
			System.out.println(descripcion);
			
			JOptionPane.showMessageDialog(this, "Te has unido a la partida: " + partidaClase.getNombre());
			control.agregarPartida(partidaClase, personaje, descripcion);
		} else {
			JOptionPane.showMessageDialog(this, "Debes seleccionar un personaje");
		}
		
	}
}
