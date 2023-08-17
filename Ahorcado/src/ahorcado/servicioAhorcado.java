package ahorcado;

import java.io.Console;
import java.util.Scanner;

public class servicioAhorcado {
    private final Scanner leer;
    private final Console console = System.console();
        
    public servicioAhorcado() {
        leer = new Scanner(System.in, "UTF-8");
        /*
        if (console == null) {
            System.err.println("No console available");
            System.exit(1);
        }*/
    }

    public Ahorcado setAhorcado() {
        String palabra;
        int intentos;

        cls();

        //palabra = new String(console.readPassword("Ingrese una palabra para jugar: "));
        System.out.print("Ingrese una palabra para jugar: ");
        palabra = leer.nextLine();
        palabra = palabra.toLowerCase();
        //System.out.print("Ingrese una palabra para jugar: ");
        //palabra = leer.nextLine();

        System.out.print("Ingrese la cantidad de intentos: ");
        intentos = leer.nextInt();
        leer.nextLine();    

        return new Ahorcado(palabra, intentos);
    }

    public void jugar() {
        Ahorcado ahorcado = setAhorcado();
        ahorcado.jugar();
    }

    /* CLS */
    public void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}