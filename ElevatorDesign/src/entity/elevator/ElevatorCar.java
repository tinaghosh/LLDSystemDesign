package entity.elevator;

import config.ElevatorState;
import entity.panel.Display;
import entity.panel.InsideElevatorPanel;
import java.util.Queue;

public class ElevatorCar {
    int elevatorId;
    Door door;
    InsideElevatorPanel panel;
    Display display;
    int currentFloor;
    int capacity;
    ElevatorState elevatorState;
    boolean overload;
    boolean maintenance;
    Queue<Integer> requestQueue;
}
