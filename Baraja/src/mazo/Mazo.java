package mazo;

import carta.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Mazo {
    public List<Carta> cartas = new ArrayList<>();
      
    
    public Mazo() {
    }
    
    public Mazo(List<Carta> listaCartas) {
        cartas = listaCartas;
    }
    
    public int cantidadCartas() {
        return cartas.size();
    }
    
    public void barajar() {
        Collections.shuffle(cartas);
    }
    
    public Boolean ponerCarta(Carta c) {
        cartas.add(c);
        return true;
    }
    
    public Boolean ponerCartas(List<Carta> mano) {
        cartas.addAll(mano);
        return true;
    }
    
    public Carta sacarCarta() {
        return cartas.remove(0);
    }
    
    // usar enum
    // crea un mazo con numeros del 1-7, 10-12
    public void crearMazo() {
        for (int i=1; i<13; i++) {
            if ((i==7) || (i==8)) {
                continue;
            }
            for (int j=0; j<4; j++) {
                Carta carta = new Carta(i, j);
                cartas.add(carta);
            }
        }
    }
    
    public void verCartas() {
        if (cartas.isEmpty()) {
            System.out.println("Vacío");
            return;
        }
        cartas.forEach((Carta carta) -> {
            System.out.println(carta);
        });
    }    
}