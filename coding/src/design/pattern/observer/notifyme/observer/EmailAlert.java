package design.pattern.observer.notifyme.observer;

import design.pattern.observer.notifyme.observable.StockObservable;

public class EmailAlert implements NotificationAlertObserver {

    String emailId;
    StockObservable observable;

    public EmailAlert(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(emailId, "Product is in stock hurry up!");
    }

    private void sendMail(String emailId, String message) {
        System.out.println("mail send to emailId: " + emailId);
    }
}
