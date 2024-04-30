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
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(486, 31, 305, 60);
		add(labelTitulo);

		// Tabla Personajes
		JTable tablaGameMaster = new JTable(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Id Game Master", "Alias", "Id Miembro" }));
		tablaGameMaster.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablaGameMaster.setForeground(new Color(255, 255, 255));
		tablaGameMaster.setBackground(new Color(37, 34, 81));
		tablaGameMaster.setBounds(10, 25, 921, 88);
		add(tablaGameMaster);

		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		JScrollPane scrollPane = new JScrollPane(tablaGameMaster);
		scrollPane.setBounds(168, 267, 940, 130);
		add(scrollPane);

		// Boton editar personajes
		JButton botonEditarPersonajes = new JButton("Subir Nivel");
		botonEditarPersonajes.setFont(new Font("Verdana", Font.BOLD, 15));
		botonEditarPersonajes.setBounds(521, 453, 208, 43);
		add(botonEditarPersonajes);
		
		//FUNCIONALIDAD DEL BOTÓN, CON LA CLASE ( ControlInfoGM )
		botonEditarPersonajes.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ControlInfoGM.mostrarMensajeSubirNivel();
		    }
		});
		
		// Etiqueta superior id partida
		JLabel labelIdPartida = new JLabel("ID Partida");
		labelIdPartida.setForeground(new Color(255, 255, 255));
		labelIdPartida.setBounds(206, 139, 80, 14);
		add(labelIdPartida);

		// Etiqueta superior numero de personajes
		JLabel labelNumeroPersonajes = new JLabel("Número de Game Master");
		labelNumeroPersonajes.setForeground(new Color(255, 255, 255));
		labelNumeroPersonajes.setBounds(206, 164, 132, 14);
		add(labelNumeroPersonajes);

		// Etiqueta superior
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(206, 189, 49, 14);
		add(lblNewLabel_2);

		// Etiqueta superior id partida
		JLabel lblNewLabel_4 = new JLabel("1");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(340, 139, 139, 14);
		add(lblNewLabel_4);

		// Etiqueta superior numero de personajes
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(343, 164, 101, 14);
		add(lblNewLabel_5);

		// Etiqueta superior
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(341, 189, 101, 14);
		add(lblNewLabel_6);
	}
	
}
