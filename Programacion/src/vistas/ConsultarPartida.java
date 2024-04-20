/**
 * 
 */
package vistas;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Font;
import java.awt.Color;

public class ConsultarPartida extends JPanel {
	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablePartida;

	public ConsultarPartida() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);

		// Titulo de Pagina
		JLabel labelConsultarPartida = new JLabel("Consultar Partida");
		labelConsultarPartida.setFont(new Font("Verdana", Font.BOLD, 40));
		labelConsultarPartida.setForeground(new Color(255, 255, 255));
		labelConsultarPartida.setBounds(309, 63, 401, 43);
		add(labelConsultarPartida);

		// Tabla Partida
		tablePartida = new JTable(new DefaultTableModel(
				new Object[][] { { 1, "La búsqueda del anillo", "2024-04-01", 1, "Tierra Media", "No", 4, 99 },
						{ 2, "Galaxia en guerra", "2024-04-02", 1, "Galaxia", "No", 3, 99 },
						{ 3, "Las sombras de la montaña", "2024-04-03", 1, "Montañas", "No", 5, 99 },
						{ 4, "La magia perdida", "2024-04-04", 1, "Bosque encantado", "No", 4, 99 },
						{ 5, "El rescate de la princesa", "2024-04-05", 1, "Castillo", "No", 3, 99 },
						{ 6, "Intriga en la corte", "2024-04-06", 1, "Palacio real", "No", 5, 99 },
						{ 7, "La ciudad maldita", "2024-04-07", 1, "Ciudad abandonada", "No", 4, 99 },
						{ 8, "El laberinto de la muerte", "2024-04-08", 1, "Laberinto", "No", 6, 99 } },
				new String[] { "Identificador", "Nombre", "Día", "Nº Sesión", "Ambientación", "Finalizada (Si/No)",
						"Duración", "Id Game Master" }));
		tablePartida.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablePartida.setForeground(new Color(255, 255, 255));
		tablePartida.setBackground(new Color(37, 34, 81));
		tablePartida.setBounds(-19, 26, 841, 452);
		add(tablePartida);

		// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
		tablePartida.getColumnModel().getColumn(0).setPreferredWidth(90);
		tablePartida.getColumnModel().getColumn(1).setPreferredWidth(260);
		tablePartida.getColumnModel().getColumn(2).setPreferredWidth(130);
		tablePartida.getColumnModel().getColumn(3).setPreferredWidth(70);
		tablePartida.getColumnModel().getColumn(4).setPreferredWidth(200);
		tablePartida.getColumnModel().getColumn(5).setPreferredWidth(150);
		tablePartida.getColumnModel().getColumn(6).setPreferredWidth(70);
		tablePartida.getColumnModel().getColumn(7).setPreferredWidth(150);

		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		JScrollPane scrollPane = new JScrollPane(tablePartida);
		scrollPane.setBounds(34, 150, 964, 153);
		add(scrollPane);

		// Contenedor para recuadro blanco
		JPanel panelContenedor = new JPanel();
		panelContenedor.setBackground(new Color(255, 255, 255));
		panelContenedor.setBounds(363, 456, 315, 70);
		add(panelContenedor);

		// Imagen de Slogan
		JLabel labelSlogan = new JLabel("");
		panelContenedor.add(labelSlogan);
		labelSlogan.setIcon(new ImageIcon("img/SloganDC1.png"));

	}

}
