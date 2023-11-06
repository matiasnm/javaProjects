package com.egg.noticias.repositorios;

import com.egg.noticias.entidades.Noticia;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, String> { //<Clase, id>
    
    @Query("SELECT n FROM Noticia n WHERE n.titulo LIKE %:titulo%")
    public List<Noticia> buscarPorTitulo(@Param("titulo") String titulo);
}