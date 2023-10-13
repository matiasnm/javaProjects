package jdbc;

import java.util.Scanner;

import jdbc.servicios.CasaService;
import jdbc.servicios.FamiliasService;

public class JDBC {

    static final String [] MENU = {
        "a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.",
        "b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.",
        "c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.",
        "d) Casas disponibles a partir de una fecha dada y un número de días específico.",
        "e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.",
        "f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó (que reemplazaría a la anterior).",
        "g) Incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.",
        "h) Obtener el número de casas que existen para cada uno de los países diferentes.",
        "i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.",
        "j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas."};

    public static void main(String[] args) throws Exception {
        
        FamiliasService familiaService = new FamiliasService();
        CasaService casaService = new CasaService();
        
        try (Scanner leer = new Scanner(System.in).useDelimiter("\n")) {
            
            String choice = "";
            String options = "abcdefghij";
            Boolean whileCheck = true;

            for (String op : MENU) {
                System.out.println(op);  
            }

            do {
                System.out.println("Selecciona una opcion: ");
                choice = leer.next().strip();
                whileCheck = (!options.contains(choice) || choice.length() > 1);
                
                switch(choice) {
                    case "a":   System.out.println("Opción A");
                                familiaService.imprimirFamilias();
                                break;
                    case "b":   System.out.println("Opción B");
                                casaService.imprimirCasas();
                                break;
                    case "c":   System.out.println("Opción C");
                                familiaService.FamiliasEmail();
                                break;
                    case "d":   System.out.println("Opción D");
                                casaService.OpcionD();
                                break;
                    case "e":   System.out.println("Opción E");
                                //casaService.imprimirCasas();
                                break;
                    case "f":   System.out.println("Opción F");
                                //casaService.imprimirCasas();
                                break;
                    case "g":   System.out.println("Opción G");
                                //familiaService.imprimirFamilias();
                                break;
                    case "h":   System.out.println("Opción H");
                                //casaService.imprimirCasas();
                                break;
                    case "i":   System.out.println("Opción I");
                                //casaService.imprimirCasas();
                                break;
                    case "j":   System.out.println("Opción J");
                                //familiaService.imprimirFamilias();
                                break;                           
                    default:    if (whileCheck) {
                                    System.out.println("Opción incorrecta, intente nuevamente.");
                                } else {
                                    System.out.println("Opción Default");
                                }
                                break;
                }

            } while (whileCheck);
            
            
        } catch (Exception e) {
            throw e;
        }
    }
}