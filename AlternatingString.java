

public class AlternatingString {

	public int maxLength(String s) {
		int maxLength = 1;
		int currentLength = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				currentLength++;
			} else {
				if (currentLength > maxLength) {
					maxLength = currentLength;
				}
				currentLength = 1;
			}
		}
		if (currentLength > maxLength) {
			maxLength = currentLength;
		}

		return maxLength;
	}

	public static void main(String[] args) {
		AlternatingString alternatingString = new AlternatingString();
		System.out.println(alternatingString.maxLength("111101111"));

	}

}
