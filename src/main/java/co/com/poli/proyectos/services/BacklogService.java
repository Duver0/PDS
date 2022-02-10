package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Backlog;


import java.util.List;

public interface BacklogService {
    List<Backlog> findAll();
    Backlog create(Backlog backlog);
}
