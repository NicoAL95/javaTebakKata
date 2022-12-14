// Nico Abel Laia - 20215520010 | UAS PBO TI 2021

import java.net.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4999);

        ServerStatus st = new ServerStatus();
        
        while(true) {
            Socket s = ss.accept();

            System.out.println("Client connected");

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("Client: " + str);

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("Status: " + st.ServerLoad() + " | You're" + st.getStats() + ", enjoy the game!");
            pr.flush();

            MultithreadServer thread = new MultithreadServer(bf);
            thread.start();
        }
    }
}
