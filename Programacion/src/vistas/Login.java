package vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.ControlGameMasterAlias;
import control.ControlLogin;
import control.ControlMenuPrincipalGM;
import control.ControlMenuPrincipalUsuario;
import modelo.Miembro;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	public static boolean rolGameMaster;
	private JPanel panelLogin;
	private JTextField textoUsuarioLogin;
	private JPasswordField claveContrasenhaLogin;
	private JButton botonLogin;
	private MenuPrincipalUsuario menuPrincipalUsuario;
	private MenuPrincipalGameMaster menuPrincipalGameMaster;

	public Login() {
		configuracionInicial();
		inicializarComponentes();
		System.out.println("Componentes creados");
	}

	public void configuracionInicial() {
		setType(Type.POPUP);
		setFont(new Font("Verdana", Font.BOLD, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		getContentPane().setBackground(new Color(0, 0, 0));
		setBackground(Color.WHITE);
		setTitle("DataCode++");
		setSize(1300, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout());
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void inicializarComponentes() {
		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(255, 255, 255));

		textoUsuarioLogin = new JTextField();
		textoUsuarioLogin.setFont(new Font("Verdana", Font.PLAIN, 18));
		textoUsuarioLogin.setBounds(701, 175, 499, 40);

		claveContrasenhaLogin = new JPasswordField();
		claveContrasenhaLogin.setFont(new Font("Verdana", Font.PLAIN, 20));
		claveContrasenhaLogin.setBounds(701, 313, 499, 40);

		botonLogin = new JButton("Entrar");
		botonLogin.setBackground(new Color(135, 206, 235));
		botonLogin.setFont(new Font("Verdana", Font.BOLD, 25));
		panelLogin.setLayout(null);
		botonLogin.setBounds(852, 382, 186, 40);

		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setForeground(new Color(255, 255, 255));
		labelUsuario.setBounds(701, 126, 165, 26);
		labelUsuario.setFont(new Font("Verdana", Font.BOLD, 25));
		panelLogin.add(labelUsuario);
		panelLogin.add(textoUsuarioLogin);

		JLabel lblContr = new JLabel("Contraseña:");
		lblContr.setForeground(new Color(255, 255, 255));
		lblContr.setFont(new Font("Verdana", Font.BOLD, 25));
		lblContr.setBounds(701, 264, 202, 32);
		panelLogin.add(lblContr);
		panelLogin.add(claveContrasenhaLogin);
		panelLogin.add(botonLogin);
		botonLogin.addActionListener(new ControlLogin(this));
		getContentPane().add(panelLogin, "login");

		JLabel labelLogin = new JLabel("Login");
		labelLogin.setForeground(new Color(255, 255, 255));
		labelLogin.setBounds(882, 26, 141, 78);
		labelLogin.setFont(new Font("Verdana", Font.BOLD, 40));
		panelLogin.add(labelLogin);
		panelLogin.setComponentZOrder(labelLogin, 0);

		JLabel labelFacebook = new JLabel(" ");
		labelFacebook.setIcon(new ImageIcon("img\\facebook3.png"));
		labelFacebook.setBounds(801, 468, 51, 40);
		panelLogin.add(labelFacebook);

		JLabel labelInstagram = new JLabel(" ");
		labelInstagram.setIcon(new ImageIcon("img\\Instagram.png"));
		labelInstagram.setBounds(927, 468, 51, 40);
		panelLogin.add(labelInstagram);

		JLabel labelPinterest = new JLabel(" ");
		labelPinterest.setIcon(new ImageIcon("img\\Pinterest.png"));
		labelPinterest.setBounds(1033, 468, 51, 40);
		panelLogin.add(labelPinterest);

		JLabel labelAzul = new JLabel("");
		labelAzul.setOpaque(true);
		labelAzul.setForeground(new Color(37, 34, 81));
		labelAzul.setBackground(new Color(37, 34, 81));
		labelAzul.setBounds(620, 0, 666, 623);
		panelLogin.add(labelAzul);

		JPanel panelContenedor = new JPanel();
		panelContenedor.setBackground(new Color(255, 255, 255));
		panelContenedor.setBounds(10, 57, 600, 506);
		panelLogin.add(panelContenedor);

		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("img/DataCode.Logo.png"));
		panelContenedor.add(labelLogo);
	}

	private MenuPrincipalUsuario inicializarMenuPrincipalUsuario(Miembro miembro) {
		MenuPrincipalUsuario menuPrincipalUsuario = new MenuPrincipalUsuario(miembro);
		NuevoPersonaje nuevoPersonaje = new NuevoPersonaje();
		MiembroClub miembroClub = new MiembroClub();
		ModificarPersonaje modificarPersonaje = new ModificarPersonaje();
		MostrarPersonaje mostrarPersonaje = new MostrarPersonaje();
		TextoMenuPrincipal textoMenuPrincipal = new TextoMenuPrincipal();
		PartidaActual partidaActual = new PartidaActual();

		ControlMenuPrincipalUsuario listener = new ControlMenuPrincipalUsuario(menuPrincipalUsuario, nuevoPersonaje,
				miembroClub, modificarPersonaje, mostrarPersonaje, textoMenuPrincipal, partidaActual, miembro);

		menuPrincipalUsuario.setListener(listener);

		return menuPrincipalUsuario;
	}

	private MenuPrincipalGameMaster inicializarMenuPrincipalGameMaster(Miembro miembro) {
		MenuPrincipalGameMaster menuPrincipalGameMaster = new MenuPrincipalGameMaster(miembro);
		EditarPartida editarPartida = new EditarPartida();
		CrearPartida crearPartida = new CrearPartida();
		MiembroClub miembroClub = new MiembroClub();
		TextoMenuPrincipal textoMenuPrincipal = new TextoMenuPrincipal();

		ControlMenuPrincipalGM listener = new ControlMenuPrincipalGM(menuPrincipalGameMaster,
				crearPartida, editarPartida, miembroClub, textoMenuPrincipal);

		menuPrincipalGameMaster.setListener(listener);

		return menuPrincipalGameMaster;
	}

	// Getter para el texto del usuario
	public String getTextoUsuarioLogin() {
		return textoUsuarioLogin.getText();
	}

	// Getter para la contraseña
	public String getClaveContrasenhaLogin() {
		return new String(claveContrasenhaLogin.getPassword());
	}

	public void mostrarDialogoExito(Miembro miembro) {
		System.out.println("EXITO LOGIN");
		JPanel panelDialogo = new JPanel();
		JLabel labelBienvenida = new JLabel(
				"Bienvenido " + miembro.getNombre_apelidos() + " ¿Cómo quieres iniciar sesión?");
		panelDialogo.add(labelBienvenida);

		JPanel panelOpciones = new JPanel();
		JRadioButton jugador = new JRadioButton("Jugador");
		JRadioButton gameMaster = new JRadioButton("GameMaster");
		ButtonGroup grupoOpciones = new ButtonGroup();
		grupoOpciones.add(jugador);
		grupoOpciones.add(gameMaster);
		panelOpciones.add(jugador);
		panelOpciones.add(gameMaster);
		panelDialogo.add(panelOpciones);

		int opcion = JOptionPane.showConfirmDialog(this, panelDialogo, "Inicio de Sesión", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (opcion == JOptionPane.OK_OPTION) {
			if (jugador.isSelected()) {
				rolGameMaster = false;
				JOptionPane.showMessageDialog(this, "Has seleccionado iniciar sesión como Jugador");

				mostrarMenuPrincipalUsuario(miembro);

			} else if (gameMaster.isSelected() && miembro.esMaster()) {
				rolGameMaster = true;
				JOptionPane.showMessageDialog(this, "Has seleccionado iniciar sesión como GameMaster");

				mostrarMenuPrincipalGameMaster(miembro);

			} else if (gameMaster.isSelected() && !miembro.esMaster()) {
				setVisible(false);
				new ControlGameMasterAlias(miembro);
			}
		}
	}

	public void mostrarMenuPrincipalUsuario(Miembro miembro) {
		this.setVisible(false);
		menuPrincipalUsuario = inicializarMenuPrincipalUsuario(miembro);
		menuPrincipalUsuario.setVisible(true);
	}

	public void mostrarMenuPrincipalGameMaster(Miembro miembro) {
		this.setVisible(false);
		menuPrincipalGameMaster = inicializarMenuPrincipalGameMaster(miembro);
		menuPrincipalGameMaster.setVisible(true);
	}

	public void mostrarDialogoError() {
		JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
	}

	public static boolean getRolGameMaster() {
		return rolGameMaster;
	}
}