package design.pattern.observer.notifyme.observable;

import design.pattern.observer.notifyme.observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver notificationAlertObserver);
    public void remove(NotificationAlertObserver notificationAlertObserver);
    public void notifySubscriber();
    public void setStockCount(int newStockAdded);
    public int getStockCount();
}
