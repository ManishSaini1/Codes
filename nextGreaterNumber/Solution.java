/*
        Time Complexity: O(N)
        Space Complexity: O(1)

       where N is the length of input string S.
*/ 
import java.util.Arrays;

public class Solution {
	// Function to swap two digit
	static void swap(char ar[], int i, int j) {
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	public static String nextGreater(String str) {

		char S[] = str.toCharArray();
		int i = str.length() - 2;

		// Traversing from right to find the number x which is smaller than the next one
		for (; i >= 0; i--) {
			if (S[i] < S[i + 1]) {
				break;
			}
		}

		// If it doesn't exist, return -1
		if (i < 0) {
			return "-1";
		}

		// Finding the number x' in the right side which is just greater than x
		for (int j = S.length - 1; j > i; j--) {
			if (S[j] > S[i]) {
				swap(S, i, j);
				break;
			}
		}
		// Reversing the right side to make it in increasing order
		Arrays.sort(S, i + 1, S.length);
		return String.valueOf(S);
	}
}
