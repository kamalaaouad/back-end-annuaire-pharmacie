package fr.annaire.pharmacies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.annaire.pharmacies.entities.Pharmacie;
import fr.annaire.pharmacies.services.PharmacieService;

@RestController
@RequestMapping("/api/pharmacie")
public class PharmcieController {

	@Autowired
	private PharmacieService pharmacieService;
	
	@PostMapping("/create")
	public ResponseEntity<Pharmacie> create(@RequestBody Pharmacie p){
		if(pharmacieService.create(p).equals(null)) {
			return new ResponseEntity<Pharmacie>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Pharmacie>(pharmacieService.create(p), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Pharmacie> update(@RequestBody Pharmacie p){
		if(pharmacieService.create(p).equals(null)) {
			return new ResponseEntity<Pharmacie>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<Pharmacie>(pharmacieService.update(p), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") long id) {
		return pharmacieService.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pharmacie> findById(@PathVariable("id") long id){
		if(pharmacieService.findById(id).equals(null)) {
			return new ResponseEntity<Pharmacie>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pharmacie>(pharmacieService.findById(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Pharmacie>> findAll() {
		if(pharmacieService.findAll().equals(null)) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Pharmacie>>(pharmacieService.findAll(), HttpStatus.CREATED);
	}
	
}
