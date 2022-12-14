// Nico Abel Laia - 20215520010 | UAS PBO TI 2021

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Hello bang ini Thread");
        pr.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Nico Abel Laia - 20215520010 - Server: " + str);

        MultithreadThing myThing = new MultithreadThing(pr);

        myThing.start();
    }
}
