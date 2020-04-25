package leetcode329;

public class FindLongestIncreasePathFunction {
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
		if (longest[i][j] != 0) {
			return longest[i][j];
		}

		int max = 1;

		for (int[] dir : direction) {
			int x = i + dir[0];
			int y = j + dir[1];

			if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
				continue;

			int len = 1 + dfs(matrix, x, y, longest);

			max = Math.max(max, len);
		}

		longest[i][j] = max;

		return max;
	}
}
