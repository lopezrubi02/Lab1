package edu.pucp.gtics.lab1_gtics_20211.controller;

import edu.pucp.gtics.lab1_gtics_20211.entity.Distribuidoras;
import edu.pucp.gtics.lab1_gtics_20211.repository.DistribuidorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    public String editarDistribuidoras(){

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
