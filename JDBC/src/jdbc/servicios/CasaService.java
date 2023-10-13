package jdbc.servicios;

import jdbc.entidades.Casas;
import jdbc.persistencia.CasasDAO;
import java.util.Collection;


public class CasaService {


    private CasasDAO dao;


    public CasaService() {
        this.dao = new CasasDAO();
    }
    
    
    public Collection<Casas> listarCasas() throws Exception {
        
        try {
            Collection<Casas> familias = dao.listarCasasDisponibles();
            
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }
    

    public void imprimirCasas() throws Exception {
        try {
            Collection<Casas> casas = listarCasas();
            
             if (casas.isEmpty()) {
                throw new Exception("No existen casas para imprimir");
            } else {
                for(Casas c : casas){
                    System.out.println(c);
                }
            }     
        } catch (Exception e) {
            throw e;
        }
    }


    public void OpcionD() throws Exception {
        try {
            Collection<Casas> casas = dao.OpcionD();
            
             if (casas.isEmpty()) {
                throw new Exception("No existen casas para imprimir");
            } else {
                for(Casas c : casas){
                    System.out.println(c);
                }
            }     
        } catch (Exception e) {
            throw e;
        }
    }
}