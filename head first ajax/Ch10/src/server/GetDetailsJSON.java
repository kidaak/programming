/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

/**
 *
 * @author hoangnv
 */
public class GetDetailsJSON extends HttpServlet {

    Map<String, Object> data = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        Gson gson = new Gson();
        Item itemGuitar = new Item("itemGuitar",
                "Pete Townshend once played this guitar while his own axe was in the shop having bits of drumkit removed from it.",
                5695.99f, "http://www.thewho.com/", "http://en.wikipedia.org/wiki/Pete_Townshend");
        Item itemShades = new Item("itemShades",
                "Yoko Ono\\'s sunglasses. While perhaps not valued much by Beatles fans, this pair is rumored to have been licked by John Lennon.",
                258.99f, "http://www.beatles.com/", "http://www.yoko-ono.com/");
        Item itemCowbell = new Item("itemCowbell",
                "Remember the famous \"more cowbell\" skit from Saturday Night Live? Well, this is the actual cowbell.",
                299.99f,
                "http://www.nbc.com/Saturday_Night_Live/",
                "http://en.wikipedia.org/wiki/More_cowbell");
        Item itemHat = new Item("itemHat",
                "Michael Jackson\\'s hat as worn in the \"Bille Jean\" video. Not really rock memorabilia, but it smells better than Slash\\'s tophat.",
                1699.99f,
                "http://www.michaeljackson.com/",
                "http://music.yahoo.com/vid-2143030--Billie-Jean");
        data.put("itemGuitar", gson.toJson(itemGuitar));
        data.put("itemShades", gson.toJson(itemShades));
        data.put("itemCowbell", gson.toJson(itemCowbell));
        data.put("itemHat", gson.toJson(itemHat));
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
            out.println(data.get(request.getParameter("ImageId")));
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
