package _main_;

import entidades.Autor;
import entidades.Cliente;
import entidades.Editorial;
import entidades.Libro;
import entidades.Prestamo;

import java.util.Date;
import java.time.Instant;
import java.time.Period;

import java.util.List;
import java.util.Scanner;

import servicio.AutorServicio;
import servicio.ClienteServicio;
import servicio.EditorialServicio;
import servicio.LibroServicio;
import servicio.PrestamoServicio;

/*
TODO
Submenus para seleccionar entre resultados de búsquedas de libros y autores.
Validar campos obligatorios ?
No ingresar datos duplicados ?
*/

public class LibreriaJPA {
    
    static final String [] MENU = {
        "1) Registrar préstamo.",
        "2) Registrar devolución.",
        "3) Ver Cliente.",
        "4) Búsqueda de Libro.",
        "5) Búsqueda de Autor.",
        "x) SALIR.",
    };
    
    static final String [] SUBMENU = {
        "1) Búsqueda de Libro por ISBN.",
        "2) Búsqueda de Libro/s por Título.",
        "3) Búsqueda de Libro/s por Autor.",
        "4) Búsqueda de Libro/s por Editorial.",
        "x) VOLVER.",
    };

    // Creamos Servicios
    static LibroServicio libroServicio = new LibroServicio();
    static AutorServicio autorServicio = new AutorServicio();
    static EditorialServicio editorialServicio = new EditorialServicio();
    static ClienteServicio clienteServicio = new ClienteServicio();
    static PrestamoServicio prestamoServicio = new PrestamoServicio();
    
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) throws Exception {
        
        // Inserta algunas entidades en la base de datos
        /*
        Autor autor1 = autorServicio.crear(1, "J.L.Borges", true);
        Autor autor2 = autorServicio.crear(2, "Leopoldo Marechal", true);
        Autor autor3 = autorServicio.crear(2, "Macedonio Fernández", true);
        
        Editorial editorial1 = editorialServicio.crear(1, "DeBolsillo", true);
        Editorial editorial2 = editorialServicio.crear(2, "Lumen", true);
        Editorial editorial3 = editorialServicio.crear(3, "Seix Barral", true);
        Editorial editorial4 = editorialServicio.crear(4, "Fondo de Cultura Económica", true);
        
        Libro libro1 = libroServicio.crear("1234", "El Aleph", 2021, 10, 1, 9, true, autor1, editorial1);
        Libro libro2 = libroServicio.crear("2345", "Cuentos completos", 2023, 10, 0, 10, true, autor1, editorial2);
        Libro libro4 = libroServicio.crear("3456", "Adán Buenosayres", 2004, 10, 0, 10, true, autor2, editorial3);
        Libro libro5 = libroServicio.crear("4567", "Museo de la Novela de la Eterna", 1996, 0, 0, 0, true, autor3, editorial4);       
        
        Cliente cliente1 = clienteServicio.crear(1, "123", "Cosme", "Fulanito", "1123456789");
        Cliente cliente2 = clienteServicio.crear(2, "456", "Mr. Chispa", "", "1198765432");

        Date desde = Date.from(Instant.now());
        Date hasta = Date.from(Instant.now().plus(Period.ofDays(10)));
        Prestamo prestamo1 = prestamoServicio.crear(1, desde, hasta, cliente1, libro1);
        */
        
        // Menú PRINCIPAL
        String option;
	while (true) {
            
            System.out.println("\nMENÚ");
            
            for (String op : MENU) {
		System.out.println(op);
            }
            
            System.out.print("Ingrese una opción: ");
            option = leer.nextLine().trim();
            
            switch (option) {
		case "1":
			System.out.println("Opción 1. Registrar préstamo:");
			opcion1();
			break;
                case "2":
			System.out.println("Opción 2. Registrar devolución:");
			opcion2();
			break;
		case "3":
			System.out.println("Opción 3. Ver Cliente:");
			opcion3();
			break;
                case "4":
                    	System.out.println("Opción 4. Buscar Libro:");
			buscarLibro();
			break;
                case "5":
                    	System.out.println("Opción 5. Buscar Autor:");
			buscarAutor();
			break;
		case "x":
			System.out.println("Adios!");
                        leer.close();
			System.exit(0);
			break;
		default:
			System.out.println("Opción incorrecta.");
			break;
            }    
	}
    }
    
    // Submenu SUBMENU LIBRO
    public static void buscarLibro() {
        String option;
	while (true) {
            
            System.out.println("\nBÚSQUEDA DE LIBRO");
            
            for (String op : SUBMENU) {
		System.out.println(op);
            }
            
            System.out.print("Ingrese una opción: ");
            option = leer.nextLine();
            
            switch (option) {
		case "1":
			System.out.println("Opción 1. Búsqueda de Libro por ISBN:");
			busquedaLibro1();
			break;
		case "2":
			System.out.println("Opción 2. Búsqueda de Libro por Título:");
			busquedaLibro2();
			break;
		case "3":
			System.out.println("Opción 3. Búsqueda de Libro por Autor:");
			busquedaLibro3();
			break;
		case "4":
			System.out.println("Opción 4. Búsqueda de Libro por Editorial:");
			busquedaLibro4();
			break;
		case "x":
			return;
		default:
			System.out.println("Opción incorrecta.");
			break;
            }    
	}
    }
    
    //Funciones Menú PRINCIPAL
    public static void opcion1() throws Exception {
        System.out.print("Ingrese id de cliente: ");
        int input1 = readInt();
        Cliente cliente = clienteServicio.buscarPorId(input1);
        System.out.println(cliente);
        
        System.out.print("Ingrese ISBN del libro: ");
        String input2 = leer.nextLine();
        Libro libro = libroServicio.buscarPorId(input2);
        
        System.out.print("Ingrese cantidad de días: ");
        input1 = readInt();
        
        //Convierte de java.time.Instant -> java.util.date (JPA 2.1 no funciona con java.time)
        Date desde = Date.from(Instant.now());
        Date hasta = Date.from(Instant.now().plus(Period.ofDays(input1)));
        
        if (libroServicio.prestar(libro)) {
            Prestamo prestamo = prestamoServicio.crear(input1, desde, hasta, cliente, libro);
            System.out.println(prestamo);
        } else {
            System.out.println("Sin libros para prestar.");
        }
    }
    
    public static void opcion2() throws Exception {
        System.out.print("Ingrese id de cliente: ");
        int input1 = readInt();
        Cliente cliente = clienteServicio.buscarPorId(input1);
        System.out.println(cliente);
        
        List<Prestamo> prestamos = prestamoServicio.buscarPorCliente(input1);
        
        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo prestamo = prestamos.get(i);
            System.out.println(i + ") " + prestamo);
        }
        System.out.print("Ingrese una opción: ");
        input1 = readInt();
        
        if (input1 < 0 || input1 > prestamos.size()) {
            System.out.println("Opción incorrecta.");
            return;
        }
        
        Prestamo prestamo = prestamos.get(input1);
        Libro libro = prestamo.getLibro();
        libroServicio.devolver(libro);
        libroServicio.editar(libro);
        prestamoServicio.eliminar(prestamo);
    }
       
    public static void opcion3() throws Exception {
        System.out.print("Ingrese id de cliente: ");
        int input = readInt();
        Cliente cliente = clienteServicio.buscarPorId(input);
        System.out.println(cliente);
        
        List<Prestamo> prestamos = prestamoServicio.buscarPorCliente(input);
        if (prestamos.isEmpty()) {
            System.out.println("Sin prestamos vigentes.");
            return;
        }
        prestamos.forEach((prestamo) -> {
            System.out.println(prestamo);
        });
    }
    
    public static Autor buscarAutor(){
        Autor autor;
        System.out.println("\nBÚSQUEDA DE AUTOR");
        System.out.print("Ingrese el Autor: ");
        String input = leer.nextLine();
        List<Autor> autores = autorServicio.buscarPorNombre(input);
        if (autores.isEmpty() && autores.size() < 1) {
            System.out.println("Sin resultados.");
            return null;
        }
        System.out.println(autores);
        if (autores.size() > 1) {
            System.out.println("Más de un resultado para el término \"" + input + "\"!\n(Se selecciona el primero por default)");           
        }
        autor = autores.get(0);
        return autor;
    }
    
    // Funciones Submenu SUBMENU LIBRO
    public static Libro busquedaLibro1(){
        System.out.print("Ingrese el ISBN: ");
        String input = leer.nextLine();
        Libro libro = libroServicio.buscarPorId(input);
        System.out.println(libro);
        return libro;
    }
    
    public static Libro busquedaLibro2(){
        Libro libro;
        System.out.print("Ingrese el Título: ");
        String input = leer.nextLine();
        List<Libro> libros = libroServicio.buscarPorTitulo(input);
        
        if (libros.isEmpty() && libros.size() < 1) {
            System.out.println("Sin resultados.");
            return null;
        }
        System.out.println(libros);
        if (libros.size() > 1) {
            System.out.println("Más de un resultado para el término \"" + input + "\"!\n(Se selecciona el primero por default)");           
        }
        libro = libros.get(0);
        return libro;
    }

    public static List<Libro> busquedaLibro3(){
        System.out.print("Ingrese el Autor: ");
        String input = leer.nextLine();
        List<Libro> libros = libroServicio.buscarPorAutor(input);
        libros.forEach((libro) -> {
            System.out.println(libro);
        });
        return libros;
    }
    
    public static List<Libro> busquedaLibro4(){
        System.out.print("Ingrese la Editorial: ");
        String input = leer.nextLine();
        List<Libro> libros = libroServicio.buscarPorEditorial(input);
        libros.forEach((libro) -> {
            System.out.println(libro);
        });
        return libros;
    }
    
    // OTROS
    // Lee numero entero del usuario
    public static int readInt() throws Exception {
        int numero = -1;
        
        while (true) {
            try {
                String input = leer.nextLine();
                numero = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ex) {
                System.out.print("Entrada incorrecta, debe ingresar un número: ");
            }
        }
        return numero;
    }
}