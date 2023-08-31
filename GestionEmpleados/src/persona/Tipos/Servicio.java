package persona.Tipos;

public class Servicio extends Empleado {
    
    String seccion;

    public Servicio() {
        super("Servicio");
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }
    
    @Override
    public String toString() {
        String msg = super.toString();
        msg += "\n SECCION: " + seccion;
        return msg;
    }
}
