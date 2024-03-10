package design.pattern.systemdesign.carRentals.service;

import design.pattern.systemdesign.carRentals.model.Role;
import design.pattern.systemdesign.carRentals.model.User;
import design.pattern.systemdesign.carRentals.model.Vehicle;
import design.pattern.systemdesign.carRentals.repository.InventoryRepository;

public class InventoryManagementService {
    public void updateInventory(User admin, Vehicle vehicle) {
        if (Role.ADMIN.equals(admin.getRole()))
            InventoryRepository.inventory.put(vehicle.getRegNumber(), vehicle);
        else throw new RuntimeException("User is not the admin");
    }
}
