/*
 * TCSS 342 – Winter 2019 - Assignment 2
 */
package applications;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import structures.LinkedOutputRestrictedDeque;

/**
 * Sort a queue of integers from smallest to largest.
 * 
 * @author Matthew Chan
 * @version January 30, 2019
 */
public final class RadixSortDemo {

    /** The output filename after sorting. */
    private static final String OUTPUT = "output.txt";

    /** The number of buckets needed to perform radix sort. */
    private static final int BUCKETS = 10;

    /** A variable storing the size of the queue. */
    private static int myMasterSize;

    /**
     * Private constructor to prevent instantiation.
     */
    private RadixSortDemo() {
    }

    /**
     * Performs radix sort, a kind of bucket sort. From right to left, take the
     * least significant number and put them in their corresponding bucket. Then
     * take them out, and that value is now sorted. Then do it again for all
     * values such as the first "ones", and then "tens" and so on.
     * 
     * @param theQueue the queue to be sorted
     * @return a queue with sorted numbers
     */
    public static LinkedOutputRestrictedDeque<Integer> radixSort(
                              final LinkedOutputRestrictedDeque<Integer> theQueue) {
        myMasterSize = theQueue.size();

        final LinkedOutputRestrictedDeque<Integer>[] bucket =
                        new LinkedOutputRestrictedDeque[BUCKETS];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedOutputRestrictedDeque<>();
        }

        System.out.print("Unsorted queue: ");
        System.out.println(theQueue);
        // Find the longest number of digits in the queue.
        int longestLength = 0;
        for (int i = 0; i < myMasterSize; i++) {
            final int num = theQueue.dequeue();
            final int currentLength = (int) (Math.log10(num) + 1);
            if (currentLength > longestLength) {
                longestLength = currentLength;
            }
            theQueue.enqueue(num);
        }

        int mod = BUCKETS; // The number to use modulo on
        int div = 1; // The number for rounding division.
        // Repeats as long as the highest number in the queue.
        for (int i = 0; i < longestLength; i++) {
            // Perform calculation and put elements into correct bucket.
            for (int j = 0; j < myMasterSize; j++) {
                final int index = (theQueue.first() % mod) / div;
                bucket[index].enqueue(theQueue.dequeue());
            }
            // Dequeue the numbers from the bucket in order and put them back to the queue.
            for (int k = 0; k < bucket.length; k++) {
                while (!bucket[k].isEmpty()) {
                    theQueue.enqueue(bucket[k].dequeue());
                }
            }
            mod *= BUCKETS;
            div *= BUCKETS;
        }

        System.out.print("Sorted queue: ");
        System.out.println(theQueue);
        return theQueue;
    }

    /**
     * Reads a file and returns an integer queue.
     * 
     * @param theFile the input file name
     * @return an integer queue
     */
    private static LinkedOutputRestrictedDeque<Integer> readFile(final String theFile) {
        LinkedOutputRestrictedDeque<Integer> integerQueue = null;
        try {
            final Scanner fileReader = new Scanner(new File(theFile));
            integerQueue = new LinkedOutputRestrictedDeque<>();
            while (fileReader.hasNextLine()) {
                integerQueue.enqueue(Integer.valueOf(fileReader.nextLine()));
            }
            fileReader.close();
        } catch (final FileNotFoundException | NumberFormatException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Error: File not found. Please try again.");
            } else {
                System.out.println("Error: File contains invalid values. Please try again.");
            }
        }
        return integerQueue;
    }

    /**
     * Prints an integer queue into a text file.
     * 
     * @param theQueue the integer queue to be printed
     */
    private static void writeFile(final LinkedOutputRestrictedDeque<Integer> theQueue) {
        try {
            final FileWriter fw = new FileWriter(OUTPUT);
            for (int i = 0; i < myMasterSize; i++) {
                fw.write(theQueue.dequeue() + "\n");
            }
            fw.close();
            System.out.println("Successfully generated output file: " + OUTPUT);
        } catch (final IOException e) {
            System.out.println("Error: Unexpected IOException occurred...");
        }
    }

    /**
     * The main method of this program.
     * 
     * @param theArgs command line arguments (ignored).
     */
    public static void main(final String[] theArgs) {
        myMasterSize = 0;
        final Scanner userInput = new Scanner(System.in);
        String filename = "";
        LinkedOutputRestrictedDeque<Integer> unSortedQueue = null;
        while (unSortedQueue == null) {
            System.out.print("Please enter the filename " + "of the text file: ");
            filename = userInput.nextLine();
            unSortedQueue = readFile(filename);
        }
        userInput.close();
        System.out.println("Successfully loaded file: [" + filename + "]");
        writeFile(radixSort(unSortedQueue));
    }

}
