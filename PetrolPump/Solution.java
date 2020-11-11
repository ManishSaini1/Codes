/*
    Time Complexity: O( N )
    Space Complexity: O( 1 )
    Where N is the total number of petrol stations.
*/

public class Solution {

	public static int firstCircularTour(int[] petrol, int[] distance, int n) {
		// checking for -1 condition
		int totalPetrol = 0;
		int totalDistance = 0;

		for (int i = 0; i < n; i++) {
			totalDistance += distance[i];

			totalPetrol += petrol[i];
		}

		if (totalPetrol < totalDistance)
			return -1;

		// answer will definitely exist now

		int sum = 0;
		int minimumSum = Integer.MAX_VALUE;

		int minimumSumIndex = 0;

		for (int i = 0; i < n; i++) {
			if (sum < minimumSum) {
				// finding the index where sum has least value
				minimumSum = sum;
				minimumSumIndex = i;
			}
			// updating sum with the required value
			sum += petrol[i] - distance[i];
		}
		return minimumSumIndex;
	}

}
