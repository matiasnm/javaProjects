package persona.Tipos;

public class Profesor extends Empleado {
    
    String deparatamento;
    
    protected Profesor() {
        super("Profesor");
    }

    protected void setDeparatamento(String deparatamento) {
        this.deparatamento = deparatamento;
    }

    protected String getDeparatamento() {
        return deparatamento;
    }
    
    @Override
    public String toString() {
        String msg = super.toString();
        msg += "\n DEPARTAMENTO: " + deparatamento;
        return msg;
    }
}