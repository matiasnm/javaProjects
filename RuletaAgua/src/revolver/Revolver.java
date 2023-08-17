package revolver;

public class Revolver {

    private int tambor;
    private int agua;

    public void cargar() {
        tambor = (int) Math.floor(6 * Math.random());
        agua = (int) Math.floor(6 * Math.random());
    }

    public Boolean mojar() {
        return tambor == agua;
    }

    public void siguiente() {
        tambor += 1;
        if (tambor >= 6) {
            tambor = 0;
        }
    }

    public void setTambor(int tambor) {
        this.tambor = tambor;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getTambor() {
        return tambor;
    }

    public int getAgua() {
        return agua;
    }
    
    @Override
    public String toString() {
        return "Posición actual:" + tambor + "\tAgua:" + agua;
    }
}
