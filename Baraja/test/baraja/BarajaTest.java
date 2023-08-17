package baraja;

import carta.Carta;
import java.util.List;
import mazo.Mazo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class BarajaTest {
       
    Baraja b = new Baraja();
    
    @Before
    public void setUp() {
        b.mazo.crearMazo();
        b.barajar();  
    }
    
    
    @Test
    public void testVerMazoYBarajar() {
        System.out.println("\nVerMazoYBarajar");
        System.out.println("disponibles: " + b.cantidadMazo());
    }


    @Test
    public void testCartasDescarte() {
        System.out.println("\ncartasDescarte");
        b.cartasDescarte();
    }
    

    @Test
    public void testSacarCarta() {
        System.out.println("\nsacarCarta");
        System.out.println("Mazo disponibles: " + b.cantidadMazo());
        // sacar carta remueve del mazo y agrega a descarte automaticamente
        Carta carta = b.sacarCarta();
        System.out.println(carta);
        System.out.println("Mazo disponibles: " + b.cantidadMazo());
        System.out.println("Fuera del mazo: " + b.cantidadDescarte());
        int result = b.cantidadMazo();
        int expResult = 39;
        assertEquals(expResult, result);
    }

    
    @Test
    public void testDarCartas() {
        System.out.println("\ndarCartas");
        // dar cartas remueve del mazo y agrega a descartes automaticamente
        List<Carta> cartas = b.darCartas(7);
        Mazo mano = new Mazo(cartas);
        System.out.println("Mazo disponibles: " + b.cantidadMazo());
        System.out.println("Fuera del mazo: " + b.cantidadDescarte());
        mano.verCartas();
        System.out.println("Las cartas en la mano deberían estar en el mazo de descarte:");
        b.mostrarDescarte();
        int result = mano.cantidadCartas();
        int expResult = 7;
        assertEquals(expResult, result);
    }
}
