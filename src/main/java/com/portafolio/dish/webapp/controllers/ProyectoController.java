package com.portafolio.dish.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portafolio.dish.webapp.model.Desarrollador;
import com.portafolio.dish.webapp.model.ProjectManager;
import com.portafolio.dish.webapp.model.Proyecto;
import com.portafolio.dish.webapp.services.ProyectoService;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/proyectos")
public class ProyectoController {

  private final ProyectoService service;

  @Autowired
  public ProyectoController(ProyectoService service) {
    this.service = service;
  }

  @GetMapping(value = "/form")
  public String formulario(Model model){
  
    Proyecto proyecto = new Proyecto();
    
    List<ProjectManager> pms = service.getProjectManagers();
    List<Desarrollador> devs = service.getDesarrolladores();
    model.addAttribute("proyecto", proyecto);
    model.addAttribute("pms", pms);
    model.addAttribute("devs", devs);
    return "proyectos/formulario-proyecto";
  }

  @GetMapping(value="/listado")
  public String listar(Model model) {
      List<Proyecto> proyectos = service.getProyectos();
      model.addAttribute("proyectos", proyectos);
      return "/proyectos/listado";
  }
  
  @PostMapping(value="/agregar")
  public String agregarProyecto(@ModelAttribute Proyecto proyecto,
  @RequestParam Long idPm, @RequestParam List<Long> idDesarrolladores) {  
      service.agregarProyecto(proyecto, idPm, idDesarrolladores);
      return "/proyectos/resultadoAgregar";
  }
  
  @PostMapping(value="/modificar")
  public String modificarProyecto(@RequestBody Proyecto proyecto) {
      service.modificarProyecto(proyecto);
      return "resultadoModificar";
  }


  
  
}
