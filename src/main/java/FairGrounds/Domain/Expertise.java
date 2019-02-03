package FairGrounds.Domain;

import javax.persistence.*;

@Entity
@Table(name = "Expertise")
public class Expertise {

    @Id
    @Column(name="id")
    private long id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
