
public class minValue {
	public static double minValue (double[] list) { 
		//TODO: fix this with your code
		double smallNum = list [0];
		for (int i=1; i < list.length; i=i+1) {
			if (list[i] < smallNum) {
				smallNum= list[i];
			}
		}
		return smallNum; }	
	
public static void main(String[] args) {
	
	// minValue Test sample
	double minValue = minValue (new double[] { 1, -4, -7, 7, 8, 11 });
	if (minValue == -7) {
		System.out.println("The minValue test was successful.");
	} else {
		System.out.println("The minValue test was not successful.");
	}
	
	{
		//minValue Test sample
		double minValue = minValue (new double[] { 2, -5, -9, 10, 12, 14 });
		if (minValue == -9) {
			System.out.println("The minValue test was successful.");
			} else {
				System.out.println("The minValue test was not successful.");
			}
	}
	{
		//minValue Test sample
			double minValue = minValue (new double[] { 2, -5, -9, 10, 12, 14 });
			if (minValue != -9) {
				System.out.println("The minValue test not successful.");
				} else {
					System.out.println("The minValue test was successful.");
				}
	}
	{
		//minValue Test sample
			double minValue = minValue (new double[] { 2, -5, -9, 10, 12, 14 });
			if (minValue < -9) {
				System.out.println("The minValue test was not successful.");
			 } 	else {
					System.out.println("The minValue test was successful.");
			}
	}
	{
		//minValue Test sample
			double minValue = minValue (new double[] { 2, -5, -9, 10, 12, 14 });
			if (minValue > -9) {
				System.out.println("The minValue test was not successful.");
				} else {
					System.out.println("The minValue test was successful.");
				}
	}
	{
		//minValue Test sample
			double minValue = minValue (new double[] { 0, 3, -4, -10, 11, 15 });
			if (minValue == -10) {
				System.out.println("The minValue test was successful.");
				} else {
					System.out.println("The minValue test was not successful.");
				}
	}
	}

}
