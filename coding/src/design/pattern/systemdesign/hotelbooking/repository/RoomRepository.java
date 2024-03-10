package design.pattern.systemdesign.hotelbooking.repository;

import design.pattern.systemdesign.hotelbooking.model.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomRepository {
    public static Map<String, Room> roomMap = new HashMap<>();
}
