package jdbc.persistencia;

import jdbc.entidades.Estancias;

public interface EstanciasInterfaceDAO {
    public void guardarEstancia(Estancias estancia) throws Exception;
	public void modificarEstancia(Estancias estancia) throws Exception;
	public void eliminarEstancia(Estancias estancia) throws Exception;
}