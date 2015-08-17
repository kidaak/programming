/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author hoangnv
 */
public class DictionaryListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        FileInputStream fis = null;
        try {
            File file = new File(sce.getServletContext().getRealPath("/files/dictionary.txt"));
            fis = new FileInputStream(file);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));
            HashSet<String> dictionary = new HashSet<>();
            String word;
            while ((word = buffer.readLine()) != null) {
                dictionary.add(word);
            }
            sce.getServletContext().setAttribute("dictionary", dictionary);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DictionaryListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DictionaryListener.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(DictionaryListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
