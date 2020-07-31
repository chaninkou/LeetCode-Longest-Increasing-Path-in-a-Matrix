package leetcode329;

public class FindLongestIncreasePathFunction {
	// direction of 4 sides
	private int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0 || matrix == null) {
			return 0;
		}

		int[][] longest = new int[matrix.length][matrix[0].length];

		int max = 1;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int currentLongest = dfs(matrix, i, j, longest);

				max = Math.max(max, currentLongest);
			}
		}

		return max;
	}

	private int dfs(int[][] matrix, int i, int j, int[][] longest) {
		// If not 0 by default, we already replaced it with our max
		if (longest[i][j] != 0) {
			return longest[i][j];
		}

		// Always at least one max
		int max = 1;
	
		for (int[] dir : direction) {
			// i and j will be what element we are on
			int x = i + dir[0];
			int y = j + dir[1];

			// Condition to skip if not met
			if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]){
				continue;
			}
				
			// Get the max length for next element
			int len = 1 + dfs(matrix, x, y, longest);

			max = Math.max(max, len);
		}

		// Replace 0 with the best max we found
		longest[i][j] = max;

		return max;
	}
}
