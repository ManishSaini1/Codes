/*
Time Complexity: O(n^2)
Space Complexity: O(n)

Where 'n' is the number of elements in the sequence
*/

public class Solution {
	static int fact(int num) {
		int fact = 1;

		while (num > 1) {
			fact *= num;
			num -= 1;
		}
		return fact;
	}

	// Find nth catalan number
	static int catalan(int n) {
		return fact(2 * n) / (fact(n) * fact(n + 1));
	}

	public static int[] totalBST(int[] arr, int n) {
		int i, k;
		int outputArray[] = new int[n];
		for (k = 0; k < n; k++) {
			int s = 0;

			// Count the number of element
			// less than current element
			// in arr[k]
			for (i = 0; i < n; i++) {
				if (arr[i] < arr[k])
					s += 1;
			}

			// Here s = number of node in left
			// BST and (n-s-1) = number of node
			// in right BST
			// Find number of BST using elements
			// in left BST
			int catalan_leftBST = catalan(s);

			// Find number of BST using elements
			// in right BST
			int catalan_rightBST = catalan(n - s - 1);

			// Find total number of BST
			int totalBST = catalan_rightBST * catalan_leftBST;

			// Print total BST count
			outputArray[k] = totalBST;

		}
		return outputArray;
	}

}
