package utility;
import objects.Shelter;
import java.util.Scanner;
import java.util.ArrayList;

import objects.Pet;

public class Ink {
  private Scanner input = new Scanner(System.in);
  private int choice;
  
  public void printWelcome() {
    System.out.println("\u001B[36mWelcome to Adopt-a-Pet!\u001B[0m");
  } // printWelcome()

  public String selectDayOfTheWeek() {
    System.out.println("\u001B[33mPlease select a day of the week for the appointment:");
    String day = input.nextLine();
    return day;
  }

  public void printGoodday() {
    System.out.println("\u001B[32mHave a great day pet lover\u001B[0m");
  } // printGoodday()

  public int validateMainMenu() {
    boolean valid = false;

    while(!valid) {
      System.out.println("##### MAIN MENU #####");
      System.out.println("(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Exit");
      try {
        choice = input.nextInt();
        if(choice >= 1 && choice <=4) {
          valid = true; // escapes loop only if choice is correct dt and range
        }
        else {
          System.out.println("Please enter a 1 - 4");
        }
      } 
      catch (Exception e) { // runs on exception
        System.out.println("That's not a number!");
      } 
      finally { // always runs!
        input.nextLine();
      }
    } // while
    return choice;
  } // printMenu()
  
  public void printPetDetails(Pet pet) {
    System.out.printf("\u001B[36mName: %s\n", pet.getName());
    System.out.printf("Age: %d\n", pet.getAge());
    System.out.printf("Breed: %s\n", pet.getBreed());
    System.out.printf("Color: %s\n", pet.getColor());
    System.out.printf("Owner: %s\n", pet.getOwner());
    System.out.printf("Is Adopted: %b\n", pet.getIsAdopted());
    System.out.println("Adopt this pet? Y/N");
  } // printPetDetails()
  
  public void printAvailablePets(ArrayList<Pet> pets) {
    for(int i = 0; i < pets.size(); i++) {
      if(!pets.get(i).getIsAdopted()) {
        System.out.println("\u001B[33mAvailable Pets:\u001B[0m");
        System.out.printf("(%d) Name: %s Type: %s Age: %d\n", i + 1,
          pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getAge());
      }
    } // for
    System.out.println("\u001B[35mEnter 0 to go back\u001B[0m");
  } // printAvailablePets()

  public boolean validateAppointment(String selectedDay, Shelter shelter) {
    String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    for (String day : validDays) {
        if (day.equalsIgnoreCase(selectedDay)) {
            return true;
        }
    }
    System.out.println("Invalid day selection. Please select a valid day of the week.");
    return false;
  }

  public void printShelterDetails(Shelter shelter) {
    System.out.printf("\u001B[36mShelter Address: %s\n", shelter.getAddress());
    String[] hours = shelter.getHours();
    System.out.println("\u001B[34mHours of Operation:\u001B[0m");
    for (int i = 0; i < hours.length; i++) {
      System.out.println(hours[i]);
    } // for
    System.out.println("\u001B[33mPlease select a day of the week:\u001B[0m");
    }// printShelterDetails
    
  public int selectAppointment(ArrayList<Shelter> shelters) {
        int selectedShelterIndex = input.nextInt();
        if (selectedShelterIndex < 1 || selectedShelterIndex > shelters.size()) {
            System.out.println("Invalid option. Please try again.");
            return -1;
        }
        return selectedShelterIndex;
      }
      public void printAppointmentConfirmation(String selectedHour) {
        System.out.println("Appointment booked for " + selectedHour);
    }
  } // class