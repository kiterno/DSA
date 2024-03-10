package design.pattern.observer.notifyme.observable;

import design.pattern.observer.notifyme.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class AndroidObservableImpl implements StockObservable {
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observerList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscriber() {
        for(NotificationAlertObserver observer: observerList) {
            observer.update();
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
