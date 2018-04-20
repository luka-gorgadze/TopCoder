
public class AdvertisingAgency {

	public int numberOfRejections(int[] requests) {
		int rejectionCounter = 0;
		boolean[] isOccupied = new boolean[100];

		for (int i = 0; i < requests.length; i++) {
			if (isOccupied[requests[i] - 1]) {
				rejectionCounter++;
			} else {
				isOccupied[requests[i] - 1] = true;
			}
		}

		return rejectionCounter;
	}

	public static void main(String[] args) {
		AdvertisingAgency advertisingAgency = new AdvertisingAgency();
		int[] requests = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
		System.out.println(advertisingAgency.numberOfRejections(requests));

	}

}
