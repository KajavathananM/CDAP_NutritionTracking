package com.example.mkvat.hospitalapp;

public class Doctor {
    private String docId;
    private String docName;
    private String type;
    private String centre1;
    private String centre2;
    private double docCharge;

    public Doctor(){}
    public Doctor(String docId, String docName, String type, String centre1, String centre2,double docCharge)
    {
        super();

        this.docId=docId;
        this.docName=docName;
        this.type=type;
        this.centre1=centre1;
        this.centre2=centre2;
        this.docCharge=docCharge;

    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocId() {
        return docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCentre1() {
        return centre1;
    }

    public void setCentre1(String centre1) {
        this.centre1 = centre1;
    }

    public String getCentre2() {
        return centre2;
    }

    public void setCentre2(String centre2) {
        this.centre2 = centre2;
    }

    public double getDocCharge() {
        return docCharge;
    }

    public void setDocCharge(double docCharge) {
        this.docCharge = docCharge;
    }
}
