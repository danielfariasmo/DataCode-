package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlInfoGM;


public class InfoPartidaGameMaster extends JPanel {

	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;

	public InfoPartidaGameMaster() {

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
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 40));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(326, 29, 665, 60);
		add(labelTitulo);

		// Tabla Personajes
		JTable tablaGameMaster = new JTable(new DefaultTableModel(new Object[][] { {}, {}, {}, {}, {}, {}, {}, {} },
				new String[] { "Nombre", "Raza", "Clase", "Nivel","Fuerza","Constitucion","Inteligencia","Sabiduría","Carisma" }));
		tablaGameMaster.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablaGameMaster.setForeground(new Color(255, 255, 255));
		tablaGameMaster.setBackground(new Color(37, 34, 81));
		tablaGameMaster.setBounds(-21, 25, 835, 81);
		add(tablaGameMaster);
		

		// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
		tablaGameMaster.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaGameMaster.getColumnModel().getColumn(2).setPreferredWidth(60);
		tablaGameMaster.getColumnModel().getColumn(3).setPreferredWidth(35);
		tablaGameMaster.getColumnModel().getColumn(4).setPreferredWidth(150);
		tablaGameMaster.getColumnModel().getColumn(5).setPreferredWidth(70);
		tablaGameMaster.getColumnModel().getColumn(6).setPreferredWidth(60);
		tablaGameMaster.getColumnModel().getColumn(7).setPreferredWidth(40);
		tablaGameMaster.getColumnModel().getColumn(8).setPreferredWidth(60);
		tablaGameMaster.getColumnModel().getColumn(9).setPreferredWidth(110);
		
		
		
		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		JScrollPane scrollPane = new JScrollPane(tablaGameMaster);
		scrollPane.setBounds(169, 299, 940, 130);
		add(scrollPane);

		// Boton editar personajes
		JButton botonEditarPersonajes = new JButton("Subir Nivel");
		botonEditarPersonajes.setBackground(new Color(135, 206, 235));
		botonEditarPersonajes.setForeground(new Color(37, 34, 81));
		botonEditarPersonajes.setFont(new Font("Verdana", Font.BOLD, 20));
		botonEditarPersonajes.setBounds(485, 489, 208, 38);
		add(botonEditarPersonajes);
		
		//FUNCIONALIDAD DEL BOTÓN, CON LA CLASE ( ControlInfoGM )
		botonEditarPersonajes.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ControlInfoGM.mostrarMensajeSubirNivel();
		    }
		});
		
		// Etiqueta superior id partida
		JLabel labelIdPartida = new JLabel("ID Partida");
		labelIdPartida.setFont(new Font("Verdana", Font.BOLD, 17));
		labelIdPartida.setForeground(new Color(255, 255, 255));
		labelIdPartida.setBounds(169, 141, 191, 14);
		add(labelIdPartida);

		// Etiqueta superior numero de personajes
		JLabel labelNumeroPersonajes = new JLabel("Número de Personajes");
		labelNumeroPersonajes.setFont(new Font("Verdana", Font.BOLD, 17));
		labelNumeroPersonajes.setForeground(new Color(255, 255, 255));
		labelNumeroPersonajes.setBounds(169, 166, 288, 26);
		add(labelNumeroPersonajes);

		// Etiqueta superior
		JLabel labelMaxJugadores = new JLabel("Máximo de jugadores");
		labelMaxJugadores.setFont(new Font("Verdana", Font.BOLD, 17));
		labelMaxJugadores.setForeground(new Color(255, 255, 255));
		labelMaxJugadores.setBounds(169, 195, 213, 26);
		add(labelMaxJugadores);

		// Etiqueta superior id partida
		JLabel lblNewLabel_4 = new JLabel("1");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 17));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(485, 139, 139, 14);
		add(lblNewLabel_4);

		// Etiqueta superior numero de personajes
		JLabel labelInfoNumPersonajes = new JLabel("New label");
		labelInfoNumPersonajes.setFont(new Font("Verdana", Font.BOLD, 17));
		labelInfoNumPersonajes.setForeground(new Color(255, 255, 255));
		labelInfoNumPersonajes.setBounds(485, 172, 101, 14);
		add(labelInfoNumPersonajes);

		// Etiqueta superior
		JLabel labelInfoMaxJugadores = new JLabel("New label");
		labelInfoMaxJugadores.setFont(new Font("Verdana", Font.BOLD, 17));
		labelInfoMaxJugadores.setForeground(new Color(255, 255, 255));
		labelInfoMaxJugadores.setBounds(485, 201, 101, 14);
		add(labelInfoMaxJugadores);
		
		JLabel labelGameMaster = new JLabel("GameMaster");
		labelGameMaster.setFont(new Font("Verdana", Font.BOLD, 17));
		labelGameMaster.setForeground(new Color(255, 255, 255));
		labelGameMaster.setBounds(169, 227, 216, 24);
		add(labelGameMaster);
		
		JLabel labelInfoGameMaster = new JLabel("New label");
		labelInfoGameMaster.setFont(new Font("Verdana", Font.BOLD, 17));
		labelInfoGameMaster.setForeground(new Color(255, 255, 255));
		labelInfoGameMaster.setBounds(485, 226, 101, 26);
		add(labelInfoGameMaster);
	}
}
