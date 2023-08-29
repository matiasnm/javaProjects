
package circulo;

import figura.Figura;


public class Circulo extends Figura {

   private final double radio;

    public Circulo(double radius) {
        super("Círculo");
        this.radio = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    @Override
    public String toString() {
        return ("\nNombre: " + this.getName() +
        "\nRadio: " + this.radio +
        "\nArea: " + this.getArea() +
        "\nPerimetro: " + this.getPerimetro());
    }
}