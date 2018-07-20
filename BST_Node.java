
public class BST_Node {
	BST_Node root;
	BST_Node rightNode;
	BST_Node leftNode;
	String data;
	
	public BST_Node () {
	}
	
	public BST_Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(BST_Node rightNode) {
		this.rightNode = rightNode;
	}
	public BST_Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BST_Node leftNode) {
		this.leftNode = leftNode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
