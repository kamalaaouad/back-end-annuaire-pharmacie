package fr.annaire.pharmacies.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.annaire.pharmacies.entities.Pharmacie;

@EnableJpaRepositories
public interface PharmacieDao extends JpaRepository<Pharmacie, Long> {

}
