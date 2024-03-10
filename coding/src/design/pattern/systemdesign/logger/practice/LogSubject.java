package design.pattern.systemdesign.logger.practice;

import java.util.*;

public class LogSubject {
    Map<Integer, List<LogObserver>> logObservers = new HashMap<>();

    void addObserver(int level, LogObserver logObserver) {
        List<LogObserver> logObserverList = logObservers.getOrDefault(level, new ArrayList<>());
        logObserverList.add(logObserver);

        logObservers.put(level, logObserverList);
    }

    void notifyAllObservers(int level, String message) {
        for (Map.Entry<Integer, List<LogObserver>> entry: logObservers.entrySet()) {
            if (entry.getKey() == level) {
                entry.getValue().forEach(observer -> observer.log(message));
            }
        }
    }
}
