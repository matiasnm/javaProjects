
package persona;

import java.util.Scanner;


public class servicioPersona {
    
    private final Scanner leer = new Scanner(System.in, "UTF-8");
    private static final String[] ESTADOS = {"Indefinido", "Soltera", "Casada", "Divorciada", "Viuda"};
    
    
    public void cambiarEstadoCivil(Persona persona) {
        System.out.println("Elegir ESTADO CIVIL:");
        for(int i=0; i<ESTADOS.length; i++) {
            System.out.println(i + ".-" + ESTADOS[i]);
        }
        int menu = 0;
        while (true) {
            menu = leer.nextInt();
            if ((menu < 0) || (menu > 4)) {
                System.out.println("Opción incorrecta.");
            } else {
                break;
            }
        }
        persona.setEstado(menu);
    }
    
    public void cambiarEstadoCivil(Persona persona, int estado) {
        persona.setEstado(estado);
    }
    
    public void setDatosPersonales(Persona persona, String nombre, String apellido, int dni, int estado) {
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setDni(dni);
        persona.setEstado(estado);
    }
    
    public void setNombre(Persona persona, String nombre) {
        persona.setNombre(nombre);
    }

    public void setApellido(Persona persona, String apellido) {
        persona.setApellido(apellido);
    }

    public void setDni(Persona persona, int dni) {
        persona.setDni(dni);
    }

    public void setEstado(Persona persona, int estado) {
        persona.setEstado(estado);
    }
}