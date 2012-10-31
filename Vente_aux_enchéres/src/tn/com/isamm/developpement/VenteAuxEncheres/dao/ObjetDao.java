package tn.com.isamm.developpement.VenteAuxEncheres.dao;

import tn.com.isamm.developpement.VenteAuxEncheres.model.Objet;

public interface ObjetDao {
	//Ajouter objet
	public void ajouterObjet(Objet objet);

	public void modifierObjet(Objet objet);

	public void supprimerObjet(Objet objet);

	public Objet findById(long id);
}
