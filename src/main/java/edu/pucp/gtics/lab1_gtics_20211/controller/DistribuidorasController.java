package edu.pucp.gtics.lab1_gtics_20211.controller;

import edu.pucp.gtics.lab1_gtics_20211.entity.Distribuidoras;
import edu.pucp.gtics.lab1_gtics_20211.repository.DistribuidorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DistribuidorasController {


    @Autowired
    DistribuidorasRepository distribuidorasRepository;


    @GetMapping("distribuidoras/lista")
    public String listaDistribuidoras (Model model){
        List<Distribuidoras> list = distribuidorasRepository.findAll(Sort.by("nombre"));
        model.addAttribute("lista",list);
        return "/distribuidoras/lista";
    }

    @GetMapping("distribuidoras/editar")
    public String editarDistribuidoras(Model model,
                                       @RequestParam("iddistribuidora") int iddistribuidora){
        Optional<Distribuidoras> optDistribuidora = distribuidorasRepository.findById(iddistribuidora);

        if(optDistribuidora.isPresent()){
            Distribuidoras distribuidoras = optDistribuidora.get();
            model.addAttribute("distribuidora",distribuidoras);
            return "/distribuidoras/editar";
        }else{
            return "redirect:/lista"; //revisar que funcione
        }
    }

    @GetMapping("distribuidoras/nuevo")
    public String nuevaDistribuidora(){
        return "/distribuidoras/nuevo";
    }
    @PostMapping("distribuidora/guardar")
    public String guardarDistribuidora(Distribuidoras distribuidora){
        distribuidorasRepository.save(distribuidora);
        return "redirect:/lista";
    }
/*
    public String borrarDistribuidora(){

    }
*/
}
