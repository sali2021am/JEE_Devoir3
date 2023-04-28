package ma.produit.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ma.products.Produit;


public class produitDaoImpt implements ProduitDao {
	public EntityManagerFactory ef = Persistence.createEntityManagerFactory("kcPersistenceUnit");
	public EntityManager em  = ef.createEntityManager();
	
	public void addProduit(Produit p) {
		em.getTransaction().begin();
		try {
		em.merge(p);
		em.getTransaction().commit();
		
		}catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}
	public List<Produit> listProduits() {
		Query query = em.createQuery("select p from Produit p");
		return query.getResultList();
		
}

	
	
	
}	
