package dtos;

import entities.Animal;

public class AnimalDTO {
    private String name;

    public AnimalDTO(Animal animal) {
        this.name = animal.getAnimalName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
