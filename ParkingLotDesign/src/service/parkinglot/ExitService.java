package service.parkinglot;

import entity.parkinglot.Exit;
import entity.parkinglot.ParkingTicket;

public interface ExitService {

    public ParkingTicket validateTicket(Exit exitGateNo, ParkingTicket ticket);
}
