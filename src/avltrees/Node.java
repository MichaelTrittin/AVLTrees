package avltrees;

public class Node<T extends Comparable<T>>
{

	protected T element;

	protected Node<T> left;
	protected Node<T> right;
	protected Node<T> parent;

	public Node(T element)
	{
		this.element = element;
	}

	public Node(T element, Node<T> parent)
	{
		this(element);
		this.parent = parent;
	}

	public Node<T> getLeft()
	{
		return this.left;
	}

	public Node<T> getParent()
	{
		return this.parent;
	}

	public Node<T> getRight()
	{
		return this.right;
	}

	public boolean hasChildren()
	{
		return this.left != null && this.right != null;
	}

	public Node<T> setLeft(Node<T> left)
	{
		this.left = left;
		return left;
	}

	public Node<T> setParent(Node<T> parent)
	{
		this.parent = parent;
		return parent;
	}

	public Node<T> setRight(Node<T> right)
	{
		this.right = right;
		return right;
	}
}
