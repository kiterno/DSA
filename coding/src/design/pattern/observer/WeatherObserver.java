package design.pattern.observer;

public class WeatherObserver implements Observer {

    private int pressure, humidity, temperature;
    private Subject subject;

    public WeatherObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update(int pressure, int temperature, int humidity) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;

        showData();
    }

    public void showData() {
        System.out.println( "WeatherObserver{" +
                "pressure=" + pressure +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                '}');
    }
}
