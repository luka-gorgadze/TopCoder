import java.util.Comparator;
import java.util.Arrays;

class MenuItem {
	public int index;
	public int protein;
	public int carbs;
	public int fat;
	public int totalCalories;

	public MenuItem(int index, int protein, int carbs, int fat) {
		this.index = index;
		this.protein = protein;
		this.carbs = carbs;
		this.fat = fat;
		this.totalCalories = 5 * protein + 5 * carbs + 9 * fat;
	}
}

class MenuItemComparator implements Comparator<MenuItem> {
	public String dietPlan;

	public MenuItemComparator(String dietPlan) {
		this.dietPlan = dietPlan;
	}

	public int compare(MenuItem first, MenuItem second) {
		for (int i = 0; i < dietPlan.length(); i++) {
			char c = dietPlan.charAt(i);
			int compareResult = specificCompare(c, first, second);
			if (compareResult != 0) {
				return compareResult;
			}
		}
		return Integer.compare(second.index, first.index);
	}

	public int specificCompare(char c, MenuItem first, MenuItem second) {
		switch (c) {
		case 'C':
			return Integer.compare(first.carbs, second.carbs);
		case 'c':
			return Integer.compare(second.carbs, first.carbs);
		case 'P':
			return Integer.compare(first.protein, second.protein);
		case 'p':
			return Integer.compare(second.protein, first.protein);
		case 'F':
			return Integer.compare(first.fat, second.fat);
		case 'f':
			return Integer.compare(second.fat, first.fat);
		case 'T':
			return Integer.compare(first.totalCalories, second.totalCalories);
		case 't':
			return Integer.compare(second.totalCalories, first.totalCalories);
		}
		return 0;
	}

}

public class HealthFood {

	public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
		MenuItem[] menuItems = new MenuItem[protein.length];
		for (int i = 0; i < menuItems.length; i++) {
			menuItems[i] = new MenuItem(i, protein[i], carbs[i], fat[i]);
		}

		int[] bestChoices = new int[dietPlans.length];
		for (int i = 0; i < dietPlans.length; i++) {
			MenuItemComparator comparator = new MenuItemComparator(dietPlans[i]);
			Arrays.sort(menuItems, comparator);
			bestChoices[i] = menuItems[menuItems.length - 1].index;
		}

		return bestChoices;
	}

	public static void main(String[] args) {
		HealthFood healthFood = new HealthFood();
		int[] protein = { 3, 4, 1, 5 };
		int[] carbs = { 2, 8, 5, 1 };
		int[] fat = { 5, 2, 4, 4 };
		String[] dietPlans = { "tFc", "tF", "Ftc" };
		System.out.println(healthFood.selectMeals(protein, carbs, fat, dietPlans));
	}

}
