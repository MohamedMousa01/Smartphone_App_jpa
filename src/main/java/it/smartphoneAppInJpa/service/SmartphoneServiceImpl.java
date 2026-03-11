package it.smartphoneAppInJpa.service;

import it.smartphoneAppInJpa.dao.EntityManagerUtil;
import it.smartphoneAppInJpa.dao.app.AppDAO;
import it.smartphoneAppInJpa.dao.smartphone.SmartphoneDAO;
import it.smartphoneAppInJpa.model.App;
import it.smartphoneAppInJpa.model.Smartphone;

import javax.persistence.EntityManager;
import java.util.List;

public class SmartphoneServiceImpl implements SmartphoneService {


    private SmartphoneDAO smartphoneDAO;

    @Override
    public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO) {
        this.smartphoneDAO = smartphoneDAO;
    }

    @Override
    public List<Smartphone> listAll() throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            smartphoneDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return smartphoneDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }




    @Override
    public Smartphone caricaSingoloElemento(Long id) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            smartphoneDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return smartphoneDAO.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }




    @Override
    public void aggiorna(Smartphone smartphoneInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            smartphoneDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            smartphoneDAO.update(smartphoneInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void inserisciNuovo(Smartphone smartphoneInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            smartphoneDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            smartphoneDAO.insert(smartphoneInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void rimuovi(Long idSmartphone) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            smartphoneDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            smartphoneDAO.delete(idSmartphone);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }







}
