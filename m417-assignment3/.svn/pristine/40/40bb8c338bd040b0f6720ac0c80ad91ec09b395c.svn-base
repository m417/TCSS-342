/*
 * TCSS 342
 */

package programs;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Demonstrates the use of an expression tree to evaluate postfix expressions.
 *
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342; added additional output
 * @version Winter 2019
 */
public final class PostfixTesterMain    
{
    
    /**
     * A private constructor to inhibit external instantiation.
     */
    private PostfixTesterMain()
    {
        // do nothing
    }
    
    /**
     * Reads and evaluates multiple postfix expressions.
     * 
     * @param theArgs - command line parameters - ignored in this program
     */
    public static void main(final String[] theArgs)
    {
        String expression;
        String again;
        int result;
    
        final Scanner in = new Scanner(System.in);
      
        do
        {  
            final PostfixEvaluator evaluator = new PostfixEvaluator();
            System.out.println("Enter a valid post-fix expression one token "
                    + "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");
            System.out.println("Each token must be an integer or an operator (+,-,*,/)");
            expression = in.nextLine();

            try
            {
                result = evaluator.evaluate(expression);
                System.out.println();
                System.out.println("That expression equals " + result);
                
                System.out.println("The Expression Tree for that expression is: ");
                System.out.println(evaluator.getTree().printTree());
                
                displayTreeInfo(evaluator.getTree());
                System.out.println();
            }
            catch (final EmptyStackException e)
            {
                System.out.println("Not a valid postfix expression");
            }
            catch (final NumberFormatException e)
            {
                System.out.println("Not a valid postfix expression");
            }
            
            System.out.print("Evaluate another expression [Y/N]? ");
            again = in.nextLine();
            System.out.println();
        }
        while ("y".equalsIgnoreCase(again));
        
        in.close();
    }

    /**
     * Displays some information about a binary tree.
     * 
     * @param theTree the Tree from which to display information.
     */
    private static void displayTreeInfo(final ExpressionTree theTree)
    {
        System.out.println("Here is some information about the expression tree.");

        System.out.println("\nPreOrder Traversal: ");
        Iterator<ExpressionTreeOp> itr = theTree.iteratorPreOrder();
        while (itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        
        System.out.println("\nInOrder Traversal: ");
        itr = theTree.iteratorInOrder();
        while (itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        
        System.out.println("\nPostOrder Traversal: ");
        itr = theTree.iteratorPostOrder();
        while (itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        
        System.out.println("\nLevelOrder Traversal: ");
        itr = theTree.iteratorLevelOrder();
        while (itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        
        System.out.println("\ntheTree.size(): " + theTree.size());
        System.out.println("theTree.getHeight(): " + theTree.getHeight());
        System.out.println("theTree.countLeafNodes(): " + theTree.countLeafNodes());
        System.out.println("theTree.toString(): " + theTree.toString());
    }
}
