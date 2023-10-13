package jdbc.persistencia;

import java.util.ArrayList;
import java.util.Collection;

import jdbc.entidades.Familias;


public class FamiliasDAO extends DAO implements FamiliasInterfaceDAO {
    

    public void guardarFamilia(Familias familia) throws Exception{
        try {
            if(familia == null){
                throw new Exception("Debe indicar una familia!");
            }
            String sql = "INSERT INTO familias (id_familia, nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) VALUES ( '" 
                    + familia.getId_familia() + "', '" + familia.getNombre()+ "', '" + familia.getEdad_minima() +  "', '" 
                    + familia.getEdad_maxima() +  "', '" + familia.getNum_hijos() + "', '" + familia.getEmail() + "', '" 
                    + familia.getId_casa_familia() + "')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    

    public void modificarFamilia(Familias familia) throws Exception {
        try {
            if(familia == null){
                throw new Exception("Debe indicar una familia!");
            }
            String sql = "UPDATE familias SET nombre = '" + familia.getNombre()+ "' WHERE nombre = '" + familia.getNombre()+ "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }


    public void eliminarFamilia(Familias familia) throws Exception {
        String nombre = familia.getNombre();
        try {     
            String sql = "DELETE FROM familias WHERE nombre = '" + nombre + "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Familias> listarFamiliasEmail() throws Exception {
    try {
            String sql = "SELECT * FROM familias WHERE email LIKE '%hotmail%';";
            consultarBase(sql);
            Familias familia = null;

            Collection<Familias> familias = new ArrayList();
            while(resultado.next()){
                familia = new Familias();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));            
                familia.setEmail(resultado.getString(6));
                familia.setId_casa_familia(resultado.getInt(7));
                familias.add(familia);
            } 
            desconectarBase();    
            return familias;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }      
        

    public Collection<Familias> listarFamilias() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE num_hijos >= 3 AND edad_maxima < 10";
            consultarBase(sql);
            Familias familia = null;

            Collection<Familias> familias = new ArrayList();
            while(resultado.next()){
                familia = new Familias();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));            
                familia.setEmail(resultado.getString(6));
                familia.setId_casa_familia(resultado.getInt(7));
                familias.add(familia);
            } 
            desconectarBase();    
            return familias;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }  
}