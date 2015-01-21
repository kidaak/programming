/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictions2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author hoangnv
 */
public class PredictionsServlet extends HttpServlet {

    private Predictions predictions; //backend bean

    @Override
    public void init() throws ServletException {
        super.init();
        predictions = new Predictions();
        predictions.setServletContext(this.getServletContext());
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PredictionsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PredictionsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String param = request.getParameter("id");
        Integer key = (param == null) ? null : new Integer(param.trim());
        //Check user preference for XML or JSON by inspecting
        //the HTTP headers for the Accept key
        boolean json = false;
        String accept = request.getHeader("accept");
        if (accept != null && accept.contains("json")) {
            json = true;
        }
        //If no query string, assume client wants the full list.
        if (key == null) {
            ConcurrentMap<Integer, Prediction> map = predictions.getMap();
            //Sort the map's values for readability
            Object[] list = map.values().toArray();
            Arrays.sort(list);
            String xml = predictions.toXML(list);
            sendResponse(response, xml, json);
        } //Otherwise, return the specified Prediction
        else {
            Prediction pred = predictions.getMap().get(key);
            if (pred == null) {//no such Prediction
                String msg = key + "does not map to a prediction.\n";
                sendResponse(response, predictions.toXML(msg), false);
            } else {//requested Prediction found
                sendResponse(response, predictions.toXML(pred), json);
            }
        }
    }

    /**
     * HTTP body should contain two keys, one for the predictor ("who") and
     * another for the prediction ("what")
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String who = request.getParameter("who");
        String what = request.getParameter("what");
        //Are the data to create a new prediction present?
        if (who == null || what == null) {
            throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
        }
        //Create a Prediction.
        Prediction p = new Prediction();
        p.setWho(who);
        p.setWhat(what);
        //Save the ID of the newly created Prediction.
        int id = predictions.addPrediction(p);
        //Generate the confirmation message.
        String msg = "Prediction " + id + " created.\n";
        sendResponse(response, predictions.toXML(msg), false);
    }

    /*
     HTTP body should contain at least two keys: the prediction's id and either who or what
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         A workaround is necessary for a PUT request because neither Tomcat nor 
         Jetty generates a workable parameter map for this HTTP verb.
         */
        String key = null;
        String rest = null;
        boolean who = false;
        /*Let the hack begin*/
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String data = br.readLine();
            /*
             To simplify the hack, assume that the PUT request has exactly two parameters:
             the id and either who or what. Assume, further, that the id comes first.
             From the client side, a hash character # separates the id and the who/what, e.g.,
             id=33#who=Homer Allision
             */
            String[] args = data.split("#");
            String[] parts1 = args[0].split("=");
            key = parts1[1];
            String[] parts2 = args[1].split("=");
            if (parts2[0].contains("who")) {
                who = true;
            }
            rest = parts2[1];
        } catch (Exception e) {
            throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        //if no key, then the request is ill formed.
        if (key == null) {
            throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
        }
        //Look up the specified prediction.
        Prediction p = predictions.getMap().get(new Integer(key.trim()));
        if (p == null) {
            String msg = key + " does not map to a Prediction.\n";
            sendResponse(response, predictions.toXML(msg), false);
        } else {
            if (rest == null) {
                throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
            } else {
                if (who) {
                    p.setWho(rest);
                } else {
                    p.setWhat(rest);
                }
                String msg = "Prediction " + key + " has been edited.\n";
                sendResponse(response, predictions.toXML(msg), false);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("id");
        Integer key = (param == null) ? null : new Integer(param.trim());
        //Only one Prediction can be deleted at a time.
        if (key == null) {
            throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
        }
        try {
            predictions.getMap().remove(key);
            String msg = "Prediction " + key + " removed.\n";
            sendResponse(response, predictions.toXML(msg), false);
        } catch (Exception e) {
            throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
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

    public void sendResponse(HttpServletResponse response, String payload, boolean json) {
        try {
            if (json) {
                JSONObject jobt = XML.toJSONObject(payload);
                payload = jobt.toString();//3 is indentation level for nice look
            }
            OutputStream out = response.getOutputStream();
            out.write(payload.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
