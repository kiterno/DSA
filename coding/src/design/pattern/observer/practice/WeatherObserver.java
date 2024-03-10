package design.pattern.observer.practice;

public class WeatherObserver implements Observer {
    private int pressure, temperature, humidity;
    private Subject subject;

    public WeatherObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update(int pressure, int temperature, int humidity) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.pressure = pressure;
        showData();
    }

    public void showData() {
        System.out.println("WeatherObserver{" +
                "pressure=" + pressure +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}');
    }
}
