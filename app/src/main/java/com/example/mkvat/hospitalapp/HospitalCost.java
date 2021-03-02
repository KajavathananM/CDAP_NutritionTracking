package com.example.mkvat.hospitalapp;

public class HospitalCost {
    private String hospId;
    private String hospName;
    private double bookingCharge;
    private double hospCharge;

    public HospitalCost() {
    }

    public HospitalCost(String hospId, String hospName, double bookingCharge, double hospCharge) {
        this.hospId = hospId;
        this.hospName = hospName;
        this.bookingCharge = bookingCharge;
        this.hospCharge = hospCharge;
    }

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId;
    }

    public String getHospName() {
        return hospName;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName;
    }

    public double getBookingCharge() {
        return bookingCharge;
    }

    public void setBookingCharge(double bookingCharge) {
        this.bookingCharge = bookingCharge;
    }

    public double getHospCharge() {
        return hospCharge;
    }

    public void setHospCharge(double hospCharge) {
        this.hospCharge = hospCharge;
    }
}
