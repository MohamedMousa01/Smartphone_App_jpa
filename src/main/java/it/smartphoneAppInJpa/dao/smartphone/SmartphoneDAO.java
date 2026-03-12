package it.smartphoneAppInJpa.dao.smartphone;

import it.smartphoneAppInJpa.dao.IBaseDAO;
import it.smartphoneAppInJpa.model.Smartphone;

public interface SmartphoneDAO extends IBaseDAO<Smartphone> {

    public void disinstallaApp(Long idSmartphone, Long idApp) throws Exception;



}
