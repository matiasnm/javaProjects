package jdbc.persistencia;

import java.util.ArrayList;
import java.util.Collection;

import jdbc.entidades.Casas;


public class CasasDAO extends DAO implements CasasInterfaceDAO{


    public void guardarCasas(Casas casa) throws Exception{
        try {
            if(casa == null){
                throw new Exception("Debe indicar una casa!");
            }
            
            String sql = "INSERT INTO casas (id_casa, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda) VALUES ( '" 
                    + casa.getId_casa()+ "', '" + casa.getCalle()+ "', '" + casa.getNumero()+ "', '" 
                    + casa.getCodigo_postal()+ "', '" + casa.getCiudad()+ "', '" + casa.getPais()+ "', '" + casa.getFecha_desde()+ "', '" 
                    + casa.getFecha_hasta()+ "', '" + casa.getTiempo_minimo()+ "', '" + casa.getTiempo_maximo()+ "', '" + casa.getPrecio_habitacion()+ "', '" 
                    + casa.getTipo_habitacion()+ "')";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    

    public void modificarCasas(Casas casa) throws Exception {
        try {
            if(casa == null){
                throw new Exception("Debe indicar una casa!");
            }
            
            String sql = "UPDATE casas SET numero = '" + casa.getNumero()+ "' WHERE id_casa = '" + casa.getId_casa()+ "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    

    public void eliminarCasas(Casas casa) throws Exception {
        int id_casa = casa.getId_casa();
        try {     
            String sql = "DELETE FROM casas WHERE nombre = '" + id_casa + "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public Collection<Casas> listarCasasDisponibles() throws Exception{
        try {     
            String sql = "SELECT * FROM casas WHERE pais = 'Reino Unido' AND fecha_desde = '2020-08-01' AND fecha_hasta = '2020-08-31'";

            consultarBase(sql);
            
            
            Casas casa = null;
            
            Collection<Casas> casas = new ArrayList();
            
            while(resultado.next()){
                casa = new Casas();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigo_postal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));            
                casa.setFecha_desde(resultado.getDate(7));
                casa.setFecha_hasta(resultado.getDate(8));
                casa.setTiempo_minimo(resultado.getInt(9));
                casa.setTiempo_maximo(resultado.getInt(10));
                casa.setPrecio_habitacion(resultado.getFloat(11));
                casa.setTipo_habitacion(resultado.getString(12));            
                casas.add(casa);
            }
            
            desconectarBase();
            
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }


    public Collection<Casas> OpcionD() throws Exception{

        String fecha = "'2021-05-01'";
        String dias = "15";

        try {     
            String sql = "SELECT * FROM casas WHERE ADDDATE(" + fecha + ", INTERVAL " +
            dias + " DAY) <= fecha_hasta AND " + fecha + " >= fecha_desde AND " +
            dias + " >= tiempo_minimo AND " + dias + " <= tiempo_maximo;";

            consultarBase(sql);
            
            
            Casas casa = null;
            
            Collection<Casas> casas = new ArrayList();
            
            while(resultado.next()){
                casa = new Casas();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigo_postal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));            
                casa.setFecha_desde(resultado.getDate(7));
                casa.setFecha_hasta(resultado.getDate(8));
                casa.setTiempo_minimo(resultado.getInt(9));
                casa.setTiempo_maximo(resultado.getInt(10));
                casa.setPrecio_habitacion(resultado.getFloat(11));
                casa.setTipo_habitacion(resultado.getString(12));            
                casas.add(casa);
            }
            
            desconectarBase();
            
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
