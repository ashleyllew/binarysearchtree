
public class BinarySearchTree implements BST_Interface {
	
	public static void main (String[] args) {
	}
	
	public BST_Node addRoot(String data) {
		BST_Node root = new BST_Node();
		if (data == null) {
			return null;
		}
		else {
			root.setData(data);
		}
		return root;
	}
	
	@Override
	public boolean insert(BST_Node root, String s) {
		
		BST_Node newNode = new BST_Node();
		newNode.setData(s);
		
		BST_Node currentNode = root;
		
		
		while (currentNode != null) {
			if (Integer.parseInt(newNode.getData()) < Integer.parseInt(currentNode.getData())) {
				if (currentNode.getLeftNode() == null) {
					currentNode.setLeftNode(newNode);
					return true;
				}
				else {
					currentNode = currentNode.getLeftNode();
				}
			}
			else if (Integer.parseInt(newNode.getData()) > Integer.parseInt(currentNode.getData())) {
				if (currentNode.getRightNode() == null) {
					currentNode.setRightNode(newNode);
					return true;
				}
				else {
					currentNode = currentNode.getRightNode();
				}
			}
		}
		return true;
	}

	@Override
	public boolean remove(BST_Node node, String s) {
			if (node.getData() == s) {
				return true;			
			}
			else if (Integer.parseInt(s) > Integer.parseInt(node.getData())) {
				if (node.getRightNode() != null) {
					if (node.getRightNode().getData() == s) {
						String side = "right";
						removeNextStep(node, side);
					}
					else {
						contains(node.getRightNode(), s);					
					}
				}
				else {
					return false;
				}
			}
			else if (Integer.parseInt(s) < Integer.parseInt(node.getData())) {
				if (node.getLeftNode() != null) {
					if (node.getLeftNode().getData() == s) {
						String side = "left";
						removeNextStep(node, side);
					}
					else {
						contains(node.getLeftNode(), s);					
					}
				}
				else {
					return false;
				}
			}
			return false;
	}
	
	public void removeNextStep(BST_Node node, String side) {
		if (side == "left") {
			if (node.getLeftNode().getRightNode() == null && node.getLeftNode().getLeftNode() == null) {
				node.setLeftNode(null);
			}
			else if (node.getLeftNode().getRightNode() != null && node.getLeftNode().getLeftNode() == null) {
				node.setLeftNode(node.getLeftNode().getRightNode());
			}
			else if (node.getLeftNode().getLeftNode() != null && node.getLeftNode().getRightNode() == null) {
				node.setLeftNode(node.getLeftNode().getLeftNode());
			}
			else {
				removeWithTwoChildren(node, side);
			}
		}
		if (side == "right") {
			if (node.getRightNode().getRightNode() == null && node.getRightNode().getLeftNode() == null) {
				node.setRightNode(null);
			}
			else if (node.getRightNode().getRightNode() != null && node.getRightNode().getLeftNode() == null) {
				node.setRightNode(node.getRightNode().getRightNode());
			}
			else if (node.getRightNode().getLeftNode() != null && node.getRightNode().getRightNode() == null) {
				node.setRightNode(node.getRightNode().getLeftNode());
			}
			else {
				removeWithTwoChildren(node, side);
			}
		}
	}
	
	public void removeWithTwoChildren(BST_Node node, String side) {
		if (side == "right") {
			node = node.getRightNode();
			BST_Node rightChild = node.getRightNode();
			String rightMin = findMin(rightChild);
			node.setData(rightMin);
			remove(rightChild, rightMin);
		}
		if (side == "left") {
			node = node.getLeftNode();
			BST_Node rightChild = node.getRightNode();
			String rightMin = findMin(rightChild);
			node.setData(rightMin);
			remove(rightChild, rightMin);
		}
	}
	
	
	
	@Override
	public String findMin(BST_Node root) {
		BST_Node currentNode = root;
		if (currentNode.getLeftNode() != null) {
			while (currentNode.getLeftNode() != null) {
				currentNode = currentNode.getLeftNode();
			}
		}
		else {
			return currentNode.getData();			
		}
		return currentNode.getData();
	}

	@Override
	public String findMax(BST_Node root) {
		BST_Node currentNode = root;
		if (currentNode.getRightNode() != null) {
			// why does this while loop need to be currentNode.getRightNode() instead of 
			// currentNode.getRightNode().getData() ???
			while (currentNode.getRightNode() != null) {
				currentNode = currentNode.getRightNode();
			}
		}
		else {
			return currentNode.getData();			
		}
		return currentNode.getData();
	}

	@Override
	public boolean contains(BST_Node node, String s) {
		if (node.getData() == s) {
			return true;			
		}
		else if (Integer.parseInt(s) > Integer.parseInt(node.getData())) {
			if (node.getRightNode() != null) {
				contains(node.getRightNode(), s);
			}
			else {
				return false;
			}
		}
		else if (Integer.parseInt(s) < Integer.parseInt(node.getData())) {
			if (node.getLeftNode() != null) {
				contains(node.getLeftNode(), s);				
			}
			else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int size(BST_Node root) {
		return 0;
		// how is this different from height???
	}

	@Override
	public int height(BST_Node node) {
		// got help from geeksforgeeks how to write height of BST
		if (node == null) {
			return 0;
		}
		else {
			int leftDepth = height(node.getLeftNode());
			int rightDepth = height(node.getRightNode());
			
			if (leftDepth > rightDepth) {
				return (leftDepth + 1);
			}
			else {
				return (rightDepth + 1);
			}
		}
	}
}
