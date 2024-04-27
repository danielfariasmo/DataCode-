package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlInfoGM;

public class InfoPartidaJugador extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;

	public InfoPartidaJugador() {

		configuracionInicial();
		inicializarComponentes();
	}

	public void configuracionInicial() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1300, 660); 
		setForeground(new Color(255, 255, 255));
	}

	public void inicializarComponentes() {

		// Titulo de la partida
		JLabel labelTitulo = new JLabel("-TÍTULO DE LA PARTIDA-");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(493, 43, 305, 60);
		add(labelTitulo);

		// Tabla Personajes
		JTable tablaPersonajes = new JTable(new DefaultTableModel(new Object[][] { {}, {}, {}, {}, {}, {}, {}, {} },
				new String[] { "Nombre", "Raza", "Clase", "Nivel", }));
		tablaPersonajes.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablaPersonajes.setForeground(new Color(255, 255, 255));
		tablaPersonajes.setBackground(new Color(37, 34, 81));
		tablaPersonajes.setBounds(1, 26, 835, 81);
		add(tablaPersonajes);

		// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
		tablaPersonajes.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaPersonajes.getColumnModel().getColumn(2).setPreferredWidth(60);
		tablaPersonajes.getColumnModel().getColumn(3).setPreferredWidth(35);
		tablaPersonajes.getColumnModel().getColumn(4).setPreferredWidth(130);

		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		JScrollPane scrollPane = new JScrollPane(tablaPersonajes);
		scrollPane.setBounds(185, 255, 952, 153);
		add(scrollPane);

		// Boton unirme a la partida
		JButton botonUnirmePartida = new JButton("Unirme a la partida");
		botonUnirmePartida.setFont(new Font("Verdana", Font.BOLD, 15));
		botonUnirmePartida.setBounds(551, 470, 208, 43);
		add(botonUnirmePartida);
	
		// FUNCIONALIDAD DEL BOTÓN, CON LA CLASE ( ControlInfoJ )
		botonUnirmePartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlInfoGM.mostrarMensajeSubirNivel();
			}
		});
		

		// Etiqueta superior id partida
		JLabel labelIdPartida = new JLabel("ID Partida");
		labelIdPartida.setForeground(new Color(255, 255, 255));
		labelIdPartida.setBounds(194, 139, 80, 14);
		add(labelIdPartida);

		// Etiqueta superior numero de personajes
		JLabel labelNumeroPersonajes = new JLabel("Número de Personajes");
		labelNumeroPersonajes.setForeground(new Color(255, 255, 255));
		labelNumeroPersonajes.setBounds(194, 164, 112, 14);
		add(labelNumeroPersonajes);

		// Etiqueta superior
		JLabel lblNewLabel_2 = new JLabel("Máximo de Jugadores");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(194, 189, 112, 14);
		add(lblNewLabel_2);

		// Etiqueta superior id partida
		JLabel lblNewLabel_4 = new JLabel("1");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(311, 139, 139, 14);
		add(lblNewLabel_4);

		// Etiqueta superior numero de personajes
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(316, 164, 101, 14);
		add(lblNewLabel_5);

		// Etiqueta superior
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(316, 189, 101, 14);
		add(lblNewLabel_6);
	}

}
