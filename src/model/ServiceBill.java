/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Cuong
 */
public class ServiceBill {
    private String  billID, serviceID,  serviceNote;
    private Date serviceDay;
    private int  serviceAmount; 
    private float Compensation;


    public ServiceBill() {
    }
   
    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    
    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public Date getServiceDay() {
        return serviceDay;
    }

    public void setServiceDay(Date serviceDay) {
        this.serviceDay = serviceDay;
    }

    public float getCompensation() {
        return Compensation;
    }

    public void setCompensation(float Compensation) {
        this.Compensation = Compensation;
    }

    public String getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(String serviceNote) {
        this.serviceNote = serviceNote;
    }

    public int getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(int serviceAmount) {
        this.serviceAmount = serviceAmount;
    }  
}
