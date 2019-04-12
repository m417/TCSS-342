/*
 * TCSS 342 – Winter 2019 - Assignment 4
 */
package applications;

import javax.swing.SwingUtilities;

/**
 * This program reads a text file and discover what words appear in that file
 * and how many times each word appears. It will then determine which words
 * appeared in the file most frequently.
 * 
 * @author Matthew Chan
 * @version February 23, 2019
 */
public final class WordCount {

    /**
     * Private constructor to prevent instantiation.
     */
    private WordCount() {
    }

    /**
     * The main method of this program.
     * 
     * @param theArgs command line arguments (ignored).
     */
    public static void main(final String[] theArgs) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCountGUI();
            }
        });
    }
    
}
