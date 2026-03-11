package it.smartphoneAppInJpa.dao.smartphone;

import it.smartphoneAppInJpa.model.Smartphone;

import javax.persistence.EntityManager;
import java.util.List;

public class SmartphoneDAOImpl implements SmartphoneDAO{

    private EntityManager entityManager;

    @Override
    public List<Smartphone> findAll() throws Exception {
        return entityManager.createQuery("from Brano", Smartphone.class).getResultList();
    }

    @Override
    public Smartphone findById(Long id) throws Exception {
        return entityManager.find(Smartphone.class, id);
    }

    @Override
    public void update(Smartphone input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(Smartphone input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == null)
            throw new Exception("Problema valore in input");

        entityManager.createQuery("delete from Brano where id=?1").setParameter(1, id).executeUpdate();
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



}
