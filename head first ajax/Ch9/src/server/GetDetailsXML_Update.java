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
public class GetDetailsXML_Update extends HttpServlet {

    private final Map details = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        details.put("itemGuitar", "<?xml version=\"1.0\"?>\n"
                + "<item id=\"itemGuitar\">\n"
                + "	<category>\n"
                + "		<name>Manufacturer</name>\n"
                + "		<value>Gibson</value>\n"
                + "	</category>\n"
                + "	<category>\n"
                + "		<name>Model</name>\n"
                + "		<value>Les Paul Standard</value>\n"
                + "	</category>\n"
                + "	<category>\n"
                + "		<name>Description</name>\n"
                + "		<value>Pete Townshend once played this guitar while his own axe was in the shop having bits of drumkit removed from it.</value>\n"
                + "	</category>\n"
                + "	<category>\n"
                + "		<name>Price</name>\n"
                + "		<value>5695.99</value>\n"
                + "	</category>\n"
                + "  <category type=\"list\">\n"
                + "    <name>URLs</name>\n"
                + "    <value>http://www.thewho.com/</value>\n"
                + "    <value>http://en.wikipedia.org/wiki/Pete_Townshend</value>\n"
                + "  </category>\n"
                + "</item>");
        details.put("itemShades", "<?xml version=\"1.0\"?>\n"
                + "<item id=\"itemGuitar\">\n"
                + "        <category>\n"
                + "                <name>Description</name>\n"
                + "                <value>Yoko Ono's sunglasses. While perhaps not valued much by Beatles fans this pair is rumored to have been licked by John Lennon.</value>\n"
                + "        </category>\n"
                + "        <category>\n"
                + "                <name>Color</name>\n"
                + "                <value>Black</value>\n"
                + "        </category>\n"
                + "        <category>\n"
                + "                <name>Price</name>\n"
                + "                <value>258.99</value>\n"
                + "        </category>\n"
                + "  <category type=\"list\">\n"
                + "    <name>Worn By</name>\n"
                + "    <value>John Lennon</value>\n"
                + "    <value>Ringo Starr</value>\n"
                + "    <value>Yoko Ono</value>\n"
                + "  </category>\n"
                + "  <category type=\"list\">\n"
                + "    <name>URLs</name>\n"
                + "    <value>http://www.beatles.com/</value>\n"
                + "    <value>http://johnlennon.com/</value>\n"
                + "    <value>http://www.yoko-ono.com/</value>\n"
                + "  </category>\n"
                + "</item>");
        details.put("itemCowbell", "<?xml version=\"1.0\"?>\n"
                + "<item id=\"itemCowbell\">\n"
                + "        <category>\n"
                + "                <name>Description</name>\n"
                + "<value>Remember the famous \\\"more cowbell\\\" skit from Saturday Night Live? Well, this is the actual cowbell.</value>\n"
                + "        </category>\n"
                + "        <category>\n"
                + "                <name>Price</name>\n"
                + "                <value>299.99</value>\n"
                + "        </category>\n"
                + "  <category type=\"list\">\n"
                + "    <name>URLs</name>\n"
                + "    <value>http://www.nbc.com/Saturday_Night_Live/</value>\n"
                + "    <value>http://en.wikipedia.org/wiki/More_cowbell</value>\n"
                + "  </category>\n"
                + "</item>");
        details.put("itemHat", "<?xml version=\"1.0\"?>\n"
                + "<item id=\"itemHat\">\n"
                + " <category>\n"
                + "   <name>Description</name>\n"
                + "   <value>Michael Jackson's hat as worn in the \\\"Billie Jean\\\" video. Not really rock memorabilia but it smells better than Slash's tophat.</value>\n"
                + " </category>\n"
                + " <category>\n"
                + "  <name>Price</name>\n"
                + "  <value>1699.99</value>\n"
                + " </category>\n"
                + " <category>\n"
                + "  <name>Size</name>\n"
                + "  <value>6 1/4\\\"</value>\n"
                + " </category>\n"
                + "\n"
                + "  <category type=\"list\">\n"
                + "    <name>URLs</name>\n"
                + "    <value>http://www.michaeljackson.com/</value>\n"
                + "    <value>http://music.yahoo.com/vid-2143030--Billie-Jean</value>\n"
                + "  </category>\n"
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
