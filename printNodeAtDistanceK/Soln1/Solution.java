/*
Time complexity: O(N)
Space complexity: O(N)

Where 'N' is number of nodes in binary tree.
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
	BinaryTreeNode node;
	int val;

	Pair() {
	}

	Pair(BinaryTreeNode node, int val) {
		this.node = node;
		this.val = val;

	}
}

public class Solution {
	public static ArrayList<Integer> nodesAtDistanceK(BinaryTreeNode root, BinaryTreeNode target, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		// Map to store parent of every node.
		HashMap<BinaryTreeNode, BinaryTreeNode> parentNode = new HashMap<>();
		performDFS(root, null, ans, parentNode);
		performBFS(root, target, k, ans, parentNode);
		return ans;
	}

	private static void performBFS(BinaryTreeNode root, BinaryTreeNode target, int k, ArrayList<Integer> ans,
			HashMap<BinaryTreeNode, BinaryTreeNode> parentNode) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(target, 0));

		HashSet<BinaryTreeNode> visited = new HashSet<>();
		visited.add(target);

		// For the BFS traversal
		while (!q.isEmpty()) {
			Pair curr = q.peek();
			visited.add(curr.node);
			q.poll();

			if (curr.val == k) {
				ans.add(curr.node.val);
			}

			BinaryTreeNode left = curr.node.left, right = curr.node.right;
			BinaryTreeNode parent = parentNode.get(curr.node);

			// Left of node is not visited
			if (left != null && !visited.contains(left)) {
				q.add(new Pair(left, curr.val + 1));
			}

			// Right of node is not visited
			if (right != null && !visited.contains(right)) {
				q.add(new Pair(right, curr.val + 1));
			}

			// Parent of node is not visited.
			if (parent != null && !visited.contains(parent)) {
				q.add(new Pair(parent, curr.val + 1));
			}
		}

	}

	private static void performDFS(BinaryTreeNode root, BinaryTreeNode parNode, ArrayList<Integer> ans,
			HashMap<BinaryTreeNode, BinaryTreeNode> parentNode) {
		if (root == null) {
			return;
		}
		parentNode.put(root, parNode);
		performDFS(root.left, root, ans, parentNode);
		performDFS(root.right, root, ans, parentNode);

	}
}
