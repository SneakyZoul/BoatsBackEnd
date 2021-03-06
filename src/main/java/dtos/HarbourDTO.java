package dtos;

import entities.Boat;
import entities.Harbour;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HarbourDTO {

    private int id;
    private String name;
    private String address;
    private String capacity;



    private Set<BoatDTO> boats = new HashSet<>();

    public HarbourDTO(Harbour harbour) {
        this.id=harbour.getId();
        this.name= harbour.getName();
        this.address= harbour.getAddress();
        this.capacity= harbour.getCapacity();

        for (Boat boat: harbour.getBoats()) {
            this.boats.add(new BoatDTO(boat));
        }
}
        public static List<HarbourDTO> getDtos(List<Harbour> harbourList){
            List<HarbourDTO> harbourDTOS = new ArrayList();
            harbourList.forEach(harbour->harbourDTOS.add(new HarbourDTO(harbour)));
            return harbourDTOS;
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

    public Set<BoatDTO> getBoats() {
        return boats;
    }

    public void setBoats(Set<BoatDTO> boats) {
        this.boats = boats;
    }

}
