package baraja;

import carta.Carta;
import java.util.ArrayList;
import java.util.List;
import mazo.Mazo;

// sistema de 2 mazos, uno contabiliza el descarte
public class Baraja {
    

    public Mazo mazo = new Mazo();
    
    // descarte considera todas las cartas qeu sacamos el mazo
    public Mazo descarte = new Mazo();
    
    public Baraja() {
    }
    
    public void barajar() {
        mazo.barajar();
    }
    
    //remueve una carta del mazo, la agrega a descartes y la devuelve
    public Carta sacarCarta() {
        Carta carta = mazo.sacarCarta();
        descarte.ponerCarta(carta);
        return carta;
    }
    
    //idem con lista de cartas
    public List<Carta> darCartas(int n) {
        List<Carta> mano = new ArrayList<>();
        for (int i=0; i<n; i++) {
            mano.add(mazo.sacarCarta());
        }
        descarte.ponerCartas(mano);
        return mano;
    }
    
    //imprime el mazo
    public void mostrarMazo() {
        mazo.verCartas();
    }
    
    //imprime el mazo
    public void mostrarDescarte() {
        descarte.verCartas();
    }
    
    public int cantidadMazo() {
        return mazo.cantidadCartas();
    }
    
    public int cantidadDescarte() {
        return descarte.cantidadCartas();
    }
    
    public void cartasDescarte() {
        System.out.println("Vacío");
    }   
}