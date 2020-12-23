
public class BinaryAdding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "1";// "0000100";// "110";// "1011"; // "101";
		String s2 = "10fg";// "101";// "1000"; // "100";

		String res = "";
		res = add(s1.toCharArray(), s2.toCharArray(), s1.length() - 1, s2.length() - 1, 0, res);

		System.out.println(s1 + " + " + s2 + " = " + res);

	}

	private static String add(char[] A, char[] B, int i, int j, int carry, String result) {

		if (i < 0 && j < 0) {
			return (carry > 0 ? carry : "") + result;
		}

		int a = (i >= 0 ? 'a' - '0' : 0);
		int b = (j >= 0 ? B[j] - '0' : 0);
		int sum = a + b + carry;
		result = sum % 2 + result;

		return add(A, B, i - 1, j - 1, sum / 2, result);
	}

}
