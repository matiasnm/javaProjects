package generadorAlumno;

import java.util.Random;
import alumno.Alumno;


public class GeneradorAlumno {
    
    private final Random random = new Random();
    
    private static final String[] SILABAS = {"ba", "be", "bi", "bo", "bu", "ca", "ce", "ci", "co", "cu",
            "da", "de", "di", "do", "du", "fa", "fe", "fi", "fo", "fu", "ga", "ge", "gi", "go", "gu", "gu",
            "ha", "he", "hi", "ho", "hu", "ja", "je", "ji", "jo", "ju", "ka", "ke", "ki", "ko", "ku",
            "la", "le", "li", "lo", "lu", "ma", "me", "mi", "mo", "mu", "na", "ne", "ni", "no", "nu",
            "pa", "pe", "pi", "po", "pu", "ra", "re", "ri", "ro", "ru", "sa", "se", "si", "so", "su",
            "ta", "te", "ti", "to", "tu", "va", "ve", "vi", "vo", "vu", "za", "ze", "zi", "zo", "zu"};

    public Alumno generar(int dni) {
        String nombre = randomNombre(2) + " " + randomNombre(3);
        int votos = 0;
        Alumno alumno = new Alumno(nombre, dni, votos);
        return alumno;
    }
    
    public String randomNombre(int minSilabas) {
        String nombre = "";
        int longitud = random.nextInt(4) + minSilabas;
        for (int i = 0; i < longitud; i++) {
            nombre += SILABAS[random.nextInt(SILABAS.length)];
        }
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }
}
