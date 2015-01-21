
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
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
public class SimpleHttpClient {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: SimpleHttpClient <url>");
            return;
        }
        try {
            //Parse the URL.
            URL url = new URL(args[0]);
            String host = url.getHost();
            String path = url.getPath();
            int port = url.getPort();
            if (port < 0) {
                port = 80;
            }
            //Send the request.
            String request = "GET " + path + " HTTP/1.1\n";
            request += "host: " + host;
            request += "\n\n";
            Socket sock = new Socket(host, port);
            PrintWriter writer = new PrintWriter(sock.getOutputStream());
            writer.print(request);
            writer.flush();
            //Read and print response
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String next_record = null;
            while ((next_record = reader.readLine()) != null) {
                System.out.println(next_record);
            }
            sock.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SimpleHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
