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

import fr.annaire.pharmacies.entities.User;
import fr.annaire.pharmacies.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User p) {
		System.out.println("hello "+p);
		if (userService.create(p).equals(null)) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else
			return new ResponseEntity<User>(userService.create(p), HttpStatus.CREATED);
//		return null;
	}

	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User p) {
		if (userService.create(p).equals(null)) {
			return new ResponseEntity<User>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<User>(userService.update(p), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") long id) {
		return userService.delete(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") long id) {
		if (userService.findById(id).equals(null)) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(userService.findById(id), HttpStatus.FOUND);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> findAll() {
		if (userService.findAll().equals(null)) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.CREATED);
	}
}
