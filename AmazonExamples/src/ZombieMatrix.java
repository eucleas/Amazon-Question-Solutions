import java.util.LinkedList;
import java.util.Queue;

//Given a 2D grid, each cell is either a zombie or a human. Zombies can turn adjacent (up/down/left/right) 
//human beings into zombies every day. Find out how many days does it take to infect all humans?
//
//Input:
//matrix, a 2D integer array where a[i][j] = 1 represents a zombie on the cell 
//and a[i][j] = 0 represents a human on the cell.
//
//Output:
//Return an integer represent how many days does it take to infect all humans.
//Return -1 if no zombie exists.

public class ZombieMatrix {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		System.out.println(minDays(grid));
	}

	private static int minDays(int[][] matrix) {
		Queue<int[]> q = new LinkedList<>();
		int target = matrix.length * matrix[0].length;
		int cnt = 0, res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					q.offer(new int[] { i, j });
					cnt++;
				}
			}
		}
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!q.isEmpty()) {
			int size = q.size();
			if (cnt == target)
				return res;
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int ni = cur[0] + dir[0];
					int nj = cur[1] + dir[1];
					if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && matrix[ni][nj] == 0) {
						cnt++;
						q.offer(new int[] { ni, nj });
						matrix[ni][nj] = 1;
					}
				}
			}
			res++;
		}
		return -1;
	}
}
