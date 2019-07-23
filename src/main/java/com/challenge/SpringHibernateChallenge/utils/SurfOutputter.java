package com.challenge.SpringHibernateChallenge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.challenge.SpringHibernateChallenge.entities.Surf;
import com.challenge.SpringHibernateChallenge.repositories.SurfDao;


@Component
public class SurfOutputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Ma planche de surf");

    @Autowired
    private SurfDao surfDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + surfDao.count());

        // Crée une nouvelle planche de surf et enregistres la dans la BDD
        Surf surf1 = new Surf("Slingshot", "Tyrant", 349);
        LOG.info("******************");
        LOG.info(surf1 + " has been created !");
        surfDao.save(surf1);
        LOG.info(surf1 + " has been saved !");

        // Crée une 2eme planche de surf et enregistres la dans la BDD
        Surf surf2 = new Surf("Butcher", "Shark", 679);
        LOG.info("******************");
        LOG.info(surf2 + " has been created !");
        surfDao.save(surf2);
        LOG.info(surf2 + " has been saved !");

        // Lit les informations correspondant au second surf
        Surf tempUser = surfDao.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second surf's name is " + tempUser.getName());
        LOG.info("Second surf's brand is " + tempUser.getBrand());
        LOG.info("Second surf's price is " + tempUser.getPrice());

        // Liste les surfs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Surfs in list are ");
        for(Surf mySurf : surfDao.findAll()) {
            LOG.info(mySurf.toString());
        };

        // Update et save le nom du surf 1 dans la BDD
        surf1.setName("Baker");
        surfDao.save(surf1);


        // Supprime le second surf de la BDD
        surfDao.deleteById(2L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */

        /*     Liste les surfs enregistrés dans la BDD
             (permet de vérifier que le second surf
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Surfs in list are ");
        for(Surf mySurf : surfDao.findAll()) {
            LOG.info(mySurf.toString());
        };
    }    
}