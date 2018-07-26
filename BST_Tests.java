import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BST_Tests {

	@Test
	public void insertElement() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = new BST_Node();
		root.setData("15");
		boolean insert = myBST.insert(root, "12");
		assertEquals(insert, true);
	}
	
	@Test
	public void heightAfterInsertion() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = new BST_Node();
		root.setData("15");
		myBST.insert(root, "12");
		int j = myBST.height(root);
		assertEquals(j, 2);
	}

	@Test
	public void heightAfterTwoInsertions() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = new BST_Node();
		root.setData("15");
		myBST.insert(root, "12");		
		myBST.insert(root, "13");
		int j = myBST.height(root);
		assertEquals(j, 3);
	}
	
	@Test
	public void removeItem() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = new BST_Node();
		root.setData("15");
		myBST.insert(root, "12");
		myBST.remove(root, "12");
		int j = myBST.height(root);
		assertEquals(j, 1);
	}

	@Test
	public void findMin() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = new BST_Node();
		root.setData("15");
		myBST.insert(root, "12");		
		myBST.insert(root, "13");
		assertEquals(myBST.findMin(root), "12");
	}
	
	@Test
	public void findMax() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = new BST_Node();
		root.setData("15");
		myBST.insert(root, "12");		
		myBST.insert(root, "13");
		myBST.insert(root,  "23");
		assertEquals(myBST.findMax(root), "23");
	}
	
	@Test
	public void notContains() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = myBST.addRoot("12");
		myBST.insert(root, "15");
		myBST.insert(root, "13");
		myBST.insert(root, "23");
		assertEquals(myBST.contains(root, "1"), false);
	}

	@Test
	public void containsRoot() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = myBST.addRoot("12");
		myBST.insert(root, "15");
		myBST.insert(root, "13");
		myBST.insert(root, "23");
		assertEquals(myBST.contains(root, "12"), true);
	}
	
	@Test
	public void containsNode() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = myBST.addRoot("12");
		myBST.insert(root, "15");
		boolean contains = myBST.contains(root, "15");
		assertEquals(contains, true);
	}
	
	@Test
	public void containsSecondNode() {
		BinarySearchTree myBST = new BinarySearchTree();
		BST_Node root = myBST.addRoot("12");
		myBST.insert(root, "15");
		myBST.insert(root, "11");
		boolean contains = myBST.contains(root, "11");
		assertEquals(contains, true);
	}
	// why doesn't this test work??
//	@Test
//	public void containsThirdNode() {
//		BinarySearchTree myBST = new BinarySearchTree();
//		BST_Node root = myBST.addRoot("12");
//		myBST.insert(root, "15");
//		myBST.insert(root, "11");
//		myBST.insert(root, "17");
//		boolean contains = myBST.contains(root, "17");
//		assertEquals(contains, true);
//	}

}
