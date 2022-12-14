// Nico Abel Laia - 20215520010 | UAS PBO TI 2021

public class ServerStatus extends ServerStop {
    protected String serStats;

    // Encapsulation
    public String getStats(){
        return "connected";
    }

    // Polymorphism
    public String ServerLoad(){
        return "Online";
    }
}
