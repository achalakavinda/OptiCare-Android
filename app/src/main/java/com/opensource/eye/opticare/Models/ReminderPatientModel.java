package com.opensource.eye.opticare.Models;

public class ReminderPatientModel {

    private String id;
    private String optician_id;
    private String optician_name;
    private String patient_name;
    private String patient_id;
    private String date;
    private String type;
    private String isMobile;
    private String status;
    private String note;
    private Boolean show;


    public ReminderPatientModel(String id, String optician_id, String optician_name, String patient_name, String patient_id, String date, String type, String isMobile, String status, String note, Boolean show) {
        this.id = id;
        this.optician_id = optician_id;
        this.optician_name = optician_name;
        this.patient_name = patient_name;
        this.patient_id = patient_id;
        this.date = date;
        this.type = type;
        this.isMobile = isMobile;
        this.status = status;
        this.note = note;
        this.show = show;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOptician_id() {
        return optician_id;
    }

    public void setOptician_id(String optician_id) {
        this.optician_id = optician_id;
    }

    public String getOptician_name() {
        return optician_name;
    }

    public void setOptician_name(String optician_name) {
        this.optician_name = optician_name;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return isMobile;
    }

    public void setMobile(String mobile) {
        isMobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

}
