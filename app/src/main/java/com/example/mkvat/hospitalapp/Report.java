package com.example.mkvat.hospitalapp;

public class Report {
    private String rId;
    private String rType;
    private double rCharge;

    public Report() {
    }

    public Report(String rId, String rType, double rCharge) {
        this.rId = rId;
        this.rType = rType;
        this.rCharge = rCharge;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType;
    }

    public double getrCharge() {
        return rCharge;
    }

    public void setrCharge(double rCharge) {
        this.rCharge = rCharge;
    }
}
