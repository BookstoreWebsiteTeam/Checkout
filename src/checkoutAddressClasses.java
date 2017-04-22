/*** Created by Christopher C Newman on 4/9/2017.*/
import java.util.Scanner;
import java.lang.*;

public class checkoutAddressClasses {

    Scanner input = new Scanner(System.in);

    public String nameInput() {
        String fName, lName, suffix, fullName;

        System.out.print("First name: ");
        fName = input.nextLine();
        System.out.print("Last name: ");
        lName = input.nextLine();
        System.out.print("Suffix: ");
        suffix = input.nextLine();

        if(suffix.length() > 0) {
            fullName = suffix + " " + fName + " " + lName;
        } else {
            fullName = fName + " " + lName;
        }
        return fullName;
    }

    public String addressInput() {
        String add1, add2, city, state, zip = "", fullAddress = "temp";
        int digCount = 0;
        boolean zipValid = false, allLinesFilled = false;

        // While loop to ensure all necessary boxes are filled.
        while(!allLinesFilled) {
            System.out.print("Address Line 1*: ");
            add1 = input.nextLine();
            System.out.print("Address Line 2 (PO box #, Apt. #, etc: ");
            add2 = input.nextLine();
            System.out.print("City*: ");
            city = input.nextLine();
            System.out.print("State*: ");
            state = input.nextLine();

            // Code for inputing Zip code, made to insure the zip code is 5 digits exactly.
            while (!zipValid) {
                System.out.print("Zip Code*: ");
                zip = input.nextLine();
                if (zip.length() != 5) {
                    System.out.println("Zip code is invalid.");
                }
                for (int i = 0; i < zip.length(); i++) {
                    char zipCheckDigit = zip.charAt(i);
                    if (Character.isDigit(zipCheckDigit)) {
                        digCount++;
                    }
                }
                if (digCount != 5) {
                    System.out.println("Zip code is invalid.");
                } else {
                    zipValid = true;
                }
            }

            if (add2.length() > 0 && add1.length() > 0 && city.length() > 0 && state.length() > 0) {
                fullAddress = add1 + " " + add2 + " " + city + ", " + state + ", " + zip;
                allLinesFilled = true;
            } else if (add1.length() > 0 && city.length() > 0 && state.length() > 0) {
                fullAddress = add1 + " " + city + ", " + state + ", " + zip;
                allLinesFilled = true;
            } else {
                System.out.println("Please provide input for all lines marked with a '*' above.");
            }
        }
        return fullAddress;
    }
}