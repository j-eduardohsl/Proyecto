package com.portafolio.dish.webapp.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {

  @Id
  @SequenceGenerator(
    name = "proyecto_sequence",
    // Sequence 1 for 1
    sequenceName = "proyecto_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "proyecto_sequence"
  )
  private Long id;
  private String nombre;
  @Column(name = "fecha_inicio")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaInicio;
  @Column(name = "fecha_fin")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaFin;
  private String descripcion;
  @ManyToOne
  @JoinColumn(name = "pm_id")
  private ProjectManager projectManager;
  @ManyToMany
  @JoinTable(
    name = "proyectos_desarrolladores",
    joinColumns = {@JoinColumn(name="id_proyecto")},
    inverseJoinColumns = {@JoinColumn(name="id_desarrollador")}
  )
  private List<Desarrollador> desarrolladores;

  public Proyecto() {
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public LocalDate getFechaInicio() {
    return fechaInicio;
  }
  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }
  public LocalDate getFechaFin() {
    return fechaFin;
  }
  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  public ProjectManager getProjectManager() {
    return projectManager;
  }
  public void setProjectManager(ProjectManager projectManager) {
    this.projectManager = projectManager;
  }
  public List<Desarrollador> getDesarrolladores() {
    return desarrolladores;
  }
  public void setDesarrolladores(List<Desarrollador> desarrolladores) {
    this.desarrolladores = desarrolladores;
  }

}
