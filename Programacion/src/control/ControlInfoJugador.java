package control;

import javax.swing.JOptionPane;

public class ControlInfoJugador {
	public static void mostrarMensajeSubirNivel() {
		//Mensaje mostrado en pantalla
        JOptionPane.showMessageDialog(null, "Estás seguro que quieres unirte a esta partida ?", "Unirme a la Partida", JOptionPane.INFORMATION_MESSAGE);
    }

}
