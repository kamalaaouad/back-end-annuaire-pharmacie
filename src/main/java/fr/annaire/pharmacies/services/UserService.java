package fr.annaire.pharmacies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.annaire.pharmacies.Interfaces.InterfaceGeneric;
import fr.annaire.pharmacies.Repositories.UserDao;
import fr.annaire.pharmacies.entities.User;

@Service
public class UserService implements InterfaceGeneric<User> {

	@Autowired
	private UserDao userDao;
	@Override
	public User create(User o) {
		try {
			return userDao.save(o);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public User update(User o) {
		try {
			return userDao.save(o);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String delete(long id) {
		try {
			userDao.deleteById(id);
			return "deleted";
		} catch (Exception e) {
			// TODO: handle exception
			return "not deleted";
		}
	}

	@Override
	public User findById(long id) {
		Optional<User> user=userDao.findById(id);
		if(user.isPresent())
			return user.get();
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

}
