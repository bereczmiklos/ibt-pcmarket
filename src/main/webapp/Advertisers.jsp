<%-- 
    Document   : ProductListing
    Created on : 2022. jan. 7., 9:43:09
    Author     : IBT
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.AdvertiserDAO"%>
<%@page import="model.Advertiser"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Myprofile</title>
    </head>
    <body>
        <h1>Bejelentkezve</h1>
        <font size="+2" style="bold">Email:</font> 
        <%Advertiser loginedAdv = (Advertiser)session.getAttribute("advertiser");%>
        <%=loginedAdv.getEmailAddress()%><br>
        <a href="index.html">kijelentkezés</a>
        <br>
        
        <p><h2>Hirdetett termékeid:</h2>
        <%ProductDAO pDao = new ProductDAO();%>
        <%AdvertiserDAO aDao = new AdvertiserDAO();%>
          <table border="1">
            <tr>
                <th>Név</th>
                <th>Ár</th>
                <th>Lefoglalta</th>
            </tr>
            <%List<Product> products = new ArrayList<>();
            for (Product product : pDao.readAll()) {
                    if (product.getAdvId() == loginedAdv.getId()) {
                            products.add(product);
                        }
                }
            
            for (Product prod : products) {%>
                 <tr>
                      <td><%=prod.getProductName()%></td>
                      <td><%=prod.getPrice()%></td>
                      <%if (prod.getBookerId() == 0) {
                            %><td>-</td><%
                          }else{
                             %><td><%=aDao.readOne(prod.getBookerId()).getEmailAddress()%></td><%
                            }
                      %>
                 </tr>
                <% }%>
        </table>
        
        <p><h2>Új termék felvétele:</h2>
        <form action="RecorderServlet" method="post">
            <table>
                <tr><td>Név:</td><td><input type="text" name="name"></td></tr>
                <tr><td>Ár:</td><td><input type="text" name="price"></td></tr>
            </table>
            Kulcsszó: <select name="keyword" id="keyword-select">
                <option value="${Product.PROCESSOR}">processzor</option>
                <option value="${Product.MOTHERBOARD}">alaplap</option>
                <option value="${Product.MEMORY}">memória</option>
                <option value="${Product.POWERSUPPLY}">tápegység</option>
                <option value="${Product.VGA}">videókártya</option>
            </select><br>
            <input type="submit" name="recordSubmit" value="Felvesz">
        </form><br>
        
        <h2>Keresés:</h2>
        <form action="SearchServlet" method="post">
            <select name="searchedkeyword" id="keyword-select">
                <option value="${Product.PROCESSOR}">processzor</option>
                <option value="${Product.MOTHERBOARD}">alaplap</option>
                <option value="${Product.MEMORY}">memória</option>
                <option value="${Product.POWERSUPPLY}">tápegység</option>
                <option value="${Product.VGA}">videókártya</option>
            </select><br>
            <input type="submit" name="searchSubmit" value="Keresés">
        </form>
    </body>
</html>
