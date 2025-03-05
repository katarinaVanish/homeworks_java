package org.knit.sem2.lab2_2.Task2_6;

class Train extends Thread {
    private final RailwayCrossing crossing;

    public Train(RailwayCrossing crossing) {
        this.crossing = crossing;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000); // Время перед появлением поезда
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            crossing.trainArrives();
            try {
                Thread.sleep(3000); // Время, пока поезд едет
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            crossing.trainDeparts();
        }
    }
}
