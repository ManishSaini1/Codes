/*
Time complexity : O(N * log(N))
Space complexity : O(N)
where N is the size of input array
*/
public class Solution {
	static void merge(int input[], int left, int mid, int right, int temp[]) {
		int i = left, j = mid + 1, k = 0;
		while (i <= mid && j <= right) {
			if (input[i] < input[j]) {
				temp[k] = input[i];
				k++;
				i++;
			} else {
				temp[k] = input[j];
				j++;
				k++;
			}
		}
		while (i <= mid) {
			temp[k] = input[i];
			k++;
			i++;
		}
		while (j <= right) {
			temp[k] = input[j];
			j++;
			k++;
		}
		for (int x = 0, y = left; x < k; x++, y++) {
			input[y] = temp[x];
		}
	}

	static void mergeSort(int input[], int temp[], int start, int end) {
		if (end <= start) {
			return;
		} else {
			int mid = (end + start) / 2;
			mergeSort(input, temp, start, mid);
			mergeSort(input, temp, mid + 1, end);
			merge(input, start, mid, end, temp);
		}
	}

	public static void mergeSort(int[] arr, int n) {
		int[] temp = new int[n];
		mergeSort(arr, temp, 0, n - 1);

	}

}