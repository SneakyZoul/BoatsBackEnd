package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HarbourDTO;
import repository.HarbourRepo;
import repository.OwnerRepo;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("harbour")
public class HarbourResource {

    private static EntityManagerFactory emf;
    HarbourRepo facade = new HarbourRepo();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello Harbour\"}";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHarbourById(@PathParam("id") long id){
        HarbourDTO h = facade.getHarbourById(id);
return Response
        .ok()
        .entity(gson.toJson(h))
        .build();
            }


}
