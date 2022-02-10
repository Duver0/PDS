package co.com.poli.proyectos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "backlog")
public class Backlog extends EntityBase{

    @Column(name="project_identifier", nullable = false)
    @NotEmpty(message = "El campo no puede estar vacío")

    private String projectIdentifier;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="project_id")
    private Project project;

    @JsonManagedReference
    @OneToMany(mappedBy = "backlog", cascade = CascadeType.PERSIST)
    private List<ProjectTask> projectTasks;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
