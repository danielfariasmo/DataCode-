package vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JPanel panelLogin;
    private JTextField tfUsuarioLogin;
    private JPasswordField pfContraseñaLogin;

    public Login() {
        setTitle("Menu");
        setSize(711, 428);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new CardLayout());

        panelLogin = new JPanel();
        tfUsuarioLogin = new JTextField();
        pfContraseñaLogin = new JPasswordField();
        JButton btnLogin = new JButton("Iniciar Sesión");

        panelLogin.setLayout(null);
        tfUsuarioLogin.setBounds(113, 11, 150, 20);
        pfContraseñaLogin.setBounds(113, 42, 150, 20);
        btnLogin.setBounds(113, 102, 150, 20);

        panelLogin.add(new JLabel("Usuario:")).setBounds(10, 10, 80, 20);
        panelLogin.add(tfUsuarioLogin);
        panelLogin.add(new JLabel("Contraseña:")).setBounds(10, 40, 80, 20);
        panelLogin.add(pfContraseñaLogin);
        panelLogin.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @SuppressWarnings("unused")
			@Override
            public void actionPerformed(ActionEvent e) {
                String usuario = tfUsuarioLogin.getText();
                String contraseña = new String(pfContraseñaLogin.getPassword());

                // Aquí puedes agregar la lógica de autenticación si lo deseas
                // Por ahora solo muestra un mensaje
                if (true /* Condición de autenticación */) {
                    JOptionPane.showMessageDialog(Login.this, "Bienvenido " + usuario);
                    // Aquí puedes abrir tu juego o la siguiente ventana
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos");
                }
            }
        });

        getContentPane().add(panelLogin, "login");

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}
