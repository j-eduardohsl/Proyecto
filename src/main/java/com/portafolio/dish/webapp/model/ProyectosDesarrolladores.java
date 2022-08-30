package com.portafolio.dish.webapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos_desarrolladores")
public class ProyectosDesarrolladores implements Serializable{

  @Id
  @ManyToOne
  @JoinColumn(name = "id_proyecto")
  private Proyecto proyecto;
  @Id
  @ManyToOne
  @JoinColumn(name = "id_desarrollador")
  private Desarrollador desarrollador;
  public Proyecto getProyecto() {
    return proyecto;
  }
  public void setProyecto(Proyecto proyecto) {
    this.proyecto = proyecto;
  }
  public Desarrollador getDesarrollador() {
    return desarrollador;
  }
  public void setDesarrollador(Desarrollador desarrollador) {
    this.desarrollador = desarrollador;
  }

  
  
}
