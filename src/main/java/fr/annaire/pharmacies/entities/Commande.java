package fr.annaire.pharmacies.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String BonCommande;
    private Date date_Commande;
    private String moyen_paiement;
    private double total_commande;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    private User userr;

    @ManyToMany
    @JsonManagedReference
    private List <LigneCommande> ligneCommandes;

    public User getUserr() {
		return userr;
	}

	public void setUserr(User userr) {
		this.userr = userr;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBonCommande() {
        return BonCommande;
    }

    public void setBonCommande(String bonCommande) {
        BonCommande = bonCommande;
    }

    public Date getDate_Commande() {
        return date_Commande;
    }

    public void setDate_Commande(Date date_Commande) {
        this.date_Commande = date_Commande;
    }

    public String getMoyen_paiement() {
        return moyen_paiement;
    }

    public void setMoyen_paiement(String moyen_paiement) {
        this.moyen_paiement = moyen_paiement;
    }

    public double getTotal_commande() {
        return total_commande;
    }

    public void setTotal_commande(double total_commande) {
        this.total_commande = total_commande;
    }

    public User getUser() {
        return userr;
    }

    public void setUser(User user) {
        this.userr = user;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "BonCommande='" + BonCommande + '\'' +
                ", date_Commande=" + date_Commande +
                ", moyen_paiement='" + moyen_paiement + '\'' +
                ", total_commande='" + total_commande + '\'' +
                ", user=" + userr +
                '}';
    }
}
