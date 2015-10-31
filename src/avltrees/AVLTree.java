package avltrees;

import java.util.Stack;

public class AVLTree<T extends Comparable<T>>
{
	private Node<T> head = null;

	public AVLTree()
	{
	}

	public AVLTree(T[] items)
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
	 * Inserts into the tree
	 *
	 * @param item
	 * @return true if able to insert, false otherwise
	 */
	private boolean insert(T item)
	{
		// TODO
		return false;
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
		// TODO
		return -1;
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
