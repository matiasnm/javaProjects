package com.egg.noticias.controladores;

import com.egg.noticias.entidades.Noticia;
import com.egg.noticias.servicios.NoticiaServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/")
public class NoticiaControlador {
    
    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/error")
    public String error() {
        return "error.html";
    }

    @GetMapping("/")
    public String home(ModelMap modelo) {
        List<Noticia> noticias = noticiaServicio.read();
        modelo.addAttribute("noticias", noticias);
        return "home.html";
    }
    
    @PostMapping("/crear")
    public String createPost(@RequestParam(required=false) String tituloCrear, @RequestParam(required=false) String cuerpoCrear, ModelMap modelo) {
        try {
            noticiaServicio.create(tituloCrear, cuerpoCrear);
            return "redirect:/";
        } 
        catch(Exception ex) {
            Logger.getLogger(NoticiaServicio.class.getName()).log(Level.SEVERE, null, ex);
            return "redirect:/";
        }
    }
       
    @PostMapping("/editar")
    public String updateGet(@RequestParam String id, ModelMap modelo) {
        modelo.put("editar", noticiaServicio.read(id));     
        return home(modelo);
    }

    @PostMapping("/guardar")
    public String updatePost(@RequestParam(required=false) String tituloGuardar, @RequestParam(required=false) String cuerpoGuardar, @RequestParam(required=false) String idGuardar, ModelMap modelo) {
        try {
            noticiaServicio.update(idGuardar, tituloGuardar, cuerpoGuardar);
            return "redirect:/";
        } catch (Exception ex) {
            return "redirect:/";
        }
    }
    
    @PostMapping("/buscar")
    public String search(@RequestParam(required=false) String tituloBuscar, ModelMap modelo) {
        List<Noticia> noticias = noticiaServicio.search(tituloBuscar);
        modelo.addAttribute("noticias", noticias);
        return "home.html";
    }

    @GetMapping("/borrar")
    public String delete(@RequestParam(required=false) String idBorrar, ModelMap modelo) {
        noticiaServicio.delete(idBorrar);
       return "redirect:/";
    }
    
}