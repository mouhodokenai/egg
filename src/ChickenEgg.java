public class ChickenEgg {
    public static void main(String[] args) {
        Thread chickenThread = new Thread(new Chicken());
        Thread eggThread = new Thread(new Egg());

        eggThread.start();
        chickenThread.start();


        try {
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (eggThread.isAlive()) {
            System.out.println("Яйцо появилось сначала!");
        } else {
            System.out.println("Курица появилась сначала!");
        }
    }

    static class Chicken implements Runnable {
        @Override
        public void run() {
            System.out.println("Курица");
        }
    }

    static class Egg implements Runnable {
        @Override
        public void run() {
            System.out.println("Яйцо");
        }
    }
}
