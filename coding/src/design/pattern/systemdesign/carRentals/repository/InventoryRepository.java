package design.pattern.systemdesign.carRentals.repository;

import design.pattern.systemdesign.carRentals.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class InventoryRepository {
    public static Map<String, Vehicle> inventory = new HashMap<>();
}
