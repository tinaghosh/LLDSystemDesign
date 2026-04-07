package models;

import java.util.Date;

public class LockerPackage{

     private ItemPackage itemPackage;
     private Locker locker;
     private String oneTimeCode;
     private String deliveredBy;
     private Date packageDeliveryTime;
     private int codeValidDays;

    public ItemPackage getItemPackage() {
        return itemPackage;
    }

    public void setItemPackage(ItemPackage itemPackage) {
        this.itemPackage = itemPackage;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public String getOneTimeCode() {
        return oneTimeCode;
    }

    public void setOneTimeCode(String oneTimeCode) {
        this.oneTimeCode = oneTimeCode;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public Date getPackageDeliveryTime() {
        return packageDeliveryTime;
    }

    public void setPackageDeliveryTime(Date packageDeliveryTime) {
        this.packageDeliveryTime = packageDeliveryTime;
    }

    public int getCodeValidDays() {
        return codeValidDays;
    }

    public void setCodeValidDays(int codeValidDays) {
        this.codeValidDays = codeValidDays;
    }
}
