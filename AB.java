

public class AB {

	public String createString(int N, int K) {
		StringBuilder sb = new StringBuilder();
		int half = N / 2;
		int charsLeft = N - half;
		for (int i = 0; i < half; i++) {
			sb.append('B');
		}
		while (charsLeft > 0 && K > half) {
			sb.insert(0, 'A');
			charsLeft--;
			K -= half;
		}
		if (charsLeft == 0 && K != 0) {
			return "";
		}
		if (K > 0) {
			sb.insert(sb.length() - K, 'A');
			charsLeft--;
		}
		while(charsLeft != 0) {
			sb.append('A');
			charsLeft--;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AB ab = new AB();
		System.out.println(ab.createString(2, 0));
	}

}
