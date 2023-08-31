package profesor;


import org.junit.Test;
import static org.junit.Assert.*;

import persona.Tipos.Servicio;
import persona.Tipos.servicioServicio;

import persona.Tipos.Profesor;
import persona.Tipos.servicioProfesor;

import persona.Tipos.Alumno;
import persona.Tipos.servicioAlumno;

import persona.servicioPersona;


public class TestGeneral {
    
    public TestGeneral() {
    }
    
    @Test
    public void testVarios() {
        
        
        // crea alumno usando servicios propios de cada clase
        servicioAlumno servicioAlumno = new servicioAlumno();
        Alumno alumno = servicioAlumno.crear("Jimbo", "Jones", 32464342, 1, "Matemática");

        // crea profesor usando servicios propios de cada clase
        servicioProfesor servicioProfe = new servicioProfesor();
        Profesor profe = servicioProfe.crear("Seymour", "Skinner", 2365132, 1, "Geografía");
        
          
        // crea un 'personal de Servicio' vacio
        servicioServicio servicioServicio = new servicioServicio();
        Servicio servicio = servicioServicio.crear();
        // llena los datos usando metodo heredado de clase Persona
        servicioServicio.setDatosPersonales(servicio, "William", "McDougal", 13432321, 4);
        // agrego la 'seccion' usando el metodo propio de la clase Servicio ('personal de Servicio')
        servicioServicio.setSeccion(servicio, "Jardinería");
        
        
        // crea un servicioPersona 
        servicioPersona servicioPersona = new servicioPersona();
        // cambia estado civil a profe
        servicioPersona.cambiarEstadoCivil(profe, 2);
        // cambia dni a alumno
        servicioPersona.setDni(alumno, 22222222);
                
        System.out.println(profe);
        System.out.println(alumno);
        System.out.println(servicio);
    }   
}