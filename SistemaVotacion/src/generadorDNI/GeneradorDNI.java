
package generadorDNI;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class GeneradorDNI {
    
    private static final int MIN_DNI = 10000000;
    private static final int MAX_DNI = 99999999;
    private static final int INTENTOS = 1000;

    private final Set<Integer> DNIs = new HashSet<>();
    private final Random random = new Random();
        
    private int randomDNI() {
        return random.nextInt(MAX_DNI - MIN_DNI + 1) + MIN_DNI;
    }

    public int generar() {
        for (int i = 0; i < INTENTOS; i++) {
            int randomDNI = randomDNI();
            if (!DNIs.contains(randomDNI)) {
                DNIs.add(randomDNI);
                return randomDNI;
            }
        }
        throw new IllegalStateException("Fállo en la generación de DNI único luego de " + INTENTOS + " intentos.");
    }
}