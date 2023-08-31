package persona.Tipos;

import persona.servicioPersona;

public class servicioProfesor extends servicioPersona{
    
    public Profesor crear() {
        Profesor profesor = new Profesor();
        return profesor;
    }
    
    
    public Profesor crear(String nombre, String apellido, int dni, int estado, String deparatamento) {
        Profesor profesor = new Profesor();
        profesor.setDatos(nombre, apellido, dni, estado);
        profesor.setDeparatamento(deparatamento);
        return profesor;
    }
    
    
    public void setDeparatamento(Profesor profesor, String deparatamento) {
        profesor.setDeparatamento(deparatamento);
    }

}