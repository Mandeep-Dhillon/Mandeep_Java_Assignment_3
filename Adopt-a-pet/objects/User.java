package objects;

public class User {
  private String name;
  private String email;
  private int phone;
  private String appointmentDay; // to store the selected day of the week

  public User(String name, String email, int phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  } // constructor

  //===============>>
  // GETTERS
  public String getName() {
    return this.name;
  }
  public String getEmail() {
    return this.email;
  }
  public int getPhone() {
    return this.phone;
  }
  public String getAppointmentDay() {
    return appointmentDay;
  }

  //===============>>
  // SETTERS
  public void setName(String name) {
    this.name = name;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setPhone(int phone) {
    this.phone = phone;
  }
  public void setAppointmentDay(String appointmentDay) {
    this.appointmentDay = appointmentDay;
  }
} // class