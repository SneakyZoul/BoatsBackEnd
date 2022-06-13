package entities;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    public Owner() {
    }

    public Owner(String name) {
        this.name = name;

    }
}
