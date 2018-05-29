public class FryingHamburgers {

	public int howLong(int panSize, int hamburgers) {
		int firstSideLeft = hamburgers;
		int secondSideLeft = 0;
		int time = 0;
		while (firstSideLeft != 0 || secondSideLeft != 0) {
			time += 5;
			int firstSideFried = Integer.min(panSize, firstSideLeft);
			firstSideLeft -= firstSideFried;
			int panSizeLeft = panSize - firstSideFried;
			int secondSideFried = Integer.min(panSizeLeft, secondSideLeft);
			secondSideLeft -= secondSideFried;
			secondSideLeft += firstSideFried;
		}

		return time;
	}

}
