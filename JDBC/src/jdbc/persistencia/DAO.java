package jdbc.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class DAO {

    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB = "estancias_exterior"; 
    private final String USER = "root";
    private final String PASS = "root";

    protected Connection conexion;
    protected ResultSet resultado;
    protected Statement sentencia;


    protected void conectarBase() throws Exception {
        try {
            conexion = DriverManager.getConnection(URL + DB, USER, PASS);
        } catch (SQLException ex) {
            throw ex;
        }
    }


    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }


    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }


    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {            
            throw ex;
        } finally {
            desconectarBase();
        }
    }

}