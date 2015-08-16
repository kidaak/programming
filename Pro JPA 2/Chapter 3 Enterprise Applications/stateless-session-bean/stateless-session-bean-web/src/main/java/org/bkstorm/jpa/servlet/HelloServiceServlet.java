/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.jpa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bkstorm.jpa.stateless.HelloService;

/**
 *
 * @author Nguyen
 */
@WebServlet(name = "HelloServiceServlet", urlPatterns = {"/HelloServiceServlet"})
public class HelloServiceServlet extends HttpServlet {

    private final String TITLE
            = "Chapter 3: Stateless Session Bean Example";

    private final String DESCRIPTION
            = "This example demonstrates the basics of defining and accessing "
            + "a Stateless Session Bean. </br>"
            + "Enter a name and click 'Go'.  This will trigger a servlet client that talks "
            + "to a Stateless Session Bean to create a 'hello' String that is then "
            + "displayed in the browser.";

    @EJB
    private HelloService helloService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);

        // if there was a name submitted, print the hello string
        String name = request.getParameter("name");
        if (name != null) {
            // use the service to print the 'hello' string to the html stream
            out.println(helloService.sayHello(name));
        }
        printHtmlFooter(out);
    }

    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
        out.println("<center><h1>" + TITLE + "</h1></center>");
        out.println("<p>" + DESCRIPTION + "</p>");
        out.println("</hr>");
        out.println("<form action=\"HelloServiceServlet\" method=\"POST\">");
        out.println("<table><tbody>");
        out.println("<tr><td>Name:</td><td><input type=\"text\" name=\"name\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<input name=\"action\" type=\"submit\" value=\"Go\"/>");
        out.println("</form>");
        out.println("<hr/>");
    }

    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }

}
