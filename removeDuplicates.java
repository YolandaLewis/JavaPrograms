
public class rmoveDuplicates {

	public static double[] removeDuplicates (double[] list) {
      double dup= list.length;
      int j;
      int i;
		for (i=0; i<dup; i++){
			for (j=i+1; j<dup;j++){
			if(list[i]==list[j]){
				list[j] = list[(int)(dup-1)];
				dup--;
				j--;
			}
				
		}
	}

double[] newList=new double[(int)dup];
System.arraycopy(list, 0, newList, 0, (int)dup);
return newList;
	}

	
		
{
}

public static void main(String[] args) {
//removeDuplicates Test sample
		double noDuplicates[] = removeDuplicates (new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });
		if (noDuplicates.length > 0) {
			System.out.println("The removeDuplicates test was successful.");
			for (double duplicate : noDuplicates) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was not successful.");
		}

	}


{
//removeDuplicates Test sample
		double noDuplicates[] = removeDuplicates (new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });
		if (noDuplicates.length == 0) {
			System.out.println("The removeDuplicates test was not successful.");
			for (double duplicate : noDuplicates) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was successful.");
		}

	}

	{
// removeDuplicates Test sample
				double noDuplicates[] = removeDuplicates (new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });
				if (noDuplicates.length < 0) {
					System.out.println("The removeDuplicates test was not successful.");
					for (double duplicate : noDuplicates) {
						System.out.println("Value ["+duplicate+"]");
					}
				} else {
					System.out.println("The removeDuplicates test was successful.");
				}

			}

	{
	
//removeDuplicates Test sample
double noDuplicates[] = removeDuplicates (new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });
if (noDuplicates.length !=0) {
	System.out.println("The removeDuplicates test was not successful.");
	for (double duplicate : noDuplicates) {
		System.out.println("Value ["+duplicate+"]");
	}
} else {
	System.out.println("The removeDuplicates test was successful.");
}

}

	{
		//removeDuplicates Test sample
		double noDuplicates[] = removeDuplicates (new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });
		if (noDuplicates.length > 2) {
			System.out.println("The removeDuplicates test was not successful.");
			for (double duplicate : noDuplicates) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was successful.");
		}
	}
}

