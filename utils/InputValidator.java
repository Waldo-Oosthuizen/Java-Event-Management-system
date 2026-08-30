package utils;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class InputValidator {

    // Integer checker
    public static int intCheck(Scanner input) {

        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
        }

        int value = input.nextInt();
        input.nextLine();

        return value;
    }

    // Get a positive int for max students and ids
    public static int positiveIntCheck(Scanner input){

        while (true) {
            // Check if value is int
            if (!input.hasNextInt()){
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
                continue;
            }

            int value = input.nextInt();
            input.nextLine();

            // check if value is positive
            if(value > 0){
                return value;
            }
            // if number is not positive
            System.out.println("Number must be greater than 0.");
        }
    }

    // Check for empty strings for event name and location
    public static String emptyStringCheck(Scanner input){
        while(true) {

            String value = input.nextLine();
            // If value is not empty, return the value
            // Using trim to trmobr trailing white spaces
            if (!value.trim().isEmpty()){
                return value.trim();
            }
            // Else print input error  
            System.out.println("Input cannot be empty.");
        }

    }

    // Ensure that date is valid format
    public static LocalDate dateCheck(Scanner input) {
        
        while (true){
        String value = input.nextLine();
        // If format is valid
        try {
            return LocalDate.parse(value);
        }
        // Catch and display error if format is not valid
        catch (DateTimeParseException e) {

            System.out.println("Date is invalid. Use YYYY-MM-DD");

            }
        }

    }

    // Ensure correct time format
    public static LocalTime timeCheck(Scanner input) {

        while (true){

        String value = input.nextLine();
        // Return the value if it is in correct format
        try {
            return LocalTime.parse(value);
        // Else catch and display error
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time. Use HH:mm.");
            }   
        }
    }


}