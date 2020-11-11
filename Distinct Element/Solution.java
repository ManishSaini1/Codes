import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

class Pair<T>{
	T key;
	T value;
	Pair(T key, T value){
		this.key = key;
		this.value = value;
	}
}

public class Solution {

	public static int distinctLeft(int[] arr, int n, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++){
			if(!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i])+1);
		}
 		//create a max heap
		PriorityQueue<Pair<Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer>>(){
			@Override
			public int compare(Pair<Integer> i , Pair<Integer> j){
				return -i.key.compareTo(j.key);
			}
		});
		Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
		//add all the key-value pairs to the heap
		while(itr.hasNext()){
			int tempkey = itr.next().getKey();
			Pair<Integer> temppair = new Pair<>(tempkey,map.get(tempkey));
			heap.offer(temppair);
		}
		//removing top K elements 
		//also keep checking if heap is empty or not
		for(int i=0;i<k && !heap.isEmpty();i++){
			Pair<Integer> temppair = heap.peek();
			if(temppair.value != 1){
				temppair.value--; // decrement count of max element so far
			}else{
				heap.remove(); // remove from heap
				map.remove(temppair.key);
			}
		}
		return map.size();
	}

}