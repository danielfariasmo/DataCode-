package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlMenuPrincipalUsuario;
import modelo.Partida;
import modelo.Personaje;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Panel para mostrar la información de una partida para un jugador.
 */
public class InfoPartidaJugador extends JPanel {
	// Declaración de variables de instancia
	private static final long serialVersionUID = 1L;
	// ComboBox para seleccionar un personaje
	private JComboBox<Personaje> boxPersonaje;
	// Etiqueta para mostrar el título de la partida
	private JLabel labelTitulo;
	// Etiqueta para mostrar el identificador de la partida
	private JLabel labelIdentificadorPartida;
	// Etiqueta para mostrar la duración máxima de la partida
	private JLabel labelInfoMaxJugadores;
	// Etiqueta para mostrar el GameMaster de la partida
	private JLabel labelInfoGameMaster;
	// Tabla para mostrar los personajes disponibles en la partida
	private JTable tablaPersonajes;
	// Referencia a la partida actual
	private Partida partidaClase;
	// Controlador asociado a esta vista
	private ControlMenuPrincipalUsuario control;

	/**
	 * Constructor de la clase.
	 * 
	 * @param control El controlador asociado a esta vista.
	 */
	public InfoPartidaJugador(ControlMenuPrincipalUsuario control) {
		this.control = control;
		configuracionInicial();
		inicializarComponentes();
	}

	/**
	 * Configuración inicial del panel.
	 */
	public void configuracionInicial() {

		// Establecer el estilo de la barra superior
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(37, 34, 81));
		setLayout(null);
		setSize(1302, 660);
		setForeground(new Color(255, 255, 255));
	}

	/**
	 * Inicializa los componentes de la interfaz.
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
		tablaPersonajes.setFont(new Font("Verdana", Font.PLAIN, 15));
		tablaPersonajes.setForeground(new Color(255, 255, 255));
		tablaPersonajes.setBackground(new Color(37, 34, 81));
		tablaPersonajes.setBounds(-15, 25, 939, 77);
		tablaPersonajes.setEnabled(false);
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
		JButton botonUnirmePartida = new JButton("Unirme a la partida");
		botonUnirmePartida.setBackground(new Color(135, 206, 235));
		botonUnirmePartida.setForeground(new Color(37, 34, 81));
		botonUnirmePartida.setFont(new Font("Verdana", Font.BOLD, 25));
		botonUnirmePartida.setBounds(742, 457, 321, 43);
		botonUnirmePartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				itemSeleccionado(evt);
			}
		});
		add(botonUnirmePartida);

		// Id Partida
		JLabel labelIdPartida = new JLabel("ID Partida");
		labelIdPartida.setFont(new Font("Verdana", Font.BOLD, 20));
		labelIdPartida.setForeground(new Color(255, 255, 255));
		labelIdPartida.setBounds(181, 124, 156, 22);
		add(labelIdPartida);

		labelIdentificadorPartida = new JLabel("");
		labelIdentificadorPartida.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelIdentificadorPartida.setForeground(new Color(255, 255, 255));
		labelIdentificadorPartida.setBounds(472, 124, 139, 22);
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
		labelInfoMaxJugadores.setBounds(472, 155, 131, 25);
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

		boxPersonaje = new JComboBox<Personaje>();
		boxPersonaje.setFont(new Font("Verdana", Font.PLAIN, 25));
		boxPersonaje.setBounds(181, 436, 444, 84);
		add(boxPersonaje);
		// Label de TituloPersonaje
		JLabel tituloPersonaje = new JLabel("Personajes");
		tituloPersonaje.setFont(new Font("Verdana", Font.BOLD, 25));
		tituloPersonaje.setForeground(new Color(255, 255, 255));
		tituloPersonaje.setBounds(307, 382, 197, 44);
		add(tituloPersonaje);
	}

	/**
	 * Obtiene el ComboBox de personajes.
	 * 
	 * @return El ComboBox de personajes.
	 */
	public JComboBox<Personaje> getBoxPersonaje() {
		return boxPersonaje;
	}

	/**
	 * Carga la información de la partida en la interfaz.
	 * 
	 * @param partida         La partida cuya información se cargará.
	 * @param misPersonajes   Lista de personajes del jugador en la partida.
	 * @param todosPersonajes Lista de todos los personajes disponibles en la
	 *                        partida.
	 */
	public void cargarInfoPartida(Partida partida, ArrayList<Personaje> misPersonajes,
			ArrayList<Personaje> todosPersonajes) {
		// Asignación de los valores de la partida a los componentes de la interfaz
		labelTitulo.setText(partida.getNombre());
		labelIdentificadorPartida.setText(partida.getIdPartida());
		labelInfoMaxJugadores.setText(partida.getDuracionSesion() + " horas.");
		labelInfoGameMaster.setText(partida.getIdGameMaster());
		// Limpiar la tabla de personajes
		DefaultTableModel modelo = (DefaultTableModel) tablaPersonajes.getModel();
		modelo.setNumRows(0);
		// Agregar los personajes a la tabla
		for (Personaje personaje : todosPersonajes) {
			ArrayList<String> registro = new ArrayList<String>();
			registro.add(personaje.getNombre());
			registro.add(personaje.getRaza());
			registro.add(personaje.getClase());
			registro.add(String.valueOf(personaje.getNivelExperiencia()));

			modelo.addRow(registro.toArray());
		}
		// Actualizar el ComboBox de personajes con los personajes del jugador
		DefaultComboBoxModel<Personaje> dcbm = new DefaultComboBoxModel<Personaje>();
		dcbm.addAll(misPersonajes);
		boxPersonaje.setModel(dcbm);
		// Guarda una referencia a la partida actual
		partidaClase = partida;

	}

	/**
	 * Maneja la acción de selección de un elemento en el ComboBox de personajes.
	 * 
	 * @param e El evento de acción.
	 */
	private void itemSeleccionado(ActionEvent e) {
		// Obtiene el personaje seleccionado en el ComboBox
		Personaje personaje = (Personaje) boxPersonaje.getSelectedItem();
		// Verifica si se ha seleccionado un personaje
		if (personaje != null) {
			// Solicita al usuario que ingrese una descripción para el personaje
			String descripcion = JOptionPane.showInputDialog("Indica la descripción de tu personaje: ");
			// Verifica si se ha ingresado una descripción válida
			if (descripcion != null) {
				if (!descripcion.trim().isEmpty()) {
					// Muestra un mensaje de confirmación de unión a la partida y llama al método
					// para agregar la partida
					System.out.println(descripcion);
					JOptionPane.showMessageDialog(this, "Te has unido a la partida: " + partidaClase.getNombre());
					control.agregarPartida(partidaClase, personaje, descripcion);

				} else {
					JOptionPane.showMessageDialog(this, "No has rellenado los campos correctamente.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		} else {
			// Muestra un mensaje de error si no se ha seleccionado ningún personaje
			JOptionPane.showMessageDialog(this, "Debes seleccionar un personaje.", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
