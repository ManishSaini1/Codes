/*
Time Complexity : O(N * log( N ))
Space Complexity : (N)
Where 'N' is the number of nodes in the given binary tree.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Pair {
	BinaryTreeNode root;
	int level;

	Pair() {
	}

	Pair(BinaryTreeNode root, int level) {
		this.root = root;
		this.level = level;
	}
}

public class Solution {

	public static void applyPreOrder(BinaryTreeNode root, int hDistance, int level, HashMap<Integer, Pair> visited) {

		// Base Case:
		if (root == null) {
			return;
		}
		// Check whether the current horizontal distance is already visited or not? if
		// visited then is previous visited element has greater level.

		if (!visited.containsKey(hDistance)) {
			visited.put(hDistance, new Pair(root, level));
		} else {
			Pair p = visited.get(hDistance);

			if (p.level >= level) {
				visited.put(hDistance, new Pair(root, level));
			}
		}

		// Go for left subtree with one less horizontal distance and one more level
		applyPreOrder(root.left, hDistance - 1, level + 1, visited);

		// Go for right subtree with one more horizontal distance and one more level
		applyPreOrder(root.right, hDistance + 1, level + 1, visited);
	}

	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {

		// To store horizontal distance as a key and pair of node's value and it's level
		// as the value
		HashMap<Integer, Pair> visited = new HashMap<>();

		// Apply pre-order with 0 horizontal distance and 0 levels for root.
		applyPreOrder(root, 0, 0, visited);

		// Get the top view of the tree
		ArrayList<Integer> topView = new ArrayList<>();
		for (int key : visited.keySet()) {
			topView.add(key);
		}
		// Sorting Keys according to the level Example (-2,-1,0,1,2)
		Collections.sort(topView);

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i : topView) {
			ans.add(visited.get(i).root.val);
		}
		return ans;
	}

}
