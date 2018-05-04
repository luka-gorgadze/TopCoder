
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animation {

	public String[] animate(int speed, String init) {
		List<String> animationBuilder = new ArrayList<>();
		char[] frame = new char[init.length()];
		int time = 0;
		boolean isEmpty;

		while (true) {
			for (int i = 0; i < frame.length; i++) {
				frame[i] = '.';
			}

			for (int i = 0; i < init.length(); i++) {
				if (init.charAt(i) == 'L' && i - (time * speed) >= 0) {
					frame[i - (time * speed)] = 'X';
				}
				if (init.charAt(i) == 'R' && i + (time * speed) < init.length()) {
					frame[i + (time * speed)] = 'X';
				}
			}

			animationBuilder.add(new String(frame));

			isEmpty = true;
			for (int i = 0; i < frame.length; i++) {
				if (frame[i] != '.') {
					isEmpty = false;
				}
			}
			if (isEmpty) {
				break;
			}
			time++;
		}

		return animationBuilder.toArray(new String[0]);
	}

	public static void main(String[] args) {
		Animation animation = new Animation();
		System.out.println(Arrays.toString(animation.animate(2, "LRLR.LRLR")));
	}

}
