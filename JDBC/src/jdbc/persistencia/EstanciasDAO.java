package jdbc.persistencia;

import jdbc.entidades.Estancias;


public class EstanciasDAO extends DAO implements EstanciasInterfaceDAO {


    public void guardarEstancia(Estancias estancia) throws Exception{
        try {
            if(estancia == null){
                throw new Exception("Debe indicar una estancia!");
            }
            
            String sql = "INSERT INTO estancias (id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) VALUES ( '" 
                    + estancia.getId_estancia() + "', '" + estancia.getId_cliente()+ "', '" + estancia.getId_casa()+  "', '" 
                    + estancia.getNombre_huesped()+  "', '" + estancia.getFecha_desde()+ "', '" + estancia.getFecha_hasta()+ "')";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarEstancia(Estancias estancia) throws Exception {
        try {
            if(estancia == null){
                throw new Exception("Debe indicar una estancia!");
            }
            
            String sql = "UPDATE estancias SET nombre_huesped = '" + estancia.getNombre_huesped()+ "' WHERE id_estancia = '" + estancia.getId_estancia()+ "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarEstancia(Estancias estancia) throws Exception {
        int id_estancia = estancia.getId_estancia();
        try {     
            String sql = "DELETE FROM estancias WHERE nombre = '" + id_estancia + "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}