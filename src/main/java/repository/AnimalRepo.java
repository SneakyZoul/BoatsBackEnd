package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AnimalDTO;
import entities.Animal;
import utils.HttpUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;

public class AnimalRepo {
    private static EntityManagerFactory emf;
    private static AnimalRepo instance;

    private static Gson gson = new GsonBuilder().create();


    public static AnimalRepo getAnimalRepo(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AnimalRepo();
        }
        return instance;
    }


    public AnimalDTO getRandomAnimal() throws IOException {
        String json = HttpUtils.fetchData("https://zoo-animal-api.herokuapp.com/animals/rand");
        return gson.fromJson(json, AnimalDTO.class);
    }
    public AnimalDTO saveAnimalString(AnimalDTO animalDTO){
        EntityManager em = emf.createEntityManager();
        Animal animal = new Animal(animalDTO.getName());


        try{
            em.getTransaction().begin();
            em.persist(animal);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
        return new AnimalDTO(animal);
    }
}
