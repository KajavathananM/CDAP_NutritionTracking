package com.example.mkvat.hospitalapp;

public class LabReceiptData {
    private int refid;
    private String patientName;
    private String contactNo;
    private String email;
    private String nic;
    private String date;
    private String reportType;
    private double reportCharge;
    private String hospital;

    public LabReceiptData() {
    }

    public LabReceiptData(String patientName, String contactNo, String email, String nic, String date, String reportType, double reportCharge, String hospital) {

        this.patientName = patientName;
        this.contactNo = contactNo;
        this.email = email;
        this.nic = nic;
        this.date = date;
        this.reportType = reportType;
        this.reportCharge = reportCharge;
        this.hospital = hospital;
    }

    public int getRefid() {
        return refid;
    }

    public void setRefid(int refid) {
        this.refid = refid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public double getReportCharge() {
        return reportCharge;
    }

    public void setReportCharge(double reportCharge) {
        this.reportCharge = reportCharge;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
