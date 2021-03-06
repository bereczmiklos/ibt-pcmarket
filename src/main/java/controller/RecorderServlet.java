/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Advertiser;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author IBT
 */
@WebServlet(name = "RecorderServlet", urlPatterns = {"/RecorderServlet"})
public class RecorderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductDAO pDao = ProductDAO.getInstance();
        
        Advertiser loginedAdv = (Advertiser)request.getSession().getAttribute("advertiser");
        String name = request.getParameter("name");
        String keyWord = request.getParameter("keyword");
        String priceParam = request.getParameter("price");
        int price;
        
        if (!priceParam.equals("")) {
            price = Integer.parseInt(priceParam);
        }
        else{
            throw new RuntimeException("invalid price");
        }
        
        Product newProd = new Product(name, price, keyWord, loginedAdv.getEmailAddress());
        
        if (!name.isEmpty()) {
            loginedAdv.getProducts().add(newProd);
            pDao.create(newProd);
        }
        
        request.getRequestDispatcher("Advertisers.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
