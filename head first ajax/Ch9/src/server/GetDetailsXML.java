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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoangnv
 */
public class GetDetailsXML extends HttpServlet {

    private final Map details = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        details.put("itemGuitar", "<?xml version=\"1.0\"?>\n"
                + "<item id=\"itemGuitar\">\n"
                + " <description>Pete Townshend once played this guitar while his own axe was in the shop having bits of drumkit removed from it</description>\n"
                + " <price>5695.99</price>\n"
                + " <resources>\n"
                + "   <url>http://www.thewho.com/</url>\n"
                + "   <url>http://en.wikipedia.org/wiki/Pete_Townshend</url>\n"
                + " </resources>\n"
                + "</item>");
        details.put("itemShades", "<?xml version=\"1.0\"?>\n"
                + "<item id=\"itemShades\">\n"
                + " <description>Yoko Ono's sunglasses. While perhaps not valued much by Beatles fans this pair is rumored to have been licked by John Lennon.</description>\n"
                + " <price>258.99</price>\n"
                + " <resources>\n"
                + "   <url>http://www.beatles.com/</url>\n"
                + "   <url>http://johnlennon.com/</url>\n"
                + "   <url>http://www.yoko-ono.com/</url>\n"
                + " </resources>\n"
                + "</item>");
        details.put("itemCowbell", "<?xml version=\"1.0\"?>\n"
                + "<item id=\"itemCowbell\">\n"
                + " <description>Remember the famous \\\"more cowbell\\\" skit\n"
                + "    from Saturday Night Live? Well, this is the actual\n"
                + "    cowbell.</description>\n"
                + " <price>299.99</price>\n"
                + " <resources>\n"
                + "   <url>http://www.nbc.com/Saturday_Night_Live/</url>\n"
                + "   <url>http://en.wikipedia.org/wiki/More_cowbell</url>\n"
                + " </resources>\n"
                + "</item>");
        details.put("itemHat", "<?xml version=\"1.0\"?>\n"
                + "<item id=\"itemHat\">\n"
                + " <description>Michael Jackson's hat as worn in the \\\"Billie Jean\\\" video. Not really rock memorabilia but it smells better than Slash's tophat.\n"
                + " </description>\n"
                + " <price>1699.99</price>\n"
                + " <resources>\n"
                + "   <url>http://www.michaeljackson.com/</url>\n"
                + "   <url>http://music.yahoo.com/vid-2143030--Billie-Jean</url>\n"
                + " </resources>\n"
                + "</item>");
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
        response.setContentType("text/xml;charset=UTF-8");
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
