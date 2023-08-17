package revolver;

import org.junit.Test;
import static org.junit.Assert.*;

public class RevolverTest {
    
    Revolver r = new Revolver();
    
    public RevolverTest() {

    }
    
    @Test
    public void testCargar_Mostrar() {
        System.out.println("\nCargar y Mostrar:");
        r.cargar();
        System.out.println(r);
        Boolean result = false;
        if (r.getAgua() >= 0 && r.getAgua() < 6) {
            result = true;
        }
        assertEquals(true, result);
    }

    @Test
    public void testSiguiente_Mojar() {
        System.out.println("\nSiguiente y Mojar:");
        r.setAgua(5);
        r.setTambor(0);
        System.out.println(r);
        while (!r.mojar()) {
            r.siguiente();
            System.out.println(r);
        }
        Boolean result = true;
        assertEquals(r.mojar(), result);
    }
    
}
