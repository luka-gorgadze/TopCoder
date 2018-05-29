import java.util.List;
import java.util.ArrayList;

public class Hyphenated {

	public double avgLength(String[] lines) {
		StringBuilder sb = new StringBuilder();
		for(String line : lines) {
			sb.append(line).append("*");
		}

		for(int i = 1; i < sb.length() - 2; i++) {
			if(Character.isLetter(sb.charAt(i - 1)) && sb.charAt(i) == '-' && sb.charAt(i + 1) == '*' && Character.isLetter(sb.charAt(i + 2))) {
				sb.deleteCharAt(i);
				sb.deleteCharAt(i);
			}
		}

		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == '-' || sb.charAt(i) == '.' || sb.charAt(i) == '*') {
				sb.setCharAt(i, ' ');
			}
		}
	
		String[] words = sb.toString().split(" ");
		List<String> nonEmptyWords = new ArrayList<>();
		for(String word : words) {
			if(word.length() != 0) {
				nonEmptyWords.add(word);
			}
		}
		
		int letterCount = 0;
		for(String word : nonEmptyWords) {
			letterCount += word.length();
		}

		return letterCount / (double) nonEmptyWords.size();
	}

	public static void main(String[] args) {
		Hyphenated hyphenated = new Hyphenated();
		String[] lines = {" now is the ex-", "ample. "};
		System.out.println(hyphenated.avgLength(lines));
		
	}
}
