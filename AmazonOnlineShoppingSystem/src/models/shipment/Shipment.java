package models.shipment;

import enumerations.ShipmentStatus;

import java.util.Date;

public class Shipment {

    public String ShipmentNumber;
    public Date shipmentPlacedOn;
    public Date estimatedDeliveryDate;
    public String shipmentAgency;
    public ShipmentStatus shipmentStatus;

    public Shipment(String shipmentNumber, Date shipmentPlacedOn, Date estimatedDeliveryDate, String shipmentAgency, ShipmentStatus shipmentStatus) {
        ShipmentNumber = shipmentNumber;
        this.shipmentPlacedOn = shipmentPlacedOn;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.shipmentAgency = shipmentAgency;
        this.shipmentStatus = shipmentStatus;
    }

    public String getShipmentNumber() {
        return ShipmentNumber;
    }

    public Date getShipmentPlacedOn() {
        return shipmentPlacedOn;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public String getShipmentAgency() {
        return shipmentAgency;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }
}
