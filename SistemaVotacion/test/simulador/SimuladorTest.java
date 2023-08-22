package simulador;

import alumno.Alumno;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class SimuladorTest {
    Simulador simulador = new Simulador();
    int CANTIDAD_ALUMNOS = 20;
    int CANTIDAD_VOTOS = 3;
        
    public SimuladorTest() {
    }
      
    @Before
    public void setUp() {
    }
    
    @Ignore
    @Test
    public void testHashMap() {
        System.out.println("SIMULACIÓN DE SISTEMA DE VOTOS (con HashMap)");
        System.out.println("CANTIDAD DE ALUMNOS: " + CANTIDAD_ALUMNOS);
        System.out.println("CANTIDAD DE VOTOS: " + CANTIDAD_VOTOS);
        List<Alumno> lista = simulador.crearLista(CANTIDAD_ALUMNOS);
        System.out.println("\nLISTA INICIAL:\n");
        lista.forEach((Alumno alumno) -> {
            System.out.println(alumno);
        });
        System.out.println("\nVOTACIÓN:");
        simulador.votacionConMapa(lista, CANTIDAD_VOTOS);
        
        System.out.println("\nLISTA FINAL:\n");
        lista.forEach((Alumno alumno) -> {
            System.out.println(alumno);
        });
        
        int expResult = CANTIDAD_ALUMNOS;
        int result = lista.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testClaseVoto() {
        System.out.println("SIMULACIÓN DE SISTEMA DE VOTOS (con Clase Voto)");
        System.out.println("CANTIDAD DE ALUMNOS: " + CANTIDAD_ALUMNOS);
        System.out.println("CANTIDAD DE VOTOS: " + CANTIDAD_VOTOS);
        List<Alumno> lista = simulador.crearLista(CANTIDAD_ALUMNOS);
        System.out.println("\nLISTA INICIAL:\n");
        lista.forEach((Alumno alumno) -> {
            System.out.println(alumno);
        });
        System.out.println("\nVOTACIÓN:");
        simulador.votacion(lista, CANTIDAD_VOTOS);
        
        // muestra votantes y votados
        simulador.resultados();
        
        System.out.println("\nLISTA FINAL:\n");
        lista.forEach((Alumno alumno) -> {
            System.out.println(alumno);
        });
        
        int expResult = CANTIDAD_ALUMNOS;
        int result = lista.size();
        assertEquals(expResult, result);
    }
}