package models;

public class DeliveryPerson extends Person {

    private String deliveryPersonId;

    public String getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public void setDeliveryPersonId(String deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    //Methods
    public void deliverParcel(LockerPackage lockerPakage) {

        if (lockerPakage.getLocker().addPackage(lockerPakage)) {
            System.out.println("DeliveryPerson " + deliveryPersonId +
                    " delivered package " + lockerPakage.getItemPackage().getPackageId() + " to locker " +
                    lockerPakage.getLocker().getLockerId());
        }
    }

    public void getNotificationToPickReturnItems(Notification notification) {
        System.out.println("DeliveryPerson " + deliveryPersonId + " received return notification for locker " + notification.getLockerId());
    }

    public boolean pickUpReturnedItem(LockerPackage lockerPackage) {
        if (lockerPackage.getLocker().removePackage()) {
            System.out.println("DeliveryPerson " + deliveryPersonId +
                    " picked up returned package " + lockerPackage.getItemPackage().getPackageId() +
                    " from locker " + lockerPackage.getLocker().getLockerId());

            return true;
        }
        return false;
    }
}