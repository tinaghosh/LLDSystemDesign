import controller.ParkingLotController;
import entity.parkinglot.DisplayBoard;
import entity.parkinglot.Entrance;
import entity.parkinglot.Exit;
import entity.parkinglot.ParkingTicket;
import entity.parkingspot.*;
import entity.vehicle.*;

public class ParkingLotDesignMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n====================== PARKING LOT SYSTEM DEMO ======================\n");
        System.out.println("\n// -------------- SYSTEM INITIALIZATION --------------\n");

        ParkingLotController parkingLotController = ParkingLotController.getInstance();

        parkingLotController.addParkingSpot(new DisabilitySpot(1));
        parkingLotController.addParkingSpot(new CompactSpot(2));
        parkingLotController.addParkingSpot(new LargeSpot(3));
        parkingLotController.addParkingSpot(new MotorCycleSpot(4));

        parkingLotController.addDisplayBoard(new DisplayBoard(1));

        parkingLotController.addEntrance(new Entrance(1));
        parkingLotController.addExit(new Exit(1));


        // ----------------- SCENARIO 1: CUSTOMER ENTERS, PARKS -----------------

        System.out.println("\n→→→ SCENARIO 1: Customer enters and parks a car\n");

        Vehicle car = new Car("KA-01-HH-1234");
        System.out.println("-> Car " + car.getLicenseNo() + " arrives at entrance");
        System.out.println(parkingLotController.getAllParkingSports());

        parkingLotController.getEntranceTicket(1,car);

        System.out.println("-> Updating display board after parking:");
        parkingLotController.getDisplayBoardDetails(1);

        // ----------------- SCENARIO 2: CUSTOMER EXITS AND PAYS -----------------

        System.out.println("\n→→→ SCENARIO 2: Customer exits and pays\n");

        System.out.println("-> Car " + car.getLicenseNo() + " proceeds to exit panel");
        Thread.sleep(1500); // Simulate parking duration (1.5 sec)
        parkingLotController.getExitVehicle(1,car);

        System.out.println("-> Updating display board after parking:");
        parkingLotController.getDisplayBoardDetails(1);

        // --------- SCENARIO 3: FILLING LOT AND REJECTING ENTRY IF FULL ---------
        System.out.println("\n→→→ SCENARIO 3: Multiple customers attempt to enter; lot may become full\n");

        // Vehicles arriving
        Vehicle van = new Van("KA-01-HH-9999");
        Vehicle motorcycle = new MotorCycle("KA-02-XX-3333");
        Vehicle truck = new Truck("KA-04-AA-9998");
        Vehicle car2 = new Car("DL-09-YY-1234");

        System.out.println("-> Van " + van.getLicenseNo() + " arrives at entrance");
        parkingLotController.getEntranceTicket(1,van);

        System.out.println("-> Motorcycle " + motorcycle.getLicenseNo() + " arrives at entrance");
        parkingLotController.getEntranceTicket(1,motorcycle);

        System.out.println("-> Truck " + truck.getLicenseNo() + " arrives at entrance");
        parkingLotController.getEntranceTicket(1,truck);

        System.out.println("-> Car " + car2.getLicenseNo() + " arrives at entrance");
        parkingLotController.getEntranceTicket(1,car2);

        System.out.println("-> Updating display board after parking:");
        parkingLotController.getDisplayBoardDetails(1);

        // Try to park another car (lot may now be full)

        Vehicle car3 = new Car("UP-01-CC-1001");
        System.out.println("-> Car " + car3.getLicenseNo() + " attempts to park (should be denied if lot is full):");
        parkingLotController.getEntranceTicket(1,car3);

        parkingLotController.getDisplayBoardDetails(1);

        System.out.println("\n====================== END OF DEMONSTRATION ======================\n");
    }
}