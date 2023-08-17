package carta;


public class Carta {
    
    static private final String PALOS[] = {"Bastos", "Copas", "Espadas", "Oros"};
    
    // 1 - 7, 10 - 12
    private int num;
    // 0, 1, 2, 3
    private int palo;

    public Carta(int num, int palo) {
        this.num = num;
        this.palo = palo;
    }

    public Carta() {
    }

    public int getNum() {
        return num;
    }

    public int getPalo() {
        return palo;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return num + " de " + PALOS[palo];
    }    
}
