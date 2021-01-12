/*
Time complexity: O(N)
Space complexity: O(N)

Where 'N' is number of nodes in binary tree.
*/
import java.util.Deque;
import java.util.LinkedList;

class Pair {
	int first;
	int second;

	Pair() {
	};

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

class Pair1 {
	BinaryTreeNode node;
	Pair p;

	Pair1() {
	};

	Pair1(BinaryTreeNode node, Pair p) {
		this.node = node;
		this.p = p;
	}
}

public class Solution {

	public static int countTurn(BinaryTreeNode root, int source, int destination) {
		// First find the LCA
		BinaryTreeNode lca = lowestCommonAncestor(root, source, destination);
		Pair p = new Pair(2, 3);
		// Queue to store ( current node , character, turns)
		Deque<Pair1> que = new LinkedList<>();
		que.addLast(new Pair1(lca, new Pair(-1, 0)));

		// Total number to required to reach 'source'destination' node from 'LCA'
		int sourceTurn = 0;
		int destTurn = 0;
		while (que.size() != 0) {
			Pair1 popTuple = que.getLast();
			que.pollLast();

			/*
			 * node= current node direction = current direction of parent to child node call
			 * turns =total number of turns required to reach at current node
			 * 
			 */

			BinaryTreeNode node = popTuple.node;
			int direction = popTuple.p.first;
			int turns = popTuple.p.second;

			if (node.left != null) {
				if (direction == 1) {
					// If 'currentnode = parent.right', now call 'child of current node=
					// currentnode.left' then number of turns increase by '1'.
					que.addLast(new Pair1(node.left, new Pair(0, turns + 1)));
					if (source == node.left.val) {
						sourceTurn = turns + 1;
					}
					if (destination == node.left.val) {
						destTurn = turns + 1;
					}
				} else {
					// If 'currentnode = parent.left', now call 'child of current node=
					// currentnode.left' then we are not turning.
					que.addLast(new Pair1(node.left, new Pair(0, turns)));
					if (source == node.left.val) {
						sourceTurn = turns;
					}
					if (destination == node.left.val) {
						destTurn = turns;
					}
				}
			}

			if (node.right != null) {
				if (direction == 0) {
					// If 'currentnode = parent.left', now call 'child of current node=
					// currentnode.right' then number of turns increase by '1'.
					que.add(new Pair1(node.right, new Pair(1, turns + 1)));
					if (source == node.right.val) {
						sourceTurn = turns + 1;
					}
					if (destination == node.right.val) {
						destTurn = turns + 1;
					}
				} else {
					// If 'currentnode = parent.right', now call 'child of current node=
					// currentnode.right' then we are not turning.
					que.addLast(new Pair1(node.right, new Pair(1, turns)));
					if (source == node.right.val) {
						sourceTurn = turns;
					}
					if (destination == node.right.val) {
						destTurn = turns;
					}
				}
			}
		}
		// If 'source/destination' are LCA then we not need to turn with respect to LCA
		// node.
		if (source == lca.val || destination == lca.val) {
			return sourceTurn + destTurn;
		}

		return sourceTurn + destTurn + 1;
	}

	private static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, int source, int destination) {
		// Base case
		if (root == null) {
			return null;
		}

		// Find the LCA in left side
		BinaryTreeNode leftAns = lowestCommonAncestor(root.left, source, destination);

		// Find the LCA in right side
		BinaryTreeNode rightAns = lowestCommonAncestor(root.right, source, destination);

		// If current node is LCA
		if (((leftAns != null) && (rightAns != null)) || (root.val == source || root.val == destination)) {
			return root;
		}

		// If LCA is already present in child part of root
		else {
			if (leftAns != null) {
				return leftAns;
			} else {
				return rightAns;
			}
		}
	}

}
