/*
Time Complexity: O(N)
Space Complexity: O(N)

where N is the number of nodes in the binary tree.

*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static ArrayList<Integer> findAncestors(BinaryTreeNode root, BinaryTreeNode targetNode) {
		ArrayList<Integer> ans = new ArrayList<>();
		// Base case.
		if (root == null)
			return ans;

		// Creating a map to store parents.
		HashMap<BinaryTreeNode, BinaryTreeNode> par = new HashMap<>();

		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);

		// Doing BFS on the given tree and storing parents.
		while (!q.isEmpty()) {
			BinaryTreeNode curr = q.peek();
			q.poll();
			if (curr.left != null) {
				par.put(curr.left, curr);
				q.add(curr.left);
			}
			if (curr.right != null) {
				par.put(curr.right, curr);
				q.add(curr.right);
			}
		}

		// If the targetNode is not found, then return empty vector.
		if (!par.containsKey(targetNode)) {
			return new ArrayList<>();
		}

		BinaryTreeNode curr_parent = par.get(targetNode);
		ans.add(curr_parent.val);

		while (curr_parent != root) {
			curr_parent = par.get(curr_parent);
			ans.add(curr_parent.val);
		}

		return ans;
	}
}
