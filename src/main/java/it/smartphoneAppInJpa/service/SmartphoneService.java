package it.smartphoneAppInJpa.service;

import it.smartphoneAppInJpa.dao.app.AppDAO;
import it.smartphoneAppInJpa.dao.smartphone.SmartphoneDAO;
import it.smartphoneAppInJpa.model.App;
import it.smartphoneAppInJpa.model.Smartphone;

import java.util.List;

public interface SmartphoneService {

    public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);

    public List<Smartphone> listAll() throws Exception;

    public Smartphone caricaSingoloElemento(Long id) throws Exception;

    public void aggiorna(Smartphone smartphoneIntance) throws Exception;

    public void inserisciNuovo(Smartphone smartphoneInstance) throws Exception;

    public void rimuovi(Long idSmartphone) throws Exception;

    public void aggiornaVersioneEDataApp(Long idSmartphone, Long idApp, String nuovaVersione) throws Exception;

    public void setAppDAO(AppDAO appDAO);

    public void disinstallaApp(Long idSmartphone, Long idApp) throws Exception;

}
