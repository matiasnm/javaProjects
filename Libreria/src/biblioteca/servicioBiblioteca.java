package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import libros.Libro;
import libros.Ejemplar;

/*
TODO
servicio para crear libros y ejemplares
que no permita crear nuevos objetos
para libros/ejemplares que quiza ya existen en la biblioteca!
usar equals() y selecionar_libro()
*/

// servicio Biblioteca cuenta con un objeto Biblioteca como attributo
public class servicioBiblioteca {
    
    // attributos
    Biblioteca biblioteca = new Biblioteca();
    // constructor vacio
    public servicioBiblioteca() { 
    }
    // constructores con parametros
    public servicioBiblioteca(String direccion) {
        biblioteca.setDireccion(direccion);   
    }
    
    
    // crear un libro y un ejemplar para insertarlo en biblioteca.archivo (HashMap)
    public Boolean agregar_libroYejemplar(Libro libro, Ejemplar ejemplar) {
        try {
            // check si biblioteca.archivo existe
            if (biblioteca != null && biblioteca.archivo != null) {
                ArrayList <Ejemplar> ejemplares = new ArrayList<>();
                ejemplares.add(ejemplar);
                biblioteca.archivo.put(libro, ejemplares);
            } else {
                // msg para imprimir en catch para la excepcion de tipo...
                throw new NullPointerException("Biblioteca o biblioteca.archivo es null.");
            }
        }
        // manejo de excepcion, msg de error
        catch (NullPointerException e) {
        System.err.println("Error: " + e.getMessage());
        return false;
        }
    return true;
    }
  

    // agregar key Libro al HashMap
    public Boolean agregar_libro(Libro libro) {
        try {
            // check si biblioteca.archivo existe
            if (biblioteca != null && biblioteca.archivo != null) {
                
                // verifica si el libro existe en la biblioteca (Key del HashMap)
                if (biblioteca.archivo.containsKey(libro)) {
                    System.out.println("El libro ya existe en la biblioteca.\n" + libro.toString());
                    return false;
                } else {
                    // !!!!verificar si el nombre del libro es similar a un libro existente del mismo autor?
                    ArrayList <Ejemplar> ejemplares = new ArrayList<>();
                    biblioteca.archivo.put(libro, ejemplares);
                }
            } else {
                // msg para imprimir en catch para la excepcion de tipo...
                throw new NullPointerException("Biblioteca o biblioteca.archivo es null.");
            }
        }
        // manejo de excepcion, msg de error
        catch (NullPointerException e) {
        System.err.println("Error: " + e.getMessage());
        return false;
        }
    return true;
    }


    // agregar una ejemplar en la lista de key=Libro en el HashMap
    public Boolean agregar_ejemplar(Libro libro, Ejemplar ejemplar) {
        try {
            // check si biblioteca.archivo existe
            if (biblioteca != null && biblioteca.archivo != null) {
                // get Lista de ejemplares (Value del HashMap)
                
                // falta verificar si key=Libro existe!!
                // (ejemplares != null ?!?!
                
                ArrayList <Ejemplar> ejemplares = biblioteca.archivo.get(libro);

                // si la lista NO es null y el ejemplar ya existe en la lista
                if (ejemplares.contains(ejemplar))
                {
                    System.out.println("El ejemplar ya existe en la biblioteca.\n" + ejemplar.toString());
                    return false;
                } else {
                    ejemplares.add(ejemplar);
                    biblioteca.archivo.put(libro, ejemplares);
                }
            } else {
                // msg para imprimir en catch para la excepcion de tipo...
                throw new NullPointerException("Biblioteca o biblioteca.archivo es null.");
            }
        }
        // manejo de excepcion, msg de error
        catch (NullPointerException e) {
        System.err.println("Error: " + e.getMessage());
        return false;
        }
    return true;
    }
    
    
    // imprimir libros 
    public void listar_libros() {
        Set<Libro> setLibros = biblioteca.archivo.keySet();
        Iterator<Libro> iterator = setLibros.iterator();
        int index = 1;
        
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            System.out.println(index + ". " + libro.getTitulo());
            index++;
        }
    }
    
    
    // imprimir libros y selecionar con parametros
    public Libro selecionar_libro(int seleccion) {     
        Set<Libro> setLibros = biblioteca.archivo.keySet();
        if (seleccion >= 1 && seleccion <= setLibros.size()) {
            // convertir setLibros en array
            Libro[] librosArray = setLibros.toArray(new Libro[0]);
            Libro libro = librosArray[seleccion - 1];
            System.out.println("Seleccion: " + libro.getTitulo());
            // retorna libro selecionado
            return libro;
        } else {
            System.out.println("Seleccion inválida.");
        }
        return null;
    }
    
    // selecionar sin parametos (scanner input)
    public void selecionar_libro() {
        Set<Libro> setLibros = biblioteca.archivo.keySet();
        // user input
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Selecionar un libro de la Biblioteca: ");
            int seleccion = scanner.nextInt();
            
            if (seleccion >= 1 && seleccion <= setLibros.size()) {
                // convertir setLibros en array
                Libro[] librosArray = setLibros.toArray(new Libro[0]);
                Libro libro = librosArray[seleccion - 1];
                System.out.println("Seleccion: " + libro.getTitulo());
                System.out.println("\n");
            } else {
                System.out.println("Seleccion inválida.\n");
            }
        }
    }
    
    
    // imprimir toda la biblioteca
    public void ver_biblioteca() {
        for (HashMap.Entry<Libro, ArrayList<Ejemplar>> entry : biblioteca.archivo.entrySet() ) {
            Libro libro = entry.getKey();
            ArrayList<Ejemplar> ejemplares = entry.getValue();
            System.out.println("Biblioteca [Dirección: " + biblioteca.getDireccion() + "]");
            System.out.println(libro.toString());
            if (!(ejemplares.size() > 0)) {
                System.out.println("\u0009Sin ejemplares");
                return;
            }
            for (Ejemplar ejemplar : ejemplares) {
                System.out.println(ejemplar.toString());
            }
        }
    }
}
