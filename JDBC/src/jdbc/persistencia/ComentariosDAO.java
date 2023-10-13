package jdbc.persistencia;

import jdbc.entidades.Comentarios;


public class ComentariosDAO extends DAO implements ComentariosInterfaceDAO{


    public void guardarComentarios(Comentarios comentario) throws Exception{
        try {
            if(comentario == null){
                throw new Exception("Debe indicar un comentario!");
            }
            
            String sql = "INSERT INTO comentarios (id_comentario, id_casa, comentario) VALUES ( '" 
                    + comentario.getId_comentario() + "', '" + comentario.getId_casa()+ "', '" + comentario.getComentario()+ "')";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    

    public void modificarComentarios(Comentarios comentario) throws Exception {
        try {
            if(comentario == null){
                throw new Exception("Debe indicar un comentario!");
            }
            
            String sql = "UPDATE comentarios SET comentario = '" + comentario.getComentario()+ "' WHERE id_comentario = '" + comentario.getId_comentario()+ "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public void eliminarComentarios(Comentarios comentario) throws Exception {
        int id_comentario = comentario.getId_comentario();
        try {     
            String sql = "DELETE FROM comentarios WHERE nombre = '" + id_comentario + "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}