package fr.annaire.pharmacies.services;

import fr.annaire.pharmacies.Interfaces.InterfaceGeneric;
import fr.annaire.pharmacies.Repositories.CommandeDao;
import fr.annaire.pharmacies.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements InterfaceGeneric<Commande> {

    @Autowired
    private CommandeDao commandeDao;


    @Override
    public Commande create(Commande c) {
        try {
            return commandeDao.save(c);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    @Override
    public Commande update(Commande c) {
        try {
            return commandeDao.save(c);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(long id) {
        try {
            commandeDao.deleteById(id);
            return "deleted";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error in delete";
        }
    }

    @Override
    public Commande findById(long id) {
        Optional<Commande> commande=commandeDao.findById(id);
        if(commande.isPresent()) {
            return commande.get();
        }
        return null;
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }



}
