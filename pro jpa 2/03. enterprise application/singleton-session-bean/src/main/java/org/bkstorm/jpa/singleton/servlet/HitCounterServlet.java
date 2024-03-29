/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.jpa.singleton.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bkstorm.jpa.singleton.bean.HitCounter;

/**
 *
 * @author Nguyen
 */
@WebServlet(name = "HitCounterServlet", urlPatterns = {"/HitCounterServlet"})
public class HitCounterServlet extends HttpServlet {

    private final String TITLE
            = "Chapter 3: Singleton Session Bean Example";

    private final String DESCRIPTION
            = "This example demonstrates the basic use of a "
            + "Singleton Session Bean. </br>"
            + "The simple example allows you to call and update the count stored in the singleton bean.";

    @EJB
    private HitCounter counter;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);

        // process request
        if (request.getParameter("list") != null) {
            out.println("Count: " + counter.getCount());
        } else if (request.getParameter("increment") != null) {
            counter.increment();
            out.println("Count incremented.");
        } else if (request.getParameter("reset") != null) {
            counter.reset();
            out.println("Count reset.");
        }

        printHtmlFooter(out);
    }

    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
        out.println("<center><h1>" + TITLE + "</h1></center>");
        out.println("<p>" + DESCRIPTION + "</p>");
        out.println("<hr/>");
        out.println("<form action=\"HitCountServlet\" method=\"GET\">");
        out.println("<input name=\"list\" type=\"submit\" value=\"Get Count\"/>");
        out.println("<input name=\"increment\" type=\"submit\" value=\"Incremement Count\"/>");
        out.println("<input name=\"reset\" type=\"submit\" value=\"Reset Count\"/>");
        out.println("</form>");
    }

    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
