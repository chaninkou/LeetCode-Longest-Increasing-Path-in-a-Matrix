package leetcode329;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
		
		System.out.println("grid: " + Arrays.deepToString(matrix));
		
		FindLongestIncreasePathFunction solution = new FindLongestIncreasePathFunction();
		
		System.out.println("Solution: " + solution.longestIncreasingPath(matrix));
	}
}
