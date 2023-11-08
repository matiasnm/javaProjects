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
/*
 * TODO
 * 1. agregar Excepciones
 * 2. verificacion campos
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
        catch(Exception ex) {
            Logger.getLogger(NoticiaServicio.class.getName()).log(Level.SEVERE, null, ex);
            return "redirect:/";
        }
    }

    @PostMapping("/editar")
    public String updatePost(@RequestParam String idEditar, ModelMap modelo) {
        modelo.put("editar", noticiaServicio.read(idEditar));     
        return home(modelo);
    }

    //@PatchMapping no anda para recibir PATCH(?), uso @RequestMapping.
    @RequestMapping("/guardar")
    //cambio Param por Path..@RequestParam String tituloGuardar, @RequestParam String cuerpoGuardar, @RequestParam String idGuardar, ModelMap modelo) {
    public String updatePatch(@RequestPath String tituloGuardar, @RequestPath String cuerpoGuardar, @RequestPath String idGuardar, ModelMap modelo) {
        try {
            noticiaServicio.update(idGuardar, tituloGuardar, cuerpoGuardar);
            return "redirect:/";
        } catch (Exception ex) {
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
    public String delete(@RequestPath String idBorrar, ModelMap modelo) {
        noticiaServicio.delete(idBorrar);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
    
}