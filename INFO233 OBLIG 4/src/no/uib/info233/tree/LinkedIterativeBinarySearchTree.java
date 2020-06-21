package no.uib.info233.tree;/** * A class that implements the ADT binary search tree by extending BinaryTree. * Iterative version. *  * @author Frank M. Carrano * @author Timothy M. Henry * @version 4.2 */public class LinkedIterativeBinarySearchTree<T extends Comparable<? super T>> extends LinkedBinaryTree<T>        implements SearchTree<T> {    public LinkedIterativeBinarySearchTree() {        super();    }    public LinkedIterativeBinarySearchTree(T rootEntry) {        super();        setRootNode(new BinaryTreeNode<>(rootEntry));    }    public void setTree(T rootData) // Disable setTree (see Segment 25.6)    {        throw new UnsupportedOperationException();    }    public void setTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {        throw new UnsupportedOperationException();    }    @Override    public T getEntry(T entry) {        T result = null;        boolean found = false;        BinaryTreeNode<T> currentNode = getRootNode();        while (!found && (currentNode != null)) {            T currentEntry = currentNode.getData();            if (entry.equals(currentEntry)) {                result = currentEntry;                found = true;            } else if (entry.compareTo(currentEntry) < 0) {                currentNode = currentNode.getLeftChild();            } else {                currentNode = currentNode.getRightChild();            }        }        return result;    }    @Override    public Boolean contains(T entry) {        return getEntry(entry) != null;    }    @Override    public T add(T newEntry) {        T result = null;        if (isEmpty()) {            setRootNode(new BinaryTreeNode<>(newEntry));        } else {            result = addEntry(newEntry);        }        return result;    }    // Adds newEntry to the nonempty subtree rooted at rootNode.    private T addEntry(T newEntry) {        BinaryTreeNode<T> currentNode = getRootNode();        assert currentNode != null;        T result = null;        boolean found = false;        while (!found) {            T currentEntry = currentNode.getData();            int comparison = newEntry.compareTo(currentEntry);            if (comparison == 0) { // newEntry matches currentEntry;                                   // return and replace currentEntry                found = true;                result = currentEntry;                currentNode.setData(newEntry);            } else if (comparison < 0) {                if (currentNode.hasLeftChild()) {                    currentNode = currentNode.getLeftChild();                } else {                    found = true;                    currentNode.setLeftChild(new BinaryTreeNode<>(newEntry));                }            } else {                assert comparison > 0;                if (currentNode.hasRightChild()) {                    currentNode = currentNode.getRightChild();                } else {                    found = true;                    currentNode.setRightChild(new BinaryTreeNode<>(newEntry));                }            }        }        return result;    }    /*     * // SOLUTION to Exercise 12, Chapter 27 private T addEntry(BinaryNode<T>     * rootNode, T newEntry) { BinaryNode<T> currentNode = rootNode; assert     * currentNode != null; BinaryNode<T> parentNode = null; T result = null;     * boolean found = false;     *      * while (!found && (currentNode != null) ) { T currentEntry =     * currentNode.getData(); int comparison = newEntry.compareTo(currentEntry);     *      * if (comparison == 0) { // newEntry matches currentEntry: return and replace     * currentEntry found = true; result = currentEntry;     * currentNode.setData(newEntry); } else if (comparison < 0) { // Search left     * parentNode = currentNode; currentNode = currentNode.getLeftChild(); } else {     * // Search right parentNode = currentNode; currentNode =     * currentNode.getRightChild(); } }     *      * if (!found) { // Add new entry as a leaf of parentNode BinaryNode<T> newLeaf     * = new BinaryNode<>(newEntry);     *      * if (newEntry.compareTo(parentNode.getData()) < 0)     * parentNode.setLeftChild(newLeaf); else parentNode.setRightChild(newLeaf); }     *      * return result; }     */    @Override    public T remove(T entry) {        T result = null;        // Locate node (and its parent) that contains a match for entry        NodePair pair = findNode(entry);        BinaryTreeNode<T> currentNode = pair.getFirst();        BinaryTreeNode<T> parentNode = pair.getSecond();        if (currentNode != null) // Entry is found        {            result = currentNode.getData(); // Get entry to be removed            // Case 1: currentNode has two children            if (currentNode.hasLeftChild() && currentNode.hasRightChild()) {                // Replace entry in currentNode with the entry in another node                // that has at most one child; that node can be deleted                // Get node to remove (contains inorder predecessor; has at                // most one child) and its parent                pair = getNodeToRemove(currentNode);                BinaryTreeNode<T> nodeToRemove = pair.getFirst();                parentNode = pair.getSecond();                // Copy entry from nodeToRemove to currentNode                currentNode.setData(nodeToRemove.getData());                currentNode = nodeToRemove;                // Assertion: currentNode is the node to be removed; it has at                // most one child                // Assertion: Case 1 has been transformed to Case 2            }            // Case 2: currentNode has at most one child; delete it            removeNode(currentNode, parentNode);        }        return result;    }    // Locate node that contains a match for entry    private NodePair findNode(T entry) {        NodePair result = new NodePair();        boolean found = false;        BinaryTreeNode<T> currentNode = getRootNode();        BinaryTreeNode<T> parentNode = null;        while (!found && (currentNode != null)) {            T currentEntry = currentNode.getData();            int comparison = entry.compareTo(currentEntry);            if (comparison < 0) {                parentNode = currentNode;                currentNode = currentNode.getLeftChild();            } else if (comparison > 0) {                parentNode = currentNode;                currentNode = currentNode.getRightChild();            } else {                found = true;            }        }        if (found) {            result = new NodePair(currentNode, parentNode);            // Located entry is currentNode.getData()        }        return result;    }    // Gets the node that contains the inorder predecessor of currentNode.    // Precondition: currentNode has two children    private NodePair getNodeToRemove(BinaryTreeNode<T> currentNode) {        // Find node with largest entry in left subtree by        // moving as far right in the subtree as possible        BinaryTreeNode<T> leftSubtreeRoot = currentNode.getLeftChild();        BinaryTreeNode<T> rightChild = leftSubtreeRoot;        BinaryTreeNode<T> priorNode = currentNode;        while (rightChild.hasRightChild()) {            priorNode = rightChild;            rightChild = rightChild.getRightChild();        }        // rightChild contains the inorder predecessor and is the node to        // remove; priorNode is its parent        return new NodePair(rightChild, priorNode);    }    // Removes a node having at most one child.    private void removeNode(BinaryTreeNode<T> nodeToRemove, BinaryTreeNode<T> parentNode) {        BinaryTreeNode<T> childNode;        if (nodeToRemove.hasLeftChild()) {            childNode = nodeToRemove.getLeftChild();        } else {            childNode = nodeToRemove.getRightChild();        }        // Assertion: if nodeToRemove is a leaf, childNode is null        assert (nodeToRemove.isLeaf() && childNode == null) || !nodeToRemove.isLeaf();        if (nodeToRemove == getRootNode()) {            setRootNode(childNode);        } else if (parentNode.getLeftChild() == nodeToRemove) {            parentNode.setLeftChild(childNode);        } else {            parentNode.setRightChild(childNode);        }    }    // Other public methods in SearchTreeInterface are inherited from BinaryTree.    private class NodePair {        private BinaryTreeNode<T> first, second;        public NodePair() {            first = null;            second = null;        }        public NodePair(BinaryTreeNode<T> firstNode, BinaryTreeNode<T> secondNode) {            first = firstNode;            second = secondNode;        }        public BinaryTreeNode<T> getFirst() {            return first;        }        public BinaryTreeNode<T> getSecond() {            return second;        }    }}