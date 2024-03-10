package design.pattern.systemdesign.splitwinzo.model;

import java.util.ArrayList;
import java.util.List;

public class UserShare {
    private String userId;
    private double share;

    public UserShare(String userId, double share) {
        this.userId = userId;
        this.share = share;
    }

    public String getUserId() {
        return userId;
    }

    public double getShare() {
        return share;
    }

    @Override
    public String toString() {
        return "UserShare{" +
                "userId='" + userId + '\'' +
                ", share=" + share +
                '}';
    }
}
