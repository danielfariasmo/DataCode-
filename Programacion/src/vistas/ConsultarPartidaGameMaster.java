/**
 * 
 */
package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlMenuPrincipalGM;
import modelo.Partida;

public class ConsultarPartidaGameMaster extends JPanel {
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
	private ArrayList<Partida> partidasEnTabla;
	private ControlMenuPrincipalGM controlMenuPrincipal;

	public ConsultarPartidaGameMaster(ControlMenuPrincipalGM controlMenuPrincipal) {
		this.controlMenuPrincipal = controlMenuPrincipal;
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

		partidasEnTabla = partidas;

		DefaultTableModel modelo = (DefaultTableModel) tablaPartida.getModel();
		modelo.setNumRows(0);

		for (Partida partida : partidas) {
			ArrayList<String> registro = new ArrayList<String>();
			registro.add(partida.getNombre());
			registro.add(partida.getDiaHora());
			registro.add(partida.getDuracionSesion());
			registro.add(partida.getAmbientacion());
			registro.add(partida.getFinalizada());

			modelo.addRow(registro.toArray());
		}

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
				"Día y hora de Creación", "Duración Sesión", "Ambientación", "Finalizada (Si/No)", }));

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

		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		scrollPane = new JScrollPane(tablaPartida);
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
		botonInfoPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				itemSeleccionado(evt);
			}
		});
		add(botonInfoPartida);
	}

	public void itemSeleccionado(ActionEvent e) {

		// TODO
		Partida partidaSeleccionada = partidasEnTabla.get(tablaPartida.getSelectedRow());
		System.out.println(partidaSeleccionada);

		//controlMenuPrincipal.cambiarInfoPartidaJugador(partidaSeleccionada);
	}

	public JTable getTablaPartida() {
		return tablaPartida;
	}

}
