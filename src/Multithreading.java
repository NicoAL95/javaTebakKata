public class Multithreading {
    public static void main(String[] args) {
        MultithreadThing myThing = new MultithreadThing();
        MultithreadThing myThing2 = new MultithreadThing();

        myThing.start();
        myThing2.start();
    }
}
