package fr.annaire.pharmacies.Repositories;

import fr.annaire.pharmacies.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CommandeDao  extends JpaRepository <Commande, Long>{
}
