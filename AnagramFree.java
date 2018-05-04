
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AnagramFree {

	public int getMaximumSubset(String[] S) {
		Set<String> maximumSubset = new HashSet<>();
		char[] sortedString;

		for (int i = 0; i < S.length; i++) {
			sortedString = S[i].toCharArray();
			Arrays.sort(sortedString);
			maximumSubset.add(new String(sortedString));
		}

		return maximumSubset.size();
	}

	public static void main(String[] args) {
		AnagramFree anagramFree = new AnagramFree();
		String[] S = { "creation", "sentence", "reaction", "sneak", "star", "rats", "snake" };
		System.out.println(anagramFree.getMaximumSubset(S));

	}

}
