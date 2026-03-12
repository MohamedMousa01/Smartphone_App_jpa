package it.smartphoneAppInJpa.service;

import it.smartphoneAppInJpa.dao.EntityManagerUtil;
import it.smartphoneAppInJpa.dao.app.AppDAO;
import it.smartphoneAppInJpa.model.App;

import javax.persistence.EntityManager;
import java.util.List;

public class AppServiceImpl implements AppService{

    private AppDAO appDAO;

    @Override
    public void setAppDAO(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @Override
    public List<App> listAll() throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            appDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return appDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }




    @Override
    public App caricaSingoloElemento(Long id) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            appDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return appDAO.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }




    @Override
    public void aggiorna(App appInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            appDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            appDAO.update(appInstance);

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
    public void inserisciNuovo(App appInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            appDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            appDAO.insert(appInstance);

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
    public void rimuovi(Long idBrano) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            appDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            appDAO.delete(idBrano);

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
