package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "harbour")
public class Harbour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String address;
    private String capacity;

    @OneToMany(mappedBy = "harbour")
    private Set<Boat> boats = new HashSet<>();

    public Harbour(){}

    public Harbour(String name, String address, String capacity){
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Set<Boat> getBoats() {
        return boats;
    }

    public void setBoats(Set<Boat> boats) {
        this.boats = boats;
    }

    public void addBoat(Boat boat) {
        this.boats.add(boat);
        if(boat.getHarbour()!=this){
            boat.addHarbour(this);
        }
    }

    @Override
    public String toString() {
        return "Harbour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity='" + capacity + '\'' +
                ", boats=" + boats +
                '}';
    }
}
