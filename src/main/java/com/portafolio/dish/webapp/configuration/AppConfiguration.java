package com.portafolio.dish.webapp.configuration;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.portafolio.dish.webapp.model.Desarrollador;
import com.portafolio.dish.webapp.model.ProjectManager;
import com.portafolio.dish.webapp.repositories.DesarrolladorRepository;
import com.portafolio.dish.webapp.repositories.PmRepository;

@Configuration
public class AppConfiguration {
  
  @Bean
  CommandLineRunner commandLineRunner(PmRepository pmRepository, DesarrolladorRepository desarrolladorRepository){
    return args -> {

      ProjectManager projectManager1 = new ProjectManager(

      1L, "Jose Hernandez", LocalDate.of(1980, 1, 10)

      );

      ProjectManager projectManager2 = new ProjectManager(

      2L, "Noemi Rojas", LocalDate.of(1990, 3, 19)

      );

      ProjectManager projectManager3 = new ProjectManager(

      3L, "Manuel Razo", LocalDate.of(1995, 11, 25)

      );

      Desarrollador dev1 = new Desarrollador(
        1L, "Alan Solis", LocalDate.of(1996, 4, 18)
      );

      Desarrollador dev2 = new Desarrollador(
        2L, "Daniela Cruz", LocalDate.of(1991, 8, 8)
      );

      Desarrollador dev3 = new Desarrollador(
        3L, "Kevin Soto", LocalDate.of(2002, 12, 6)
      );

      desarrolladorRepository.saveAll(List.of(dev1, dev2, dev3));
      pmRepository.saveAll(List.of(projectManager1, projectManager2, projectManager3));

    };
  }

}
