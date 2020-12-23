import java.util.Arrays;

public class UtilizationChecks {

	public static void main(String[] args) {

		int instanceNumber = 100000000;
		int[] averageUtil = { 30, 95, 4, 8, 19, 89 };

		int lastIntanceNumber = getNewInstanceNumber(instanceNumber, averageUtil);
	}

	private static int getNewInstanceNumber(int instances, int[] averageUtil) {

		int tempinstance = 0;
		int INSTANCE_LIMIT = 2 * 100_000_000;

		for (int i = 0; i < averageUtil.length; i++)

		{
			if (averageUtil[i] < 25 && instances > 1) {
				instances = (int) Math.ceil((double) instances / 2);
				i += 10;
			} else if (averageUtil[i] > 60) {
				tempinstance = 2 * instances;
				if (tempinstance <= INSTANCE_LIMIT) {
					instances = tempinstance;
					i += 10;
				}
			}
		}
		return instances;
	}

}
