package vistas;

import javax.swing.*;
import java.awt.*;

public class TextoMenuPrincipal extends JPanel {

    public TextoMenuPrincipal() {
    	setBackground(new Color(135, 206, 255));
        setLayout(new BorderLayout());

        // Logo a la izquierda
        JLabel logoLabel = new JLabel(new ImageIcon("img/DataCode.Logo.png"));
        logoLabel.setBackground(new Color(135, 206, 255));
        add(logoLabel, BorderLayout.WEST);

        // Introduccion a la derecha
        JLabel labelTexto = new JLabel(
                "<html><div style='text-align: center; width: 350px;'>Adéntrate en el mundo del Club de Rol DataCode++ de la UEM, donde la imaginación cobra vida a través de épicas aventuras. Nuestra aplicación de gestión de personajes te permite crear y dirigir héroes en sus peligrosos viajes, mientras los Game Masters dan forma a mundos llenos de misterio y emoción. Con un simple clic, podrás explorar tierras desconocidas, forjar alianzas y enfrentarte a desafíos que pondrán a prueba tu valentía. ¿Estás listo para sumergirte en un universo donde solo la imaginación es el límite? Entonces únete a nosotros y deja que la aventura comience.</div></html>");
        labelTexto.setBackground(new Color(135, 206, 235));
        labelTexto.setForeground(new Color(37, 34, 81));
        labelTexto.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(labelTexto, BorderLayout.EAST);

        // Crear un JMenuBar y agregar el JMenu
//        JMenuBar menuBar = new JMenuBar();
//        JMenu volverMenu = new JMenu("");
//        volverMenu.setIcon(new ImageIcon("img/home.png"));
//        volverMenu.setForeground(new Color(37, 34, 81));
//        volverMenu.setFont(new Font("Verdana", Font.BOLD, 25));
//        menuBar.add(volverMenu);
        
        // Asignar el JMenuBar al frame (o al contenedor superior)
        JFrame frame = new JFrame("DataCode++");
        frame.setBackground(new Color(135, 206, 235));
        frame.getContentPane().setBackground(new Color(135, 206, 235));
//        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }
}
