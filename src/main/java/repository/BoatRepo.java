package repository;

import dtos.BoatDTO;
import dtos.OwnerDTO;
import entities.Boat;
import entities.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class BoatRepo {
    private static EntityManagerFactory emf;
    private static BoatRepo instance;


    public static BoatRepo getBoatRepo(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BoatRepo();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public List<BoatDTO> getAllBoats() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Boat> query = em.createQuery("SELECT b FROM Boat b", Boat.class);
            List<Boat> boats = query.getResultList();
            return BoatDTO.getDtos(boats);
        } finally {
            em.close();
        }
    }

    public BoatDTO getBoatByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Boat> query = em.createQuery("SELECT b FROM Boat b where b.id=:id", Boat.class);
            query.setParameter("id", id);
            Boat boat = query.getSingleResult();
            return new BoatDTO(boat);
        } finally {
            em.close();
        }
    }

//    public List<OwnerDTO> getListOfAllOwnersOfBoat() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            TypedQuery<Owner> query = em.createQuery("SELECT o FROM Owner o join Boat b where b=o.boats and b.id =:boatID", Owner.class);
//        }
//
//
//    }
}
