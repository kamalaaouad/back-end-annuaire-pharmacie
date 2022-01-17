package fr.annaire.pharmacies.Interfaces;

import java.util.List;

public interface InterfaceGeneric<T> {
	T create(T o);
	T update(T o);
	String delete(long id);
	T findById(long id);
	List<T> findAll();
	
}
