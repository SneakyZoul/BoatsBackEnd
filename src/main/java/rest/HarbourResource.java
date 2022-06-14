package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BoatDTO;
import dtos.HarbourDTO;
import repository.HarbourRepo;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("harbour")
public class HarbourResource {
    //det her vigtigt for at em virker i repo
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final HarbourRepo facade = HarbourRepo.getHarbourRepo(EMF);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello Harbour\"}";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHarbourById(@PathParam("id") int id) {
        HarbourDTO h = facade.getHarbourById(id);
        return Response
                .ok()
                .entity(gson.toJson(h))
                .build();
    }

    @GET
    @Path("/boatlist/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListOfBoatsInHarbour(@PathParam("id") int id) {
        List<BoatDTO> boatDTOList = facade.getAllBotsFromOneHarbour(id);
        return Response
                .ok()
                .entity(boatDTOList)
                .build();
    }

}
