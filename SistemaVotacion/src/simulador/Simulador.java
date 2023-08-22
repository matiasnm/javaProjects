package simulador;

import alumno.Alumno;
import generadorAlumno.GeneradorAlumno;
import generadorDNI.GeneradorDNI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import voto.Voto;

public class Simulador {
    
    GeneradorDNI dniGenerador = new GeneradorDNI();
    GeneradorAlumno alumnoGenerador = new GeneradorAlumno();
    Random random = new Random();
    List<Voto> votos = new ArrayList();
    
    public Simulador() {
    }
    
    // Crea y devuelve un listado de n alumnos
    public List<Alumno> crearLista(int n) {
        List<Alumno> lista = new ArrayList();
        for (int i=0; i<n; i++) {
            int dni = dniGenerador.generar();
            Alumno nuevoAlumno = alumnoGenerador.generar(dni);
            lista.add(nuevoAlumno);
        }
        return lista;
    }
    
    // Implementación usando la clase Voto
    public void votacion(List<Alumno> lista, int cantidadVotaciones) {
        int cantidad = lista.size();
        if (cantidad < cantidadVotaciones) {
            throw new IllegalArgumentException("Insuficientes alumnos(" + cantidad + ") para simular un sistema de " + cantidadVotaciones + " votaciones por alumno.");
        }
        lista.forEach((Alumno votante) -> {
            Set<Alumno> controlVotos = new HashSet();
            List<Alumno> votados = new ArrayList();
            Voto nuevoVoto = new Voto();
            nuevoVoto.setVotante(votante);
            int votaciones = 0;
            while (votaciones < cantidadVotaciones) {
                int randomIndice = random.nextInt(cantidad);
                Alumno alumnoVotado = lista.get(randomIndice);
                if (alumnoVotado != votante && !(controlVotos.contains(alumnoVotado))) {
                    controlVotos.add(alumnoVotado);       
                    alumnoVotado.addVoto();
                    votados.add(alumnoVotado);
                    votaciones += 1;
                }
            }
            nuevoVoto.setVotados(votados);
            votos.add(nuevoVoto);
        });
    }
    
    
    // Imprimir resultados lista votos
    public void resultados() {
        votos.forEach( (Voto voto) -> {
            Alumno votante = voto.getVotante();
            System.out.println("\n" + votante.getNombre().toUpperCase() + " consiguió " + votante.getVotos() + " votos");
            System.out.println("Votó a:");
            voto.getVotados().forEach( (Alumno alumno) -> {
                System.out.println("\t" + alumno.getNombre());
            });
        });
    }
    
    
    // Implementación usando HashMap, sin utilizar la clase Voto
    public void votacionConMapa(List<Alumno> lista, int cantidadVotaciones) {
        Map<Alumno, Set<Alumno>> resultados = new HashMap();
        int cantidad = lista.size();
        if (cantidad < cantidadVotaciones) {
            throw new IllegalArgumentException("Insuficientes alumnos(" + cantidad + ") para simular un sistema de " + cantidadVotaciones + " votaciones por alumno.");
        }
        lista.forEach((key) -> {
            resultados.put(key, null);
        });
        
        resultados.keySet().forEach((Alumno alumno) -> {
            Set<Alumno> votados = new HashSet<>();
            //List<Integer> resultados;
            //resultados = new ArrayList<>();
            int votaciones = 0;
            while (votaciones < cantidadVotaciones) {
                int randomIndice = random.nextInt(cantidad);
                Alumno alumnoVotado = lista.get(randomIndice);
                if (!votados.contains(alumnoVotado) && alumno != alumnoVotado) {
                    alumnoVotado.addVoto();
                    votados.add(alumnoVotado);
                    votaciones += 1;
                }
            }
            resultados.put(alumno, votados);
        });
        
        // Imprimir listado de resultados!
        resultados.entrySet().forEach((entry) -> {
            Alumno key = entry.getKey();
            Set<Alumno> value = entry.getValue();
            System.out.println("\n" + key.getNombre().toUpperCase() + " votó a:");
            value.forEach(alumno -> {
                System.out.println("\t" + alumno.getNombre());
            });
        });
        
        // Imprimir más votado
        Comparator comparador = Comparator.comparingInt(Alumno::getVotos).reversed();
        Collections sort;
        Collections.sort(lista, comparador);
        Alumno ganador = lista.get(0);
        System.out.println("\nEl más votado es " + ganador.getNombre().toUpperCase() + " con " + ganador.getVotos() + " votos.");
    }
}