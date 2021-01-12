/*
Time complexity: O(N)
Space complexity: O(N)

Where 'N' is number of nodes in binary tree.
*/
public class Solution {
	static int Count;

	private static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, int source, int destination) {
		// Base case
		if (root == null) {
			return null;
		}

		// Find the LCA in left side
		BinaryTreeNode leftAns = lowestCommonAncestor(root.left, source, destination);

		// Find the LCA in right side
		BinaryTreeNode rightAns = lowestCommonAncestor(root.right, source, destination);

		// If current BinaryTreeNode is LCA
		if (((leftAns != null) && (rightAns != null)) || (root.val == source || root.val == destination)) {
			return root;
		}

		// If LCA is already present in child part of root
		else {
			if (leftAns != null) {
				return leftAns;
			} else {
				return rightAns;
			}
		}
	}

	// Function count number of turn need to reach
	// Given node from it's LCA we have two way to
	public static boolean CountTurn(BinaryTreeNode root, int val, boolean turn) {
		if (root == null)
			return false;

		// If found the val value in tree
		if (root.val == val)
			return true;

		// Case 1:
		if (turn == true) {
			if (CountTurn(root.left, val, turn))
				return true;
			if (CountTurn(root.right, val, !turn)) {
				Count += 1;
				return true;
			}
		} else // Case 2:
		{
			if (CountTurn(root.right, val, turn))
				return true;
			if (CountTurn(root.left, val, !turn)) {
				Count += 1;
				return true;
			}
		}
		return false;
	}

	public static int countTurn(BinaryTreeNode root, int source, int destination) {
		BinaryTreeNode LCA = lowestCommonAncestor(root, source, destination);

		// there is no path between these two BinaryTreeNode
		if (LCA == null)
			return -1;
		Count = 0;

		// case 1:
		if (LCA.val != source && LCA.val != destination) {

			// Count number of turns needs to reached
			// the destination BinaryTreeNode from LCA
			if (CountTurn(LCA.right, destination, false) || CountTurn(LCA.left, destination, true))
				;

			// Count number of turns needs to reached
			// The first BinaryTreeNode from LCA
			if (CountTurn(LCA.left, source, true) || CountTurn(LCA.right, source, false))
				;
			return Count + 1;
		}

		// case 2:
		if (LCA.val == source) {

			// count number of turns needs to reached
			// the destination BinaryTreeNode from LCA
			CountTurn(LCA.right, destination, false);
			CountTurn(LCA.left, destination, true);
			return Count;
		} else {

			// count number of turns needs to reached
			// the first BinaryTreeNode from LCA1
			CountTurn(LCA.right, source, false);
			CountTurn(LCA.left, source, true);
			return Count;

		}
	}
}
