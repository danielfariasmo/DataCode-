/**
 * 
 */
package vistas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Miembro;

/**
 * @author Daniel F.
 * @author Ignacio M.
 * @author Daniel G.
 */
/**
 * Clase que representa la interfaz gráfica para mostrar los miembros de un
 * club.
 */
public class MiembroClub extends JPanel {

	JComboBox<Miembro> mostrarMiembros;

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase MiembroClub.
	 */
	public MiembroClub() {
		configuracionIncial();
		inicializarComponentes();
	}

	/**
	 * Configuración inicial del panel.
	 */
	public void configuracionIncial() {
		// Barra Superior.
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
	}

	/**
	 * Inserta una lista de miembros en el JComboBox.
	 * 
	 * @param array Lista de miembros a insertar.
	 */
	public void insertarMiembros(ArrayList<Miembro> array) {
		DefaultComboBoxModel<Miembro> dcbm = new DefaultComboBoxModel<Miembro>();
		dcbm.addAll(array);
		mostrarMiembros.setModel(dcbm);

	}

	/**
	 * Inicializa los componentes del panel.
	 */
	public void inicializarComponentes() {

		// ComboBox para mostrar miembros
		mostrarMiembros = new JComboBox<Miembro>();
		mostrarMiembros.setToolTipText("");
		mostrarMiembros.setBackground(new Color(255, 255, 255));
		mostrarMiembros.setForeground(new Color(37, 34, 81));
		mostrarMiembros.setFont(new Font("Verdana", Font.PLAIN, 19));
		mostrarMiembros.setBounds(715, 189, 486, 106);
		add(mostrarMiembros);

		// Panel para contener el eslogan
		JPanel contenedorSlogan = new JPanel();
		contenedorSlogan.setBounds(805, 368, 328, 80);
		add(contenedorSlogan);

		// Etiqueta para el eslogan
		JLabel labelSlogan = new JLabel("");
		contenedorSlogan.add(labelSlogan);
		labelSlogan.setIcon(new ImageIcon("img/SloganDC1.png"));

		// Etiqueta para el título
		JLabel labelTitulo = new JLabel("Miembros");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 40));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(858, 79, 275, 89);
		add(labelTitulo);

		// Panel para información adicional
		JPanel contenedorInformacion = new JPanel();
		contenedorInformacion.setBackground(new Color(37, 34, 81));
		contenedorInformacion.setBounds(629, 0, 671, 600);
		add(contenedorInformacion);
		setLayout(null);
		contenedorInformacion.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// Etiqueta para el título de información adicional
		JLabel labelTituloInformacion = new JLabel("Jugadores de Rol Famosos");
		labelTituloInformacion.setForeground(new Color(37, 34, 81));
		labelTituloInformacion.setFont(new Font("Verdana", Font.BOLD, 30));
		labelTituloInformacion.setBounds(50, 10, 479, 59);
		add(labelTituloInformacion);

		// Información de famosos jugadores de rol

		// VIN DIESEL
		JLabel labelVinDiesel = new JLabel("Vin Diesel");
		labelVinDiesel.setForeground(new Color(37, 34, 81));
		labelVinDiesel.setFont(new Font("Verdana", Font.BOLD, 20));
		labelVinDiesel.setBounds(75, 263, 114, 26);
		add(labelVinDiesel);

		JLabel labelImagenVin = new JLabel("");
		labelImagenVin.setIcon(new ImageIcon("img/Vin_Diesel.png"));
		labelImagenVin.setBounds(50, 93, 173, 160);
		add(labelImagenVin);

		// DAWYNE JONHSON
		JLabel labelLaRoca = new JLabel("Dawyne Johnse");
		labelLaRoca.setForeground(new Color(37, 34, 81));
		labelLaRoca.setFont(new Font("Verdana", Font.BOLD, 20));
		labelLaRoca.setBounds(346, 258, 183, 37);
		add(labelLaRoca);

		JLabel labelImagenDawyne = new JLabel("");
		labelImagenDawyne.setIcon(new ImageIcon("img/the_rock.png"));
		labelImagenDawyne.setBounds(336, 79, 173, 160);
		add(labelImagenDawyne);

		// MIKE MYERS
		JLabel labelMikeMyers = new JLabel("Mike Myers");
		labelMikeMyers.setForeground(new Color(37, 34, 81));
		labelMikeMyers.setFont(new Font("Verdana", Font.BOLD, 20));
		labelMikeMyers.setBounds(75, 487, 128, 37);
		add(labelMikeMyers);

		JLabel labelImagenMike = new JLabel("");
		labelImagenMike.setIcon(new ImageIcon("img/mike_myers.png"));
		labelImagenMike.setBounds(50, 317, 173, 160);
		add(labelImagenMike);

		// TIM DUCAN
		JLabel labelTimDuncan = new JLabel("Tim Duncan");
		labelTimDuncan.setForeground(new Color(37, 34, 81));
		labelTimDuncan.setFont(new Font("Verdana", Font.BOLD, 20));
		labelTimDuncan.setBounds(370, 486, 139, 37);
		add(labelTimDuncan);

		JLabel labelImagenTim = new JLabel("");
		labelImagenTim.setIcon(new ImageIcon("img/tim_duncan.png"));
		labelImagenTim.setBounds(336, 317, 173, 160);
		add(labelImagenTim);
	}

}
