package vistas;

import javax.swing.*;

import modelo.ConexionBBDD;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelLogin;
	private JTextField textoUsuarioLogin;
	private JPasswordField claveContraseñaLogin;

	public Login() {
		setType(Type.POPUP);
		setFont(new Font("Verdana", Font.BOLD, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		getContentPane().setBackground(new Color(0, 0, 0));
		setBackground(Color.WHITE);
		setTitle("DataCode++");
		setSize(1050, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout());

		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(255, 255, 255));

		textoUsuarioLogin = new JTextField();
		textoUsuarioLogin.setFont(new Font("Verdana", Font.PLAIN, 18));

		claveContraseñaLogin = new JPasswordField();
		claveContraseñaLogin.setFont(new Font("Verdana", Font.PLAIN, 20));
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setBackground(new Color(135, 206, 235));
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 18));

		panelLogin.setLayout(null);
		textoUsuarioLogin.setBounds(550, 172, 457, 40);
		claveContraseñaLogin.setBounds(550, 263, 457, 40);
		btnLogin.setBounds(694, 344, 186, 40);

		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setForeground(new Color(255, 255, 255));
		labelUsuario.setBounds(550, 136, 105, 26);
		labelUsuario.setFont(new Font("Verdana", Font.BOLD, 20));
		panelLogin.add(labelUsuario);
		panelLogin.add(textoUsuarioLogin);

		JLabel lblContr = new JLabel("Contraseña:");
		lblContr.setForeground(new Color(255, 255, 255));
		lblContr.setFont(new Font("Verdana", Font.BOLD, 20));
		lblContr.setBounds(550, 233, 151, 20);
		panelLogin.add(lblContr);
		panelLogin.add(claveContraseñaLogin);
		panelLogin.add(btnLogin);

		setVisible(true);

		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = textoUsuarioLogin.getText();
				String contraseña = new String(claveContraseñaLogin.getPassword());

				// Variable para guardar la informacion de la consulta
				boolean loginExitoso = false;

				// Creamos consulta
				String selectLogin = "SELECT * FROM miembro WHERE nombre_usuario = '" + usuario + "' AND clave_usuario = " + contraseña;

				// Conecto la bbs
				ConexionBBDD conexionbbdd= new ConexionBBDD();
				Connection conn = conexionbbdd.conectar();
				//conn = ConexionBBDD.conectar();

				// Ejecuto la consulta
				try {
					Statement s = conn.createStatement();
					ResultSet resultado = s.executeQuery(selectLogin);
					loginExitoso = resultado.next();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				conexionbbdd.cerrar();

				if (loginExitoso) {
					// Crear un cuadro de diálogo personalizado
					JPanel panelDialogo = new JPanel();
					JLabel labelBienvenida = new JLabel("Bienvenido " + usuario + " ¿Cómo quieres iniciar sesión?");
					panelDialogo.add(labelBienvenida);

					// Opciones de inicio de sesión
					JPanel panelOpciones = new JPanel();
					JRadioButton jugador = new JRadioButton("Jugador");
					JRadioButton gameMaster = new JRadioButton("GameMaster");
					ButtonGroup grupoOpciones = new ButtonGroup();
					grupoOpciones.add(jugador);
					grupoOpciones.add(gameMaster);
					panelOpciones.add(jugador);
					panelOpciones.add(gameMaster);
					panelDialogo.add(panelOpciones);

					// Mostrar el cuadro de diálogo personalizado
					int opcion = JOptionPane.showConfirmDialog(Login.this, panelDialogo, "Inicio de Sesión",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

					// Acciones basadas en la selección del usuario
					if (opcion == JOptionPane.OK_OPTION) {
						if (jugador.isSelected()) {
							JOptionPane.showMessageDialog(Login.this, "Has seleccionado iniciar sesión como Jugador");
							// Aquí puedes realizar las acciones para el inicio de sesión como jugador
						} else if (gameMaster.isSelected()) {
							JOptionPane.showMessageDialog(Login.this,
									"Has seleccionado iniciar sesión como GameMaster");
							// Aquí puedes realizar las acciones para el inicio de sesión como GameMaster
						}
					}
				} else {
					JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos");
				}
			}
		});

		getContentPane().add(panelLogin, "login");

		JLabel labelLogin = new JLabel("Login");
		labelLogin.setForeground(new Color(255, 255, 255));
		labelLogin.setBounds(720, 40, 141, 78);
		labelLogin.setFont(new Font("Verdana", Font.BOLD, 40));
		panelLogin.add(labelLogin);
		panelLogin.setComponentZOrder(labelLogin, 0);

		JLabel labelFacebook = new JLabel(" ");
		labelFacebook.setIcon(new ImageIcon("img\\facebook3.png"));
		labelFacebook.setBounds(758, 452, 51, 40);
		panelLogin.add(labelFacebook);

		JLabel labelInstagram = new JLabel(" ");
		labelInstagram.setIcon(new ImageIcon("img\\Instagram.png"));
		labelInstagram.setBounds(676, 452, 51, 40);
		panelLogin.add(labelInstagram);

		JLabel labelPinterest = new JLabel(" ");
		labelPinterest.setIcon(new ImageIcon("img\\Pinterest.png"));
		labelPinterest.setBounds(840, 452, 51, 40);
		panelLogin.add(labelPinterest);

		JLabel labelAzul = new JLabel("");
		labelAzul.setOpaque(true);
		labelAzul.setForeground(new Color(37, 34, 81));
		labelAzul.setBackground(new Color(37, 34, 81));
		labelAzul.setBounds(524, 0, 512, 613);
		panelLogin.add(labelAzul);

		JPanel panelContenedor = new JPanel();
		panelContenedor.setBackground(new Color(255, 255, 255));
		panelContenedor.setBounds(10, 57, 504, 462);
		panelLogin.add(panelContenedor);

		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("img/DataCode.Logo.png"));
		panelContenedor.add(labelLogo);

	}

	public void hacerVisible() {
		setVisible(true);
	}

	// Main de prueba.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Login();
			}
		});
	}

}
