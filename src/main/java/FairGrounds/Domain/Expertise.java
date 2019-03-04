package FairGrounds.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Expertise")
public class Expertise {

    /**
     * Required default constructor for Spring Framework
     */
    public Expertise(){

    }

    @Id
    @Column(name="id")
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}