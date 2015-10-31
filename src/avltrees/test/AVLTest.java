package avltrees.test;

import avltrees.AVLTree;

public class AVLTest
{
	public static void main(String[] args)
	{
		AVLTree<Integer> tree = new AVLTree<Integer>();
		int elements[] = { 5, 2, 3, 6, 1, 4, 10, 11, 7, 8, 9, 13, 12 };

		for (int i = 0; i < elements.length; i++) {
			try {
				tree.insert(elements[i]);
			} catch (Exception e) {
				System.err.println("Failed to add element (" + elements[i] + ") due to a balance exception.");
			}
		}

		System.out.println(tree.toString());
		System.out.println(tree.size());
	}
}
