package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
public class GameMaster extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public GameMaster() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setTitle("DataCode++ (Editar Partida)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null); // Layout null para posicionar elementos manualmente

		// Texto en el centro de la ventana
		JLabel textoCentral = new JLabel("Ups.. !No eres GameMaster!");
		textoCentral.setFont(new Font("Verdana", Font.BOLD, 30));
		textoCentral.setForeground(Color.WHITE);
		textoCentral.setBounds(539, 77, 487, 50);
		getContentPane().add(textoCentral);

		// Panel para el texto "Escribe tu alias"
		JPanel panelAlias = new JPanel();
		panelAlias.setBackground(new Color(37, 34, 81));
		panelAlias.setLayout(new BorderLayout());
		panelAlias.setBounds(597, 337, 350, 50);
		getContentPane().add(panelAlias);

		// Botón para registrarse
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setFont(new Font("Verdana", Font.BOLD, 20));
		botonRegistrarse.setForeground(new Color(37, 34, 81));
		botonRegistrarse.setBackground(new Color(135, 206, 235));
		botonRegistrarse.setBounds(670, 426, 216, 50);
		getContentPane().add(botonRegistrarse);
		
		//Label alias
		JLabel labelAlias = new JLabel("Escribe tu \"Alias\" :");
		labelAlias.setBounds(624, 230, 303, 50);
		getContentPane().add(labelAlias);
		labelAlias.setFont(new Font("Verdana", Font.PLAIN, 30));
		labelAlias.setForeground(Color.WHITE);
		
		// Label mostrar mensaje al usuario
		JLabel labelMensaje = new JLabel("");
		labelMensaje.setBounds(351, 350, 350, 50);
		getContentPane().add(labelMensaje);
		labelMensaje.setFont(new Font("Verdana", Font.BOLD, 25));
		labelMensaje.setForeground(Color.WHITE);
		
		//Texto para escribir el alias
		JTextField textoAlias = new JTextField();
		textoAlias.setBounds(597, 290, 350, 50);
		getContentPane().add(textoAlias);
		textoAlias.setFont(new Font("Verdana", Font.PLAIN, 20));
		textoAlias.setPreferredSize(new Dimension(200, 40));
		
		JLabel etiquetaLogo = new JLabel(" ");
		etiquetaLogo.setBounds(10, 0, 519, 612);
		etiquetaLogo.setIcon(new ImageIcon("img/DataCode.Logo.png"));
		getContentPane().add(etiquetaLogo);
		
		JLabel labelRegistrate = new JLabel("REGISTRATE");
		labelRegistrate.setForeground(new Color(255, 255, 255));
		labelRegistrate.setFont(new Font("Verdana", Font.BOLD, 30));
		labelRegistrate.setBounds(670, 137, 223, 43);
		getContentPane().add(labelRegistrate);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(37, 34, 81));
		panel.setBounds(522, 0, 514, 613);
		getContentPane().add(panel);

		// Crear un cuadro de diálogo personalizado
		botonRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String alias = textoAlias.getText();
				//Mensaje del cuadro de dialogo , con la información del alias introducido por el usuario
				JOptionPane.showMessageDialog(GameMaster.this, "Has sido registrado correctamente como GameMaster con el alias: " + alias);
			}
		});

		// Tamaño y posición de la ventana.
		setSize(1050, 650);
		setLocationRelativeTo(null);

		// Hacemos visible la ventana para que se ejecute.
		setVisible(true);
	}

	// Main de prueba.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameMaster();
			}
		});
	}
}
