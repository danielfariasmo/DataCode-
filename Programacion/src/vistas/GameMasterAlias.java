package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControlGameMasterAlias;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */

/**
 * Ventana para que un usuario pueda registrarse como GameMaster mediante un alias.
 * Permite al usuario ingresar un alias y registrarse como GameMaster.
 */
public class GameMasterAlias extends JFrame {

	private JTextField textoAlias;
	private JButton botonRegistrarse;
	private ControlGameMasterAlias controlGameMasterAlias;
	private static final long serialVersionUID = 1L;
	private JLabel textoCentral;
	private JLabel etiquetaLogo;
	private JLabel labelRegistrate;
	private JPanel panel;
	private JLabel labelAlias;
	private JLabel labelMensaje;

	 /**
     * Constructor de la clase GameMasterAlias.
     * 
     * @param controlGameMasterAlias Controlador para manejar las acciones relacionadas con el alias del GameMaster.
     */
	public GameMasterAlias(ControlGameMasterAlias controlGameMasterAlias) {
		this.controlGameMasterAlias = controlGameMasterAlias;
		configuracionInicial();
		inicializarComponentes();
	}

	/**
     * Configura las propiedades iniciales de la ventana.
     */
	public void configuracionInicial() {
		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setTitle("DataCode++ (Editar Partida)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		// Tamaño y posición de la ventana.
		setSize(1300, 660);
		setLocationRelativeTo(null);

		// Hacemos visible la ventana para que se ejecute.
		setVisible(true);
	}

	/**
     * Inicializa todos los componentes visuales de la ventana.
     */
	public void inicializarComponentes() {

		// Texto en el centro de la ventana
		textoCentral = new JLabel("Ups.. ¡No eres GameMaster!");
		textoCentral.setFont(new Font("Verdana", Font.BOLD, 40));
		textoCentral.setForeground(Color.WHITE);
		textoCentral.setBounds(644, 63, 642, 50);
		getContentPane().add(textoCentral);

		// Botón para registrarse
		botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setFont(new Font("Verdana", Font.BOLD, 25));
		botonRegistrarse.setForeground(new Color(37, 34, 81));
		botonRegistrarse.setBackground(new Color(135, 206, 235));
		botonRegistrarse.setBounds(848, 420, 223, 50);
		botonRegistrarse.addActionListener(controlGameMasterAlias);
		getContentPane().add(botonRegistrarse);

		// Label alias
		labelAlias = new JLabel("Escribe tu \"Alias\" :");
		labelAlias.setBounds(821, 230, 303, 50);
		getContentPane().add(labelAlias);
		labelAlias.setFont(new Font("Verdana", Font.PLAIN, 30));
		labelAlias.setForeground(Color.WHITE);

		// Label mostrar mensaje al usuario
		labelMensaje = new JLabel("");
		labelMensaje.setBounds(351, 350, 350, 50);
		getContentPane().add(labelMensaje);
		labelMensaje.setFont(new Font("Verdana", Font.BOLD, 25));
		labelMensaje.setForeground(Color.WHITE);

		// Texto para escribir el alias
		textoAlias = new JTextField();
		textoAlias.setBounds(755, 289, 392, 50);
		getContentPane().add(textoAlias);
		textoAlias.setFont(new Font("Verdana", Font.PLAIN, 20));
		textoAlias.setPreferredSize(new Dimension(200, 40));
		
		// Logo
		etiquetaLogo = new JLabel(" ");
		etiquetaLogo.setBounds(45, 12, 600, 612);
		etiquetaLogo.setIcon(new ImageIcon("img/DataCode.Logo.png"));
		getContentPane().add(etiquetaLogo);

		// Label Registrarse
		labelRegistrate = new JLabel("REGISTRATE");
		labelRegistrate.setForeground(new Color(255, 255, 255));
		labelRegistrate.setFont(new Font("Verdana", Font.BOLD, 30));
		labelRegistrate.setBounds(848, 137, 223, 43);
		getContentPane().add(labelRegistrate);

		// Panel extra
		panel = new JPanel();
		panel.setBackground(new Color(37, 34, 81));
		panel.setBounds(637, 0, 649, 624);
		getContentPane().add(panel);

	}

	// Getter.
	public String getTextoAlias() {
		return textoAlias.getText();
	}

	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}

}
