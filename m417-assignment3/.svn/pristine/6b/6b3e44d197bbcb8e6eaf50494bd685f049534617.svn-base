/*
 * TCSS 342
 */

package structures;

/**
 * BinaryTreeNode represents a node in a binary tree with a left and 
 * right child.
 * 
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342
 * @version Winter 2019
 * 
 * @param <T> the generic type placeholder
 */
public class BinaryTreeNode<T>
{
    /** The element referred to by this Node. */
    protected T myElement;
    
    /** A reference to the left child of this Node. */
    protected BinaryTreeNode<T> myLeft;
    
    /** A reference to the right child of this Node. */
    protected BinaryTreeNode<T> myRight;

    /**
     * Creates a new tree node with the specified data.
     *
     * @param theElement the element that will become a part of the new tree node
    */
    public BinaryTreeNode(final T theElement) 
    {
        myElement = theElement;
        myLeft = null;
        myRight = null;
    }

    /**
     * Creates a new tree node with the specified data.
     *
     * @param theElement the element that will become a part of the new tree node
     * @param theLeft the tree that will be the left subtree of this node
     * @param theRight the tree that will be the right subtree of this node
     */
    public BinaryTreeNode(final T theElement,
                          final LinkedBinaryTree<T> theLeft,
                          final LinkedBinaryTree<T> theRight) 
    {
        myElement = theElement;
        if (theLeft == null)
        {
            myLeft = null;
        }
        else
        {
            myLeft = theLeft.getRootNode();
        }
        if (theRight == null)
        {
            myRight = null;
        }
        else
        {
            myRight = theRight.getRootNode();
        }
    }
    
    /**
     * Returns the number of non-null children of this node.
     *
     * @return the integer number of non-null children of this node 
     */
    public int numChildren() 
    {
        int children = 0;

        if (myLeft != null)
        {
            children = 1 + myLeft.numChildren();
        }
        if (myRight != null)
        {
            children = children + 1 + myRight.numChildren();
        }
        return children;
    }
    
    /**
     * Return the element at this node.
     *
     * @return the element stored at this node
     */
    public T getElement() 
    {
        return myElement;
    }
    
    /**
     * Return the right child of this node.
     *
     * @return the right child of this node
     */
    public BinaryTreeNode<T> getRight() 
    {
        return myRight;
    }
    
    /**
     * Sets the right child of this node.
     *
     * @param theNode the right child of this node
     */
    public void setRight(final BinaryTreeNode<T> theNode)
    {
        myRight = theNode;
    }
    
    /**
     * Return the left child of this node.
     *
     * @return the left child of the node
     */
    public BinaryTreeNode<T> getLeft() 
    {
        return myLeft;
    }
    
    /**
     * Sets the left child of this node.
     *
     * @param theNode the left child of this node
     */
    public void setLeft(final BinaryTreeNode<T> theNode) 
    {
        myLeft = theNode;
    }
}

