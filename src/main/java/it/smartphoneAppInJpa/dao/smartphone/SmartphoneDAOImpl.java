package it.smartphoneAppInJpa.dao.smartphone;

import it.smartphoneAppInJpa.model.Smartphone;

import javax.persistence.EntityManager;
import java.util.List;

public class SmartphoneDAOImpl implements SmartphoneDAO{

    private EntityManager entityManager;

    @Override
    public List<Smartphone> findAll() throws Exception {
        return entityManager.createQuery("from Smartphone", Smartphone.class).getResultList();
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

        entityManager.createQuery("delete from Smartphone where id=?1").setParameter(1, id).executeUpdate();
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void disinstallaApp(Long idSmartphone, Long idApp) throws Exception{

        if (idSmartphone == null || idApp == null) {
            throw new Exception("Input non valido");
        }

        int rows = entityManager.createNativeQuery(
                        "delete from smartphone_app where smartphone_id = ?1 and app_id = ?2")
                .setParameter(1, idSmartphone)
                .setParameter(2, idApp)
                .executeUpdate();

        if (rows == 0) {
            throw new Exception("Nessuna app disinstallata: associazione non trovata");
        }
    }






}
