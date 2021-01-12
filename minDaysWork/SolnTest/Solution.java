/*
Time complexity: O(n* log(n))
Space complexity: O(n)

Where 'n' is the number of works
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Pair {
	int x, y;

	Pair(int a, int b) {
		this.x = a;
		this.y = b;
	}
}

public class Solution {
 
	public static int minDaysWork(int N, int D1[], int D2[]) {
		
		int ans = 0;

		ArrayList<Pair> list = new ArrayList<Pair>();

		for (int i = 0; i < N; i++)
			list.add(new Pair(D1[i], D2[i]));

		// sort by first i.e D(i)
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.x - p2.x;
			}
		});

// Calculate the minimum possible days  
		for (int i = 0; i < N; i++) {
			if (list.get(i).y >= ans)
				ans = list.get(i).y;
			else
				ans = list.get(i).x;
		}

		return ans;
	}

}
