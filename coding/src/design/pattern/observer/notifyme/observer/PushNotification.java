package design.pattern.observer.notifyme.observer;

import design.pattern.observer.notifyme.observable.StockObservable;

public class PushNotification implements NotificationAlertObserver {
    String userName;
    StockObservable observable;

    public PushNotification(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendPushNotification(userName, "Product is in stock hurry up!");
    }

    private void sendPushNotification(String userName, String message) {
        System.out.println("msg sent to: " + userName);
    }
}
