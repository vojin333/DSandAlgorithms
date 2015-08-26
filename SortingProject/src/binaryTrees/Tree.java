package binaryTrees;

public class Tree {

	private Node root;
	
	public Node find(int key) {
		Node current = root;
		
		while (current.iData != key) {
			if (key > current.iData) {
				current = current.right;
			} else {
				current = current.left;
			}
			
			if(current == null){
				return null;
			}
		}
		return current;
	}
	
	public void insert(int key, double value) {
		
		Node newNode = new Node();
		newNode.iData = key;
		newNode.fData = value;
		
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent; 
			while (true) {
				parent = current;
				if (key < current.iData) {
					current = current.left;
					if(current == null){
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if(current == null){
						parent.right = newNode;
						return;
					}
				}
				
			}
		}
		
	}
	
	public void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.left);
			System.out.println("Local root" + localRoot.iData);
			inOrder(localRoot.right);
		}
	}
	
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key) {
			parent = current;
			if (key < current.iData) {
				current = current.left;
				isLeftChild = true;
			} else {
				current = current.right;
				isLeftChild = false;
			}
			
			if (current == null) {
				return false;
			}
		}
		//case that found current node is leaf(no children)
		if (current.left == null && current.right == null) {
			if(current == root) {
				root = null;
			}
			if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		//case parent has only one child
		if(current.left == null) {
			if(current == root) {
				root = current.right;
			}
			if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		}
		if (current.right == null) {
			if (current == root) {
				root = current.left;
			}
			if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		}
		return true;
		
	}
}
