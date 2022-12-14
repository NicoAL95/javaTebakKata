import java.net.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("Client connected");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Client: " + str);

        // ParentFunc prn = new ParentFunc("Marc");
        // System.out.println("Tebak Kata Nico Abel Laia - 20215520010");
        // System.out.println("Hy Gez : " + prn.getSambutan());
    }

    // Input Kata

    // Clue Kata

    // Multithread

    // File

    // Newtwork
}
