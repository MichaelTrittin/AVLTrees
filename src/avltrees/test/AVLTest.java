package avltrees.test;

import avltrees.AVLTree;
import avltrees.Node;

public class AVLTest
{
	public static void main(String[] args)
	{
		AVLTree<Integer> tree = new AVLTree<Integer>();
		Node<Integer> nodeList[] = new Node[10];
		for (int i = 0; i < 10; i++) {
			nodeList[i] = new Node<Integer>(i);
		}

		tree.setHead(nodeList[5]);
		nodeList[5].setLeft(nodeList[2]);
		nodeList[2].setLeft(nodeList[1]);
		nodeList[1].setLeft(nodeList[0]);
		nodeList[2].setRight(nodeList[4]);
		nodeList[4].setLeft(nodeList[3]);
		nodeList[5].setRight(nodeList[9]);
		nodeList[9].setLeft(nodeList[6]);
		nodeList[6].setRight(nodeList[8]);
		nodeList[8].setLeft(nodeList[7]);

		System.out.println(tree.toString());
	}
}
