/**
 * 
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Partida;

public class ConsultarPartida extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaPartida;
	private JLabel labelConsultarPartida;
	private JScrollPane scrollPane;
	private JPanel panelContenedor;
	private JLabel labelSlogan;
	private JButton botonInfoPartida;

	public ConsultarPartida() {

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

	public void cargarPartida(ArrayList<Partida> partidas) {

		String [][] datos = new String[partidas.size()][6];
		
		
		for (int i = 0; i < partidas.size(); i++) {
			Partida partida = partidas.get(i);

			datos [i][0] = partida.getNombre();
			datos [i][1] = partida.getDiaHora();
			datos [i][2] = partida.getDuracionSesion();
			datos [i][3] = partida.getNumeroSesion();
			datos [i][4] = partida.getAmbientacion();
			datos [i][5] = partida.getFinalizada();
		}

		tablaPartida = new JTable(new DefaultTableModel(datos, new String[] { "Nombre",
				"Día y hora de Creación", "Duración Sesión", "Nº Sesión", "Ambientación", "Finalizada (Si/No)", }));
		tablaPartida.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablaPartida.setForeground(new Color(255, 255, 255));
		tablaPartida.setBackground(new Color(37, 34, 81));
		tablaPartida.setBounds(10, -13, 841, 452);
		add(tablaPartida);

		// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
		tablaPartida.getColumnModel().getColumn(0).setPreferredWidth(450);
		tablaPartida.getColumnModel().getColumn(1).setPreferredWidth(450);
		tablaPartida.getColumnModel().getColumn(2).setPreferredWidth(450);
		tablaPartida.getColumnModel().getColumn(3).setPreferredWidth(10);
		tablaPartida.getColumnModel().getColumn(4).setPreferredWidth(130);
		tablaPartida.getColumnModel().getColumn(5).setPreferredWidth(10);

		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		scrollPane = new JScrollPane(tablaPartida);
		scrollPane.setBounds(162, 157, 952, 153);
		add(scrollPane);
	}

	public void inicializarComponentes() {

		// Titulo de Pagina
		labelConsultarPartida = new JLabel("Consultar Partida");
		labelConsultarPartida.setFont(new Font("Verdana", Font.BOLD, 40));
		labelConsultarPartida.setForeground(new Color(255, 255, 255));
		labelConsultarPartida.setBounds(432, 65, 401, 43);
		add(labelConsultarPartida);

		// Tabla Partida
		tablaPartida = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre",
				"Día y hora de Creación", "Duración Sesión", "Nº Sesión", "Ambientación", "Finalizada (Si/No)", }));

		// Contenedor para recuadro blanco
		panelContenedor = new JPanel();
		panelContenedor.setBackground(new Color(255, 255, 255));
		panelContenedor.setBounds(480, 454, 315, 70);
		add(panelContenedor);

		// Imagen de Slogan
		labelSlogan = new JLabel("");
		panelContenedor.add(labelSlogan);
		labelSlogan.setIcon(new ImageIcon("img/SloganDC1.png"));

		botonInfoPartida = new JButton("Información de la partida");
		botonInfoPartida.setFont(new Font("Verdana", Font.BOLD, 14));
		botonInfoPartida.setBackground(new Color(135, 206, 235));
		botonInfoPartida.setForeground(new Color(37, 34, 81));
		botonInfoPartida.setBounds(509, 363, 262, 43);
		add(botonInfoPartida);
	}
}
