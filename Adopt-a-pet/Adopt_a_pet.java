import utility.*;
import objects.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Adopt_a_pet {
   private static Scanner input = new Scanner(System.in);
   private static Ink ink = new Ink();
   private static User user;
   private static Shelter shelter;
   private static Pet pet;

   private static int choice;
   private static boolean isDone = false;
   private static boolean goBack = false;

   public static void main(String[] args) {
      
    createUser(); // create the user
        String[] newHours = {"Mon: 8am - 4pm", "Tues: 8am - 4pm", "Wed: 8am - 4pm", "Thurs: 8am - 4pm", "Fri: 8am - 4pm", "Sat/Sun: closed"};
        shelter = new Shelter("123 Scoopers Lane", newHours, true); // Instantiate shelter object
        createPets(); // helper pets
       
      while(!isDone) {
      choice = ink.validateMainMenu();

      switch (choice) {
        case 1: // print available pets
          ink.printAvailablePets(shelter.getPets());
          while(!goBack) {
            int pick = input.nextInt();
            if(pick != 0) {
              ink.printPetDetails(shelter.getPet(pick - 1));
              String answer = input.next();
              if(answer.equalsIgnoreCase("Y")) {
                shelter.adopt(pick - 1, user.getName());
                goBack = true;
              }
              else {
                goBack = true;
              }
            }
            else {
              goBack = true;
            }
          } // while
          break;

          
        case 2: // print shelter details
          ink.printShelterDetails(shelter);
          while(!goBack) {
            input.nextLine();
            goBack = true;
          } // while
          break;
          
        case 3: // book an appointment menu
        String selectedDay = ink.selectDayOfTheWeek(); // to select a day of the week
        user.setAppointmentDay(selectedDay); // Update User object with selected day
        System.out.println("Appointment booked for " + selectedDay);
        ink.printShelterDetails(shelter);
        int appointmentChoice = input.nextInt();
        if (appointmentChoice != 0 && appointmentChoice <= shelter.getHours().length) {
          String selectedHour = shelter.getHours()[appointmentChoice - 1];
          ink.printAppointmentConfirmation(selectedHour);
          String answer = input.next();
          input.nextLine();
          if (answer.equalsIgnoreCase("Y")) {
              // Book the appointment
              shelter.bookAppointment(selectedHour);
              goBack = true;
          }
        } else {
          System.out.println("Invalid input for appointment. Please try again.");
      }
      break;
      
      case 4:
          isDone = true;
          break;
          default:
            System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            break;
        } // switch
        
      goBack = false; // Reset goBack for the next iteration
    } // while(main)

    ink.printGoodday();
  } // main()
  
  // 100% for test data!
  public static void createPets() {
    pet = new Pet("spot", "dog",
      3, "black", "hound");
    shelter.addPet(pet);
    pet = new Pet("cleveland", "dog",
      7, "brown", "boxer");
    shelter.addPet(pet);
    pet = new Pet("monster", "cat",
      1, "calico", "calico");
    shelter.addPet(pet);
  } // createPets()
  
  public static void createUser() {
    String name, email;
    int phone;
    System.out.println("What is your name? ");
    name = input.nextLine();
    System.out.println("What is your email? ");
    email = input.nextLine();
    System.out.println("What is your phone? ");
    try {
        phone = input.nextInt();
        input.nextLine(); // Consume newline character
    } catch (InputMismatchException e) {
        System.out.println("Invalid input for phone number. Please enter a valid integer.");
        input.nextLine(); // Clear the input buffer
        createUser(); // Call the method recursively to retry input
        return; // Exit the method after recursive call
    }
    user = new User(name, email, phone);
  }// createUser()
} // class