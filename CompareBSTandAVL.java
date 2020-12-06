package program4;

import java.util.*;
import stdlib.*;


public class CompareBSTandAVL{
	
 
	public static void main(String[] args) {
		
//		Create a BST and an AVL tree for keys of type String and values of type Long.			
		Program4BST<String, Long> bstArbol = new Program4BST<String, Long>();
		Program4AVLTree<String, Long> avlArbol = new Program4AVLTree<String, Long>();		
		
//		Fill each of those trees with counts of the words in the text file data/tale.txt.
		StdIn.fromFile("data/tale.txt");
			String key = StdIn.readAll();
			String[] text = key.toLowerCase().split(" ");  
			
			
		for (String textLines : text) {
				if (avlArbol.contains(textLines)){
					avlArbol.put(textLines, avlArbol.get(textLines)+1);
					
				}else {
					avlArbol.put(textLines, (long)1);
				}
				if (bstArbol.contains(textLines)){

					bstArbol.put(textLines, bstArbol.get(textLines)+1);
				}else {

					bstArbol.put(textLines, (long)1);
				}
			
		}



//		Print for each tree how many comparisons were performed in filling it.
		StdOut.println("For the Tale of Two Cities the AVL Tree has " + avlArbol.getCount() +" " + "compares" + " and the BST Tree has" + " " + bstArbol.getCounter() +" " +  "compares");

//		Next, fill an array list with integer values read from data/8kints.txt.  	
	StdIn.fromFile("data/8Kints.txt");
	
	ArrayList<Integer> numbersArray = new ArrayList<Integer>();

	for(int i=0; !StdIn.isEmpty(); i++){
		if(StdIn.hasNextLine()){
			String numbers = StdIn.readLine();
			String[] numsArray = numbers.split("\n");
			numbersArray.add( Integer.parseInt(numsArray[0].trim()));
		}		
	}
//	Create new trees for keys of type Integer and values of type Boolean.
	Program4AVLTree<Integer,Boolean> avlOchi = new Program4AVLTree <Integer, Boolean>();
	Program4BST<Integer,Boolean> bstOchi = new Program4BST <Integer, Boolean>();
	
//	Fill those trees with the integer values read in the array list.
	
	for(Integer theInt: numbersArray ){
		if(theInt<0){
			avlOchi.put(theInt, false);
			bstOchi.put(theInt, false);

		}else {
			avlOchi.put(theInt, true);
			bstOchi.put(theInt, true);
			
			
		}
	}
	
//	Print the comparison counts. 
	StdOut.println("The unsorted AVL Tree has " + avlOchi.getCount() +" " + "compares" + " and the BST Tree has" + " " + bstOchi.getCounter() +" " +  "compares");
	
//	Finally, sort the array list and repeat the previous three steps.
	
	Program4AVLTree<Integer,Boolean> avlArbre = new Program4AVLTree <Integer, Boolean>();
	Program4BST<Integer,Boolean> bstArbre = new Program4BST <Integer, Boolean>();
	
	Collections.sort(numbersArray);
	
	for(Integer theInt: numbersArray ){
		if(theInt<0){
			avlArbre.put(theInt, false);
			bstArbre.put(theInt, false);
			
			
		}else {
			avlArbre.put(theInt, true);
			bstArbre.put(theInt, true);
			
			
		}
	}
	StdOut.println("The sorted AVL Tree has " + avlArbre.getCount() +" " + "compares" + " and the BST Tree has" + " " + bstArbre.getCounter() +" " +  "compares");

	}
	
	
	
	
	
	
	}




