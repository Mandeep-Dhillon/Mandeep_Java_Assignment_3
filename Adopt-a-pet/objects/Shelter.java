package objects;
import java.util.ArrayList;

public class Shelter {
  private String address = "123 Scoopers Lane";
  private String[] hours = {
            "Mon: 8am - 4pm",
            "Tues: 8am - 4pm",
            "Wed: 8am - 4pm",
            "Thurs: 8am - 4pm",
            "Fri: 8am - 4pm",
            "Sat/Sun: closed"
  };
  private boolean isAppointmentAvailable = true;
  private ArrayList<Appointment> appointments = new ArrayList<>();
  private ArrayList<Pet> pets = new ArrayList<>();
  private ArrayList<Shelter> shelters = new ArrayList<>();

  public Shelter(String string, String[] newHours, boolean b) {
  }

  public void bookAppointment(String hour) {
    System.out.println("Booking appointment for hour: " + hour);
      if (isAppointmentAvailable) {
        isAppointmentAvailable = false;
        System.out.println("Appointment booked for hour: " + hour);
      } else {
        System.out.println("No appointment available for this hour.");
      }
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<Shelter> getShelterArrayList() {
        return this.shelters;
    }

    public ArrayList<Pet> getPets() {
        return this.pets;
    }

    public Pet getPet(int idx) {
        return pets.get(idx);
    }

    public boolean isAppointmentAvailable() {
        return isAppointmentAvailable;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHours(String[] hours) {
        this.hours = hours;
    }

    public void setHours(int idx, String[] hours) {
      shelters.get(idx).setHours(hours);
      System.out.printf("Choose the day of the week: %s\n", (Object[]) shelters.get(idx).getHours());
    }  

    public void adopt(int idx, String owner) {
      pets.get(idx).setIsAdopted();
      pets.get(idx).setOwner(owner);
      System.out.printf("%s is now yours!", pets.get(idx).getName());
      pets.remove(idx); // takes the pet from the shelter
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addAppointment(Appointment appointment) {
    appointments.add(appointment);
    }
    public String[] getHours() {
      return hours;
    }
}
