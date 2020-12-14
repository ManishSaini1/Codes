
/*
Time Complexity: O(N^2 * log(K))
Space complexity: O(1)

Where N is the size of the given array and K is the maximum element in the given array.
*/
public class Solution {

	public static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}

		return GCD(b, a % b);
	}

	public static int maxGCDPair(int[] arr, int n) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				ans = Math.max(ans, GCD(arr[i], arr[j]));
			}
		}
		return ans;
	}

}
