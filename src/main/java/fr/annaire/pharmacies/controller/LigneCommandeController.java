 package fr.annaire.pharmacies.controller;

import fr.annaire.pharmacies.entities.Commande;
import fr.annaire.pharmacies.entities.LigneCommande;
import fr.annaire.pharmacies.services.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lignecommande")
public class LigneCommandeController {

    @Autowired
    private LigneCommandeService ligneCommandeService;


    @PostMapping("/create")
    public ResponseEntity<LigneCommande> create(@RequestBody LigneCommande l){
        if(ligneCommandeService.create(l).equals(null)) {
            return new ResponseEntity<LigneCommande>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<LigneCommande>(ligneCommandeService.create(l), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<LigneCommande> update(@RequestBody LigneCommande l ){
        if(ligneCommandeService.create(l).equals(null)) {
            return new ResponseEntity<LigneCommande>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<LigneCommande>(ligneCommandeService.update(l), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return ligneCommandeService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneCommande> findById(@PathVariable("id") long id){
        if(ligneCommandeService.findById(id).equals(null)) {
            return new ResponseEntity<LigneCommande>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LigneCommande>(ligneCommandeService.findById(id), HttpStatus.FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LigneCommande>> findAll() {
        if(ligneCommandeService.findAll().equals(null)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<LigneCommande>>(ligneCommandeService.findAll(), HttpStatus.CREATED);
    }
}
