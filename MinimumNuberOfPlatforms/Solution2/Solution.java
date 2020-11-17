 /*
    Time Complexity : O(N * log(N))
    Space Complexity :  O(1)

    where N is the number of trains.
*/
import java.util.Arrays;
public class Solution {

public static	int calculateMinPatforms(int at[], int dt[], int n) {
		// Sort both the arrays
		Arrays.sort(at);
		Arrays.sort(dt);

		// Indicates the number of platforms needed at a time
		int curNumOfPlatforms = 0;

		// Variable to store the final answer i.e. minimum number of platforms required
		int minNumOfPlatforms = 0;

		int i = 0, j = 0;

		while (i < n && j < n) {

			// If the next event in sorted order is arrival, increment count of platforms
			// needed
			if (at[i] <= dt[j]) {
				curNumOfPlatforms++;
				i++;
			}

			// Else decrement count of platforms needed
			else {
				curNumOfPlatforms--;
				j++;
			}

			// Update minNumOfPlatforms
			minNumOfPlatforms = Math.max(minNumOfPlatforms, curNumOfPlatforms);
		}

		return minNumOfPlatforms;
	}
}
