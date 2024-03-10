package design.pattern.observer.notifyme.observable;

import design.pattern.observer.notifyme.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {
    public List<NotificationAlertObserver> notificationAlertObserverList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscriber() {
        for(NotificationAlertObserver notificationAlertObserver : notificationAlertObserverList) {
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if (stockCount == 0) {
            notifySubscriber();
        }

        stockCount += newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
