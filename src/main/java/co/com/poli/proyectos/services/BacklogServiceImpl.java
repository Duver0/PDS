package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Backlog;
import co.com.poli.proyectos.repository.BacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BacklogServiceImpl implements BacklogService{
    @Autowired
    private BacklogRepository repository;
    @Override
    public List<Backlog> findAll() {
        return repository.findAll();
    }

    @Override
    public Backlog create(Backlog backlog) {
        return repository.save(backlog);
    }
}
