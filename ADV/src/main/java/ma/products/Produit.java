package ma.products;


import java.io.Serializable; 

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity 
@Table(name= "produits")
public class Produit implements Serializable {
	@Id
	 
	private String id ;
	private String CptDep ;
	
	private String CptCred ;
	
	private String type ;
	
	private String date ;
	private Double Montant ;

	public String getid() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getCptDep() {
		return CptDep;
	}
	public void setCptDep(String cptDep) {
		CptDep = cptDep;
	}
	public String getCptCred() {
		return CptCred;
	}
	public void setCptCred(String cptCred) {
		CptCred = cptCred;
	}
	public Double getMontant() {
		return Montant;
	}
	public void setMontant(Double montant) {
		Montant = montant;
	}
	public Produit(String id, String cptDep, String cptCred, Double montant) {
		super();
		this.id = id;
		CptDep = cptDep;
		CptCred = cptCred;
		Montant = montant;

		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
		this.date = format.format(d);
		if(this.CptDep.subSequence(0, 3).equals(this.CptCred.subSequence(0, 3))){
			this.type = "VIRINT";
		}else {
			this.type = "VIRCHA";
		}

	}

	public Produit() {
		super();
	}


}
