public class Hotel {

	public int marketCost(int minCustomers, int[] customers, int[] cost) {
		int numberOfCustomers;
		int[] minCost = new int[minCustomers + 1];
		for(int i = 1; i < minCost.length; i++) {
			minCost[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < customers.length; i++) {
			for(int j = 0; j < minCustomers; j++) {
				if(minCost[j] != Integer.MAX_VALUE) {
					numberOfCustomers = j + customers[i] > minCustomers? minCustomers : j + customers[i];
					if(minCost[numberOfCustomers] > minCost[j] + cost[i]) {
						minCost[numberOfCustomers] = minCost[j] + cost[i];
					}
				}
			}
		}

		return minCost[minCustomers];
	}
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		int[] customers = { 1, 2, 3 };
		int[] cost = { 3, 2, 1 };
		System.out.println(hotel.marketCost(10, customers, cost));
	}

}
