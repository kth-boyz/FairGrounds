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
}
