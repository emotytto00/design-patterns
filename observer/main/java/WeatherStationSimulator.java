public class WeatherStationSimulator {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer display1 = new ConcreteObserver("Observer 1");
        Observer display2 = new ConcreteObserver("Observer 2");
        Observer display3 = new ConcreteObserver("Observer 3");

        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);
        weatherStation.registerObserver(display3);

        Thread stationThread = new Thread(weatherStation);
        stationThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.removeObserver(display2);
        System.out.println("Observer 2 removed.");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stationThread.interrupt();
        try {
            stationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Weather station simulation ended.");
    }
}