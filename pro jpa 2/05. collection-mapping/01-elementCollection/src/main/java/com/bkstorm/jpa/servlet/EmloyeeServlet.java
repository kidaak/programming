/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.jpa.servlet;

import com.bkstorm.jpa.model.Employee;
import java.io.IOException;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoangnv
 */
public class EmloyeeServlet extends HttpServlet {

    @PersistenceUnit(unitName = "sample")
    private EntityManagerFactory emf;
    private EntityManager em;

    @Override
    public void init() throws ServletException {
        super.init();
//        emf = Persistence.createEntityManagerFactory("sample");
        em = emf.createEntityManager();
    }

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
        Query query = em.createQuery("SELECT e FROM Employee e");
        Collection<Employee> emps = (Collection<Employee>) query.getResultList();
        emps.stream().forEach((emp) -> {
            printEmployeeInfo(emp);
        });
    }

    private void printEmployeeInfo(Employee emp) {
        if (emp.getNickName() != null) {
            emp.getNickName().stream().forEach((nickName) -> {
                System.out.println(nickName);
            });
        }

        if (emp.getVacationBookings() != null) {
            emp.getVacationBookings().stream().forEach((vacation) -> {
                System.out.println(vacation.getStartDate());
            });
        }
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
