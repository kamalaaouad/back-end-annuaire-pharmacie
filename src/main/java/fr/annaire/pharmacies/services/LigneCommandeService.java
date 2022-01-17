package fr.annaire.pharmacies.services;

import fr.annaire.pharmacies.Interfaces.InterfaceGeneric;
import fr.annaire.pharmacies.Repositories.LigneCommandeDao;
import fr.annaire.pharmacies.entities.Commande;
import fr.annaire.pharmacies.entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeService implements InterfaceGeneric<LigneCommande> {

    @Autowired
    private LigneCommandeDao ligneCommandeDao;

    @Override
    public LigneCommande create(LigneCommande l) {
        try {
            return ligneCommandeDao.save(l);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    @Override
    public LigneCommande update(LigneCommande l) {
        try {
            return  ligneCommandeDao.save(l);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(long id) {
        try {
            ligneCommandeDao.deleteById(id);
            return "deleted";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error in delete";
        }
    }

    @Override
    public LigneCommande findById(long id) {
        Optional<LigneCommande> ligneCommande=ligneCommandeDao.findById(id);
        if(ligneCommande.isPresent()) {
            return ligneCommande.get();
        }
        return null;
    }

    @Override
    public List<LigneCommande> findAll() {
        return ligneCommandeDao.findAll();
    }
}
