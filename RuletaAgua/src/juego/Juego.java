package juego;

import jugador.Jugador;
import java.util.ArrayList;
import revolver.Revolver;

public class Juego {

    private ArrayList<Jugador> jugadores;
    private Revolver revolver;

    public Void setup(ArrayList<Jugador> j, Revolver r) {
        revolver = r;
        jugadores = j;
        return null;
    }

    public Boolean jugar() {
        revolver.cargar();
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println("\nRevolver: " + revolver);
                Jugador j = jugadores.get(i);
                System.out.println("Jugador " + j.getNombre() + " dispara:");
                if (j.disparar(revolver)) {
                        System.out.println("Agua de plomo, " + j.getNombre() + " se voló la cabeza.");
                        juegoTerminado = true;
                        break;
                    }
                System.out.println("...nada...");
            }
        }
        return juegoTerminado;
    }
}
