import java.util.Scanner;
import java.util.Random;

public class SortComparison {

	public static void main(String[] args) {
        
		Scanner s = new Scanner(System.in);
		Random r=new Random();
		System.out.print("Input Array Length: ");
		int len = s.nextInt();
		int[] n = new int[len];
		final int RUNS = 40;
		double stotalTime = 0, itotalTime = 0;
		double stotalSwaps = 0, itotalSwaps = 0;
		double stotalComparisons = 0, itotalComparisons = 0;

        //insert sort comparion algorithm here:
		int[] nums = new int[2];
		double start = 0.0;
		double end = 0.0;
		for (int i = 0; i < RUNS; i++) {
		    for (int j = 0; j < len; j++) {
			    n[j] = r.nextInt(len);
		    }

			start = System.nanoTime();
			nums = Sorts.selectionSort(n.clone());
			end = System.nanoTime();
			stotalTime += (start - end);
			stotalComparisons += nums[0];
			stotalSwaps += nums[1];

			start = System.nanoTime();
			nums = Sorts.insertionSort(n.clone());
			end = System.nanoTime();
			itotalTime += (end - start);
			itotalComparisons += nums[0];
			itotalSwaps += nums[1];
	    }

		System.out.println("Selection Sort: Total Time: " + stotalTime + "ms\n\tAverage time: " + stotalTime/RUNS + "ms,\n\tavg. swaps: " + stotalSwaps/RUNS + " swaps,\n\tavg. comparisons: " + stotalComparisons/RUNS + " comparisons\n");
	
		System.out.println("Insertion Sort: Total Time: " + itotalTime  + "ms\n\tAverage time: " + itotalTime/RUNS + "ms,\n\tavg. swaps: " + itotalSwaps/RUNS + " swaps,\n\tavg. comparisons: " + itotalComparisons/RUNS + " comparisons\n");
	}
}