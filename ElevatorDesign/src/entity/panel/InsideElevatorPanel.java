package entity.panel;

import entity.button.DoorButton;
import entity.button.EmergencyButton;
import entity.button.FloorButton;

import java.util.List;

public class InsideElevatorPanel{
    List<FloorButton> floorButtons;
    DoorButton openButton;
    DoorButton closeButton;
    EmergencyButton alertButton;
}
