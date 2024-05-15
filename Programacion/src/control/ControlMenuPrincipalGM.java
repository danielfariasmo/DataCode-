/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import modelo.ConexionBBDD;
import modelo.Miembro;
import modelo.Partida;
import vistas.ConsultarPartidaGameMaster;
import vistas.CrearPartida;
import vistas.EditarPartida;
import vistas.MenuPrincipalGameMaster;
import vistas.MiembroClub;
import vistas.TextoMenuPrincipal;

public class ControlMenuPrincipalGM implements ActionListener{

	/**
	 * @author Daniel F.
	 * @author Ignacio M.
	 * @author Daniel G.
	 */

	private MenuPrincipalGameMaster menuPrincipalGameMaster;
	private ConsultarPartidaGameMaster consultarPartida;
	private CrearPartida crearPartida;
	private EditarPartida editarPartida;
	private MiembroClub miembroClub;
	private TextoMenuPrincipal textoMenuPrincipal;
	private ConexionBBDD conexionbbdd;

	public ControlMenuPrincipalGM(MenuPrincipalGameMaster menuPrincipalGameMaster,
			CrearPartida crearPartida, EditarPartida editarPartida, MiembroClub miembroClub,
			TextoMenuPrincipal textoMenuPrincipal) {
		this.menuPrincipalGameMaster = menuPrincipalGameMaster;
		this.consultarPartida = new ConsultarPartidaGameMaster(this);
		this.crearPartida = crearPartida;
		this.editarPartida = editarPartida;
		this.miembroClub = miembroClub;
		this.textoMenuPrincipal = textoMenuPrincipal;
	}

	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() instanceof JMenuItem) {
			if (evento.getActionCommand().equals("Crear Partida")) {
				menuPrincipalGameMaster.cambiarPanel(crearPartida);

			} else if (evento.getActionCommand().equals("Consultar Partida")) {
				consultarPartida();
			} else if (evento.getActionCommand().equals("Mostrar Miembros")) {
				menuPrincipalGameMaster.cambiarPanel(miembroClub);

				ConexionBBDD conexionBBDD = new ConexionBBDD();
				ArrayList<Miembro> miembros = conexionBBDD.obtenerMiembros();

				if (miembros != null) {
					for (Miembro miembro : miembros) {
						System.out.println(miembro);
					}

					miembroClub.insertarMiembros(miembros);

				} else {
					System.out.println("No se pudieron obtener los miembros.");
				}

			} else if (evento.getActionCommand().equals("Editar Partida")) {
				menuPrincipalGameMaster.cambiarPanel(editarPartida);

			} else if (evento.getActionCommand().equals("Menú Principal")) {
				menuPrincipalGameMaster.cambiarPanel(textoMenuPrincipal);

			}
		}

	}
	
	private void consultarPartida() {
		menuPrincipalGameMaster.cambiarPanel(consultarPartida);
		conexionbbdd = new ConexionBBDD();
		
		ArrayList<Partida> partidas = conexionbbdd.consultarPartida();
		consultarPartida.cargarPartida(partidas);
	}
}
