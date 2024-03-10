
package design.pattern.observer;

public class App {
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        WeatherObserver observer = new WeatherObserver(station);
        SecondObserver secondObserver = new SecondObserver(station);

        station.setHumidity(11);
        station.setPressure(200);
        station.setTemperature(37);

    }
}
