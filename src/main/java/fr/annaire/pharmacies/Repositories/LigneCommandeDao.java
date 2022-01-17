package fr.annaire.pharmacies.Repositories;


import fr.annaire.pharmacies.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface LigneCommandeDao extends JpaRepository <LigneCommande,Long>{
}
