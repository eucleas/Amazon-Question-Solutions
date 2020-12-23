import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class FindSubstings {

	private static class Elements {
		int membercount;
		int lettercount;
		ArrayList<String> array;

		public int getMembercount() {
			return membercount;
		}

		public int getLettercount() {
			return lettercount;
		}

		public ArrayList<String> getArray() {
			return array;
		}

	}

	// alllist permutation

	static ArrayList<ArrayList<String>> allList = new ArrayList<ArrayList<String>>();
	static String first = "baddacxb";

	public static void main(String[] args) {
		// input String

		String str = "baddacxb";

		// output string to store non-overlapping substrings
		Deque<String> output = new ArrayDeque<>();

		// Print all non-overlapping substrings
		recur(str, output);
	}

	// Find all combinations of non-overlapping substrings of given String
	public static void recur(String str, Deque<String> output) {
		// if all characters of the input String are processed,
		// print the output String
		if (str.length() == 0) {
			System.out.println(output);
			ArrayList<String> arraylist = new ArrayList<String>(output);
			allList.add(arraylist);
			if (output.getLast().equals(first)) {
				eleminateSubStrings(allList);

			}
			return;
		}

		// add each substring [0, i] in the output string and recur for
		// remaining substring [i+1, n-1]
		for (int i = 0; i < str.length(); i++) {
			// push substring [0, i] into output string
			output.addLast(str.substring(0, i + 1));

			// recur for remaining String [i+1, n-1]
			recur(str.substring(i + 1), output);

			// backtrack (remove current substring from string)
			output.pollLast();
		}
	}

	public static List<String> eleminateSubStrings(ArrayList<ArrayList<String>> allList) {

		ArrayList<ArrayList<String>> newAllList = new ArrayList<ArrayList<String>>();
		ArrayList<Elements> elementList = new ArrayList<Elements>();
		int i = 0;
		for (ArrayList<String> array : allList) {
			ArrayList<String> newArray = new ArrayList<String>(array);
			newAllList.add(newArray);

			for (int s = 0; s < array.size(); s++) {
				for (int m = 0; m < newArray.size(); m++) {
					if (s != m && (array.get(s).contains(array.get(m)) || array.get(m).contains(array.get(s)))) {
						newAllList.get(i).remove(m);
						break;
					}
				}
			}

			Elements element = new Elements();
			element.array = newArray;
			element.membercount = newArray.size();
			int lettercount = 0;
			for (int m = 0; m < newArray.size(); m++) {
				lettercount = lettercount + newArray.get(m).length();
				element.lettercount = lettercount;
			}
			elementList.add(element);
			i++;
		}

		Elements maxElement = new Elements();
		int minLetter = 0;
		int maxMember = 0;

		for (Elements element : elementList) {
			if (element.membercount > maxMember) {
				maxMember = element.membercount;
				maxElement = element;
			} else if (element.membercount == maxMember && element.lettercount < minLetter) {
				maxElement = element;
			}
		}
		return maxElement.array;
	}

}
