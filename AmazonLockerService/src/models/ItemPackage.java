package models;

public class ItemPackage {

    private String packageId;
    private Order orderDetails;
    private double packageSize;

    public String getPackageId() {
        return packageId;
    }
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public Order getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Order orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(double packageSize) {
        this.packageSize = packageSize;
    }

    //Methods
    public void packItem(){
        System.out.println("Package "+ getPackageId()+"successfully packed for "+
               getOrderDetails().getOrderId());
    }
}
