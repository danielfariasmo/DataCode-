package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Clase que representa la interfaz gráfica del texto del menú principal.
 */

public class TextoMenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel labelTexto;

	/**
	 * Constructor de la clase TextoMenuPrincipal.
	 */
	public TextoMenuPrincipal() {
		configuracionInicial();
		inicializarComponentes();
	}

	/**
	 * Configuración inicial del panel.
	 */
	public void configuracionInicial() {
		setBackground(new Color(37, 34, 82));
	}

	/**
	 * Inicializa los componentes del panel.
	 */
	public void inicializarComponentes() {

		// Texto de introducción
		labelTexto = new JLabel(
				"<html><div style='text-align: center; width: 350px;'>Adéntrate en el mundo del Club de Rol DataCode++ de la UEM, donde la imaginación cobra vida a través de épicas aventuras. Nuestra aplicación de gestión de personajes te permite crear y dirigir héroes en sus peligrosos viajes, mientras los Game Masters dan forma a mundos llenos de misterio y emoción. Con un simple clic, podrás explorar tierras desconocidas, forjar alianzas y enfrentarte a desafíos que pondrán a prueba tu valentía. ¿Estás listo para sumergirte en un universo donde solo la imaginación es el límite? Entonces únete a nosotros y deja que la aventura comience.</div></html>");
		labelTexto.setBackground(new Color(135, 206, 235));
		labelTexto.setForeground(new Color(255, 255, 255));
		labelTexto.setFont(new Font("Verdana", Font.PLAIN, 20));

		// Logo
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("img/DataCode.Logo.png"));

		// Configuración de GroupLayout
		GroupLayout groupLayout = new GroupLayout(this);
		// Define el grupo horizontal del GroupLayout.
		groupLayout.setHorizontalGroup(
				// Crea un grupo paralelo que alinea sus componentes de manera conjunta en el
				// sentido horizontal.
				groupLayout.createParallelGroup(Alignment.LEADING)
						// Define un grupo secuencial para disponer los componentes en secuencia
						// horizontal.
						.addGroup(groupLayout.createSequentialGroup().addGap(68)
								.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
								.addGap(120)
								.addComponent(labelTexto, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE)
								.addGap(104)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING,
										groupLayout.createSequentialGroup().addGap(45).addComponent(labelTexto,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										groupLayout.createSequentialGroup().addGap(19).addComponent(labelLogo,
												GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(106, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
