package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlMenuPrincipalGM;
import modelo.Partida;
import modelo.Personaje;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Panel que muestra información detallada de una partida para el GameMaster.
 * Permite visualizar los personajes asociados a la partida y subir la
 * experiencia de un personaje. Extiende JPanel y utiliza ActionListener para
 * manejar eventos de acción en la interfaz.
 */
public class InfoPartidaGameMaster extends JPanel {
	// Serial version UID para la serialización
	private static final long serialVersionUID = 1L;
	// Componentes de la interfaz
	private JLabel labelTitulo;
	private JLabel labelIdentificadorPartida;
	private JLabel labelInfoMaxJugadores;
	private JLabel labelInfoGameMaster;
	private JTable tablaPersonajes;
	private Partida partidaClase;
	// Controlador asociado a esta vista
	private ControlMenuPrincipalGM controlGM;
	// Lista de personajes asociados a la partida
	private ArrayList<Personaje> personajes;

	/**
	 * Constructor que inicializa el panel de información de la partida.
	 *
	 * @param controlGM el controlador asociado
	 */
	public InfoPartidaGameMaster(ControlMenuPrincipalGM controlGM) {
		this.controlGM = controlGM;
		configuracionInicial();
		inicializarComponentes();
	}

	/**
	 * Configuración inicial del panel.
	 */
	public void configuracionInicial() {
		// Configuración de la apariencia del panel
		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1302, 660);
		setForeground(new Color(255, 255, 255));
	}

	/**
	 * Inicialización de los componentes de la interfaz.
	 */
	public void inicializarComponentes() {

		// Titulo de la partida
		labelTitulo = new JLabel("");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 40));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(350, 35, 1200, 60);
		add(labelTitulo);

		// Tabla Personajes
		tablaPersonajes = new JTable(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Raza", "Clase", "Nivel" }));
		// Tabla Personajes
		// Configuración de la tabla de personajes
		tablaPersonajes.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablaPersonajes.setForeground(new Color(255, 255, 255));
		tablaPersonajes.setBackground(new Color(37, 34, 81));
		tablaPersonajes.setBounds(-15, 25, 939, 77);
		// tablaPersonajes.setEnabled(false);
		add(tablaPersonajes);

		// Ajustar tamaño preferido de las columnas para que los nombres sean visibles
		tablaPersonajes.getColumnModel().getColumn(0).setPreferredWidth(150);
		tablaPersonajes.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaPersonajes.getColumnModel().getColumn(2).setPreferredWidth(60);
		tablaPersonajes.getColumnModel().getColumn(3).setPreferredWidth(35);

		// Agregar la tabla a un JScrollPane para permitir desplazamiento si es
		// necesario
		JScrollPane scrollPane = new JScrollPane(tablaPersonajes);
		scrollPane.setBounds(181, 219, 958, 153);
		add(scrollPane);

		// Boton unirme a la partida
		JButton botonSubirExperiencia = new JButton("Subir Experiencia");
		botonSubirExperiencia.setBackground(new Color(135, 206, 235));
		botonSubirExperiencia.setForeground(new Color(37, 34, 81));
		botonSubirExperiencia.setFont(new Font("Verdana", Font.BOLD, 25));
		botonSubirExperiencia.setBounds(497, 445, 321, 43);
		botonSubirExperiencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				itemSeleccionado(evt);
			}
		});
		add(botonSubirExperiencia);

		// Id Partida
		JLabel labelIdPartida = new JLabel("ID Partida");
		labelIdPartida.setFont(new Font("Verdana", Font.BOLD, 20));
		labelIdPartida.setForeground(new Color(255, 255, 255));
		labelIdPartida.setBounds(181, 124, 156, 22);
		add(labelIdPartida);

		labelIdentificadorPartida = new JLabel("");
		labelIdentificadorPartida.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelIdentificadorPartida.setForeground(new Color(255, 255, 255));
		labelIdentificadorPartida.setBounds(474, 124, 139, 22);
		add(labelIdentificadorPartida);

		// Maximo Jugadores
		JLabel labelMaximoJugadores = new JLabel("Tiempo de sesión");
		labelMaximoJugadores.setFont(new Font("Verdana", Font.BOLD, 20));
		labelMaximoJugadores.setForeground(new Color(255, 255, 255));
		labelMaximoJugadores.setBounds(181, 156, 244, 22);
		add(labelMaximoJugadores);

		labelInfoMaxJugadores = new JLabel("New label");
		labelInfoMaxJugadores.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelInfoMaxJugadores.setForeground(new Color(255, 255, 255));
		labelInfoMaxJugadores.setBounds(470, 155, 131, 25);
		add(labelInfoMaxJugadores);

		// Game Master
		JLabel labelGameMaster = new JLabel("GameMaster");
		labelGameMaster.setFont(new Font("Verdana", Font.BOLD, 20));
		labelGameMaster.setForeground(new Color(255, 255, 255));
		labelGameMaster.setBounds(181, 187, 156, 22);
		add(labelGameMaster);

		labelInfoGameMaster = new JLabel("New label");
		labelInfoGameMaster.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelInfoGameMaster.setForeground(new Color(255, 255, 255));
		labelInfoGameMaster.setBounds(471, 183, 130, 34);
		add(labelInfoGameMaster);

	}

	/**
	 * Carga la información de la partida y los personajes asociados.
	 *
	 * @param partida         la partida a mostrar
	 * @param todosPersonajes la lista de personajes asociados a la partida
	 */
	public void cargarInfoPartida(Partida partida, ArrayList<Personaje> todosPersonajes) {

		// Asigna la lista de personajes asociados a la partida
		this.personajes = todosPersonajes;
		// Asignación de los valores de la partida a los componentes de la interfaz
		labelTitulo.setText(partida.getNombre());
		labelIdentificadorPartida.setText(partida.getIdPartida());
		labelInfoMaxJugadores.setText(partida.getDuracionSesion() + " horas.");
		labelInfoGameMaster.setText(partida.getIdGameMaster());
		// Configura el modelo de la tabla de personajes con los personajes asociados
		DefaultTableModel modelo = (DefaultTableModel) tablaPersonajes.getModel();
		modelo.setNumRows(0);
		// Itera sobre la lista de personajes para agregarlos a la tabla
		for (Personaje personaje : todosPersonajes) {
			ArrayList<String> registro = new ArrayList<String>();
			registro.add(personaje.getNombre());
			registro.add(personaje.getRaza());
			registro.add(personaje.getClase());
			registro.add(String.valueOf(personaje.getNivelExperiencia()));

			modelo.addRow(registro.toArray());
		}
		// Guarda una referencia a la partida actual
		partidaClase = partida;

	}

	/**
	 * Maneja el evento de selección de un personaje en la tabla.
	 *
	 * @param e el evento de acción generado
	 */
	public void itemSeleccionado(ActionEvent e) {
		// Verifica si se ha seleccionado un personaje en la tabla
		if (tablaPersonajes.getSelectedRow() < 0) {
			// Muestra un mensaje de error si no se ha seleccionado ningún personaje
			JOptionPane.showMessageDialog(this, "Debes seleccionar un personaje.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			// Obtiene el personaje seleccionado
			Personaje personajeSeleccionada = personajes.get(tablaPersonajes.getSelectedRow());
			// Solicita al usuario que ingrese el nuevo nivel de experiencia
			String nivel = JOptionPane.showInputDialog("Modifica la experiencia:");
			// Verifica si se ha ingresado un valor válido para el nivel de experiencia
			if (nivel != null && !nivel.trim().isEmpty()) {
				try {
					int numero = Integer.parseInt(nivel.trim());
					// Verifica si el nuevo nivel es negativo
					if (numero < 0) {
						JOptionPane.showMessageDialog(this, "Experiencia no puede ser negativa.");
					} else {
						// Actualiza la experiencia del personaje en la base de datos
						controlGM.actualizarExperiencia(personajeSeleccionada.getIdPersonaje(), numero);
						// Muestra un mensaje de éxito
						JOptionPane.showMessageDialog(this, "Modificación exitosa.");
						// Actualiza la información de la partida en la interfaz
						controlGM.cambiarInfoPartidaJugador(partidaClase);
					}
				} catch (Exception e2) {
					// Muestra un mensaje de error si se ingresó un valor no válido
					JOptionPane.showMessageDialog(this, "No has rellenado los campos correctamente.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

}
