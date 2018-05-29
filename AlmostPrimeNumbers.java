

public class AlmostPrimeNumbers {

	public int getNext(int m) {
		while (true) {
			m++;
			if (m % 2 != 0 && m % 3 != 0 && m % 4 != 0 && m % 5 != 0 && m % 6 != 0 && m % 7 != 0 && m % 8 != 0
					&& m % 9 != 0 && m % 2 != 10) {
				for (int i = 11; i < m; i++) {
					if (m % i == 0) {
						return m;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		AlmostPrimeNumbers almostPrimeNumbers = new AlmostPrimeNumbers();
		System.out.println(almostPrimeNumbers.getNext(200));
	}

}
