
/*
Time Complexity: O(n^2)
Space Complexity: O(n)

Where 'n' is the number of elements in the sequence
*/
import java.util.Arrays;

public class Solution {
	public static int minJumps(int[] arr) {
		int n = arr.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);

		return minJumpsHelper(arr, 0, dp);

	}

	private static int minJumpsHelper(int[] arr, int currIdx, int[] dp) {
		// Base Case
		if (currIdx >= arr.length - 1) {
			return 0;
		}
		// If answer already calculated, return it immidiately
		if (dp[currIdx] != -1) {
			return dp[currIdx];
		}
		int minJumps = 999999; // Initialised with a very large value
		int currentAns = 0;
		// Calculate answer recursively
		for (int i = 1; i <= arr[currIdx]; i++) {
			if (currIdx + i <= arr.length - 1) {
				currentAns = 1 + minJumpsHelper(arr, currIdx + i, dp);
			}
			minJumps = Math.min(currentAns, minJumps);
			// Store the calculated answer in the dp array.
			dp[currIdx] = minJumps;
		}
		return minJumps;
	}
}
