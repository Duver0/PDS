package co.com.poli.proyectos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "backlog")
public class Backlog extends EntityBase{

    @Column(name="project_identifier")
    @NotBlank(message = "Name may not be blank")
    private String projectIdentifier;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="project_id")
    private Project project;

    ////

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
