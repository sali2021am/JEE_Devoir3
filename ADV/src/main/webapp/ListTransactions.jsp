<%@page import="ma.products.Produit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" %>
<%@ page import="java.util.List" %>

<h1>Bienvenue!</h1>


La liste des Transactions  :
<%
List<Produit> product = (List<Produit>) request.getAttribute("products");
if(product != null) {
    String trs = "<table border=\"1\"><tr>"+"<th>Reference</th><th>CptDep</th><th>CptCred</th><th>Montant</th><th>type</th><th>date</th></tr>";
    for(Produit p : product) {
        trs+="<tr><td>"+p.getid()+"</td><td>"+p.getCptDep()+"</td><td>"+p.getCptCred()+"</td><td>"+p.getMontant()+"</td><td>"+p.getType()+"</td><td>"+p.getDate()+"</td></tr>";
    }
    trs+="</table>";
    out.print(trs);
} else {
    out.print("La liste de produits n'est pas disponible");
}
%>

</body>
</html>

