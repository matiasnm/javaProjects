package ahorcado;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class Ahorcado {
    
    private Scanner leer = new Scanner(System.in, "UTF-8");
    //leer.useLocale(new Locale("es", "ES"));

// constantes
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String ORANGE = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    private static final String[] tipito = {
        "  \u2554\u2550\u2550\u2557     \n" +
        "  \u2551  \u2580     \n" +
        "  \u2551        \n" +
        "  \u2551        \n" +
        " \u252C\u2551\u252C\u252C\u252C\u252C\u252C   ",
        "  \u2554\u2550\u2550\u2557     \n" +
        "  \u2551  O     \n" +
        "  \u2551        \n" +
        "  \u2551        \n" +
        " \u252C\u2551\u252C\u252C\u252C\u252C\u252C   ",
        "  \u2554\u2550\u2550\u2557     \n" +
        "  \u2551  O     \n" +
        "  \u2551  \u2591     \n" +
        "  \u2551        \n" +
        " \u252C\u2551\u252C\u252C\u252C\u252C\u252C   ",
        "  \u2554\u2550\u2550\u2557     \n" +
        "  \u2551  O     \n" +
        "  \u2551 (\u2591     \n" +
        "  \u2551        \n" +
        " \u252C\u2551\u252C\u252C\u252C\u252C\u252C   ",
        "  \u2554\u2550\u2550\u2557     \n" +
        "  \u2551  O     \n" +
        "  \u2551 (\u2592\\     \n" +
        "  \u2551        \n" +
        " \u252C\u2551\u252C\u252C\u252C\u252C\u252C   ",
        "  \u2554\u2550\u2550\u2557     \n" +
        "  \u2551  O     \n" +
        "  \u2551 (\u2592\\     \n" +
        "  \u2551 /      \n" +
        " \u252C\u2551\u252C\u252C\u252C\u252C\u252C   ",
        "  \u2554\u2550\u2550\u2557     \n" +
        "  \u2551  |     \n" +
        "  \u2551  O     \n" +
        "  \u2551 /\u2593\\     \n" +
        "  \u2551 ( )    \n" +
        "  \u2551        \n" +
        " \u252C\u2551\u252C\u252C\u252C\u252C\u252C   ",
    };
//parametros

    String palabra;

    // set de letras usadas y letras de la palabra
    Set<Character> letrasUsadas = new HashSet<>();
    Set<Character> letrasPalabra = new HashSet<>();

    //contadores
    private int intentos;
    private int aciertos;
    private int estado;
    private double segmento;

//constructor parametrizado
    public Ahorcado(String palabra, int intentos) {
        this.palabra = palabra;
        this.intentos = intentos;
        this.aciertos = 0;
        
        // estado del tipito y valor del segmento
        this.estado = 0;
        this.segmento = (double) this.intentos / 6;
        setLetras();
    }

//constructor vacio
    public Ahorcado() {
    }
    

//metodos

    //metodo principal del juego
    public void jugar() {
        do {
            cls();//limpia la pantalla
            showAhorcado();//dibuja el ahorcado y la palabra a adivinar
            char input = getUserInput();
            if (getMatch(input)) {
                System.out.println("Letra encontrada!");
                setAciertos(); // aciertos +1
            } else {
                System.out.println("Letra incorrecta!");
                setIntentos(); // intentos -1
            };
            setLetrasUsadas(input); // guarda la nueva letra en usadas
            setEstado(); // actualiza estado del tipito
            if (getGanar()) {
                System.out.println("Ganaste!, la palabra es: " + PURPLE + this.palabra);
                System.out.print(RESET);
            } else if (getPerder()) {
                showPerder();
            }
        // repetir mientras no gané ni perdí...
        } while (!getPerder() && !getGanar());
    leer.close();
    }


    // crea el set de letras a encontrar de acuerdo a this.palabra
    private void setLetras() {
        for (char c : this.palabra.toCharArray()) {
            this.letrasPalabra.add(c);
        }
    }

    public void showAhorcado() {
        System.out.print(GREEN);
        System.out.println(tipito[this.estado]);

        System.out.print(BLUE);
        for (int i=0; i<this.palabra.length(); i++) {
            System.out.print("╔═\u2550\u2550\u2557 ");
        }

        System.out.println();
        for (char c : this.palabra.toCharArray()) {
            if (getLetrasUsadas(c)) {
                System.out.print("║ " + ORANGE + c + BLUE + " ║ ");
            } else {
                System.out.print("║ " + "_" + " ║ ");
            }
        }

        System.out.print(BLUE);
        System.out.println();
        for (int i=0; i<this.palabra.length(); i++) {
            System.out.print("╚\u2550\u2550═\u255D ");
        }

        System.out.println(PURPLE);
        System.out.println("Quedan " + getIntentos() + " intentos.");
        showUsadas(); // muestra todas las letras del set letrasUsadas

        System.out.println(RESET);
    }

    /* CLS */
    public void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // recibe input del usario, un char o un string (varias letras!)
    public char getUserInput() {
        System.out.print("Ingrese una letra: ");
        String input;
        char letra = ' ';
        do {
            input = leer.nextLine();
            input = input.toLowerCase();
            if (input.length() == 1) {
                letra = input.charAt(0); 
                if (getLetrasUsadas(letra)) {
                    System.out.print(RED + "Ya usaste esta letra. Ingresa otra: " + RESET);
                    continue;
                }
            } else if (input.length() > 1) {
                System.out.println("No se que hacer con varias letras");
                break;
            }
        } while (getLetrasUsadas(letra));
        return letra;
    }

    public int getLongitud() {
        return this.palabra.length();
    }

    public int getIntentos() {
        return this.intentos;
    }

    public void setIntentos() {
        this.intentos -= 1;
    }

    public void setEstado() {
        this.estado = Math.min((int)(6 - (int)Math.ceil((double)this.intentos / this.segmento)), 5);   
    }

    // agrega letra a this.letrasUsadas
    public void setLetrasUsadas(char letra) {
        this.letrasUsadas.add(letra);
    }

    // verifica si la letra esta en this.letrasUsadas o no
    public boolean getLetrasUsadas(char letra) {
        if (this.letrasUsadas.contains(letra)) {
            return true;
        }
        return false;
    }

    // imprime las letras que ya usaste
    public void showUsadas() {
        if (this.letrasUsadas.size() > 0) {
            System.out.print("Las letras que usaste son: ");
            for (Character element : this.letrasUsadas) {
                System.out.print(element + " ");
            }
            System.out.println("");
        }
    }

    // imprime las letras que hay que descubir
    public void showLetras() {
        System.out.print("Las letras que hay que descubir son: ");
        for (Character element : this.letrasPalabra) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }

    // devuelve True si la letra forma parte de la palabra
    public boolean getMatch(char letra) {
        for (char c : this.palabra.toCharArray()) {
            if (letra == c) {
                return true;
            }
        }
        return false;
    }

    // incrementa anciertos en 1
    public void setAciertos() {
        this.aciertos += 1;
    }

    // muestra letras adivinadas
    public void showAciertos() {
        // interseccion de usadas y letras
        final Set<Character> interseccion = new HashSet<>(this.letrasUsadas);
        interseccion.retainAll(this.letrasPalabra);

        System.out.print("Letras adivinadas: ");
        for (char element : interseccion) {
            System.out.print(element);
        }
        System.out.println("");
    }

    // letras faltantes
    public int getFaltantes() {
        int count = 0; 
        for (char c : this.palabra.toCharArray()) {
            if (!this.letrasUsadas.contains(c)) {
                count++;
            }
        }     
        return count;
    }

    // true si ya ganaste el juego sino false
    public boolean getGanar() {
        if (this.aciertos == this.letrasPalabra.size()) {
            return true;
        }
        return false;
    }

    // true si perdiste
    public boolean getPerder() {
        if (this.intentos == 0) {
            return true;
        }
        return false;
    }

    public void showPerder() {
        cls();
        System.out.print(RED);
        System.out.println(tipito[6]);
        System.out.println("");
        System.out.println("  MORIDO ");
        System.out.print(RESET);
    }
}