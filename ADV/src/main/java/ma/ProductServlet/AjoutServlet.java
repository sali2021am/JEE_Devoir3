package ma.ProductServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.products.Produit;

import ma.produit.dao.ProduitDao;

import ma.produit.dao.produitDaoImpt;


@WebServlet("/AjoutServlet")
public class AjoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AjoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref");
	    String CptDep = request.getParameter("CptDep");
	    String CptCred = request.getParameter("CptCred");
	    Double Montant = Double.parseDouble(request.getParameter("Montant"));

		
		Produit p = new Produit(ref,CptDep,CptCred,Montant);
		ProduitDao dao = new  produitDaoImpt();
		dao.addProduit(p);
		
		List<Produit> Products = dao.listProduits();
		request.setAttribute("products", Products);
		this.getServletContext().getRequestDispatcher("/ListTransactions.jsp").forward(request,response);
		
		
	}

}
