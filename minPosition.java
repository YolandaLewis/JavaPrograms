
public class minPosition {
	public static int minPosition (double[] list) {
		//TODO: fix this with your code
		int index= 0;
		for (int i=1; i < list.length; i=i+1); {
			int i= 0;
			if (list[index] < list[i]) {
				index= i;
			}
		}
		return (index);
		
}
public static void main(String[] args) {
	// minPosition Test sample
			double minPosition = minPosition(new double[] { -13, -4, -7, 7, 8, 11 });
			if (minPosition == 0) {
				System.out.println("The minPosition test was successful.");
			} else {
				System.out.println("The minPosition test was not successful.");
			}
}

{
	// minPosition Test sample
				double minPosition = minPosition(new double[] { -13, -4, -7, 7, 8, 11 });
				if (minPosition < 0) {
					System.out.println("The minPosition test was not successful.");
				} else {
					System.out.println("The minPosition test was successful.");
				}
}
{
	// minPosition Test sample
				double minPosition = minPosition(new double[] { -13, -4, -7, 7, 8, 11 });
				if (minPosition != 0) {
					System.out.println("The minPosition test was not successful.");
					System.out.println("The minPosition test was successful.");
				}
}
{
	// minPosition Test sample
				double minPosition = minPosition(new double[] { -13, -4, -7, 7, 8, 11 });
				if (minPosition > 0) {
					System.out.println("The minPosition test was not successful.");
				} else {
					System.out.println("The minPosition test was successful.");
				}
}
{
	// minPosition Test sample
				double minPosition = minPosition(new double[] { -13, -4, -7, 7, 8, 11 });
				if (minPosition == 2) {
					System.out.println("The minPosition test was not successful.");
				} else {
					System.out.println("The minPosition test was successful.");
				}
}
{
	// minPosition Test sample
				double minPosition = minPosition(new double[] { -13, -4, -7, 7, 8, 11 });
				if (minPosition ==1) {
					System.out.println("The minPosition test was not successful.");
				} else {
					System.out.println("The minPosition test was successful.");
				}
}
}