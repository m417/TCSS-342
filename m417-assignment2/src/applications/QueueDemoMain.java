/*
 * TCSS 342 – Winter 2019 - Assignment 2
 */
package applications;

/**
 * @author Alan Fowler
 * @author Matthew Chan (edited based on Alan Fowler's Stack Demo)
 * @version January 30, 2019
 */
public final class QueueDemoMain {

    /**
     * Private constructor to inhibit instantiation.
     */
    private QueueDemoMain() {
    }

    /**
     * Simple graphical Stack demo.
     * 
     * @param theArgs array of Strings
     */
    public static void main(final String[] theArgs) {
        new QueueDemoGUI().display();
    }
}
