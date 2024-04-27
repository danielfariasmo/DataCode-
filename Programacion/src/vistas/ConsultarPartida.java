/**
 * 
 */
package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ConsultarPartida extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablePartida;
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

	public void inicializarComponentes() {

		// Titulo de Pagina
		labelConsultarPartida = new JLabel("Consultar Partida");
		labelConsultarPartida.setFont(new Font("Verdana", Font.BOLD, 40));
		labelConsultarPartida.setForeground(new Color(255, 255, 255));
		labelConsultarPartida.setBounds(432, 65, 401, 43);
		add(labelConsultarPartida);

		// Tabla Partida
		tablePartida = new JTable(new DefaultTableModel(new Object[][] {
				{ "La búsqueda del anillo", "01-04-2024 / 10:30h", "06-04-2024 / 16:00h", 1, "Tierra Media", "No" },
				{ "Galaxia en guerra", "02-04-2024 / 20:00h", "10-04-2024 / 23:50h", 1, "Galaxia", "No" },
				{ "Las sombras de la montaña", "03-02-2024 / 15:00h", "06-04-2024 / 22:00h", 1, "Montañas", "No" },
				{ "La magia perdida", "04-04-2024 / 10:30h", "11-04-2024 / 16:30h", 1, "Bosque encantado", "No" },
				{ "El rescate de la princesa", "05-04-2024 / 08:00h", "12-04-2024 / 12:00h", 1, "Castillo", "No" },
				{ "Intriga en la corte", "06-04-2024 / 14:00h", "15-04-2024 / 20:00h", 1, "Palacio real", "No" },
				{ "La ciudad maldita", "07-04-2024 / 12:30h", "12-04-2024 / 19:00h", 1, "Ciudad abandonada", "No" },
				{ "El laberinto de la muerte", "08-04-2024 / 15:00h", "09-04-2024 / 20:00h", 1, "Laberinto", "No" } },
				new String[] { "Nombre", "Día y hora de Creación", "Próxima Sesión", "Nº Sesión", "Ambientación",
						"Finalizada (Si/No)", }));

		tablePartida.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablePartida.setForeground(new Color(255, 255, 255));
		tablePartida.setBackground(new Color(37, 34, 81));
		tablePartida.setBounds(10, -13, 841, 452);
		add(tablePartida);

		// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
		tablePartida.getColumnModel().getColumn(0).setPreferredWidth(450);
		tablePartida.getColumnModel().getColumn(1).setPreferredWidth(450);
		tablePartida.getColumnModel().getColumn(2).setPreferredWidth(450);
		tablePartida.getColumnModel().getColumn(3).setPreferredWidth(10);
		tablePartida.getColumnModel().getColumn(4).setPreferredWidth(130);
		tablePartida.getColumnModel().getColumn(5).setPreferredWidth(10);

		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		scrollPane = new JScrollPane(tablePartida);
		scrollPane.setBounds(162, 157, 952, 153);
		add(scrollPane);

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



