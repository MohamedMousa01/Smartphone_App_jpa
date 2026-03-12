package it.smartphoneAppInJpa.service;

import it.smartphoneAppInJpa.dao.MyDAOFactory;

public class MyServiceFactory {

    private static SmartphoneService smartphoneServiceInstance = null;
    private static AppService appServiceInstance = null;

    public static SmartphoneService getSmartphoneServiceInstanceServiceInstance() {
        if (smartphoneServiceInstance == null)
            smartphoneServiceInstance = new SmartphoneServiceImpl();

        smartphoneServiceInstance.setSmartphoneDAO(MyDAOFactory.getSmartphoneDaoInstance());

        return smartphoneServiceInstance;
    }

    public static AppService getAppServiceInstance() {
        if (appServiceInstance == null)
            appServiceInstance = new AppServiceImpl();

        appServiceInstance.setAppDAO(MyDAOFactory.getAppDAOInstance());

        return appServiceInstance;
    }


}
