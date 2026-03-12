package it.smartphoneAppInJpa.dao.app;

import it.smartphoneAppInJpa.model.App;
import it.smartphoneAppInJpa.model.Smartphone;

import javax.persistence.EntityManager;
import java.util.List;

public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Override
    public List<App> findAll() throws Exception {
        return entityManager.createQuery("from App", App.class).getResultList();
    }

    @Override
    public App findById(Long id) throws Exception {
        return entityManager.find(App.class, id);
    }

    @Override
    public void update(App input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(App input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == null)
            throw new Exception("Problema valore in input");

        entityManager.createQuery("delete from App where id=?1").setParameter(1, id).executeUpdate();
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }






}
