package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * 
 */
public class GameMaster extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public GameMaster() {

		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setTitle("DataCode++ (Editar Partida)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(37, 34, 81));
		getContentPane().setLayout(null); // Layout null para posicionar elementos manualmente

		// Texto en el centro de la ventana
		JLabel textoCentral = new JLabel("¡No estás registrado como GameMaster!");
		textoCentral.setFont(new Font("Verdana", Font.BOLD, 36));
		textoCentral.setForeground(Color.WHITE);
		textoCentral.setBounds(115, 44, 921, 50);
		getContentPane().add(textoCentral);

		// Panel para el texto "Escribe tu alias"
		JPanel panelAlias = new JPanel();
		panelAlias.setBackground(new Color(37, 34, 81));
		panelAlias.setLayout(new BorderLayout());
		panelAlias.setBounds(628, 336, 350, 50);
		getContentPane().add(panelAlias);

		// Botón para registrarse
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setFont(new Font("Verdana", Font.BOLD, 20));
		botonRegistrarse.setForeground(new Color(37, 34, 81));
		botonRegistrarse.setBackground(new Color(135, 206, 235));
		botonRegistrarse.setBounds(697, 424, 216, 50);
		getContentPane().add(botonRegistrarse);
		
		//Label alias
		JLabel labelAlias = new JLabel("Escribe tu \"Alias\" :");
		labelAlias.setBounds(649, 202, 303, 50);
		getContentPane().add(labelAlias);
		labelAlias.setFont(new Font("Verdana", Font.BOLD, 25));
		labelAlias.setForeground(Color.WHITE);
		
		// Label mostrar mensaje al usuario
		JLabel labelMensaje = new JLabel("");
		labelMensaje.setBounds(351, 350, 350, 50);
		getContentPane().add(labelMensaje);
		labelMensaje.setFont(new Font("Verdana", Font.BOLD, 25));
		labelMensaje.setForeground(Color.WHITE);
		
		//Texto para escribir el alias
		JTextField textoAlias = new JTextField();
		textoAlias.setBounds(628, 286, 350, 50);
		getContentPane().add(textoAlias);
		textoAlias.setFont(new Font("Verdana", Font.PLAIN, 20));
		textoAlias.setPreferredSize(new Dimension(200, 40));
		
		JLabel etiquetaLogo = new JLabel(" ");
		etiquetaLogo.setBounds(60, 126, 496, 464);
		etiquetaLogo.setIcon(new ImageIcon("img/DataCode.Logo.png"));
		getContentPane().add(etiquetaLogo);

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
