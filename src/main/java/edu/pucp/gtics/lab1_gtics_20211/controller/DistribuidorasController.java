package edu.pucp.gtics.lab1_gtics_20211.controller;

import edu.pucp.gtics.lab1_gtics_20211.entity.Distribuidoras;
import edu.pucp.gtics.lab1_gtics_20211.repository.DistribuidorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DistribuidorasController {


    @Autowired
    DistribuidorasRepository distribuidorasRepository;


    @GetMapping("distribuidoras/lista")
    public String listaDistribuidoras (Model model){
        List<Distribuidoras> list = distribuidorasRepository.findAll();
        model.addAttribute("lista",list);
        return "/distribuidoras/lista";
    }

    @GetMapping("/distribuidoras/editar")
    public String editarDistribuidoras(Model model,
                                       @RequestParam("iddistribuidora") int id){
        Optional<Distribuidoras> optDistribuidora = distribuidorasRepository.findById(id);

        if(optDistribuidora.isPresent()){
            Distribuidoras distribuidoras = optDistribuidora.get();
            model.addAttribute("distribuidora",distribuidoras);
            return "distribuidoras/editar";
        }else{
            return "redirect:/lista"; //revisar que funcione
        }
    }

    @GetMapping("distribuidoras/nuevo")
    public String nuevaDistribuidora(){
        return "/distribuidoras/nuevo";
    }

    public String guardarDistribuidora(){

    }

    public String borrarDistribuidora(){

    }

}
