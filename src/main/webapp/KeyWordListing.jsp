<%-- 
    Document   : KeyWordListing
    Created on : 2022. jan. 7., 9:43:39
    Author     : IBT
--%>

<%@page import="model.AdvertiserDAO"%>
<%@page import="model.Advertiser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Kulcsszavaknak megfelelnek:</h1>
        <%List<Product> products = (ArrayList<Product>)request.getSession().getAttribute("selectedproducts");%>
        <%AdvertiserDAO aDao = new AdvertiserDAO();%>
        <table border="1">
            <tr><th>Tulajdonos</th><th>Email</th><th>Név</th><th>Ár</th><th>Lefoglalás</th></tr>
            <%for (Product prod : products)                               
            {%>
                <tr>
                <td><%=aDao.readOne(prod.getAdvId()).getName()%></td>
                <td><%=aDao.readOne(prod.getAdvId()).getEmailAddress()%></td>
                <td><%=prod.getProductName()%></td>
                <td><%=prod.getPrice()%></td>
                <td>
                    <%if (prod.getBookerId() < 1) {%>
                    <a href="BookingServlet?ownerIdToBook=<%=prod.getAdvId()%>&prodIdToBook=<%=prod.getId()%>">lefoglalás</a>
                    <%}
                    else{%>
                        foglalt
                    <%}%> 
                </td>
                </tr>
                <%}%>
        </table>
        <a href="Advertisers.jsp">vissza</a>
    </body>
</html>
