
/*
Time Complexity : O(N * log( N ))
Space Complexity : (N)
Where N is the number of nodes in the given binary tree.
*/
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// For storing top view element
		ArrayList<Integer> topView = new ArrayList<>();

		// Key will be the horizontal distance from root and value corresponding to that
		// key will be the value of the node
		HashMap<Integer, Integer> visited = new HashMap<>();

		if (root == null) {
			return topView;
		}

		// For iterating level by level

		Queue<Pair> level = new LinkedList<>();

		// Append root to the level with 0 horizontal distance
		Pair p = new Pair(root, 0);
		level.add(p);

		// Iterate untill level does not become empty
		while (level.size() != 0) {

			// Get total number of node at current level
			int levelSize = level.size();

			while (levelSize != 0) {

				// Get front of the queue
				Pair curr = level.peek();
				level.poll();

				// Get the horizontal distance of curr node
				int hrDistance = curr.level;

				// Get current node
				BinaryTreeNode currNode = curr.root;

				// Check whether hDistance is visited or not. If not visited then only it will
				// be seen by the top of the tree
				if (!visited.containsKey(hrDistance)) {
					// Make it visited
					visited.put(hrDistance, currNode.val);
				}

				// Append left child if it exist with horizontal distance one less than currNode
				if (currNode.left != null) {
					Pair temp = new Pair(currNode.left, hrDistance - 1);
					level.add(temp);
				}

				// Append right child if it exist with horizontal distance one more than
				// currNode
				if (currNode.right != null) {
					Pair temp = new Pair(currNode.right, hrDistance + 1);
					level.add(temp);

				}
				levelSize = levelSize - 1;
			}
		}

		// Now visited have the element which can be the view from the top of the tree
		for (int key : visited.keySet()) {
			topView.add(key);
		}
		// Sorting Keys according to the level Example (-2,-1,0,1,2)
		Collections.sort(topView);

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i : topView) {
			ans.add(visited.get(i));
		}

		return ans;
	}
}
