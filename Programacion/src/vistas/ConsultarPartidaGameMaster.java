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

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * La clase ConsultarPartidaGameMaster representa la interfaz gráfica para que un Game Master
 * consulte las partidas disponibles en el sistema.
 * 
 * Permite mostrar una tabla con información básica de las partidas, como nombre, fecha
 * de creación, duración, ambientación y estado de finalización. También ofrece un botón para
 * obtener información detallada de la partida seleccionada.
 * 
 * Esta clase extiende de JPanel y se utiliza en la interfaz del menú principal del Game Master.
 */ 
public class ConsultarPartidaGameMaster extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTable tablaPartida;
	private JLabel labelConsultarPartida;
	private JScrollPane scrollPane;
	private JPanel panelContenedor;
	private JLabel labelSlogan;
	private JButton botonInfoPartida;
	private ArrayList<Partida> partidasEnTabla;
	private ControlMenuPrincipalGM control;
	
	/**
     * Constructor de la clase ConsultarPartidaGameMaster.
     * 
     * @param control El controlador del menú principal del Game Master.
     */
	public ConsultarPartidaGameMaster(ControlMenuPrincipalGM control) {
		this.control = control;
		configuracionInicial();
		inicializarComponentes();
	}

	/**
     * Configuración inicial de la interfaz gráfica.
     */
	public void configuracionInicial() {
		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1300, 660);
	}

	/**
     * Carga las partidas recibidas en la tabla de la interfaz.
     * 
     * @param partidas La lista de partidas a mostrar.
     */
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

	/**
     * Inicializa todos los componentes de la interfaz gráfica.
     */
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
		//tablaPartida.setEnabled(false);
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

		// Botón
		botonInfoPartida = new JButton("Información de la partida");
		botonInfoPartida.setFont(new Font("Verdana", Font.BOLD, 25));
		botonInfoPartida.setBackground(new Color(135, 206, 235));
		botonInfoPartida.setForeground(new Color(37, 34, 81));
		botonInfoPartida.setBounds(413, 364, 453, 43);
		botonInfoPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				itemSeleccionado(evt);
			}
		});
		add(botonInfoPartida);
	}

	/**
     * Método invocado cuando se selecciona un elemento en la tabla de partidas.
     * 
     * @param e El evento de acción que desencadenó este método.
     */
	public void itemSeleccionado(ActionEvent e) {
		// Obtener la partida seleccionada
		Partida partidaSeleccionada = partidasEnTabla.get(tablaPartida.getSelectedRow());

		// Enviar la información de la partida al controlador
		control.cambiarInfoPartidaJugador(partidaSeleccionada);
	}

	/**
     * Devuelve la tabla de partidas.
     * 
     * @return La tabla de partidas.
     */
	public JTable getTablaPartida() {
		return tablaPartida;
	}

}
