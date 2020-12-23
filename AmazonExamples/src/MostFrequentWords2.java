import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentWords2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Rose is a flower red rose are flower";
		List<String> exitWords = Arrays.asList("is", "are", "a");
		List<String> lastvalue = retrieveMostFrequentlyUsedWords(str, exitWords);
	}

	static List<String> retrieveMostFrequentlyUsedWords(String helpText, List<String> wordsToExclude) {
		List<String> restWords = new ArrayList<String>();
		Map<String, Integer> allWordsFreqMap = new HashMap<>();
		Map<String, Integer> selectWordsFreqMap = new HashMap<>();
		String[] allWords = helpText.toLowerCase().split(" ");

		for (int i = 0; i < allWords.length; i++) {
			int counter = 1;
			for (int j = 0; j < allWords.length; j++) {

				if (!allWordsFreqMap.containsKey(allWords[i])) {
					allWordsFreqMap.put(allWords[i], 1);
				} else if (i != j && allWords[i].equals(allWords[j]))
					allWordsFreqMap.replace(allWords[i], ++counter);
			}
		}

		selectWordsFreqMap = new HashMap<>(allWordsFreqMap);
		for (Entry<String, Integer> map : allWordsFreqMap.entrySet()) {
			for (int k = 0; k < wordsToExclude.size(); k++) {
				if (map.getKey().equals(wordsToExclude.get(k).toLowerCase())) {
					selectWordsFreqMap.remove(map.getKey(), map.getValue());
				}
			}
		}
		return restWords;
	}

}
