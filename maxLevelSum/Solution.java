/*
Time complexity: O(N)
Space complexity: O(W)

Where N is the number of nodes and W is the width of the given binary tree.

*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static int maxLevelSum(BinaryTreeNode root) {
		if (root == null) {

			return 0;
		}

		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		int ans = root.val;

		while (!q.isEmpty()) {

			int s = q.size();
			int sum = 0;

			// To store sum of nodes of current level.
			while (s-- > 0) {

				BinaryTreeNode temp = q.peek();
				sum += temp.val;
				q.poll();

				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}

			}

			ans = Math.max(ans, sum);

		}

		return ans;

	}

}
