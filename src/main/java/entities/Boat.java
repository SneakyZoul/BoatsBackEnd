package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
    @Table(name = "boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String make;
    private String name;
    private String img;

    @ManyToMany(mappedBy = "boats")
    private Set<Owner> owners = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="harbour_id")
    private Harbour harbour;


    public Boat(){}

    public Boat(int id, String brand,String make, String name, String img){
        this.id = id;
        this.brand = brand;
        this.make = make;
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public Set<Owner> getOwners(){
        return owners;
    }

    public void addOwner(Owner owner) {
        this.owners.add(owner);
        if(!owner.getBoats().contains(this)){
            owner.addBoat(this);
        }
    }

    public Harbour getHarbour(){
        return harbour;
    }
    public void addHarbour(Harbour harbour) {
        this.harbour = harbour;
        if(!harbour.getBoats().contains(this)){
            harbour.addBoat(this);
        }
    }
}
