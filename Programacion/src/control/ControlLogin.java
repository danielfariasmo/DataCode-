package control;
import javax.swing.*;

import modelo.ConexionBBDD;
import vistas.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlLogin implements ActionListener{

	Login login;
	
	public ControlLogin(Login l) {
		login = l;
	}
	
    public static void handleLogin(JTextField usuarioTextField, JPasswordField contraseñaPasswordField, JPanel parentPanel) {
        String usuario = usuarioTextField.getText();
        String contraseña = new String(contraseñaPasswordField.getPassword());

        // Variable para guardar la información de la consulta
        boolean loginExitoso = false;

        // Creamos consulta
        String selectLogin = "SELECT * FROM miembro WHERE nombre_usuario = '" + usuario
                + "' AND clave_usuario = '" + contraseña + "'"; // Corregido: Se agrega comillas a la contraseña

        // Conecto la BBDD
        ConexionBBDD conexionbbdd = new ConexionBBDD();
        Connection conn = conexionbbdd.conectar();

        // Ejecuto la consulta
        try {
            Statement s = conn.createStatement();
            ResultSet resultado = s.executeQuery(selectLogin);
            loginExitoso = resultado.next();
        } catch (SQLException e1) {
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
            int opcion = JOptionPane.showConfirmDialog(parentPanel, panelDialogo, "Inicio de Sesión",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            // Acciones basadas en la selección del usuario
            if (opcion == JOptionPane.OK_OPTION) {
                if (jugador.isSelected()) {
                    JOptionPane.showMessageDialog(parentPanel, "Has seleccionado iniciar sesión como Jugador");
                    // Aquí puedes realizar las acciones para el inicio de sesión como jugador
                } else if (gameMaster.isSelected()) {
                    JOptionPane.showMessageDialog(parentPanel, "Has seleccionado iniciar sesión como GameMaster");
                    // Aquí puedes realizar las acciones para el inicio de sesión como GameMaster
                }
            }
        } else {
            JOptionPane.showMessageDialog(parentPanel, "Usuario o contraseña incorrectos");
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usuario = login.getTextoUsuarioLogin().getText();
		String contraseña = new String(login.getClaveContraseñaLogin().getPassword());

		// Variable para guardar la informacion de la consulta
		boolean loginExitoso = false;

		// Creamos consulta
		String selectLogin = "SELECT * FROM miembro WHERE nombre_usuario = '" + usuario
				+ "' AND clave_usuario = " + contraseña;

		// Conecto la bbs
		ConexionBBDD conexionbbdd = new ConexionBBDD();
		Connection conn = conexionbbdd.conectar();
		// conn = ConexionBBDD.conectar();

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
}