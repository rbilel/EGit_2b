package tn.com.isamm.developpement.VenteAuxEncheres.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Historique
 *
 */
@Embeddable
public class Historique implements Serializable {

	   
	@Id
	private long id_historique;
	private long id_obj;
	private long id_mbr;
	private int montant;
	@Temporal(TemporalType.DATE)
	private Date date;
	private static final long serialVersionUID = 1L;

	public Historique() {
		super();
	}   
	public long getId_historique() {
		return this.id_historique;
	}

	public void setId_historique(long id_historique) {
		this.id_historique = id_historique;
	}   
	public long getId_obj() {
		return this.id_obj;
	}

	public void setId_obj(long id_obj) {
		this.id_obj = id_obj;
	}   
	public long getId_mbr() {
		return this.id_mbr;
	}

	public void setId_mbr(long id_mbr) {
		this.id_mbr = id_mbr;
	}   
	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
   
}
