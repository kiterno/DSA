package design.pattern.systemdesign.carRentals;

import design.pattern.systemdesign.carRentals.model.Role;
import design.pattern.systemdesign.carRentals.model.User;
import design.pattern.systemdesign.carRentals.model.Vehicle;
import design.pattern.systemdesign.carRentals.model.VehicleType;
import design.pattern.systemdesign.carRentals.repository.UserRepository;
import design.pattern.systemdesign.carRentals.service.InventoryManagementService;

public class Uber {
    public static void main(String[] args) {
        createUsersAndAdmins();
        InventoryManagementService inventoryManagementService = new InventoryManagementService();

        User admin = UserRepository.userMap.get("dheerendra");
        Vehicle SUV = new Vehicle("1234", "Safari", "Tata", "2015", VehicleType.SUV, true);
        Vehicle Hatchback = new Vehicle("245", "THAR", "Mahindra", "2015", VehicleType.HATCHBACK, true);
        Vehicle Truck = new Vehicle("124", "Ashok", "Layland", "2015", VehicleType.TRUCK, true);
        Vehicle MotorCycle = new Vehicle("965", "Apache", "TVS", "2015", VehicleType.MOTORCYCLE, true);
        inventoryManagementService.updateInventory(admin, SUV);
        inventoryManagementService.updateInventory(admin, Hatchback);
        inventoryManagementService.updateInventory(admin, Truck);
        inventoryManagementService.updateInventory(admin, MotorCycle);


    }

    private static void createUsersAndAdmins() {
        User user1 = new User( "akash", "Akash", "Choudhary", "ac911@gmail.com", "7986545465", Role.USER);
        User user2 = new User("dheerendra", "Dheerendra", "Choudhary", "dheeru@gmail.com", "9755410173", Role.ADMIN);
        User user3 = new User("rashmi", "Rashmi", "Choudhary", "rash@gmail.com", "654656878967", Role.USER);

        UserRepository.userMap.put(user1.getUserName(), user1);
        UserRepository.userMap.put(user2.getUserName(), user2);
        UserRepository.userMap.put(user3.getUserName(), user3);
    }
}
