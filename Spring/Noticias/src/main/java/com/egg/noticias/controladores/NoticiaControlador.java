package com.egg.noticias.controladores;

import com.egg.noticias.entidades.Noticia;
import com.egg.noticias.excepciones.CamposVacios;
import com.egg.noticias.servicios.NoticiaServicio;
import java.util.List;

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
/*
 * TODO
 * 3. metodo login
 */

    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/")
    public String home(ModelMap modelo) {
        List<Noticia> noticias = noticiaServicio.read();
        modelo.addAttribute("noticias", noticias);
        return "home.html";
    }
    
    @PostMapping("/crear")
    public String createPost(@RequestParam String tituloCrear, @RequestParam String cuerpoCrear, ModelMap modelo) {
        try {
            noticiaServicio.create(tituloCrear, cuerpoCrear);
            return "redirect:/";
        } 
        catch (CamposVacios ex) {
            modelo.put("alerta", ex.getMessage());
            return home(modelo);
        }
    }

    @PostMapping("/editar")
    public String updatePost(@RequestParam String idEditar, ModelMap modelo) {
        modelo.put("editar", noticiaServicio.read(idEditar));     
        return home(modelo);
    }

    //@PatchMapping no anda para recibir PATCH(?), uso @RequestMapping.
    @RequestMapping("/guardar")
    public String updatePatch(@RequestParam String tituloGuardar, @RequestParam String cuerpoGuardar, @RequestParam String idGuardar, ModelMap modelo) {
        try {
            noticiaServicio.update(idGuardar, tituloGuardar, cuerpoGuardar);
            return "redirect:/";
        } catch (CamposVacios ex) {
            modelo.put("alerta", ex.getMessage());
            return "redirect:/";
        }
    }
    
    @PostMapping("/buscar")
    public String searchPost(@RequestParam String tituloBuscar, ModelMap modelo) {
        List<Noticia> noticias = noticiaServicio.search(tituloBuscar);
        modelo.addAttribute("noticias", noticias);
        return "home.html";
    }
    
    //@DeleteMapping no anda para recibir DELETE(?), uso @RequestMapping.
    @RequestMapping("/borrar")
    public String delete(@RequestParam String idBorrar, ModelMap modelo) {
        noticiaServicio.delete(idBorrar);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
    
}