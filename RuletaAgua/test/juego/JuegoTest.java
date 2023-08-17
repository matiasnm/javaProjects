package juego;

import java.util.ArrayList;
import jugador.Jugador;
import org.junit.Test;
import static org.junit.Assert.*;
import revolver.Revolver;


public class JuegoTest {
    
    Revolver r = new Revolver();
    Jugador j1 = new Jugador(1, "Pepe");
    Jugador j2 = new Jugador(2, "Tina");
    
    public JuegoTest() {
    }
    
    @Test
    public void testJugar() {

        System.out.println("Test Juego:");
        ArrayList<Jugador> jugadores = new ArrayList();
        jugadores.add(j1);
        jugadores.add(j2);

        Juego juegoNuevo = new Juego();
        Void expResult = null;
        Void result = juegoNuevo.setup(jugadores, r);
        assertEquals(expResult, result);
        juegoNuevo.jugar();
    }
}
