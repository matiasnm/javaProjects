package cuadrado;
import figura.Figura;


public class Cuadrado extends Figura{
    
   private final double lado;

    public Cuadrado(double lado) {
        super("Cuadrado");
        this.lado = lado;
    }
    
    @Override
    public double getArea() {
        return lado * lado;
    }

    @Override
    public double getPerimetro() {
        return lado * 4;
    }
    
    @Override
    public String toString() {
        return ("\nNombre: " + this.getName() +
        "\nLado: " + this.lado +
        "\nArea: " + this.getArea() +
        "\nPerimetro: " + this.getPerimetro());
    }
}