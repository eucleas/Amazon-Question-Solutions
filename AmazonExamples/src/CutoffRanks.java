
public class CutoffRanks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cutOffRank = 4;
		int[] scores = { 2, 2, 3, 4, 5 };

		countNumPlayerToLevelUp(cutOffRank, scores);
	}

	public static int countNumPlayerToLevelUp(int cutOffRank, int[] scores) {
		int[] frequencies = new int[100 + 1];
		for (int score : scores) {
			frequencies[score]++;
		}

		int ans = 0;
		int currentRank = 1;
		for (int i = 100; i >= 0 && currentRank <= cutOffRank; i--) {
			if (frequencies[i] == 0)
				continue;

			ans += frequencies[i];
			currentRank += frequencies[i];
		}
		return ans;
	}
}
