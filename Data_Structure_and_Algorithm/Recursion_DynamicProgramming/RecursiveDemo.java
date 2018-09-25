// (By myself)

public class RecursiveDemo {

	public static void main(String[] args) {
		int amount;
		int DAY = 31;
		
		amount = computePay(DAY);		
	}
	
	
	private static int computePay(int day) {
		int amount;
		if (day == 1) {
			amount = 1;
			System.out.println("Day" + day + ": " + amount + " cents");
			return amount;
		} else {
			amount = computePay(day - 1) * 2;
			System.out.println("Day" + day + ": " + amount + " cents");
			return amount;
		}
	}
}
