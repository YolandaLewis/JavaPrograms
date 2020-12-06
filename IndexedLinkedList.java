package program6;
import java.util.*;


public class IndexedLinkedList<T> {
	
	private static int numOfItems;
	private Node<T> head;
		
		public IndexedLinkedList() {
			head= new Node<T>(null);
			numOfItems = 0;
			}

		private static class Node<T> {
			
			public T item;
			public Node<T> next;
			public Node<T> prev;
			
			public Node(T value) {
				this.item = value;
				next = null;
				numOfItems++;
			} 
		}
			
		public void insertBeforeIndex(T value, int index){ // This inserts the passed value before the node at the given index. For example, specifying an index of 2 will insert the new value so that it will be at index 2; specifying an index value of 0 will make the new value the first value in the list. Note that index may be equal to the size of the list in this method, which will make the new value the last value in the list. It will throw an IndexOutOfBoundsException if the index passed is less than zero or greater than the size of the list.
			
			//CASE I: Ensure that Index is not less than zero and index is not greater than or equal to numofItems
			if (index < 0 || index > (numOfItems))
				throw new IndexOutOfBoundsException("Invalid Index");
			
			Node<T> prev = null;
			Node<T> temp = head;
			
			//CASE II: Ensure that numOfItems is zero and index passed was zero as well
			//-- This case deals with when there is nothing in the linked list and this is the first item being added!
	        if ((numOfItems == 0) && (index ==0)){
	        	head = new Node<T>(value);
		        return;
		    }
	        
	      //CASE III: Here we are attempting to insert between head and tail 
	        else if((index >= 0) && temp !=null){
	        	for (int i = 0; i < index; i++){
	            	prev = temp;
	            	if(temp.next !=null)
	            		temp = temp.next;
	            }
	                
	            Node<T> newNode = new Node<T>(value);
	            newNode.next = temp;
	            prev.next = newNode;
	            return;
	        }      

	    }
			
		public T getValueAtIndex(int index) { // Returns the value at position index. It should throw an IndexOutOfBoundsException if the index passed is less than zero or greater or equal than the size of the list.
			if (index < 0 || index >= numOfItems)
				throw new IndexOutOfBoundsException("Invalid Index");
			
			Node<T> temp = head;
			for( int i=0; i<=index-1; i++)
				temp= temp.next;
			return temp.item;
			}
		
		public int getIndexOfValue(T value){ //Returns the index of the first value equal to the value passed as the parameter. It returns -1 if the value is not in the list. 
			Node<T> temp = head;
			for(int i=0; i<=numOfItems-1; i++){
				if(value.equals(temp.item))
					return i;
				else
					temp = temp.next;
			}
			return -1;
		}
		
		public int countValue(T value){ //Returns a count of how many times the parameter value occurs in the list. 
			Node<T> current = head;
			int count = 0;
			for(int i = 0; i < numOfItems -1; i++){
				if(value.equals(current.item))
					count++;
					current = current.next;
			}
			return count;
		}

		public Iterable<T> values() { //Returns an Iterable object (e.g, an array list) containing the values in the list in the order in which they occur.
			ArrayList<T> itemArray = new ArrayList<>();
			Node<T> collectionOfNodeItems = head;
			for(int i = 0; i < numOfItems -1; i++){
				itemArray.add((T)collectionOfNodeItems.item);
				collectionOfNodeItems = collectionOfNodeItems.next;
				}
			
			return itemArray;
			
			}
		
		public int size() { //Returns the number of values currently in the list. 	
			return numOfItems;      
		}

}


