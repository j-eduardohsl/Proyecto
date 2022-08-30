package com.portafolio.dish.webapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "project_manager")
public class ProjectManager {
  
  @Id
  @SequenceGenerator(
    name = "pm_sequence",
    // Sequence 1 for 1
    sequenceName = "pm_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "pm_sequence"
  )
  private Long id;
  private String nombre;
  @Column(name = "fecha_nacimiento")
  private LocalDate fechaNacimiento;

  public ProjectManager(Long id, String nombre, LocalDate fechaNacimiento) {
    this.id = id;
    this.nombre = nombre;
    this.fechaNacimiento = fechaNacimiento;
  }

  public ProjectManager() {
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
  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  

}
