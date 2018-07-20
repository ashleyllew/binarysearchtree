public interface BST_Interface {
	
	public boolean insert(BST_Node root, String s);
	public boolean remove(BST_Node root, String s);
	public String findMin(BST_Node root);
	public String findMax(BST_Node root);
	public boolean contains(BST_Node root, String s);
	public int size(BST_Node root);
	public int height(BST_Node root);
	public BST_Node addRoot(String data);
}
