package avltrees;

public class NodePair<T extends Comparable<T>>
{
	protected Node<T> node = null;
	protected boolean visited = false;

	public NodePair(Node<T> node)
	{
		this.node = node;
	}

	public NodePair(Node<T> node, boolean visited)
	{
		this(node);
		this.visited = visited;
	}
}