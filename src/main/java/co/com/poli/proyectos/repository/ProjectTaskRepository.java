package co.com.poli.proyectos.repository;

import co.com.poli.proyectos.entities.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask,Long> {

}
