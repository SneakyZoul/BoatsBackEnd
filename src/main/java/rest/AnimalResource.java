package rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AnimalDTO;
import repository.AnimalRepo;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("animal")
public class AnimalResource {

    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final AnimalRepo FACADE = AnimalRepo.getAnimalRepo(emf);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("rand")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRandomAnimal() throws IOException {
        return GSON.toJson(FACADE.getRandomAnimal());
    }

    @Path("save")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String saveAnimal(String animal) {
         AnimalDTO animalDTO = GSON.fromJson(animal,AnimalDTO.class);
         AnimalDTO animalDTO1 = FACADE.saveAnimalString(animalDTO);
        return GSON.toJson(GSON.toJson(animalDTO1));
    }
}
