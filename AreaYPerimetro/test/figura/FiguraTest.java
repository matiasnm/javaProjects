package figura;

import circulo.Circulo;
import cuadrado.Cuadrado;
import org.junit.Test;
import static org.junit.Assert.*;

public class FiguraTest {
    
    public FiguraTest() {
    }
  
    @Test
    public void testCirculo() {
        Circulo circuloInstance = new Circulo(1);
        System.out.println(circuloInstance);
        double expResult = Math.PI;
        double result = circuloInstance.getArea();
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testCuadrado() {
        Cuadrado cuadradoInstance = new Cuadrado(4);
        System.out.println(cuadradoInstance);
        double expResult = cuadradoInstance.getPerimetro();
        double result = cuadradoInstance.getArea();
        assertEquals(expResult, result, 0);
    }
    
}
