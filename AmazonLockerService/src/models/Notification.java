package models;

public class Notification {

    private String sendingTo;
    private String oneTimeCode;
    private String lockerId;
    private String orderId;

    public String getSendingTo() {
        return sendingTo;
    }

    public void setSendingTo(String sendingTo) {
        this.sendingTo = sendingTo;
    }

    public String getOneTimeCode() {
        return oneTimeCode;
    }

    public void setOneTimeCode(String oneTimeCode) {
        this.oneTimeCode = oneTimeCode;
    }

    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    //Methods
    public void sendNotifications(){
        System.out.println("Notification sent to : " + sendingTo +
                ": Your order " + orderId +
                " has been placed in locker " + lockerId +
                ". Pickup code: " + oneTimeCode);
     }

}
