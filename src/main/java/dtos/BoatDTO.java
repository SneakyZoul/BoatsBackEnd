package dtos;

import entities.Boat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoatDTO  {
    private int id;
    private String brand;
    private String make;
    private String name;
    private String img;
    private int harbourId;

    public BoatDTO(Boat boat) {
        this.id = boat.getId();
        this.brand = boat.getBrand();
        this.make = boat.getMake();
        this.name = boat.getName();
        this.img = boat.getImg();
        if (boat.getHarbour() != null) {
            this.harbourId = boat.getHarbour().getId();
        }
    }
    public static List<BoatDTO> getDtos(List<Boat> boatList){
        List<BoatDTO> boatDTOS = new ArrayList();
        boatList.forEach(boat->boatDTOS.add(new BoatDTO(boat)));
        return boatDTOS;
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

    public int getHarbourId() {
        return harbourId;
    }

    public void setHarbourId(int harbourId) {
        this.harbourId = harbourId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoatDTO boatDTO = (BoatDTO) o;
        return id == boatDTO.id && harbourId == boatDTO.harbourId && Objects.equals(brand, boatDTO.brand) && Objects.equals(make, boatDTO.make) && Objects.equals(name, boatDTO.name) && Objects.equals(img, boatDTO.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, make, name, img, harbourId);
    }
}
