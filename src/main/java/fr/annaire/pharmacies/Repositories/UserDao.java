package fr.annaire.pharmacies.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.annaire.pharmacies.entities.User;

@EnableJpaRepositories
public interface UserDao extends JpaRepository<User, Long> {

}
