/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoangnv
 */
@WebServlet(name = "GetDetails", urlPatterns = {"/getDetails"})
public class GetDetails extends HttpServlet {

    private final Map details = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        details.put("itemGuitar", "<p>Pete Townshend once played this guitar "
                + "while his own axe was in the shop having bits of drumkit removed from it.</p>");
        details.put("itemShades", "<p>Yoko Ono's sunglasses. While perhaps not "
                + "valued much by Beatles fans, this pair is rumored to have been licked by John Lennon.</p>");
        details.put("itemCowbell", "<p>Remember the famous \\\"more cowbell\\\""
                + " skit from Saturday Night Live? Well, this is the actual cowbell.</p>");
        details.put("itemHat", "<p>Michael Jackson's hat, as worn in the \\\"Billie Jean\\\""
                + " video. Not really rock memorabilia, but it smells better than Slash's tophat.</p>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(details.get(request.getParameter("ImageId")));
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
