package it.smartphoneAppInJpa.test;

import it.smartphoneAppInJpa.dao.EntityManagerUtil;
import it.smartphoneAppInJpa.model.App;
import it.smartphoneAppInJpa.model.Smartphone;
import it.smartphoneAppInJpa.service.AppService;
import it.smartphoneAppInJpa.service.MyServiceFactory;
import it.smartphoneAppInJpa.service.SmartphoneService;

import java.time.LocalDate;



public class MyTest {

    public static void main(String[] args) {

        SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstanceServiceInstance();
        AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();

        try {
            System.out.println("In tabella ci sono: " + smartphoneServiceInstance.listAll().size()
                    + " smartphone e " + appServiceInstance.listAll().size() + " app");

            testInserimentoNuovoSmartphone(smartphoneServiceInstance);

            testUpdateSmartphone(smartphoneServiceInstance);

            testInserisciApp(appServiceInstance);

            testAggiornaVersioneEDataApp(smartphoneServiceInstance, appServiceInstance);



            System.out.println("In tabella ci sono: " + smartphoneServiceInstance.listAll().size()
                    + " smartphone e " + appServiceInstance.listAll().size() + " app");


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            EntityManagerUtil.shutdown();
        }
    }


    public static void testInserimentoNuovoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception{

        System.out.println("---------testInseriscoNuovoSmartphone INIZIO----------");

        Smartphone cellulareDaInserire = new Smartphone("Samsung", "S25", 1200, "7");
        smartphoneServiceInstance.inserisciNuovo(cellulareDaInserire);
        if(smartphoneServiceInstance.caricaSingoloElemento(cellulareDaInserire.getId()) == null)
            throw new Exception("testInserimentoNuovoSmartphone FAILED");
        System.out.println("----------------testInsertSmartphone PASSED---------------");
    }


    public static void testUpdateSmartphone( SmartphoneService smartphoneServiceInstance) throws Exception{
        System.out.println("-------testUpdateSmartphone INIZIO--------");

        Smartphone cellulareDaInserire = new Smartphone("Samsung", "S25", 1200, "7");
        smartphoneServiceInstance.inserisciNuovo(cellulareDaInserire);
        if (smartphoneServiceInstance.caricaSingoloElemento(cellulareDaInserire.getId()) == null)
            throw new Exception("testUpdateVersioneOS FAILED: cellulare non presente sul db");

        cellulareDaInserire.setVersioneOS("8");
        smartphoneServiceInstance.aggiorna(cellulareDaInserire);
        if (!smartphoneServiceInstance.caricaSingoloElemento(cellulareDaInserire.getId()).getVersioneOS().equals("8"))
            throw new Exception("testUpdateVersioneOS FAILED: dato non correttamente aggiornato");
        System.out.println("----------------testUpdateVersioneOS PASSED---------------");

    }

    public static void testInserisciApp(AppService appServiceInstance) throws Exception{

        System.out.println("--------testInserisciApp INIZIO---------");

        App appDaInserire = new App("instagram", LocalDate.of(2018, 7, 5), LocalDate.of(2016, 7, 5), "CDC400");
        appServiceInstance.inserisciNuovo(appDaInserire);
        if (appServiceInstance.caricaSingoloElemento(appDaInserire.getId()) == null)
            throw new Exception("testInsertApp FAILED: cellulare non presente sul db");
        System.out.println("----------------testInsertApp PASSED---------------");

    }



    public static void testAggiornaVersioneEDataApp( SmartphoneService smartphoneServiceInstance,AppService appServiceInstance) throws Exception{
        System.out.println("---------testAggiornaVersioneEDataApp INIZIO------------");

        App appDaInserire = new App("instagram", LocalDate.of(2018, 7, 5), LocalDate.of(2016, 7, 5), "CDC400");
        appServiceInstance.inserisciNuovo(appDaInserire);
        if (appServiceInstance.caricaSingoloElemento(appDaInserire.getId()) == null)
            throw new Exception("testAggiornaVersioneEDataApp FAILED: cellulare non presente sul db");
        Smartphone cellulareDaInserire = new Smartphone("Samsung", "GalaxyA50", 200, "7");
        smartphoneServiceInstance.inserisciNuovo(cellulareDaInserire);

        smartphoneServiceInstance.aggiornaVersioneEDataApp(cellulareDaInserire.getId(), appDaInserire.getId(), "8");
        if (!smartphoneServiceInstance.caricaSingoloElemento(cellulareDaInserire.getId()).getVersioneOS().equals("8"))
            throw new Exception("testAggiornaVersioneEDataApp FAILED: dato non correttamente aggiornato");

        System.out.println("----------------testAggiornaVersioneEDataApp PASSED---------------");
    }


}
