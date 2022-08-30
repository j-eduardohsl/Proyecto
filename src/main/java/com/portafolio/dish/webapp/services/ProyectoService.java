package com.portafolio.dish.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portafolio.dish.webapp.model.Desarrollador;
import com.portafolio.dish.webapp.model.ProjectManager;
import com.portafolio.dish.webapp.model.Proyecto;
import com.portafolio.dish.webapp.repositories.DesarrolladorRepository;
import com.portafolio.dish.webapp.repositories.PmRepository;
import com.portafolio.dish.webapp.repositories.ProyectoRepository;

@Service
public class ProyectoService {

  private final ProyectoRepository repository;
  private final PmRepository pmRepository;
  private final DesarrolladorRepository desarrolladorRepository;
  
  public ProyectoService(@Autowired ProyectoRepository repository, @Autowired PmRepository pmRepository, @Autowired DesarrolladorRepository desarrolladorRepository) {
    this.repository = repository;
    this.pmRepository = pmRepository;
    this.desarrolladorRepository = desarrolladorRepository;
  }

  public List<ProjectManager> getProjectManagers(){
    return pmRepository.findAll();
  }

  public List<Proyecto> getProyectos(){
    return repository.findAll();
  }

  public List<Desarrollador> getDesarrolladores(){
    return desarrolladorRepository.findAll();
  }

  public void agregarProyecto(Proyecto proyecto, Long idProjectManager, List<Long> idDesarrolladores){
    Desarrollador desarrollador;
    ProjectManager projectManager = pmRepository.findById(idProjectManager).orElseThrow(()-> new IllegalStateException("Pm no encontrado"));
    proyecto.setProjectManager(projectManager);
    if(idDesarrolladores != null && !idDesarrolladores.isEmpty()){
      proyecto.setDesarrolladores(new ArrayList<>());
      for (Long idDesarrollador : idDesarrolladores) {
        desarrollador = desarrolladorRepository.findById(idDesarrollador).orElseThrow(() -> new IllegalStateException("Desarrollador con id " + idDesarrollador + " no encontrado"));
        proyecto.getDesarrolladores().add(desarrollador);
      }
    }
    repository.save(proyecto);
  }

  @Transactional
  public void modificarProyecto(Proyecto proyecto){
    Proyecto proyectoEncontrado = repository
    .findById(proyecto.getId())
    .orElseThrow(
      () ->  new IllegalStateException("Proyecto con id " + proyecto.getId() + " no existe")
    );
    if(proyecto.getNombre() != null && proyecto.getNombre().length() > 0
    && !Objects.equals(proyecto.getNombre(), proyectoEncontrado.getNombre())){
      proyectoEncontrado.setNombre(proyecto.getNombre());
    }
    if(proyecto.getDescripcion() != null && proyecto.getDescripcion().length() > 0
    && !Objects.equals(proyecto.getDescripcion(), proyectoEncontrado.getDescripcion())){
      proyectoEncontrado.setDescripcion(proyecto.getDescripcion());
    }
    if(proyecto.getFechaInicio() != null 
    && !Objects.equals(proyecto.getFechaInicio(), proyectoEncontrado.getFechaInicio())){
      proyectoEncontrado.setFechaInicio(proyecto.getFechaInicio());
    }
    if(proyecto.getFechaFin() != null 
    && !Objects.equals(proyecto.getFechaFin(), proyectoEncontrado.getFechaFin())){
      proyectoEncontrado.setFechaFin(proyecto.getFechaFin());
    }
  }
  
}
