package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InfoPartida extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableInfoPartida;

	public InfoPartida() {
		setForeground(new Color(255, 255, 255));
		
		// Barra Superior.
				setFont(new Font("Verdana", Font.BOLD, 20));
				setBackground(new Color(37, 34, 81));
				setLayout(null);

				// Titulo de Pagina
				JLabel labelInfoPartida = new JLabel("Información de la Partida");
				labelInfoPartida.setFont(new Font("Verdana", Font.BOLD, 40));
				labelInfoPartida.setForeground(new Color(255, 255, 255));
				labelInfoPartida.setBounds(177, 27, 624, 43);
				add(labelInfoPartida);
				
				//Titulo de la partida
				JLabel labelTitulo = new JLabel("-TÍTULO DE LA PARTIDA-");
				labelTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
				labelTitulo.setForeground(new Color(255, 255, 255));
				labelTitulo.setBounds(311, 81, 305, 60);
				add(labelTitulo);
				
				// Tabla Personajes
				JTable tablaPersonajes = new JTable(new DefaultTableModel(
						new Object[][] { {},
								{},
								{},
								{},
								{},
								{},
								{},
								{} },
						new String[] { "Id Personaje", "Nombre", "Raza", "Nivel", "Clase",
								}));
				tablaPersonajes.setFont(new Font("Verdana", Font.PLAIN, 15));
				tablaPersonajes.setForeground(new Color(255, 255, 255));
				tablaPersonajes.setBackground(new Color(37, 34, 81));
				tablaPersonajes.setBounds(228, 63, 392, 133);
				add(tablaPersonajes);

				// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
				tablaPersonajes.getColumnModel().getColumn(0).setPreferredWidth(30);
				tablaPersonajes.getColumnModel().getColumn(1).setPreferredWidth(150);
				tablaPersonajes.getColumnModel().getColumn(2).setPreferredWidth(60);
				tablaPersonajes.getColumnModel().getColumn(3).setPreferredWidth(35);
				tablaPersonajes.getColumnModel().getColumn(4).setPreferredWidth(130);
				

				// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
				// necesario
				JScrollPane scrollPane = new JScrollPane(tablaPersonajes);
				scrollPane.setBounds(10, 266, 952, 153);
				add(scrollPane);
				
				//Boton unirme a la partida
				JButton botonUnirmePartida = new JButton("Unirme a la partida");
				botonUnirmePartida.setFont(new Font("Verdana", Font.BOLD, 15));
				botonUnirmePartida.setBounds(380, 436, 208, 43);
				add(botonUnirmePartida);
				
				JLabel lblNewLabel = new JLabel("ID Partida");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setBounds(83, 139, 80, 14);
				add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Número de Personajes");
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_1.setBounds(83, 164, 112, 14);
				add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("New label");
				lblNewLabel_2.setForeground(new Color(255, 255, 255));
				lblNewLabel_2.setBounds(83, 189, 49, 14);
				add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("New label");
				lblNewLabel_3.setForeground(new Color(255, 255, 255));
				lblNewLabel_3.setBounds(83, 214, 49, 14);
				add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("1");
				lblNewLabel_4.setForeground(new Color(255, 255, 255));
				lblNewLabel_4.setBounds(205, 139, 139, 14);
				add(lblNewLabel_4);
				
				JLabel lblNewLabel_5 = new JLabel("New label");
				lblNewLabel_5.setForeground(new Color(255, 255, 255));
				lblNewLabel_5.setBounds(205, 164, 101, 14);
				add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("New label");
				lblNewLabel_6.setForeground(new Color(255, 255, 255));
				lblNewLabel_6.setBounds(205, 189, 101, 14);
				add(lblNewLabel_6);
				
				JLabel lblNewLabel_7 = new JLabel("New label");
				lblNewLabel_7.setForeground(new Color(255, 255, 255));
				lblNewLabel_7.setBounds(205, 214, 101, 14);
				add(lblNewLabel_7);

				

	}
	}



