package ma.products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("kcPersistenceUnit");
		EntityManager em  = ef.createEntityManager();
		
		Produit p = new Produit("2ID","yydd","dddzz",4.9);
			
	
			em.getTransaction().begin();
			
			em.merge(p);
			em.getTransaction().commit();
		
	}

}