/*
 * TCSS 342 – Winter 2019 - Assignment 1
 */

package program;

import java.util.InputMismatchException;
import java.util.Scanner;
import structures.ArrayStack;

/**
 * Converts decimal to binary using Stack.
 * 
 * @author Matthew Chan
 * @version January 16, 2019
 */
public final class StackUtilities {

    /** The error message for invalid input. */
    private static final String ERROR = "Invalid input. Please try again.";

    /**
     * Private constructor to prevent instantiation.
     */
    private StackUtilities() {
    }

    /**
     * Converts decimal to binary.
     * 
     * @param theInteger the decimal number to be converted.
     * @return the string representation of the binary equivalent to theInteger
     */
    public static String decimalToBinary(final int theInteger) {
        if (theInteger <= 0) {
            throw new IllegalArgumentException();
        }
        
        String result = "";

        try {
            final ArrayStack<Integer> stack = new ArrayStack<>();
            final StringBuilder sb = new StringBuilder();
            int num = theInteger;
            
            while (num > 0) {
                final int r = num % 2;
                stack.push(r);
                num /= 2;
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            result = sb.toString();
        } catch (final IllegalArgumentException ime) {
            result = "Input has to be a positive integer.";
        }
        return result;
    }

    /**
     * The main method of this program.
     * 
     * @param theArgs command line arguments (ignored).
     */
    public static void main(final String[] theArgs) {
        final Scanner in = new Scanner(System.in);
        int userInput = -1;
        boolean isInProgress = true;

        while (userInput <= 0 || isInProgress) {
            try {
                System.out.print("Enter a positive integer: ");
                userInput = in.nextInt();
                System.out.println("The binary representation of " + userInput + " is: "
                                + decimalToBinary(userInput));
                System.out.print("Continue? (y/n): ");
                final String choice = in.next();
                if (!"y".equalsIgnoreCase(choice)) {
                    isInProgress = false;
                }
            } catch (final InputMismatchException | IllegalArgumentException ex) {
                System.out.println(ERROR);
                in.nextLine();
            }
        }
        
        System.out.println("Thank you for using this program. Goodbye!");
        in.close();
    }

}
