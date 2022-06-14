package dtos;

import entities.Harbour;

import java.util.HashSet;
import java.util.Set;

public class HarbourDTO {

    private long id;
    private String name;
    private String address;
    private String capacity;



    private Set<BoatDTO> boats = new HashSet<>();

    public HarbourDTO(Harbour harbour) {
        this.id=harbour.getId();
        this.name= harbour.getName();
        this.address= harbour.getAddress();
        this.capacity= harbour.getCapacity();
}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<BoatDTO> getBoats() {
        return boats;
    }

    public void setBoats(Set<BoatDTO> boats) {
        this.boats = boats;
    }

}
