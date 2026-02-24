package controller;

import entity.parkinglot.DisplayBoard;
import entity.parkinglot.Entrance;
import entity.parkinglot.Exit;
import entity.parkinglot.ParkingTicket;
import entity.parkingspot.*;
import entity.vehicle.*;
import service.parkinglot.DisplayBoardService;
import service.parkinglot.EntranceService;
import service.parkinglot.ExitService;
import service.parkinglot.serviceimpl.DisplayBoardServiceImpl;
import service.parkinglot.serviceimpl.EntranceServiceImpl;
import service.parkinglot.serviceimpl.ExitServiceImpl;
import service.parkingspot.ParkingLotService;
import service.parkingspot.serviceimpl.ParkingLotServiceImpl;
import service.payment.PaymentService;
import service.payment.serviceimpl.PaymentServiceImpl;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotController{

    private static final ParkingLotController instance = null;
    private Map<Integer,ParkingSpot> parkingSpots = new HashMap<>();
    private Map<Integer,ParkingTicket> parkingTickets = new HashMap<>();
    private Map<Integer,DisplayBoard> displayBoards = new HashMap<>();
    private Map<Integer,Entrance> entranceList = new HashMap<>();
    private Map<Integer,Exit> exitList = new HashMap<>();

    public ParkingLotService parkingLotService = new ParkingLotServiceImpl();
    public EntranceService entranceService = new EntranceServiceImpl();
    public DisplayBoardService displayBoardService = new DisplayBoardServiceImpl();
    public PaymentService paymentService = new PaymentServiceImpl();
    public ExitService exitService = new ExitServiceImpl();

    //Singleton object Creation for the ParkingLot
    public static ParkingLotController getInstance(){
        if(instance == null){
            return new ParkingLotController();
        }else{
            return instance;
        }
    }

    //Add Parking Spot
    public void addParkingSpot(ParkingSpot parkingSpot){
       parkingSpots.put(parkingSpot.getParkingSpotId(),parkingSpot);
    }

    //Add Display Board
    public void addDisplayBoard(DisplayBoard displayBoard){
        displayBoards.put(displayBoard.getDisplayBoardId(), displayBoard);
    }

    //Add Entrance
    public void addEntrance(Entrance entrance){
        entranceList.put(entrance.getEntranceGateNo(),entrance);
    }

    //Add Exit
    public void addExit(Exit exit){
        exitList.put(exit.getExitGateNo(),exit);
    }

    //Get Entrance Ticket
    public ParkingTicket getEntranceTicket(int entranceId,Vehicle v){
        Entrance entrance = entranceList.get(entranceId);
        ParkingTicket parkingTicket = entranceService.getTicket(entrance,v , getAllParkingSports());
        return parkingTicket;
    }

    // Exit Vehicle
    public void getExitVehicle(int exitId, Vehicle v){
        Exit exit = exitList.get(exitId);
        exitService.validateTicket(exit,v.getParkingTicket());
    }

    //Get DisplayBoard
    public void getDisplayBoardDetails(int disPlayBoardId){
        DisplayBoard displayBoard = displayBoards.get(disPlayBoardId);
        displayBoardService.updateDisplay(getAllParkingSports(),displayBoard);
        displayBoardService.showFreeSlot(displayBoard);
    }

    //Get All Parking Spots
    public Collection<ParkingSpot> getAllParkingSports(){
        return parkingSpots.values();
    }

    //Park Vehicle based on Parking Type
    public ParkingTicket parkVehicle(Vehicle v , Collection<ParkingSpot> spots){
        System.out.println();
         for(ParkingSpot spot : spots){
             if(!spot.isOccupied()  && canFitVehicleInTheParkingSpotType(v,spot)){
                 parkingLotService.assignVehicle(v,spot);
                 ParkingTicket ticket = new ParkingTicket(spot,v);
                 parkingTickets.put(ticket.getParkingTicketNo(),ticket);
                 return ticket;
             }
         }
        System.out.println("Sorry, parking lot is full. New cars cannot be parked.");
        return null;
    }

    //Free ParkingSlot While exit
    public void freeSlot(ParkingSpot s){
        if(s.isOccupied()){
            parkingLotService.removeVehicle(s);
        }
    }

    public boolean canFitVehicleInTheParkingSpotType(Vehicle v, ParkingSpot s){

       if((v instanceof MotorCycle && s instanceof MotorCycleSpot) ||
               (v instanceof Car && s instanceof CompactSpot) ||
                   (v instanceof Car && s instanceof DisabilitySpot && v.isHavingDisableStricker()) ||
                  ((v instanceof Van || v instanceof Truck) && s instanceof LargeSpot)) {

           return true;
       }
       return false;
    }
}
