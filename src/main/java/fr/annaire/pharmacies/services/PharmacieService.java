package fr.annaire.pharmacies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.annaire.pharmacies.Interfaces.InterfaceGeneric;
import fr.annaire.pharmacies.Repositories.PharmacieDao;
import fr.annaire.pharmacies.entities.Pharmacie;

@Service
public class PharmacieService implements InterfaceGeneric<Pharmacie> {

	@Autowired
	private PharmacieDao pharmacieDao;
	@Override
	public Pharmacie create(Pharmacie o) {
		try {
			return pharmacieDao.save(o);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
		
	}

	@Override
	public Pharmacie update(Pharmacie o) {
		try {
			return pharmacieDao.save(o);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
		
	}

	@Override
	public String delete(long id) {
		try {
			pharmacieDao.deleteById(id);
			return "deleted";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "error in delete";
		}
	}

	@Override
	public Pharmacie findById(long id) {
		Optional<Pharmacie> pharmacie=pharmacieDao.findById(id);
		if(pharmacie.isPresent()) {
			return pharmacie.get();
		}
		return null;
	}

	@Override
	public List<Pharmacie> findAll() {
		// TODO Auto-generated method stub
		return pharmacieDao.findAll();
	}

}
