/*
Time Complexity: O(N)
Space Complexity: O(N),

where N is the number of nodes in the tree
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
	int hd;
	BinaryTreeNode node;

	Pair(int hd, BinaryTreeNode node) {
		this.hd = hd;
		this.node = node;
	}
}

public class Solution {

	public static ArrayList<Integer> verticalBinaryTree(BinaryTreeNode root) {

		// Base case
		if (root == null)
			return new ArrayList<Integer>();

		// Create a map and store vertical oder in
		// map using function getVerticalOrder()
		TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
		int hd = 0;

		// Create queue to do level order traversal.
		// Every item of queue contains BinaryTreeNode and
		// horizontal distance.
		Queue<Pair> que = new LinkedList<>();
		que.add(new Pair(0, root));

		while (!que.isEmpty()) {
			// pop from queue front
			Pair temp = que.poll();
			hd = temp.hd;
			BinaryTreeNode node = temp.node;

			// insert this BinaryTreeNode's data in array of hash
			if (m.containsKey(hd)) {
				m.get(hd).add(node.val);
			} else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(node.val);
				m.put(hd, al);
			}
			if (node.left != null)
				que.add(new Pair(hd - 1, node.left));
			if (node.right != null)
				que.add(new Pair(hd + 1, node.right));
		}

		// Traverse the map and print BinaryTreeNodes at
		// every horizontal distance (hd)
		ArrayList<Integer> ans = new ArrayList<>();
		for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
			ArrayList<Integer> al = entry.getValue();
                        Collections.sort(al);
			for (int i : al)
				ans.add(i);

		}
		return ans;
	}

}
