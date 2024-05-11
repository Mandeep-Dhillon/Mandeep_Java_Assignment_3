package objects;

public class Appointment {
    private String hour;
    private String date;
    private String purpose;

    // Constructor
    public Appointment(String hour, String date, String purpose) {
        this.hour = hour;
        this.date = date;
        this.purpose = purpose;
    }

    //===============>>
    // GETTERS
    public String getHour() {
        return hour;
    }
    public String getDate() {
        return date;
    }
    public String getPurpose() {
        return purpose;
    }

    //================>>
    // SETTERS
    public void setHour(String hour) {
        this.hour = hour;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}//class
    
