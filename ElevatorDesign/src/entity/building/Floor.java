package entity.building;

import entity.panel.Display;
import entity.panel.InsideElevatorPanel;
import entity.panel.OutsideElevatorPanel;

import java.util.ArrayList;
import java.util.List;

public class Floor{

    private int floorNo;
    private List<OutsideElevatorPanel> panels;
    private List<Display> displays;

    public Floor(int floorNo, int numOfPanels, int numOfDisplays, int topFloor){
        this.floorNo = floorNo;
        this.panels = new ArrayList<>();
        for(int i=0;i<numOfPanels;i++){
            panels.add(new OutsideElevatorPanel());
        }
    }

    public int getFloorNo() {
        return floorNo;
    }

}
