package binaryTrees;

public class TreeApp {

	/**
	 * @param args
	 * @see 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree binaryTree = new Tree();
		
		binaryTree.insert(50, 50);
		binaryTree.insert(60, 60);
		binaryTree.insert(70, 70);
		binaryTree.insert(65, 65);
		binaryTree.insert(55, 55);
		binaryTree.insert(40, 40);
		binaryTree.insert(30, 30);
		
		binaryTree.inOrder(binaryTree.find(50));
	}

}
