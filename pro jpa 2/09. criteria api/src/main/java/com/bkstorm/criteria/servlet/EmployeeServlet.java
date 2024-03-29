package com.bkstorm.criteria.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkstorm.criteria.model.Employee;
import com.bkstorm.criteria.stateless.SearchService;

public class EmployeeServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 7939699001096405243L;

    private final String TITLE = "Chapter 9: Employee Search Service using Criteria API Example";

    private final String DESCRIPTION = "This example allows you to search for employees using one or more query criteria.";

    // inject a reference to the SearchService slsb
    @EJB
    SearchService service;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

//        printHtmlHeader(out);

        // process request
        String action = request.getParameter("action");
        if (action == null) {
            // do nothing if no action requested
        } else if (action.equals("FindEmployees")) {
            out.println("CriteriaQuery: ");
            String name = request.getParameter("name");
            if ("".equals(name)) {
                name = null;
            }
            String dept = request.getParameter("dept");
            if ("".equals(dept)) {
                dept = null;
            }
            String project = request.getParameter("project");
            if ("".equals(project)) {
                project = null;
            }
            String city = request.getParameter("city");
            if ("".equals(city)) {
                city = null;
            }

            Collection<Employee> emps = service.findEmployees(name, dept, project, city, out);

            if (emps.isEmpty()) {
                out.println("<br/>No Employees found ");
            } else {
                out.println("<br/>Found Employees:<br/>");
                for (Employee emp : emps) {
                    out.print(emp + "<br/>");
                }
            }
        }

        printHtmlFooter(out);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
        out.println("<center><h1>" + TITLE + "</h1></center>");
        out.println("<p>" + DESCRIPTION + "</p>");
        out.println("<hr/>");
        out.println("<form action=\"EmployeeServlet\" method=\"POST\">");

        // form to find Employees
        out.println("<h3>Find Employees</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td>Name:</td><td><input type=\"text\" name=\"name\"/>(String)</td></tr>");
        out.println("<tr><td>DeptName:</td><td><input type=\"text\" name=\"dept\" />(String)</td></tr>");
        out.println("<tr><td>ProjectName:</td><td><input type=\"text\" name=\"project\" />(String)</td></tr>");
        out.println("<tr><td>City:</td><td><input type=\"text\" name=\"city\" />(String)</td>"
                + "<td><input name=\"action\" type=\"submit\" value=\"FindEmployees\"/></td></tr>");
        out.println("</tbody></table>");

        // show all Employees
        out.println("<hr/>");
        out.println("<br/>Employees: ");
        Collection<Employee> emps = service.findAllEmployees();
        for (Employee emp : emps) {
            out.println("<br/>" + emp);
        }
        out.println("<hr/>");
    }

    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
