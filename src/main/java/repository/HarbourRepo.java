package repository;

import dtos.HarbourDTO;
import entities.Harbour;
import entities.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class HarbourRepo {
    private static EntityManagerFactory emf;
    private static HarbourRepo instance;


    public static HarbourRepo getHarbourRepo(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HarbourRepo();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Harbour creatHarbour(Harbour harbour) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(harbour);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return harbour;
    }

    public Harbour creatHabour(Harbour harbour) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(harbour);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return harbour;
    }

    public HarbourDTO creatHarbour(HarbourDTO harbourDTO) {
        Harbour harbour = new Harbour(harbourDTO.getName(), harbourDTO.getAddress(), harbourDTO.getCapacity());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(harbour);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HarbourDTO(harbour);
    }

    public List<HarbourDTO> getAllHarbours() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Harbour> query = em.createQuery("SELECT h FROM Harbour h", Harbour.class);
            List<HarbourDTO> list = new ArrayList<>();
            {
                for (int i = 0; i < list.size(); i++) {
                    list.add(new HarbourDTO(query.getResultList().get(i)));
                }
            }
            return list;
        } finally {
            em.close();
            emf.close();
        }
    }

    public HarbourDTO getHarbourById(long id){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Harbour> query = em.createQuery("SELECT h FROM Harbour h WHERE h.id=:id",Harbour.class);
            query.setParameter("id",id);
            Harbour harbour = query.getSingleResult();
            return new HarbourDTO(harbour);
        }finally {
            em.close();
        }

    }


}
