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

	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode takeInput() {
		int rootData = s.nextInt();

		if (rootData == -1) {
			return null;
		}

		BinaryTreeNode root = new BinaryTreeNode(rootData);
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			BinaryTreeNode currentNode = q.peek();
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
			BinaryTreeNode root = takeInput();
			int maxSum = Solution.maxLevelSum(root);

			System.out.println(maxSum);

		}

	}

}
