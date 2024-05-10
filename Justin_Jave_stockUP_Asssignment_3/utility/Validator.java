package utility;

import java.util.Scanner;

public class Validator {
  
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_RED = "\u001B[31m";
  
  public Validator() {
    // do nothing
  }

  public int selValidation(Ink ink, Scanner input, int min, int max) {
    boolean valid = false;
    int choice = 0;
    while(!valid) {
      ink.printMenu();
      try {
        choice = input.nextInt(); // throw an exception
        if(choice >= min && choice <= max){
          valid = true;
        }
        else {
          System.out.println(ANSI_RED + "Selection out of range!");
        }
      }
      catch (Exception e) {
        System.out.println(ANSI_RED + "Please read the menu and make a valid selection!");
        valid = false; // just in case
      } 
      finally { // runs if there's an error or NOT!! always runs
        input.nextLine(); // clear the input
      }
    } // while()
    return choice;
  } // isValid()

  public double fundValidation(Ink ink, Scanner input, double balance) {
    double amount = 0;
    boolean valid = false;
    while(!valid) {
      ink.printAddFunds(balance);
      try {
        amount = input.nextDouble(); // throw an exception
        if(amount > 0){
          valid = true;
        }
        else {
          System.out.println(ANSI_RED + "Deposit amount must be a positive $ amount");
        }
      } 
      catch (Exception e) {
        System.out.println(ANSI_RED + "Please enter a valid deposit amount!");
        valid = false; // just in case
      } 
      finally { // runs if there's an error or NOT!! always runs
        input.nextLine(); // clear the input
      }
    } // while()
    return amount;
  }
  public double depositValidation(Ink ink, Scanner input, double minDeposit) {
    double amount = 0;
    boolean valid = false;
    while (!valid) {
        ink.printAddFunds(minDeposit);
        try {
            amount = input.nextDouble();
            if (amount > minDeposit) {
                valid = true; // just in case
            } else {
                System.out.println(ANSI_RED + "Deposit amount must be a positive $ amount");
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Please enter a valid deposit amount!");
            valid = false;
        } finally { // runs if there's an error or NOT!! always runs
            input.nextLine(); // Clear the input buffer
        }
    }
    return amount;
}

} // class