/* 
Time complexity: O(n)
Space complexity: O(n)

Where ‘n’ is the number of elements.
*/
public class Solution2 {
	static long MOD = 1000000007;

	public static long countDerangements(long n) {
		int derangementCount[] = new int[(int) (n + 1)];

		// Base cases
		derangementCount[1] = 0;
		derangementCount[2] = 1;

		// Fill derangementCount[0..n] in bottom up manner using above recursive formula
		for (int i = 3; i <= n; ++i)
			derangementCount[i] = (int) (((i - 1) % MOD
					* (derangementCount[i - 1] % MOD + derangementCount[i - 2] % MOD) % MOD) % MOD);

		// Return result for n
		return derangementCount[(int) n];
	}

}
