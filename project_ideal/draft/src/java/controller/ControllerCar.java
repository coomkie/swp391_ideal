/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOCar;
import dao.DAORenter;
import dao.DAOUser;
import entity.Car;
import entity.user;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "ControllerCar", urlPatterns = {"/carURL"})
public class ControllerCar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerCar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void becomeRenter(user User, Car Car) {
        DAOCar daoCar = new DAOCar();
        DAOUser daoUser = new DAOUser();
        DAORenter daoRenter = new DAORenter();
        //add car
        Car newCar = new Car(User.getFullName(),
                Car.getCarBrandID(),
                Car.getCarName(),
                Car.getCarPricePerDay(),
                Car.getFuelType(),
                Car.getCarLicense());
        daoCar.insertCar(newCar);
        //update renter = 1
        daoUser.updateUserRent(User);
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
        int CarBrandID = Integer.parseInt(request.getParameter("CarBrandID"));
        String CarName = request.getParameter("CarName");
        int CarPricePerDay = Integer.parseInt(request.getParameter("CarPricePerDay"));
        String FuelType = request.getParameter("FuelType");
        String CarLicense = request.getParameter("CarLicense");
        HttpSession session = request.getSession();
        user User = (user) session.getAttribute("account");
        DAOCar daoCar = new DAOCar();
        Car newCar = new Car(User.getFullName(), CarBrandID, CarName, CarPricePerDay, FuelType, CarLicense);
        becomeRenter(User, newCar);
        request.setAttribute("newCar", newCar);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
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
