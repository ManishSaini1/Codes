/*
Time complexity: O(N)
Space complexity: O(H)

where N is the number of nodes in the input binary tree and
H is the height of the input binary tree
*/
import java.util.ArrayList;

public class Solution {

	private static int nodesAtDistanceKHelper(BinaryTreeNode root, BinaryTreeNode target, int k,
			ArrayList<Integer> list) {
		if (root == null) {
			return -1;
		}
		if (root == target) {
			nodesAtDistanceKDown(root, k, list);
			return 0;
		}

		int leftD = nodesAtDistanceKHelper(root.left, target, k, list);
		if (leftD != -1) {
			if (leftD + 1 == k) {
				list.add(root.val);
			} else {
				nodesAtDistanceKDown(root.right, k - leftD - 2, list);
			}

			return 1 + leftD;
		}

		int rightD = nodesAtDistanceKHelper(root.right, target, k, list);
		if (rightD != -1) {
			if (rightD + 1 == k) {
				list.add(root.val);
			} else {
				nodesAtDistanceKDown(root.left, k - rightD - 2, list);
			}

			return 1 + rightD;
		}

		return -1;
	}

	private static void nodesAtDistanceKDown(BinaryTreeNode root, int k, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			list.add(root.val);
			return;
		}
		nodesAtDistanceKDown(root.left, k - 1, list);
		nodesAtDistanceKDown(root.right, k - 1, list);
	}

	public static ArrayList<Integer> nodesAtDistanceK(BinaryTreeNode root, BinaryTreeNode target, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		nodesAtDistanceKHelper(root, target, k, list);
		return list;
	}

}
