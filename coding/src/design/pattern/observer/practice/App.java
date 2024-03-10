package design.pattern.observer.practice;

public class App {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        WeatherObserver weatherObserver = new WeatherObserver(weatherStation);
        weatherStation.setTemperature(10);
        weatherStation.setHumidity(209);
        weatherStation.setPressure(967678);

        weatherObserver.update(1,1,1);
    }
}
