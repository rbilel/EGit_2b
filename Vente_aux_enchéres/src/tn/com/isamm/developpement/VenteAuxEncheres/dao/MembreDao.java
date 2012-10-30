package tn.com.isamm.developpement.VenteAuxEncheres.dao;

import tn.com.isamm.developpement.VenteAuxEncheres.model.Membre;

public interface MembreDao {

	public void ajouterMembre(Membre membre);

	public void modifierMembre(Membre membre);

	public void supprimerMembre(Membre membre);

	public Membre findById(long id);
}
