package com.example.mkvat.hospitalapp;

public class DrReceiptData {
    private int refid;
    private String patientName;
    private String doctorName;
    private String contactNo;
    private String email;
    private String nic;
    private String hospital;
    private String room;
    private double hCharges;
    private double dCharges;
    private double bCharges;
    private double tCharges;

    public DrReceiptData() {
    }

    public DrReceiptData(String patientName, String contactNo, String email, String nic, String doctorName, String hospital, String room, double hCharges, double dCharges, double bCharges, double tCharges) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.contactNo = contactNo;
        this.email = email;
        this.nic = nic;
        this.hospital = hospital;
        this.room = room;
        this.hCharges = hCharges;
        this.dCharges = dCharges;
        this.bCharges = bCharges;
        this.tCharges = tCharges;
    }

    public int getRefid() {
        return refid;
    }

    public void setRefid(int refid) {
        this.refid = refid;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public double gethCharges() {
        return hCharges;
    }

    public void sethCharges(double hCharges) {
        this.hCharges = hCharges;
    }

    public double getdCharges() {
        return dCharges;
    }

    public void setdCharges(double dCharges) {
        this.dCharges = dCharges;
    }

    public double getbCharges() {
        return bCharges;
    }

    public void setbCharges(double bCharges) {
        this.bCharges = bCharges;
    }

    public double gettCharges() {
        return tCharges;
    }

    public void settCharges(double tCharges) {
        this.tCharges = tCharges;
    }
}
