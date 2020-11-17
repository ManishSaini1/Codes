
/*
Time Complexity : O(N * 2360)
Space Complexity :  O(1)

where N is the number of trains.
*/

public class Solution {
	public static int calculateMinPatforms(int at[], int dt[], int n) {
		// Array to store the number of platforms required at different points of time
		int platforms[] = new int[2360];

		// Variable to store the final answer i.e. minimum number of platforms required
		int minNumOfPlatforms = 1;

		for (int i = 0; i < n; i++) {
			// Increment number of platforms for all times between arrival and departure
			// (both inclusive)
			for (int j = at[i]; j <= dt[i]; j++) {
				platforms[j]++;

				// Update minNumOfPlatforms
				minNumOfPlatforms = Math.max(minNumOfPlatforms, platforms[j]);
			}
		}

		return minNumOfPlatforms;
	}
}
