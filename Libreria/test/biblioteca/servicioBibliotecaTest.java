package biblioteca;

import libros.Ejemplar;
import libros.Libro;
import libros.servicioLibro;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class servicioBibliotecaTest {
    
    Libro nuevoLibro = servicioLibro.crear_libro("El Aleph", "J.L.Borges");
    Libro nuevoLibro2 = servicioLibro.crear_libro("La invención de Morel", "A.Bioy Casares");
    Ejemplar nuevoEjemplar = servicioLibro.crear_ejemplar(1, "Buenos Aires, 1994", true);
    Ejemplar nuevoEjemplar2 = servicioLibro.crear_ejemplar(2, "Barcelona, 2002", false);
    Ejemplar nuevoEjemplar3 = servicioLibro.crear_ejemplar(1, "Barcelona, 2012", false);
 
    
    @Test
    public void testComparar_libro1() {
        System.out.println("--------------------------");
        System.out.println("TEST: comparar libros (!= instancia)");
        
        // compara dos libros diferentes
        Boolean result = nuevoLibro.equals(nuevoLibro2);
        Boolean expResult = false;
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testComparar_libro2() {
        System.out.println("--------------------------");
        System.out.println("TEST: comparar libros (== instancia)");
        
        // compara dos libros diferentes
        Boolean result = nuevoLibro.equals(nuevoLibro);
        Boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testComparar_libro3() {
        System.out.println("--------------------------");
        System.out.println("TEST: comparar libros (!= instancia; == titulo, == autor)");
        
        // compara dos libros diferentes
        Libro nuevoLibro3 = servicioLibro.crear_libro("El Aleph", "J.L.Borges");
        
        Boolean result = nuevoLibro.equals(nuevoLibro3);
        Boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testComparar_libro4() {
        System.out.println("--------------------------");
        System.out.println("TEST: comparar libros (!= instancia; == titulo, != autor)");
        
        // compara dos libros diferentes
        Libro nuevoLibro3 = servicioLibro.crear_libro("El Aleph", "J.L.Falso");
        
        Boolean result = nuevoLibro.equals(nuevoLibro3);
        Boolean expResult = false;
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testComparar_libro5() {
        System.out.println("--------------------------");
        System.out.println("TEST: comparar libros (!= instancia; != titulo == autor)");
        
        // compara dos libros diferentes
        Libro nuevoLibro3 = servicioLibro.crear_libro("El Aleph 2", "J.L.Borges");
        
        Boolean result = nuevoLibro.equals(nuevoLibro3);
        Boolean expResult = false;
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testAgregar_libro() {
        System.out.println("--------------------------");
        System.out.println("TEST: agregar_libro\n");
        
        // crea una nueva biblioteca
        servicioBiblioteca nuevaBiblioteca = new servicioBiblioteca("Av. Santa Fe 3000");
        
        // agrega el libro
        nuevaBiblioteca.agregar_libro(nuevoLibro);
        
        // agrega otro libro
        nuevaBiblioteca.agregar_libro(nuevoLibro2);

        // agrega el libro de nuevo...
        Boolean result = nuevaBiblioteca.agregar_libro(nuevoLibro);
        Boolean expResult = false;
        
        // muestra la biblioteca
        System.out.println("Mostrar biblioteca:\n");
        nuevaBiblioteca.ver_biblioteca();
        
        assertEquals(expResult, result);
    }
        
    
    @Test
    public void testAgregar_ejemplar() {
        System.out.println("--------------------------");
        System.out.println("TEST: agregar_ejemplar\n");
        
        // crea una nueva biblioteca
        servicioBiblioteca nuevaBiblioteca = new servicioBiblioteca("Av. Santa Fe 3000");
        
        System.out.println("Agrega:" + nuevoLibro.toString() +"\n");
        
        // agrega un ejemplar
        nuevaBiblioteca.agregar_libroYejemplar(nuevoLibro, nuevoEjemplar);
        
        System.out.println("Listar y seleccionar el libro agregado:");
        // listar y seleccionar el libro ya ingresado
        nuevaBiblioteca.listar_libros();
        Libro seleccion = nuevaBiblioteca.selecionar_libro(1);
        
        // agrega otro ejemplar del mismo Libro usando la variable seleccion
        Boolean expResult = true;
        Boolean result = nuevaBiblioteca.agregar_ejemplar(seleccion, nuevoEjemplar2);
        
        // muestra la biblioteca
        System.out.println("Mostrar biblioteca:\n");
        nuevaBiblioteca.ver_biblioteca();
        
        assertEquals(expResult, result);
    }
    

    @Test
    public void testAgregar_libroYejemplar() {
        System.out.println("--------------------------");
        System.out.println("TEST: agregar_libroYejemplar\n");
        
        // crea una nueva biblioteca
        servicioBiblioteca nuevaBiblioteca = new servicioBiblioteca("Av. Santa Fe 3000");
        
        Boolean expResult = true;
        Boolean result = nuevaBiblioteca.agregar_libroYejemplar(nuevoLibro2, nuevoEjemplar2);
        // muestra la biblioteca
        System.out.println("Mostrar biblioteca:\n");
        nuevaBiblioteca.ver_biblioteca();
        
        assertEquals(expResult, result);
    }
}