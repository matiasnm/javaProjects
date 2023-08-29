package figura;

public abstract class Figura {

    protected String name;

    public Figura(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract double getArea();
    public abstract double getPerimetro();
}
