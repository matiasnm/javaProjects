package persona.Tipos;

import persona.Persona;

public class Empleado extends Persona{
    int incorporacion;
    int despacho;

    public Empleado(String tipo) {
        super("Empleado -> " + tipo);
    }

    public void setIncorporacion(int incorporacion) {
        this.incorporacion = incorporacion;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    public int getIncorporacion() {
        return incorporacion;
    }

    public int getDespacho() {
        return despacho;
    }
    
}

