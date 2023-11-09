package com.egg.noticias.servicios;

import com.egg.noticias.entidades.Noticia;
import com.egg.noticias.excepciones.CamposVacios;
import com.egg.noticias.repositorios.NoticiaRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NoticiaServicio {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @Transactional
    public void create(String titulo, String cuerpo) throws CamposVacios {
        validar(titulo, cuerpo);
        Noticia noticia = new Noticia(titulo, cuerpo);
        noticiaRepositorio.save(noticia);
    }
    
    @Transactional()//readOnly = true
    public List<Noticia> read() {
        List<Noticia> noticias;
        noticias = noticiaRepositorio.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return noticias;
    }
    
    @Transactional()//readOnly = true
    public Noticia read(String id) {
        Noticia noticia;
        noticia = noticiaRepositorio.getById(id);
        return noticia;
    }

    /*
    @Transactional()//readOnly = true
    public List<Noticia> search(String titulo) {
        List<Noticia> noticias;
        noticias = noticiaRepositorio.buscarPorTitulo(titulo);
        return noticias;
    }
    */

    @Transactional()//readOnly = true
    public List<Noticia> search(String titulo) {
        List<Noticia> noticias;
        noticias = noticiaRepositorio.findByTituloContains(titulo);
        return noticias;
    }

    @Transactional
    public void update(String id, String titulo, String cuerpo) throws CamposVacios{
        validar(titulo, cuerpo);
        
        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);
         
        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticiaRepositorio.save(noticia);
        }
    }
    
    @Transactional
    public void delete(String id) {
        noticiaRepositorio.deleteById(id);
    }

    private void validar(String titulo, String cuerpo) throws CamposVacios{
        if(titulo.isEmpty() || titulo == null){
            throw new CamposVacios("El título de la Noticia no puede estar vacío.");
        }
        if(cuerpo.isEmpty() || cuerpo == null){
            throw new CamposVacios("El cuerpo de la Noticia no puede estar vacío.");
        }
    }
    
}