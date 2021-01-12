/* 
    Time complexity: O(n*logn)
    Space complexity: O(n)

    Where n is the number of nodes in the binary tree.
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
	public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
		HashMap<Integer, Pair> mp = new HashMap<>();
		bottomViewHelper(root, 0, 0, mp);

		// Get the top view of the tree
		ArrayList<Integer> topView = new ArrayList<>();
		for (int key : mp.keySet()) {
			topView.add(key);
		}
		// Sorting Keys according to the level Example (-2,-1,0,1,2)
		Collections.sort(topView);

		ArrayList<Integer> ans = new ArrayList<>();
		// Store all final set of nodes in the answer vector.
		for (int i : topView) {
			ans.add(mp.get(i).root.val);
		}
		return ans;

	}

	private static void bottomViewHelper(BinaryTreeNode root, int level, int horizontalDistance,
			HashMap<Integer, Pair> mp) {
		if (root == null) {
			return;
		}
		// If the current horizontal distance is not already present, add it.
		if (!mp.containsKey(horizontalDistance)) {
			mp.put(horizontalDistance, new Pair(root, level));
		}
		// Compare height for already present node at similar horizontal distance
		else {
			Pair p = mp.get(horizontalDistance);
			if (p.level <= level) {
				mp.put(horizontalDistance, new Pair(root, level));
			}
		}
		// Recur for left subtree
		bottomViewHelper(root.left, level + 1, horizontalDistance - 1, mp);
		// Recur for right subtree
		bottomViewHelper(root.right, level + 1, horizontalDistance + 1, mp);

	}

}
