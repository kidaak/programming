
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hoangnv
 */
public class UrlConnectionClient {

    public static void main(String[] args) {
        //usage
        if (args.length < 1) {
            System.err.println("Usage: UrlConnectionClient <url>");
            return;
        }
        try {
            //Parse the URL.
            URL url = new URL(args[0].trim());

            //Connect.
            URLConnection sock = url.openConnection();

            //Read and print
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String next_record;
            while ((next_record = reader.readLine()) != null) {
                System.out.println(next_record);
            }
            //Close 
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(UrlConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
