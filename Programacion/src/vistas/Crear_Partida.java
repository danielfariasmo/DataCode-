package vistas;

import javax.swing.*;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

/**
 * 
 */
public class Crear_Partida extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Crear_Partida() {

        // Barra Superior.
        setFont(new Font("Verdana", Font.BOLD, 20));
        setTitle("DataCode++ (Crear Partida)");
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/DC.Icon2.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(37, 34, 81));
        getContentPane().setLayout(null); // Layout null para posicionar elementos manualmente

        /*
         * Menu.
         */
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setFont(new Font("Verdana", Font.PLAIN, 30));
        barraMenu.setBackground(new Color(135, 206, 235));

        // Opcion Personaje.
        JMenu personajes = new JMenu("Personajes");
        personajes.setForeground(new Color(37, 34, 81));
        personajes.setFont(new Font("Verdana", Font.BOLD, 25));
        JMenuItem nuevoPersonaje = new JMenuItem("Nuevo Personaje");
        nuevoPersonaje.setForeground(new Color(37, 34, 81));
        nuevoPersonaje.setFont(new Font("Verdana", Font.PLAIN, 25));
        JMenuItem mostrarPersonajes = new JMenuItem("Mostrar Personajes");
        mostrarPersonajes.setForeground(new Color(37, 34, 81));
        mostrarPersonajes.setFont(new Font("Verdana", Font.PLAIN, 25));
        JMenuItem modificarPersonaje = new JMenuItem("Modificar Personaje");
        modificarPersonaje.setForeground(new Color(37, 34, 81));
        modificarPersonaje.setFont(new Font("Verdana", Font.PLAIN, 25));
        personajes.add(nuevoPersonaje);
        personajes.add(new JSeparator());
        personajes.add(mostrarPersonajes);
        personajes.add(new JSeparator());
        personajes.add(modificarPersonaje);

        // Opcion Partidas.
        JMenu partidas = new JMenu("Partidas");
        partidas.setForeground(new Color(37, 34, 81));
        partidas.setFont(new Font("Verdana", Font.BOLD, 25));
        JMenuItem crearPartida = new JMenuItem("Crear Partida");
        crearPartida.setForeground(new Color(37, 34, 81));
        crearPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
        JMenuItem consultarPartida = new JMenuItem("Consultar Partida");
        consultarPartida.setForeground(new Color(37, 34, 81));
        consultarPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
        JMenuItem editarPartida = new JMenuItem("Editar Partida");
        editarPartida.setForeground(new Color(37, 34, 81));
        editarPartida.setFont(new Font("Verdana", Font.PLAIN, 25));
        partidas.add(crearPartida);
        partidas.add(new JSeparator());
        partidas.add(consultarPartida);
        partidas.add(new JSeparator());
        partidas.add(editarPartida);

        // Opcion Miembros.
        JMenu miembros = new JMenu("Miembros");
        miembros.setForeground(new Color(37, 34, 81));
        miembros.setFont(new Font("Verdana", Font.BOLD, 25));
        JMenuItem mostrarMiembros = new JMenuItem("Mostrar Miembros");
        mostrarMiembros.setForeground(new Color(37, 34, 81));
        mostrarMiembros.setFont(new Font("Verdana", Font.PLAIN, 25));
        miembros.add(mostrarMiembros);

        // Añadimos a la barra las opciones.
        barraMenu.add(new JSeparator());
        barraMenu.add(personajes);
        barraMenu.add(new JSeparator());
        barraMenu.add(partidas);
        barraMenu.add(new JSeparator());
        barraMenu.add(miembros);
        barraMenu.add(new JSeparator());

        // Etiquetas para introducir la información
        JLabel labelIdentificador = new JLabel("Identificador único:");
        labelIdentificador.setFont(new Font("Verdana", Font.BOLD, 20));
        labelIdentificador.setForeground(Color.WHITE);
        labelIdentificador.setBounds(50, 35, 400, 30);
        getContentPane().add(labelIdentificador);

        JLabel labelNombrePartida = new JLabel("Nombre de la partida:");
        labelNombrePartida.setFont(new Font("Verdana", Font.BOLD, 20));
        labelNombrePartida.setForeground(Color.WHITE);
        labelNombrePartida.setBounds(50, 91, 400, 30);
        getContentPane().add(labelNombrePartida);

        JLabel labelIdGameMaster = new JLabel("ID Game Master:");
        labelIdGameMaster.setFont(new Font("Verdana", Font.BOLD, 20));
        labelIdGameMaster.setForeground(Color.WHITE);
        labelIdGameMaster.setBounds(50, 143, 400, 30);
        getContentPane().add(labelIdGameMaster);

        JLabel labelAmbientacion = new JLabel("Ambientación:");
        labelAmbientacion.setFont(new Font("Verdana", Font.BOLD, 20));
        labelAmbientacion.setForeground(Color.WHITE);
        labelAmbientacion.setBounds(50, 199, 400, 30);
        getContentPane().add(labelAmbientacion);

        JLabel labelPersonajes = new JLabel("Personajes que participan:");
        labelPersonajes.setFont(new Font("Verdana", Font.BOLD, 20));
        labelPersonajes.setForeground(Color.WHITE);
        labelPersonajes.setBounds(50, 255, 400, 30);
        getContentPane().add(labelPersonajes);

        JLabel labelDiaHora = new JLabel("Día y hora de la semana:");
        labelDiaHora.setFont(new Font("Verdana", Font.BOLD, 20));
        labelDiaHora.setForeground(Color.WHITE);
        labelDiaHora.setBounds(50, 304, 400, 30);
        getContentPane().add(labelDiaHora);

        JLabel labelDuracionSesion = new JLabel("Duración de la sesión (horas):");
        labelDuracionSesion.setFont(new Font("Verdana", Font.BOLD, 20));
        labelDuracionSesion.setForeground(Color.WHITE);
        labelDuracionSesion.setBounds(50, 350, 400, 30);
        getContentPane().add(labelDuracionSesion);

        JLabel labelNumeroSesion = new JLabel("Número de la sesión:");
        labelNumeroSesion.setFont(new Font("Verdana", Font.BOLD, 20));
        labelNumeroSesion.setForeground(Color.WHITE);
        labelNumeroSesion.setBounds(50, 402, 400, 30);
        getContentPane().add(labelNumeroSesion);

        JLabel labelEstado = new JLabel("¿Está en curso o terminada? (Si/No):");
        labelEstado.setFont(new Font("Verdana", Font.BOLD, 20));
        labelEstado.setForeground(Color.WHITE);
        labelEstado.setBounds(50, 454, 434, 30);
        getContentPane().add(labelEstado);

        // Campos de texto para introducir la información
        JTextField textoIdentificador = new JTextField();
        textoIdentificador.setFont(new Font("Verdana", Font.PLAIN, 20));
        textoIdentificador.setBounds(500, 30, 400, 41);
        getContentPane().add(textoIdentificador);

        JTextField textoNombrePartida = new JTextField();
        textoNombrePartida.setFont(new Font("Verdana", Font.PLAIN, 20));
        textoNombrePartida.setBounds(500, 82, 400, 41);
        getContentPane().add(textoNombrePartida);

        JTextField textoIdGameMaster = new JTextField();
        textoIdGameMaster.setFont(new Font("Verdana", Font.PLAIN, 20));
        textoIdGameMaster.setBounds(500, 134, 400, 41);
        getContentPane().add(textoIdGameMaster);

        JTextField textoAmbientacion = new JTextField();
        textoAmbientacion.setFont(new Font("Verdana", Font.PLAIN, 20));
        textoAmbientacion.setBounds(500, 188, 400, 41);
        getContentPane().add(textoAmbientacion);

        JTextField textoPersonajes = new JTextField();
        textoPersonajes.setFont(new Font("Verdana", Font.PLAIN, 20));
        textoPersonajes.setBounds(500, 240, 400, 41);
        getContentPane().add(textoPersonajes);

        JTextField textoDiaHora = new JTextField();
        textoDiaHora.setFont(new Font("Verdana", Font.PLAIN, 20));
        textoDiaHora.setBounds(500, 292, 400, 41);
        getContentPane().add(textoDiaHora);

        JTextField textoDuracionSesion = new JTextField();
        textoDuracionSesion.setFont(new Font("Verdana", Font.PLAIN, 20));
        textoDuracionSesion.setBounds(500, 345, 400, 41);
        getContentPane().add(textoDuracionSesion);

        JTextField textoNumeroSesion = new JTextField();
        textoNumeroSesion.setFont(new Font("Verdana", Font.PLAIN, 20));
        textoNumeroSesion.setBounds(500, 397, 400, 41);
        getContentPane().add(textoNumeroSesion);

        // Botones de opción para el estado
        JRadioButton radioSi = new JRadioButton("Si");
        JRadioButton radioNo = new JRadioButton("No");
        ButtonGroup group = new ButtonGroup();
        group.add(radioSi);
        group.add(radioNo);

        radioSi.setFont(new Font("Verdana", Font.PLAIN, 20));
        radioSi.setForeground(Color.WHITE);
        radioSi.setBackground(new Color(37, 34, 81));
        radioSi.setBounds(511, 454, 70, 30);
        getContentPane().add(radioSi);

        radioNo.setFont(new Font("Verdana", Font.PLAIN, 20));
        radioNo.setForeground(Color.WHITE);
        radioNo.setBackground(new Color(37, 34, 81));
        radioNo.setBounds(693, 454, 70, 30);
        getContentPane().add(radioNo);

        // Botón para registrarse
        JButton botonCrearPartida = new JButton("Crear Partida");
        botonCrearPartida.setFont(new Font("Verdana", Font.BOLD, 20));
        botonCrearPartida.setForeground(new Color(37, 34, 81));
        botonCrearPartida.setBackground(new Color(135, 206, 235));
        botonCrearPartida.setBounds(500, 514, 400, 50);
        getContentPane().add(botonCrearPartida);

        // Crear un cuadro de diálogo personalizado
        botonCrearPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String identificador = textoIdentificador.getText();
                //Mensaje del cuadro de dialogo , con la información del identificador introducido por el usuario
                JOptionPane.showMessageDialog(Crear_Partida.this, "La partida con identificador " + identificador + ": ha sido creada correctamente");
            }
        });

        // Configuramos la barra de menú al JFrame
        setJMenuBar(barraMenu);

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
                new Crear_Partida();
            }
        });
    }
}
