/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoangnv
 */
public class TestEL extends HttpServlet {

    private String[] movieList = {"The Lord of The Ring", "The Habbit", "Friends", "Kindaichi"};
    private String[] movies1 = {"The Lord of The Ring", "The Habbit", "Friends", "Kindaichi"};
    private String[] movies2 = {"Những ngọn nến trong đêm", "Phía trước là bầu trời", "Đất và người"};
    private List nestedMovie;

    @Override
    public void init() throws ServletException {
        super.init();
        nestedMovie = new ArrayList<>();
        nestedMovie.add(movies1);
        nestedMovie.add(movies2);
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
        int page = Integer.valueOf(request.getParameter("page"));
        switch (page) {
            case 470:
                request.setAttribute("movieList", movieList);
                RequestDispatcher view = request.getRequestDispatcher("TestEL470.jsp");
                view.forward(request, response);
                break;
            case 473:
                request.setAttribute("movies", nestedMovie);
                view = request.getRequestDispatcher("TestEL473.jsp");
                view.forward(request, response);
                break;
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
