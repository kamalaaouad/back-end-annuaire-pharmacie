package fr.annaire.pharmacies.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class LigneCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ref;
	private String nomligne;
	private int quantite;
	private double prix;

	@ManyToMany(targetEntity = Pharmacie.class)
	@JsonBackReference
	private List<Pharmacie> pharmacies;
	@ManyToMany(targetEntity = Commande.class)
	@JsonBackReference
	private List<Commande> commandes;

	public List<Pharmacie> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<Pharmacie> pharmacies) {
		this.pharmacies = pharmacies;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getNomligne() {
		return nomligne;
	}

	public void setNomligne(String nomligne) {
		this.nomligne = nomligne;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneCommande{" + "ref='" + ref + '\'' + ", nomligne='" + nomligne + '\'' + ", quantite=" + quantite
				+ ", prix=" + prix +
				// ", commande=" + commande +
				'}';
	}
}
