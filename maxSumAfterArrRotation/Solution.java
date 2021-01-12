/*
Time Complexity: O(N)
Space Complexity: O(1)

where N is size of the array.
*/

public class Solution {

	public static long minJumps(int[] Arr, int N) {
        long s =1;
		long originalArraySum = 0;
		long originalIArrProd = 0;
		for (int i = 0; i < N; i++) {
			originalArraySum += Arr[i];
			originalIArrProd += (s*i * Arr[i]);
		}

		long soln = originalIArrProd;
		// j = number of rotations on original array on left side.
		for (int j = 1; j < N; j++) {
            
			originalIArrProd = originalIArrProd - originalArraySum + (s*N * Arr[j - 1]);
			soln = Math.max(soln, originalIArrProd);
		}

		return soln;
	}

}