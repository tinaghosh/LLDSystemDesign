package entity.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class DisplayBoard {

    private int displayBoardId;
    private Map<String,Integer> availableParkingSpot = new HashMap<>();
    private String message;

    public DisplayBoard( int displaiBoardId){
        this.displayBoardId = displaiBoardId;
    }

    public int getDisplayBoardId() {
        return displayBoardId;
    }

    public void setDisplaiBoardId(int displaiBoardId) {
        this.displayBoardId = displaiBoardId;
    }

    public Map<String, Integer> getAvailableParkingSpot() {
        return availableParkingSpot;
    }

    public void setAvailableParkingSpot(Map<String, Integer> availableParkingSpot) {
        this.availableParkingSpot = availableParkingSpot;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
