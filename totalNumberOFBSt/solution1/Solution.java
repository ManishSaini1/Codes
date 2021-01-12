/*
Time complexity: O(n^n)
Space complexity: O(n)

Where 'n' is equal to number of elements in the sequence.
*/
public class Solution {
	public static int minJumps(int[] arr) {
		return minJumpsHelper(arr, 0);
	}

	private static int minJumpsHelper(int[] arr, int currIdx) {
		// Base case
		if (currIdx >= arr.length - 1) {
			return 0;
		}
		int minJump = 999999; // Initialised with a very large value
		int currAns = 0; // To store the answer for every index

		// Recursively find all possible combinations of jumps.
		for (int i = 1; i <= arr[currIdx]; i++) {
			if (currIdx + i <= arr.length - 1) {
				currAns = 1 + minJumpsHelper(arr, currIdx + i);
			}
			minJump = Math.min(currAns, minJump);
		}
		return minJump;

	}
}