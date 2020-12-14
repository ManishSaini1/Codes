/*
	Time complexity: O(N)
	Space complexity: O(N)

	where N is the number of nodes in the given binary tree

 */

import java.util.HashMap;

/*class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

}*/
public class Solution {
	public static int maxLevelSum(BinaryTreeNode root) {
		// For storing the sum of nodes of each level
		HashMap<Integer, Integer> hash = new HashMap<>();

		maxLevelSumHelper(root, 0, hash);

		int ans = Integer.MIN_VALUE;

		// For finding the maximum level sum

		for (Integer key : hash.keySet()) {
			ans = Math.max(ans, hash.get(key));
		}

		return ans;
	}

	private static void maxLevelSumHelper(BinaryTreeNode root, int level, HashMap<Integer, Integer> hash) {

		if (root == null) {
			return;
		}

		// Adding the value of every node in its corresponding level in map.
		if (hash.containsKey(level)) {
			hash.put(level, hash.get(level) + root.val);
		} else {
			hash.put(level, root.val);
		}
		maxLevelSumHelper(root.left, level + 1, hash);
		maxLevelSumHelper(root.right, level + 1, hash);

	}
}
