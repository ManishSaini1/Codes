
/*
Time Complexity: O(N)
Space Complexity: O(N)

where N is the number of nodes in the binary tree.
*/
import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> findAncestors(BinaryTreeNode root, BinaryTreeNode targetNode) {

		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		getAncestors(root, targetNode, ans);
		return ans;
	}

	private static boolean getAncestors(BinaryTreeNode root, BinaryTreeNode targetNode, ArrayList<Integer> ans) {
		if (root == null)
			return false;

		if (root.val == targetNode.val)
			return true;

		if (getAncestors(root.left, targetNode, ans) || getAncestors(root.right, targetNode, ans)) {
			ans.add(root.val);
			return true;
		}

		return false;

	}

}
