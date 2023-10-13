package jdbc.servicios;

import jdbc.entidades.Familias;
import jdbc.persistencia.FamiliasDAO;
import java.util.Collection;


public class FamiliasService {


    private FamiliasDAO dao;


    public FamiliasService() {
        this.dao = new FamiliasDAO();
    }
    
    
    public Collection<Familias> listarFamilias() throws Exception {    
        try {
            Collection<Familias> familias = dao.listarFamilias();
            
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }
    

    public void imprimirFamilias() throws Exception {
        try {        
            Collection<Familias> familias = listarFamilias();
            
             if (familias.isEmpty()) {
                throw new Exception("No existen familias para imprimir");
            } else {
                for(Familias f : familias){
                    System.out.println(f);
                }
            }     
        } catch (Exception e) {
            throw e;
        }
    }

    public void FamiliasEmail() throws Exception {
        try {        
            Collection<Familias> familias = dao.listarFamiliasEmail();
            
             if (familias.isEmpty()) {
                throw new Exception("No existen familias para imprimir");
            } else {
                for(Familias f : familias){
                    System.out.println(f);
                }
            }     
        } catch (Exception e) {
            throw e;
        }

    } 
}