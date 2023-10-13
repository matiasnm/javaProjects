package jdbc.persistencia;

import jdbc.entidades.Comentarios;

public interface ComentariosInterfaceDAO {
    public void eliminarComentarios(Comentarios comentario) throws Exception;
    public void modificarComentarios(Comentarios comentario) throws Exception;
    public void guardarComentarios(Comentarios comentario) throws Exception;
}
