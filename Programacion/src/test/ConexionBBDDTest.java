package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.ConexionBBDD;
import modelo.GameMaster;
import modelo.Juega;
import modelo.Miembro;
import modelo.Partida;
import modelo.Personaje;

class ConexionBBDDTest {

	private ConexionBBDD conexion;

    @BeforeEach
    public void setUp() {
        conexion = new ConexionBBDD();
    }

    @AfterEach
    public void tearDown() {
        conexion.cerrar();
    }

    @Test
    public void testConectar() {
        Connection conn = conexion.conectar();
        assertNotNull(conn, "La conexión no debería ser nula");
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObtenerMiembros() {
        ArrayList<Miembro> miembros = conexion.obtenerMiembros();
        assertNotNull(miembros, "La lista de miembros no debería ser nula");
        assertFalse(miembros.isEmpty(), "La lista de miembros no debería estar vacía");
    }

    @Test
    public void testObtenerPersonaje() {
        String idMiembro = "1"; // Asume que hay un miembro con ID 1 en la base de datos de prueba
        ArrayList<Personaje> personajes = conexion.obtenerPersonaje(idMiembro);
        assertNotNull(personajes, "La lista de personajes no debería ser nula");
    }

    @Test
    public void testConsultarPartida() {
        ArrayList<Partida> partidas = conexion.consultarPartida();
        assertNotNull(partidas, "La lista de partidas no debería ser nula");
    }

    @Test
    public void testObtenerMiembro() {
        String usuario = "root"; // Ajusta estos valores según tu base de datos de prueba
        String clave = "root";
        Miembro miembro = conexion.obtenerMiembro(usuario, clave);
        assertNotNull(miembro, "El miembro no debería ser nulo");
    }

    @Test
    public void testIsGameMaster() {
        String idMiembro = "1"; // Asume que hay un miembro con ID 1 en la base de datos de prueba
        boolean isMaster = conexion.isGameMaster(idMiembro);
        assertTrue(isMaster, "El miembro debería ser un GameMaster");
    }

    @Test
    public void testConvertIntoGameMaster() {
        String idMiembro = "2"; // Ajusta según tu base de datos de prueba
        String alias = "testAlias";
        conexion.convertIntoGameMaster(idMiembro, alias);
        boolean isMaster = conexion.isGameMaster(idMiembro);
        assertTrue(isMaster, "El miembro debería haber sido convertido a GameMaster");
    }

    @Test
    public void testCargarTodosPersonajes() {
        String idPartida = "1"; // Ajusta según tu base de datos de prueba
        ArrayList<Personaje> personajes = conexion.cargarTodosPersonajes(idPartida);
        assertNotNull(personajes, "La lista de personajes no debería ser nula");
    }

    
    @Test
    public void testObtenerPartidasActuales() {
        String idMiembro = "1"; // Ajusta según tu base de datos de prueba
        ArrayList<String[]> partidas = conexion.obtenerPartidasActuales(idMiembro);
        assertNotNull(partidas, "La lista de partidas no debería ser nula");
    }

    @Test
    public void testObtenerCaracteristicasPartida() {
        String idPersonaje = "1"; // Ajusta según tu base de datos de prueba
        ArrayList<String[]> caracteristicas = conexion.obtenerCaracteristicasPartida(idPersonaje);
        assertNotNull(caracteristicas, "La lista de características no debería ser nula");
    }

    @Test
    public void testConsultarCaracteristicas() {
        int idPersonaje = 1; // Ajusta según tu base de datos de prueba
        int idPartida = 1; // Ajusta según tu base de datos de prueba
        Juega juega = conexion.consultarCaracteristicas(idPersonaje, idPartida);
        assertNotNull(juega, "Las características no deberían ser nulas");
    }

  
    @Test
    public void testConsultarPartidaGameMaster() {
        int idGameMaster = 1; // Ajusta según tu base de datos de prueba
        ArrayList<Partida> partidas = conexion.consultarPartidaGameMaster(idGameMaster);
        assertNotNull(partidas, "La lista de partidas no debería ser nula");
    }

    @Test
    public void testBuscarID() {
        int idGameMaster = 1; // Ajusta según tu base de datos de prueba
        GameMaster gameMaster = conexion.buscarID(idGameMaster);
        assertNotNull(gameMaster, "El GameMaster no debería ser nulo");
    }

    @Test
    public void testEliminarPersonaje() {
        String idPersonaje = "1"; // Ajusta según tu base de datos de prueba
        conexion.elminarPersonaje(idPersonaje);
        // Verificación manual necesaria
    }
}


