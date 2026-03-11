package it.smartphoneAppInJpa.service;

import it.smartphoneAppInJpa.dao.app.AppDAO;
import it.smartphoneAppInJpa.model.App;

import java.util.List;

public interface AppService {

    public void setAppDAO(AppDAO appDAO);

    public List<App> listAll() throws Exception;

    public App caricaSingoloElemento(Long id) throws Exception;


    public void aggiorna(App appIntance) throws Exception;

    public void inserisciNuovo(App appInstance) throws Exception;

    public void rimuovi(Long idBrano) throws Exception;



}
