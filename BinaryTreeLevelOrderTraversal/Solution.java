/*

    Time complexity: O(N)
    Space complexity: O(N)

    where N is the number of nodes in the input tree

*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void printLevelWise(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode frontNode = pendingNodes.poll();

			if (frontNode == null) {
//				System.out.println();

				if (!pendingNodes.isEmpty()) {
					pendingNodes.add(null);
				}

			} else {
				System.out.print(frontNode.val + " ");

				if (frontNode.left != null) {
					pendingNodes.add(frontNode.left);
				}

				if (frontNode.right != null) {
					pendingNodes.add(frontNode.right);
				}
			}

		}

	}

}