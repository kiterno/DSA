package design.pattern.systemdesign.splitwinzo.model;

import java.util.*;

public class Group {

    private final String groupId;

    public Group() {
        this.groupId = UUID.randomUUID().toString();
    }

    public void Group() {
    }

    public String getGroupId() {
        return groupId;
    }
}
