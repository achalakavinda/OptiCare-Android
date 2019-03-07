package com.opensource.eye.opticare.Models;

public class ReminderPatientModel {

    public String Id;
    public String date;
    public String time;
    public String description;
    public String Raw_Year;
    public String Raw_Month;
    public String Raw_Day;
    public String Raw_Hour;
    public String Raw_Min;

    public ReminderPatientModel() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ReminderPatientModel(String Id,String date, String time, String description ,String Raw_Year,String Raw_Month,String Raw_Day,String Raw_Hour, String Raw_Min) {
        this.Id = Id;
        this.date = date;
        this.time = time;
        this.description = description;

        this.Raw_Year = Raw_Year;
        this.Raw_Month = Raw_Month;
        this.Raw_Day = Raw_Day;
        this.Raw_Hour = Raw_Hour;
        this.Raw_Min = Raw_Min;
    }
}
