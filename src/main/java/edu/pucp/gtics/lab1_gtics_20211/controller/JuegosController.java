package edu.pucp.gtics.lab1_gtics_20211.controller;

import edu.pucp.gtics.lab1_gtics_20211.repository.JuegosRepository;
import edu.pucp.gtics.lab1_gtics_20211.repository.PlataformasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/juegos")
public class JuegosController {

    @Autowired
    JuegosRepository juegosRepository;

    @Autowired
    PlataformasRepository plataformasRepository;

    @GetMapping("/lista")
    public String listaJuegos (Model model){

        model.addAttribute("juegosLista",juegosRepository.findAll());

        return "juegos/lista";
    }

    @GetMapping("/editar")
    public String editarJuegos(Model model){

        model.addAttribute("plataformasLista",plataformasRepository.findAll());

        return "juegos/editar";
    }

    @PostMapping("/guardar")
    public String guardarJuegos(){
        return "redirect:/juegos/lista";
    }


}
