
package persona.Tipos;

import persona.servicioPersona;


public class servicioServicio extends servicioPersona {
    
    
    public Servicio crear() {
        Servicio servicio = new Servicio();
        return servicio;
    }
    
    
    public Servicio crear(String nombre, String apellido, int dni, int estado, String seccion) {
        Servicio servicio = new Servicio();
        servicio.setDatos(nombre, apellido, dni, estado);
        servicio.setSeccion(seccion);
        return servicio;
    }
    
    
    public void setSeccion(Servicio servicio, String seccion) {
        servicio.setSeccion(seccion);
    }
}