/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cds;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author hoangnv
 */
public class FetchXML {

    public void setJson(String json) {

    }

    public String getJson() {
        JSONObject json = null;
        try {
            //Fetch the XML document from the W3C site.
            String xml = "";
            URL url = new URL("http://www.w3schools.com/xml/cd_catalog.xml");
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //Read the document records.
            String line = null;
            while ((line = in.readLine()) != null) {
                xml += line;
            }
            in.close();
            xml = xml.replace("'", "");//clean up the XML
            //Transform the XML document into a JSON object.
            json = XML.toJSONObject(xml.toLowerCase());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FetchXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FetchXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json.toString();
    }
}
