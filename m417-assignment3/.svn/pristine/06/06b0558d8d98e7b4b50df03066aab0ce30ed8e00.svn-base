/*
 * TCSS 342
 */

package programs;

import structures.ArrayUnorderedList;
import structures.BinaryTreeNode;
import structures.LinkedBinaryTree;
import structures.UnorderedListADT;

/**
 * ExpressionTree represents an expression tree of operators and operands.
 * 
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342
 * @version Winter 2019
 */
public class ExpressionTree extends LinkedBinaryTree<ExpressionTreeOp>
{
    /**
     * Creates an empty expression tree.
     */
    public ExpressionTree() 
    {
        super();
    }

    /**
     * Constructs a expression tree from the two specified expression 
     * trees.
     *
     * @param theElement      the expression tree for the center
     * @param theLeftSubtree  the expression tree for the left subtree
     * @param theRightSubtree the expression tree for the right subtree
     */
    public ExpressionTree(final ExpressionTreeOp theElement,
                          final ExpressionTree theLeftSubtree,
                          final ExpressionTree theRightSubtree) 
    {
        super();
        myRoot = new BinaryTreeNode<ExpressionTreeOp>(theElement,
                                                      theLeftSubtree,
                                                      theRightSubtree);
    }
    
    /**
     * Evaluates the expression tree by calling the recursive 
     * evaluateNode method.
     *
     * @return the integer evaluation of the tree
     */
    public int evaluateTree() 
    {
        return evaluateNode(myRoot);
    }

    /**
     * Recursively evaluates each node of the tree.
     *
     * @param theRoot the root of the tree to be evaluated
     * @return the integer evaluation of the tree
     */
    public int evaluateNode(final BinaryTreeNode<ExpressionTreeOp> theRoot)
    {
        final int result;
        final int operand1;
        final int operand2;
        final ExpressionTreeOp temp;
        
        if (theRoot == null)
        {
            result = 0;
        }
        else
        {
            temp = (ExpressionTreeOp) theRoot.getElement();
            
            if (temp.isOperator())
            {
                operand1 = evaluateNode(theRoot.getLeft());
                operand2 = evaluateNode(theRoot.getRight());
                result = computeTerm(temp.getOperator(), operand1, operand2);
            }
            else
            {
                result = temp.getValue();
            }
        }
        
        return result;
    }

    /**
     * Evaluates a term consisting of an operator and two operands.
     *
     * @param theOperator  the operator for the expression
     * @param theOperand1  the first operand for the expression
     * @param theOperand2  the second operand for the expression
     * @return the result of evaluating this term
     */
    private static int computeTerm(final char theOperator,
                                   final int theOperand1,
                                   final int theOperand2)
    {
        int result = 0;
        
        if (theOperator == '+')
        {
            result = theOperand1 + theOperand2;
        }
        
        else if (theOperator == '-')
        {
            result = theOperand1 - theOperand2;
        }
        else if (theOperator == '*')
        {
            result = theOperand1 * theOperand2;
        }
        else
        {
            result = theOperand1 / theOperand2;
        }

        return result;
    }
    
    /**
     * Generates a structured string version of the tree by performing 
     * a level order traversal.
     *
     * @return a string representation of this binary tree
     */
    public String printTree() 
    {
        final UnorderedListADT<BinaryTreeNode<ExpressionTreeOp>> nodes = 
            new ArrayUnorderedList<BinaryTreeNode<ExpressionTreeOp>>();
        final UnorderedListADT<Integer> levelList = 
            new ArrayUnorderedList<Integer>();
        BinaryTreeNode<ExpressionTreeOp> current;
        final StringBuilder sb = new StringBuilder();
        final int printDepth = this.getHeight();
        final int possibleNodes = (int) Math.pow(2, printDepth + 1);
        int countNodes = 0;
        
        nodes.addToRear(myRoot);
        Integer currentLevel = 0;
        Integer previousLevel = -1;
        levelList.addToRear(currentLevel);
        
        while (countNodes < possibleNodes) 
        {
            countNodes = countNodes + 1;
            current = nodes.removeFirst();
            currentLevel = levelList.removeFirst();
            if (currentLevel > previousLevel)
            {
                sb.append("\n\n");
                previousLevel = currentLevel;
                for (int j = 0; j < ((Math.pow(2, printDepth - currentLevel)) - 1); j++)
                {
                    sb.append(' ');
                }
            }
            else
            {
                for (int i = 0; i < ((Math.pow(2, printDepth - currentLevel + 1) - 1)); i++) 
                {
                    sb.append(' ');
                }
            }
            if (current == null)
            {
                nodes.addToRear(null);
                levelList.addToRear(currentLevel + 1);
                nodes.addToRear(null);
                levelList.addToRear(currentLevel + 1);
                sb.append(' ');
            }
            else
            {
                sb.append(current.getElement().toString());
                nodes.addToRear(current.getLeft());
                levelList.addToRear(currentLevel + 1);
                nodes.addToRear(current.getRight());
                levelList.addToRear(currentLevel + 1);
            }

        }
        
        return sb.toString();
    }
}

