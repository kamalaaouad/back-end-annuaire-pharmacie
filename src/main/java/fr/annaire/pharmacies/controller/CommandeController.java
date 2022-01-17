package fr.annaire.pharmacies.controller;


import fr.annaire.pharmacies.entities.Commande;
import fr.annaire.pharmacies.entities.Pharmacie;
import fr.annaire.pharmacies.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;


    @PostMapping("/create")
    public ResponseEntity<Commande> create(@RequestBody Commande c){
        if(commandeService.create(c).equals(null)) {
            return new ResponseEntity<Commande>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Commande>(commandeService.create(c), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Commande> update(@RequestBody Commande c ){
        if(commandeService.create(c).equals(null)) {
            return new ResponseEntity<Commande>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<Commande>(commandeService.update(c), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return commandeService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> findById(@PathVariable("id") long id){
        if(commandeService.findById(id).equals(null)) {
            return new ResponseEntity<Commande>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Commande>(commandeService.findById(id), HttpStatus.FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Commande>> findAll() {
        if(commandeService.findAll().equals(null)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Commande>>(commandeService.findAll(), HttpStatus.CREATED);
    }


}
