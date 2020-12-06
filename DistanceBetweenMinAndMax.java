 
public class DistanceBetweenMinAndMax {
	public static int distanceBetweenMinAndMax (double[] list) {
		//TODO: fix this with your code
		int min= 0;
		for (int i=0; i < list.length; i=i+1); {
		int i=0;
			if (list [min] < list[i]){
				min=i;
			}
		}
		
		int max= 0;
		for(int i=0; i< list.length; i=i+1); {
		int i=0;
			if (list [max] > list[i]){
				max= i;
			}
		}
		return (max-min); 
	}
	

	
		public static void main(String[] args) {
			// distanceBetweenMinAndMax Test sample
			double distance = distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 });
			if (distance == 1) {
				System.out.println("The distanceBetweenMinAndMax test was successful.");
			} else {
				System.out.println("The distanceBetweenMinAndMax test was not successful.");
			}

		}
		{

		//distanceBetweenMinAndMax Test sample
		double distance = distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 });
		if (distance < 1) {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		}

	}
		{

		//distanceBetweenMinAndMax Test sample
		double distance = distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 });
		if (distance > 1) {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		}
		}
		{
		//distanceBetweenMinAndMax Test sample
		double distance = distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 });
		if (distance != 1) {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		}

	}

		{
		//distanceBetweenMinAndMax Test sample
		double distance = distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 });
		if (distance == 11) {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		}

	}

		{

		//distanceBetweenMinAndMax Test sample
				double distance = distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 });
				if (distance == -7) {
					System.out.println("The distanceBetweenMinAndMax test was not successful.");
				} else {
					System.out.println("The distanceBetweenMinAndMax test was successful.");
				}

			}
}

	

