
public class numUnique {
		public static int numUnique (double[] list) {
			double nums = list[0];
			int first= 0;
			int i;
			for (i=0; i < list.length; i++){
				if (list.length<= 0)
					return 0;}
		{
				if (list [i] != nums){ 
					first++;
					nums= list[i];
				}
				}
			return first +1;}

public static void main(String[] args) {

//numUnique test sample
double uniqueNumbers = numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });{
if (uniqueNumbers == 8) {
    System.out.println("The uniqueNumbers test was successful.");
} else {
    System.out.println("The uniqueNumbers test was not successful.");
}
}
	}
{
//numUnique test sample
double uniqueNumbers = numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });{
if (uniqueNumbers == 7) {
  System.out.println("The uniqueNumbers test was not successful.");
} else {
  System.out.println("The uniqueNumbers test was successful.");
}
}
	}
{
//numUnique test sample
double uniqueNumbers = numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });{
if (uniqueNumbers !=8) {
  System.out.println("The uniqueNumbers test was not successful.");
} else {
  System.out.println("The uniqueNumbers test was successful.");
}
}
	}
	{
//numUnique test sample
double uniqueNumbers = numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });{
if (uniqueNumbers < 8) {
System.out.println("The uniqueNumbers test was successful.");
} else {
System.out.println("The uniqueNumbers test was not successful.");
}
}
	}
	{
//numUnique test sample
double uniqueNumbers = numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });{
if (uniqueNumbers > 8) {
System.out.println("The uniqueNumbers test was successful.");
} else {
System.out.println("The uniqueNumbers test was not successful.");
}
}
	}
	{
//numUnique test sample
		double uniqueNumbers = numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });{
		if (uniqueNumbers ==0) {
		    System.out.println("The uniqueNumbers test was successful.");
		} else {
		    System.out.println("The uniqueNumbers test was not successful.");
		}
		}
			}
		}



