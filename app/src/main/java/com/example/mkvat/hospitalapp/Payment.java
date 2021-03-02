package com.example.mkvat.hospitalapp;

public class Payment {
    private int payId;
    private String patientName;
    private String paymentType;
    private String branchType;
    private String refNo;
    private double amount;

    public Payment() {
    }

    public Payment( String patientName, String paymentType, String branchType, String refNo, double amount) {
        this.patientName = patientName;
        this.paymentType = paymentType;
        this.branchType = branchType;
        this.refNo = refNo;
        this.amount = amount;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
