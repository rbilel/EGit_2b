package tn.com.isamm.developpement.VenteAuxEncheres.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tn.com.isamm.developpement.VenteAuxEncheres.dao.ObjetDao;
import tn.com.isamm.developpement.VenteAuxEncheres.model.Objet;

public class ObjetDaoImp implements ObjetDao {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("myPersistenceUnit");

	private static EntityManager em = emf.createEntityManager();

	@Override
	public void ajouterObjet(Objet objet) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
	}

	@Override
	public void modifierObjet(Objet objet) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(objet);
		em.getTransaction().commit();
	}

	@Override
	public void supprimerObjet(Objet objet) {
		// TODO Auto-generated method stub
		objet = findById(objet.getIdObjet());
		em.getTransaction().begin();
		em.remove(objet);
		em.getTransaction().commit();
	}

	@Override
	public Objet findById(long id) {
		// TODO Auto-generated method stub
		Objet objet = em.find(Objet.class, id);
		return objet;
	}

}
