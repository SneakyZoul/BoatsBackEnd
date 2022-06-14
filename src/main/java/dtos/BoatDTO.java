package dtos;

import entities.Boat;

public class BoatDTO {
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
}
