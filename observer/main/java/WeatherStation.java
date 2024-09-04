import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private List<Observer> observers;
    private int temperature;
    private final int minTemperature = -40;
    private final int maxTemperature = 40;
    private Random random;

    public WeatherStation() {
        observers = new ArrayList<>();
        random = new Random();
        temperature = random.nextInt(maxTemperature - minTemperature) + minTemperature;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        int tempChange = random.nextInt(3) - 1;
        temperature = Math.max(minTemperature, Math.min(maxTemperature, temperature + tempChange));
        notifyObservers();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            updateTemperature();
            try {
                Thread.sleep(random.nextInt(5000) + 1000); // Sleep for 1-5 seconds
            } catch (InterruptedException e) {
                System.out.println("WeatherStation thread interrupted, stopping simulation.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
