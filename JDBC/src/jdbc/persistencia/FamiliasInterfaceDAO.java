package jdbc.persistencia;

import java.util.Collection;

import jdbc.entidades.Familias;

public interface FamiliasInterfaceDAO {
    public Collection<Familias> listarFamilias() throws Exception;
    public void guardarFamilia(Familias familia) throws Exception;
    public void modificarFamilia(Familias familia) throws Exception;
    public void eliminarFamilia(Familias familia) throws Exception;
}