
	package vistas;

	import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

	public class PartidaActual extends JPanel {
		/**
		 * @author Daniel F.
		 * @author Ignacio M.
		 * @author Daniel G.
		 */
		private static final long serialVersionUID = 1L;
		private JTable tablaPartida;
		private JLabel labelTitulo;
		private JScrollPane scrollPane;
		private JPanel panelContenedor;
		private JLabel labelSlogan;

		public PartidaActual() {
			
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

		public void cargarPartida(ArrayList<String[]> partidasActuales) {

			DefaultTableModel modelo = (DefaultTableModel) tablaPartida.getModel();
			modelo.setNumRows(0);

			for (String[] partida : partidasActuales) {
				modelo.addRow(partida);
			}

		}

		public void inicializarComponentes() {

			// Titulo de Pagina
			labelTitulo = new JLabel("Partidas Actuales");
			labelTitulo.setFont(new Font("Verdana", Font.BOLD, 40));
			labelTitulo.setForeground(new Color(255, 255, 255));
			labelTitulo.setBounds(429, 124, 401, 43);
			add(labelTitulo);

			// Tabla Partida
			tablaPartida = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre Partida", "Finalizada (Si/No)",
					"Nombre Personaje", "Fuerza", "Destreza", "Constitución", "Inteligencia", "Sabiduria", "Carisma"}));

			tablaPartida.setForeground(new Color(255, 255, 255));
			tablaPartida.setBackground(new Color(37, 34, 81));
			tablaPartida.setBounds(10, -13, 841, 452);
			add(tablaPartida);

			// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
			tablaPartida.getColumnModel().getColumn(0).setPreferredWidth(430);
			tablaPartida.getColumnModel().getColumn(1).setPreferredWidth(350);
			tablaPartida.getColumnModel().getColumn(2).setPreferredWidth(200);
			tablaPartida.getColumnModel().getColumn(3).setPreferredWidth(200);
			tablaPartida.getColumnModel().getColumn(4).setPreferredWidth(380);
			tablaPartida.getColumnModel().getColumn(5).setPreferredWidth(430);
			tablaPartida.getColumnModel().getColumn(6).setPreferredWidth(430);
			tablaPartida.getColumnModel().getColumn(7).setPreferredWidth(430);
			tablaPartida.getColumnModel().getColumn(8).setPreferredWidth(430);

			// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
			// necesario
			scrollPane = new JScrollPane(tablaPartida);
			scrollPane.setBounds(53, 242, 1194, 153);
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
		}

		
	}



