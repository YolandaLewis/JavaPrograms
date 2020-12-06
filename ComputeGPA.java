package program1;

import algs31.BinarySearchST;
import stdlib.StdIn;
import stdlib.StdOut;

public class ComputeGPA {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	BinarySearchST<String, Double> gpaGrades = new BinarySearchST<String, Double>();
		 gpaGrades.put("A+", 4.33);
		 gpaGrades.put("A",4.00); 
		 gpaGrades.put("A-",3.67);
		 gpaGrades.put("B+",3.33);
		 gpaGrades.put("B",3.00);
		 gpaGrades.put("B-",2.67);
		 gpaGrades.put("C+",2.33);
		 gpaGrades.put("C",2.00);
		 gpaGrades.put("C-",1.67);
		 gpaGrades.put("D",1.00);
		 gpaGrades.put("F",0.00);
		 
		  int numberofCourses = 0;
		  Double sumOfGrades  = 0.00;
		  double GPA = 0.00;
		  
		  StdIn.fromFile("data/a1grades.txt");
		  
		  while (StdIn.hasNextLine()) {
			  String grade = StdIn.readLine();
		  
			  Double gradePoint = gpaGrades.get(grade);
		   
			  sumOfGrades += gradePoint;
			  numberofCourses++;

		  }
		  
		  if(numberofCourses !=0){
		   
		   GPA = sumOfGrades/(numberofCourses);
		  }
		   
		  StdOut.println("Student GPA = " + GPA);
	}

}
