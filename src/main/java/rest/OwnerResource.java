package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.OwnerDTO;
import errorhandling.GenericExceptionMapper;
import repository.JokeRepo;
import repository.OwnerRepo;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@Path("owner")
public class OwnerResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final OwnerRepo facade = OwnerRepo.getOwnerRepo(EMF);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello owner\"}";
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOwnerById(@PathParam("id") int id) {
        OwnerDTO o = facade.getOwnerById(id);
        return Response
                .ok()
                .entity(gson.toJson(o))
                .build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOwners() {
        List<OwnerDTO> ownerDTOList = facade.getAllOwner();
        if (ownerDTOList == null) return Response.status(404).build();

        return Response
                .ok()
                .entity(gson.toJson(ownerDTOList))
                .build();
    }
    //lav en bruger j

    @POST
    @Path("/createowner")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOwner(String content){
        OwnerDTO ownerDTO = gson.fromJson(content,OwnerDTO.class);
        OwnerDTO ownerDTO1 = facade.createOwner(ownerDTO);
        return Response
                .ok()
                .entity(gson.toJson(ownerDTO1))
                .build();
    }

}
