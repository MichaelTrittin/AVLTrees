package avltrees;

public class Node<T extends Comparable<T>>
{

	protected T element;

	protected Node<T> left;
	protected Node<T> right;

	protected int height = 0;

	protected BalanceEnum balance = BalanceEnum.EQUAL;

	public Node(T element) throws NullPointerException
	{
		if (element == null) {
			throw new NullPointerException("Cannot insert null elements into the tree");
		}
		this.element = element;
	}

	public BalanceEnum addBalance(BalanceEnum balance) throws BalanceException
	{
		this.balance = this.balance.addBalance(balance);
		return this.balance;
	}

	public BalanceEnum getBalance()
	{
		return this.balance;
	}

	public int getHeight()
	{
		return this.height;
	}

	public Node<T> getLeft()
	{
		return this.left;
	}

	public Node<T> getRight()
	{
		return this.right;
	}

	public boolean hasChildren()
	{
		return this.left != null && this.right != null;
	}

	public void resetHeight()
	{
		if (this.left != null && this.right != null) {
			this.height = this.left.height > this.right.height ? this.left.height + 1 : this.right.height + 1;
		} else if (this.left != null) {
			this.height = this.left.height + 1;
		} else if (this.right != null) {
			this.height = this.right.height + 1;
		} else {
			this.height = 0;
		}
	}
}
