package co.com.poli.proyectos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="project")
public class Project extends EntityBase{
    @Column(name="project_name",unique=true)
    @NotBlank(message = "Name may not be blank")
    private String projectName;

    @Column(name="project_identifier",unique=true, updatable=false)
    @NotBlank(message = "Name may not be blank")
    @Size(min = 5, max = 7, message = "Name must be between 5 and 7 characters long")
    private String ProjectIdentifier;

    @Column(name="description")
    @NotBlank(message = "Name may not be blank")
    private String description;

    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;


    @JsonManagedReference
    @OneToOne(mappedBy = "project",cascade = CascadeType.ALL)
    @JoinColumn(name="backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
