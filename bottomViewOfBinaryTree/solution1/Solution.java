
/*
Time complexity: O(n)
Space complexity: O(2*n+1)

Where n is the number of nodes present in the binary tree.
*/
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
		ArrayList<Integer> answer = new ArrayList<>();
		int n = countNodes(root);
		int vec[] = new int[2 * n + 1];
		Arrays.fill(vec, Integer.MIN_VALUE);
		int vec1[] = new int[2 * n + 1];
		Arrays.fill(vec1, Integer.MIN_VALUE);
		int mid = n, horizontalDistance = 0, priority = 0;
		int leftIndex = 0, rightIndex = 0;

		bottomViewHelper(root, vec, vec1, horizontalDistance, priority, mid, leftIndex, rightIndex);
		for (int a : vec) {
			if (a != Integer.MIN_VALUE) {
				answer.add(a);
			}
		}

		return answer;
	}

	private static void bottomViewHelper(BinaryTreeNode root, int[] vec, int[] vec1, int horizontalDistance,
			int priority, int mid, int leftIndex, int rightIndex) {
		if (root == null) {
			return;
		}

		// Update the left index
		if (horizontalDistance < leftIndex) {
			leftIndex = horizontalDistance;
		}
		// Update the right index
		if (horizontalDistance > rightIndex) {
			rightIndex = horizontalDistance;
		}
		// If no node is already present at that horizontal distance, add the current
		// one.
		if (vec[mid + horizontalDistance] == Integer.MIN_VALUE) {
			vec[mid + horizontalDistance] = root.val;
			vec1[mid + horizontalDistance] = priority;
		}
		// Else compare the priority of the already exising and current node.
		else if (vec1[mid + horizontalDistance] <= priority) {
			vec[mid + horizontalDistance] = root.val;
			vec1[mid + horizontalDistance] = priority;
		}
		// Recur for left subtree
		bottomViewHelper(root.left, vec, vec1, horizontalDistance - 1, priority + 1, mid, leftIndex, rightIndex);
		// Recur for right subtree
		bottomViewHelper(root.right, vec, vec1, horizontalDistance + 1, priority + 1, mid, leftIndex, rightIndex);

	}

	private static int countNodes(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

}
