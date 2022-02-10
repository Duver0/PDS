package co.com.poli.proyectos.repository;

import co.com.poli.proyectos.entities.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Long> {

}
