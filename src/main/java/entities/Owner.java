package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;


    @ManyToMany
    private Set<Boat> boats = new HashSet<>();

    public Owner() {
    }

    public Owner(String name, String phone,String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Boat> getBoats() {
        return boats;
    }

    public void addBoat(Boat boat) {
        this.boats.add(boat);
        if (!boat.getOwners().contains(this)) {
            boat.addOwner(this);
        }
    }

    public void removeBoat(Boat boat) {
        this.boats.remove(boat);
        if (boat.getOwners().contains(this)) {
            boat.getOwners().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", boats=" + boats +
                '}';
    }
}
