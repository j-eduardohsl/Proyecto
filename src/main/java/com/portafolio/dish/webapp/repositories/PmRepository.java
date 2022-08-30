package com.portafolio.dish.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portafolio.dish.webapp.model.ProjectManager;

public interface PmRepository extends JpaRepository<ProjectManager, Long>{
  
}
