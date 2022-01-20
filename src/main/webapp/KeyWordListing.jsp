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
        <%if (!products.isEmpty()) {%>
            <table border="1">
                <tr>
                    <th>Tulajdonos</th>
                    <th>Név</th>
                    <th>Ár</th>
                    <th>Lefoglalás</th>
                </tr>
                <%for (Product prod : products)                               
                {%>
                    <tr>
                    <td><%=prod.getOwnerEmailAddress()%></td>
                    <td><%=prod.getName()%></td>
                    <td><%=prod.getPrice()%></td>
                    <td>
                        <%if (prod.getBookingEmailAddress()==null) {%>
                        <a href="BookingServlet?ownerToBook=<%=prod.getOwnerEmailAddress()%>
                           &nameToBook=<%=prod.getName()%>
                           &priceToBook=<%=prod.getPrice()%>">lefoglalás</a>
                        <%}
                        else{%>
                            foglalt
                        <%}%> 
                    </td>
                    </tr>
                    <%}%>
            </table>
            <%}
        else{
            %>nincs a kulcsszónak megfelelő elem<br><%
        }
        %>
        
        <a href="Advertisers.jsp">vissza</a>
    </body>
</html>
