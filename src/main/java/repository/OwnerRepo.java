package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.OwnerDTO;
import entities.Harbour;
import entities.Owner;
import errorhandling.GenericExceptionMapper;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OwnerRepo {

    private static EntityManagerFactory emf;
    private static OwnerRepo instance;



    public static OwnerRepo getOwnerRepo(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new OwnerRepo();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public Owner createOwner(Owner owner) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(owner);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return owner;
    }


    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        OwnerRepo or = getOwnerRepo(emf);
    }


    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        Owner owner = new Owner(ownerDTO.getName(), ownerDTO.getAddress(), ownerDTO.getPhone());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(owner);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new OwnerDTO(owner);
    }

    public List<OwnerDTO> getAllOwner() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Owner> query = em.createQuery("select o from Owner o", Owner.class);
            List<OwnerDTO> list = new ArrayList<>();
            {
                for (int i = 0; i < list.size(); i++) {
                    list.add(new OwnerDTO(query.getResultList().get(i)));

                }
                return list;
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    // Possible solution
//    public OwnerDTO getOwnerById(int id) {
//        EntityManager em = getEntityManager();
//        try {
//                TypedQuery<Owner> query = em.createQuery("SELECT o FROM Owner o WHERE o.id=:id", Owner.class);
//                query.setParameter("id", id);
//                Owner owner = query.getSingleResult();
//                return new OwnerDTO(owner);
//
//            } finally {
//                em.close();
//            }
//
//
//        }
    public OwnerDTO getOwnerById(int id) {
        EntityManager em = emf.createEntityManager();
        Owner owner = em.find(Owner.class, id);


        return new OwnerDTO(owner);
    }

}


