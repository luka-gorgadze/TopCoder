

public class ApplePie {

	public int getApples(int[] x, int[] y, int[] day, int howMany) {
		int howManyLeft = howMany;

		for (int i = 0; i < x.length; i++) {
			if (x[i] >= 0 && x[i] <= 100 && y[i] >= 0 && y[i] <= 100) {
				howManyLeft--;
			}
			if (howManyLeft == 0) {
				return day[i];
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		ApplePie applePie = new ApplePie();
		int[] x = { 14, -958, 38, 32, 69 };
		int[] y = { 48, 485, 58, 76, 75 };
		int[] day = { 1, 2, 3, 6, 15 };
		System.out.println(applePie.getApples(x, y, day, 3));
	}

}
