package it.smartphoneAppInJpa.dao;

import it.smartphoneAppInJpa.dao.app.AppDAO;
import it.smartphoneAppInJpa.dao.app.AppDAOImpl;
import it.smartphoneAppInJpa.dao.smartphone.SmartphoneDAO;
import it.smartphoneAppInJpa.dao.smartphone.SmartphoneDAOImpl;

public class MyDAOFactory {

    private static AppDAO appDaoInstance = null;
    private static SmartphoneDAO smartphoneDaoInstance = null;

    public static AppDAO getAppDAOInstance() {
        if (appDaoInstance == null)
            appDaoInstance = new AppDAOImpl();

        return appDaoInstance;
    }

    public static SmartphoneDAO getSmartphoneDaoInstance() {
        if (smartphoneDaoInstance == null)
            smartphoneDaoInstance = new SmartphoneDAOImpl();

        return smartphoneDaoInstance;
    }

}
