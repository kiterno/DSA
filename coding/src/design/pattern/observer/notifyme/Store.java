package design.pattern.observer.notifyme;

import design.pattern.observer.notifyme.observable.AndroidObservableImpl;
import design.pattern.observer.notifyme.observable.IphoneObservableImpl;
import design.pattern.observer.notifyme.observable.StockObservable;
import design.pattern.observer.notifyme.observer.EmailAlert;
import design.pattern.observer.notifyme.observer.NotificationAlertObserver;
import design.pattern.observer.notifyme.observer.PushNotification;

public class Store {
    public static void main(String[] args) {
        StockObservable iphoneObservable = new IphoneObservableImpl();
        StockObservable androidObservable = new AndroidObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlert("xyz@gmail.com", iphoneObservable);
        NotificationAlertObserver observer11 = new EmailAlert("xyz@gmail.com", androidObservable);
        NotificationAlertObserver observer2 = new EmailAlert("xyz2@gmail.com", iphoneObservable);
        NotificationAlertObserver observer3 = new PushNotification("xyz_username", iphoneObservable);


        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);
        androidObservable.add(observer11);


        iphoneObservable.setStockCount(10);
        androidObservable.setStockCount(10);
    }
}
