// Nico Abel Laia - 20215520010 | UAS PBO TI 2021

import java.io.PrintWriter;

public class MultithreadThing extends Thread {
    private PrintWriter w;
    MultithreadThing(PrintWriter w) {
        this.w = w;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            w.println(i);
            w.flush();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }
    
}
