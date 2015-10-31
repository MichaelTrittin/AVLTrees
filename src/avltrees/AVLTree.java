package avltrees;

import java.util.Stack;

/**
 * This class is a self-balancing binary search tree which boasts the ability to
 * insert, delete, and find elements in O(log n) time. For lookup-intensive
 * applications, an AVLTree will be faster than a red-black tree.
 *
 * @author Michael
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>>
{
	private Node<T> head = null;

	public AVLTree()
	{
	}

	public AVLTree(T[] items) throws BalanceException
	{
		for (int i = 0; i < items.length; i++) {
			this.insert(items[i]);
		}
	}

	/**
	 * Checks if the tree contains the given item
	 *
	 * @param item
	 * @return
	 */
	public boolean contains(T item)
	{
		Node<T> current = head;
		while (current != null) {
			int comparison = current.element.compareTo(item);
			if (comparison == 0) {
				return true;
			} else if (comparison > 0) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		return false;
	}

	/**
	 * Deletes a node from the tree and rebalance it if necessary
	 *
	 * @param node
	 */
	public void delete(Node<T> node)
	{
		// TODO
	}

	/**
	 * Deletes the given item from the tree if it is found
	 *
	 * @param item
	 * @return true if the item is found, false otherwise
	 */
	public boolean delete(T item)
	{
		// TODO
		return false;
	}

	private void doubleLeftRotate(Node<T> node, Node<T> parent)
	{
		Node<T> newRoot = leftRotate(node.left, parent);
		rightRotate(node, newRoot);
	}

	private void doubleRightRotate(Node<T> node, Node<T> parent)
	{
		Node<T> newRoot = rightRotate(node.right, parent);
		leftRotate(node, newRoot);
	}

	/**
	 * Returns the element at the nth index in the tree using infix traversal
	 *
	 * @param item
	 * @return
	 */
	public T get(int n)
	{

		// TODO
		return null;
	}

	/**
	 * Returns the height of the tree
	 *
	 * @return
	 */
	public int getHeight()
	{
		if (this.head == null) {
			return -1;
		}
		return this.head.height;
	}

	/**
	 * Inserts into the tree
	 *
	 * @param item
	 * @return true if able to insert, false otherwise
	 */
	public boolean insert(T item) throws BalanceException
	{
		if (this.head == null) {
			this.head = new Node<T>(item);
			return true;
		}

		Stack<Node<T>> nodeStack = new Stack<>();
		nodeStack.push(this.head);
		while (true) {
			Node<T> current = nodeStack.peek();
			int comparison = current.element.compareTo(item);
			switch (comparison) {
			case -1:
				if (current.right != null) {
					nodeStack.push(current);
				} else {
					current.right = new Node<T>(item);
					BalanceEnum balance = current.right.addBalance(BalanceEnum.RIGHT);

					while (nodeStack.size() > 0) {
						Node<T> node = nodeStack.pop();
						balance = node.addBalance(balance);
						if (balance == BalanceEnum.HEAVY_RIGHT) {
							if (node.right.balance == BalanceEnum.LEFT) {
								// Perform double left rotation
								Node<T> parent = nodeStack.size() == 0 ? null : nodeStack.peek();
								doubleRightRotate(node, parent);
							} else {
								// Perform single left rotation
								Node<T> parent = nodeStack.size() == 0 ? null : nodeStack.peek();
								rightRotate(node, parent);
							}
						}
						node.resetHeight();
					}
				}
				break;
			case 0:
				return false;
			case 1:
				if (current.left != null) {
					nodeStack.push(current);
				} else {
					current.left = new Node<T>(item);
					BalanceEnum balance = current.left.addBalance(BalanceEnum.LEFT);
					while (nodeStack.size() > 0) {
						Node<T> node = nodeStack.pop();
						balance = node.addBalance(balance);
						if (balance == BalanceEnum.HEAVY_LEFT) {
							if (node.left.balance == BalanceEnum.RIGHT) {
								// Perform double right rotation
								Node<T> parent = nodeStack.size() == 0 ? null : nodeStack.peek();
								doubleLeftRotate(node, parent);
							} else {
								// Perform single right rotation
								Node<T> parent = nodeStack.size() == 0 ? null : nodeStack.peek();
								leftRotate(node, parent);
							}
						}
						node.resetHeight();
					}
				}
			}
		}
	}

	private Node<T> leftRotate(Node<T> node, Node<T> parent)
	{
		// node.right becomes new root
		// node takes ownership of node.right's left child as its right child
		// node.right takes ownership of node as its left child
		// TODO
		return null;
	}

	private Node<T> rightRotate(Node<T> node, Node<T> parent)
	{
		// TODO
		return null;

	}

	public void setHead(Node<T> head)
	{
		this.head = head;
	}

	/**
	 * Returns the size of the tree
	 *
	 * @return
	 */
	public int size()
	{
		if (this.head == null) {
			return 0;
		}

		Stack<NodePair<T>> nodeStack = new Stack<>();
		int size = 0;

		nodeStack.push(new NodePair<T>(this.head));
		while (nodeStack.size() > 0) {
			NodePair<T> nodePair = nodeStack.peek();
			if (nodePair.visited) {
				nodeStack.pop();
				size++;
				if (nodePair.node.right != null) {
					nodeStack.add(new NodePair<>(nodePair.node.right));
				}
			} else {
				nodePair.visited = true;
				if (nodePair.node.left != null) {
					nodeStack.add(new NodePair<T>(nodePair.node.left));
				} else if (nodePair.node.right == null) {
					nodeStack.pop();
					size++;
				}
			}
		}
		return size;
	}

	@Override
	public String toString()
	{
		if (this.head == null) {
			return "";
		}

		Stack<NodePair<T>> nodeStack = new Stack<>();

		String str = "{";
		nodeStack.push(new NodePair<T>(this.head));
		while (nodeStack.size() > 0) {
			NodePair<T> nodePair = nodeStack.peek();
			if (nodePair.visited) {
				nodeStack.pop();
				str += nodePair.node.element.toString() + ", ";
				if (nodePair.node.right != null) {
					nodeStack.add(new NodePair<T>(nodePair.node.right));
				}
			} else {
				nodePair.visited = true;
				if (nodePair.node.left != null) {
					nodeStack.add(new NodePair<T>(nodePair.node.left));
				} else if (nodePair.node.right == null) {
					nodeStack.pop();
					str += nodePair.node.element.toString() + ", ";
				}
			}
		}

		return str.substring(0, str.length() - 2) + "}";
	}
}
