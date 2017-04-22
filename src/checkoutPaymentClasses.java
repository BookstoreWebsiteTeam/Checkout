/***Created by Christopher C Newman on 4/11/2017.*/
import java.util.Scanner;
import java.lang.*;

public class checkoutPaymentClasses {
    Scanner input = new Scanner (System.in);

    public String dcNumInput() {                            // Debit Card number input
        String dcNum;
        int cardCount = 0;
        boolean dcNumValid = false;

        while(!dcNumValid) {
            System.out.print("Card Number: ");
            dcNum = input.nextLine();
            if(dcNum.length() != 16) {
                System.out.println("Card number is invalid.");
            }
            for(int i = 0; i < dcNum.length(); i++) {
                char debitCheckDigit = dcNum.charAt(i);
                if(Character.isDigit(debitCheckDigit)) {
                    cardCount++;
                }
            }
            if(cardCount != 16) {
                System.out.println("Card Number is invalid.");
            } else {
                dcNumValid = true;
            }
        }
        return dcNumInput();
    }

    public String dcNameInput() {                           // Debit Card name input
        String dcName = "";
        int nameCount = 0;
        boolean dcNameValid = false;

        while(!dcNameValid) {
            System.out.print("Card Name: ");
            dcName = input.nextLine();
            if(dcName.length() == 0) {
                System.out.println();                       // Will loop if nothing is input
            } else {
                for(int i = 0; i < dcName.length(); i++) {
                    char debitCheckChar = dcName.charAt(i);
                    if(Character.isLetter(debitCheckChar)) {
                        nameCount++;
                    }
                }
                if(nameCount != dcName.length()) {
                    System.out.println();
                } else {
                    dcNameValid = true;
                }
            }
        }
        return dcName;
    }

    public int dcSCInput() {                                // Debit card security code input
        int dcSC = 0, dcSCCorrect = 777;
        boolean dcSCValid = false;

        while(!dcSCValid) {
            System.out.print("Security Code: ");
            dcSC = input.nextInt();
            if(!Character.isDigit(dcSC)) {                  // If security code is not digit
                System.out.println("Card is not valid.");
            } else if(dcSC != dcSCCorrect) {                // If security code is not 777
                System.out.println("Card is not valid.");
            } else {                                        // Else all checks out
                dcSCValid = true;
            }
        }
        return dcSC;
    }

    public String PayPalUserNameInput() {       // PayPal login can be anything with at least 8 letters
        String PPUserName = "";
        boolean PPUserNameValid = false;

        while(!PPUserNameValid) {
            System.out.print("Username or email: ");
            PPUserName = input.nextLine();
            if (PPUserName.length() > 8) {
                PPUserNameValid = true;
            } else {
                System.out.println();
            }
        }
        return PPUserName;
    }

    public String passwordInput() {   // Can be used for both PayPal and Financial Aid
        String password = "";
        boolean passwordValid = false;

        while(!passwordValid) {
            System.out.print("Password: ");
            password = input.nextLine();
            if(password.length() > 8) {
                passwordValid = true;
            } else {
                System.out.println();
            }
        }
        return password;
    }

    public String KSUNetIDInput() {     // KSU net ID for Financial Aid
        String NetID = "";
        boolean PPUserNameValid = false;

        while(!PPUserNameValid) {
            System.out.print("Net ID: ");
            NetID = input.nextLine();
            if(NetID.length() > 8) {
                PPUserNameValid = true;
            } else {
                System.out.println();
            }
        }
        return NetID;
    }

    public void choosePaymentMethod() {                     // Needs to be moved to a main/test file with some modifications
        String one = "1", two = "2", three = "3";           // Valid result inputs
        String Visa = "visa", MasterCard = "mastercard";    // Valid result inputs
        String Paypal = "paypal";                           // Valid result inputs
        String FA1 = "financial aid", FA2 = "financialaid"; // Valid result inputs
        String choice;                                      // What the customer inputs
        boolean choiceValid = false;                        // Is the input valid?

        while(!choiceValid) {
            System.out.println("Choose your payment method (input 1, 2, or 3):");
            System.out.println("1. Visa/MasterCard");
            System.out.println("2. PayPal");
            System.out.println("3. Financial Aid");
            choice = input.nextLine();
            choice = choice.toLowerCase();      // Makes input lower case to compare to valid results
            if(choice.equals(one) || choice.equals(Visa) || choice.equals(MasterCard)) {
                dcNameInput();  // Prompts the user to input card information
                dcNumInput();   // Will need to have Strings or Ints respectively to take these values
                dcSCInput();
                choiceValid = true;
            } else if(choice.equals(two) || choice.equals(Paypal)) {
                PayPalUserNameInput();      // Prompts the user to login to their Paypal account
                passwordInput();
                choiceValid = true;
            } else if(choice.equals(three) || choice.equals(FA1) || choice.equals(FA2)) {
                KSUNetIDInput();            // Prompts the user to login to the Bursar office
                passwordInput();
                choiceValid = true;
            } else {
                System.out.println("Input not valid. Please input 1, 2, 3, or the method of your choice.");
            }
        }
    }

}