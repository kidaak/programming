/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictions2;

import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletContext;

/**
 *
 * @author hoangnv
 */
public class Predictions {

    private ConcurrentMap<Integer, Prediction> predictions;
    private ServletContext sctx;
    private AtomicInteger mapKey;

    public Predictions() {
        predictions = new ConcurrentHashMap<>();
        mapKey = new AtomicInteger();
    }

    public ServletContext getServletContext() {
        return sctx;
    }

    public void setServletContext(ServletContext sctx) {
        this.sctx = sctx;
    }

    public ConcurrentMap<Integer, Prediction> getMap() {
        //has the servletcontext been set?
        if (getServletContext() == null) {
            return null;
        }
        //has the data been read already?
        if (predictions.size() < 1) {
            populate();
        }
        return this.predictions;
    }

    public String toXML(Object obj) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            XMLEncoder encoder = new XMLEncoder(out);
            encoder.writeObject(obj);
            encoder.close();
            return out.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public int addPrediction(Prediction p) {
        int id = mapKey.incrementAndGet();
        p.setId(id);
        predictions.put(id, p);
        return id;
    }

    private void populate() {
        String filename = "/WEB-INF/data/predictions.db";
        InputStream in = sctx.getResourceAsStream(filename);
        //Read the data into the array of Predictions.
        if (in != null) {
            try {
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(isr);
                int i = 0;
                String record = null;
                while ((record = reader.readLine()) != null) {
                    String[] parts = record.split("!");
                    Prediction p = new Prediction();
                    p.setWho(parts[0]);
                    p.setWhat(parts[1]);
                    addPrediction(p);
                }
            } catch (IOException e) {

            }
        }
    }
}
