/*
Time Complexity - O(N)
Space Complexity - O(N)

where N is the number of nodes in the binary tree.
*/
public class Solution {
	public static BinaryTreeNode binaryTreePruning(BinaryTreeNode root) {
		// If there is a 1 in the whole tree
		if (hasOne(root) == true) {
			return root;
		}

		// Else, delete the whole tree
		return null;

	}

	private static boolean hasOne(BinaryTreeNode root) {

		if (root == null) {
			return false;
		}

		// Find if left and right subtrees contain a 1 or not
		boolean oneInLeftSubtree = hasOne(root.left);
		boolean oneInRightSubtree = hasOne(root.right);

		// If there's no 1 in left subtree
		if (oneInLeftSubtree == false) {
			// Delete left subtree
			root.left = null;
		}

		// If there's no 1 in right subtree
		if (oneInRightSubtree == false) {
			// Delete right subtree
			root.right = null;
		}

		// If there is any 1 in the subtree, return true
		if (root.val == 1 || oneInLeftSubtree || oneInRightSubtree) {
			return true;
		}

		// Else return false
		return false;
	}

}
