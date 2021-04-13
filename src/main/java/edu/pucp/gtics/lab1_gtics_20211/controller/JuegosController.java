package edu.pucp.gtics.lab1_gtics_20211.controller;

import edu.pucp.gtics.lab1_gtics_20211.entity.Juegos;
import edu.pucp.gtics.lab1_gtics_20211.repository.JuegosRepository;
import edu.pucp.gtics.lab1_gtics_20211.repository.PlataformasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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
    public String editarJuegos(@RequestParam("id") int idjuego, Model model){
        Optional<Juegos> juegosOptional = juegosRepository.findById(idjuego);

        model.addAttribute("plataformasLista",plataformasRepository.findAll());

        if(juegosOptional.isPresent()){
            Juegos juegos = juegosOptional.get();
            model.addAttribute("juegos",juegos);
            return "juegos/editar";
        }else{
            return "redirect:/juegos/lista";
        }

    }

    @PostMapping("/guardar")
    public String guardarJuegos(Juegos juegos){
        juegosRepository.save(juegos);
        return "redirect:/juegos/lista";
    }

}
