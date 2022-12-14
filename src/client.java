import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Hello bang ini Thread");
        pr.flush();

        MultithreadThing myThing = new MultithreadThing();

        myThing.start();
    }
}
