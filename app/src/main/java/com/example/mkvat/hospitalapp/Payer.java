package com.example.mkvat.hospitalapp;

public class Payer {
    private int payerId;
    private String payerName;
    private String contactNo;
    private String email;
    private String nic;

    public Payer() {
    }

    public Payer(String payerName, String contactNo, String email, String nic) {
        this.payerName = payerName;
        this.contactNo = contactNo;
        this.email = email;
        this.nic = nic;
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
