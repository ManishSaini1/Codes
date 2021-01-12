import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

}

public class Runner {
	static BinaryTreeNode target;

	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode takeInput(int tar) {
		int rootData = s.nextInt();

		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(rootData);
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			BinaryTreeNode currentNode = q.peek();
			if (currentNode.val == tar) {
				target = currentNode;
			}
			q.poll();

			int leftChild = -1, rightChild = -1;

			leftChild = s.nextInt();

			if (leftChild != -1) {
				BinaryTreeNode leftNode = new BinaryTreeNode(leftChild);
				currentNode.left = leftNode;
				q.add(leftNode);
			}

			rightChild = s.nextInt();

			if (rightChild != -1) {
				BinaryTreeNode rightNode = new BinaryTreeNode(rightChild);
				currentNode.right = rightNode;
				q.add(rightNode);
			}
		}

		return root;
	}

	public static void main(String[] args) {
		int t = s.nextInt();

		while (t-- > 0) {
			int tar = s.nextInt();
			int k = s.nextInt();
			BinaryTreeNode root = takeInput(tar);
			ArrayList<Integer> list = Solution.nodesAtDistanceK(root, target, k);
			Collections.sort(list);
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();

		}

	}

}