
//----------------------------------------------
//Assignment 4 
//Question 2 Part 1
//----------------------------------------------
//Written by: Marita Brichan (40138194) and Mohona Mazumdar (40129421)
//This program is designed to create a CellList class that has an inner class for the CellNode
//which has deifnes the linked list and its nodes. In each node, there is a a CellPhone object 
//and a next node
import java.util.NoSuchElementException;


/**Names and IDs: Marita Brichan (40138194) and Mohona Mazumdar (40129421)
* <br>
* COMP249 
* <br>
* Assignment #1
* <br>
* Due Date: Sunday, 19th April 2020
* 
* @author  Marita Brichan and Mohona Mazumdar
*<br>
*<br> 
*
* This program is to test the different methods and properties of the linked list which is the CellList class
* Each node in the list has a CellPhone object and a CellNode object next
*
*/
public class CellList {

	/**
	 * 
	 * This class is the inner class that creates nodes for the linked list
	 *The inner class should be private in order to avoid privacy leak where any user can modify the class directly
	 *
	 */
	 private class CellNode {

		/**
		 * Object cellphone as a private instance of the CellNode class
		 */
		private CellPhone phone;
		
		/**
		 * Private instance of its own class
		 */
		private CellNode next;

		/**
		 * Default constructor that sets the two attributes to null
		 */
		public CellNode() {
			phone = null;
			next = null;
		}

		//Parameterized constructor that takes an object of type of CellPhone and of type CellNode and initializes the attributes
		/**
		 * 
		 * @param phone attribute
		 * @param next attribute
		 */
		public CellNode(CellPhone phone, CellNode next) {
			this.phone = phone;
			this.next = next;

		}

		/**
		 * 
		 * @param node1 attribute
		 * Copy constructor that takes an object of type CellNode and returns an exact copy of the object given
		 *Privacy leak since the user can modify the linked list
		 */
		public CellNode(CellNode node1) {

			/**
			 * Clones the attribute phone of the calling object and stores it to the new phone of the copy object
			 */
			phone = (CellPhone) next.phone.clone();
			
			/**
			 * Clones the attribute CellNode of the calling object and stores it to the new next of the copy object
			 */
			next = node1.next;
		}

		/**
		 * Copy constructor that returns a deep copy of the calling object
		 */
		public CellNode clone() {
			return new CellNode(this);
		}

		/**
		 * Accessor method that returns the attribute phone of the calling object
		 * @return
		 */
		public CellPhone getPhone() {
			return phone;
		}

		/**
		 * Mutator method that takes a parameter of type CellPhone and sets it to the attribute phone 
		 *Privacy leak since the user can modify the linked list
		 * @param cp attribute
		 */
		public void setPhone(CellPhone cp) {
			phone = cp;
		}

		/**
		 * Accessor method that returns the attribute the CellNode of the calling object
		 * @return method
		 */
		public CellNode getCellNode() {
			return next;
		}

		/**
		 * Mutator method that takes a parameter of type CellNode and sets it to the attribute next
		 *Privacy leak since the user can modify the linked list
		 * @param cn attribute
		 */
		public void setCellNode(CellNode cn) {
			next = cn;
		}

	}

	
	/**
	 * Private instance of type CellNode for the CellList class 
	 */
	private CellNode head;

	
	/**
	 * Private instance of type integer that determines the size of the list
	 */
	private int size;

	/**
	 * Default constructor of the class that sets the instance variables to null
	 */
	public CellList() {
		head = null;
		size = 0;
	}
	
	
	/**
	 * Copy constructor that takes an object of type CellList and returns a deep copy of the list
	 * @param list attribute
	 */
	public CellList(CellList list) {
		
		
		/**
		 * Evaluates the case to determine if the list is empty or null
		 */
		if(list==null || list.head==null) {
			System.out.println("The given list is null and of size 0. An empty list will be created from it.");
			head = null;
			size = 0;
		}

		
		else {
			/**
			 * Creating a CellNode head that points to a CellNode exactly the same as the head of the calling list
			 */
			head = new CellNode(list.head);
			
			/**
			 * Size of the list is 1 now because of the head
			 */
			size=1;
			
			//Creating three pointers of type CellNode that will be used later
			CellNode firstListPointer, secondListPointer, secondListEnd;
			//The first pointer is pointing to the CellNode that comes right after the head
			firstListPointer = list.head.next;
			//The second pointer is pointing to the head of the list. This pointer will later point to all newly created nodes
			secondListPointer = head;
			//Since it is the last node of the list, it points to null
			secondListEnd = null;
			
			//While loop that stops iterating as soon as the first pointer is pointing to the last node of the list. Otherwise, 
			//it iterates
			while(firstListPointer!=null) {
				
			
			secondListEnd = new CellNode(firstListPointer.phone, firstListPointer.next);
			secondListPointer.next = secondListEnd;
			secondListEnd.next = null;
			secondListPointer = secondListEnd;
			firstListPointer = firstListPointer.next;
			
			//Increasing the size of the list everytime a node is being added
			size++;
			
			
		}
		//At the end, all pointers point to null
		firstListPointer = secondListPointer = secondListEnd = null;
		}
		}

	
	/**
	 * Method to add to the start of the list
	 *Privacy leak since the cellnode is created with the CellPhone object, as opposed to a copy of it
	 * @param cp attribute
	 */
	public void addToStart(CellPhone cp) {
		//The head is pointing to the newly created head point
		head = new CellNode(cp, head);
		//Displaying information about the cellphone that has just been added
		System.out.println("Cellphone was successfully added to the start of the list");
		System.out.println("The information of the cellphone is the following: \nSerial Number: "+ cp.getSerialNum()+
      		"\nBrand: " +cp.getBrand()+"\nPrice: "+cp.getPrice()+ "\nYear: "+ cp.getYear());
		 System.out.println("=====================================================================");
      
		 //Increasing the size of the list once the node is added to the start of the list
		size++;

	}

	/**
	 * Method that inserts a node at the given index
	 * @param cp attribute
	 * @param index attribute
	 */
	public void insertAtIndex(CellPhone cp, int index){
		//In the case where the given CellPhone object is null
      if(cp == null){
          System.out.println("\nThe given cellphone is null. It cannot be added to the list.");
          return;
      }

      try{

         //In the case where the index is either smaller than 0 or bigger than the size of the size of the list
          if(index < 0 || index > (size - 1)){

          	//In the case where the given index is 0
              if(index == 0){
              	//add the CellPhone to the start of the list
                  addToStart(cp);
                  return;
              }

              else
                  throw new NoSuchElementException();
          }
      }

      catch(NoSuchElementException e){
          System.out.println("\nError! The index is out of bounds: either smaller or bigger than the size of the list.");
          return;
      }

      //In the case where the given index is 0
      if(index == 0){
      	//add the CellPhone object to the start of of the list using the addToStart method
      	 addToStart(cp);
      }

     
      else{
      	//The new CellNode temp is pointing to head and the another CellNode is pointing to the following node of head
          CellNode temp = head;
          CellNode nextTemp = temp.next;
          CellNode newNode;

          //A for loop that iterates through the whole list till it finds the right index 
          for (int i = (index - 1); i > 0; i--) {
              temp = temp.next;
              nextTemp = temp.next;
          }

        //A new node that takes the CellPhone object given and pointing to the next node
          newNode = new CellNode(cp, nextTemp);
          temp.next = newNode;
          //Displaying the information of the CellPhone that was added to the list
          System.out.println(" A cellphone was successfully added to the given index "+index);
          System.out.println("The information of the cellphone is the following: \nSerial Number: "+ cp.getSerialNum()+
          		"\nBrand: " +cp.getBrand()+"\nPrice: "+cp.getPrice()+ "\nYear: "+ cp.getYear());
          System.out.println("=====================================================================");
          //Increasing the size of the list as soon as it is added
          size++;
      }
  }

	
		
	/**
	 * A method that deletes the node at the given index
	 * @param index attribute
	 */
	public void deletefromIndex(int index) {
		
		try {
		//In the case where the index is invalid since it is smaller than 0 or bigger than the size of the list
		if (index<0||index > (size - 1)) {
			//Display an error message
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}
		}
		catch(NoSuchElementException e) {
			System.out.println("The given index is out of bounds: either smaller or larger than the size of the list.");
			System.exit(0);
		}

		//In the case where the index is 0
		if (index == 0) {
			System.out.println("\nDeleting node with cellphone" + head.phone + " from index #" + index + ".");
			deleteFromStart();
		}

		else {

			//New CellNode that points to the head of the list
			CellNode temp = head;
			//Another node that points to the next node
			CellNode nextTemp = temp.next;
			
			//A for loop that iterates till it finds the right index
			for(int  i =(index-1); i>0;i--) {
				temp = temp.next;
				nextTemp= temp.next;
			}

			//The temp node is now pointing to the next node of the other node
			temp.next = nextTemp.next;
			//Both nodes are initialized to null
			nextTemp.next = null;
			nextTemp = null;
			
			//Displaying a message to explain to the user the action of the method
			System.out.println("\nDeleting node with cellphone" + temp.next.phone + " from index #" + index + ".");
			//Decreasing the size of the list
			size--;
			
		}
	}
	
	
	/**
	 * A method that deletes the node from the start
	 */
	public void deleteFromStart() {
		
		//In the case where the head of the list is null
		if (head==null) {
			System.out.println("The list is already empty");
			return;
		}
		//The head node is now pointing to the node following the head
		head = head.next;
		//Decreasing the size of the list
		size--;
	}
	
	
	/**
	 * A method that replaces the cellphone object at the given index
	 *Privacy leak since the method is done by using a cellphone object instead of a copy of it
	 * @param cp attribute
	 * @param index attribute
	 */
	public void replaceAtIndex(CellPhone cp, int index){
		//If the cellphone is null
      if(cp == null)
          return;
   
      //In the case where the index is either less than 0 or bigger than the size of the list 
      else if(index < 0 || index > (size - 1))
          System.out.println("The given index is out of bounds: either smaller or larger than the size of the list.");

      
      else{
      	//node temp is pointing to the head
          CellNode temp = head;
          
          //For loop that iterates till it finds the index given
          for(int i = index; i > 0; i--)
              temp = temp.next;

          //The cellphone object of the new node takes the cellphone object given
          temp.phone = cp;
          System.out.println("\nThe old cellphone at index " + index + " was replaced successfully with the given cellphone " + cp + ".");
      }
  }


	/**
	 * Find method that looks for the CellPhone object that corresponds to the serial number
	 * @param serialNum attribute
	 * @return method
	 */
	public CellNode find(long serialNum) {
		
		//node that points to the head of the list
      CellNode newNode = head;
      //Counter 
      int ctr = 0;
      //The while loop breaks off if the node is equal to null, otherwise it continues
      while (newNode != null) {
      	//If the serial number of the current node matches the serial number given, outputs the node
          if (newNode.phone.getSerialNum() == serialNum) {
              System.out.println("The Cellphone was found at " + ctr+ " after "+ctr+" iterations.");
              
              System.out.println("The information of the cellphone is the following: "+newNode.phone.toString());
              System.out.println("=====================================================================");
              return newNode;
          }
          newNode = newNode.next;
          ctr++;
      }
      return null;
  }

	/**
	 * A method that checks if it contains the object cellphone with the given serial number
	 * @param serialnum attribute
	 * @return attribute
	 */
	public boolean contains(long serialnum) {
		if (find(serialnum) != null) {
			return true;
			
		}
		else
			//returns false if it doesn't
			return false;
		
	}
	
	
	/**
	 * Method that shows the contents of the list
	 */
	public void showContents(){

		//In the case where the size of the list is 0, which means the list is empty
      if(size == 0)
          System.out.println("\nList is empty. Nothing to display.");

      else{
      	//CellNode temp that points to head of the list
          CellNode temp = head;
          
          System.out.println("\nThe current size of the list is " + size + ". Here are the contents of that list:");

        //For loop that iterates through the size of the list
          for(int i = 0; i < size; i++){

              
              if(i%3 == 0)
                  System.out.println();

              //Displays the contents of the phone of the current node of the list
              System.out.print(temp.phone + " ----> ");

              //In the case where the current node is null, it signals the end of the list
              if(temp.next == null){
                  System.out.print(" X\n");
                  return;
              }


              //Moving the temp to the next node
              else{
                  temp = temp.next;
              }
          }

          System.out.println();
      }
  }
	
	
	/**
	 * A method that checks if the calling list and the given list are equal
	 * @param c1 attribute
	 * @return method
	 */
	public boolean equals(CellList c1) {
		//In the case where the given list is null or both list are not of the same type or the sizes of the lists are not 
		//the same, return false
      if(c1 == null || c1.getClass() != this.getClass()|| c1.size!=this.size)
          return false;
  
    //node position points to the head of the calling list
    CellNode position = head;
    
    //node otherPosition points to the head of the other list
    CellNode otherPosition = c1.head;
    
    //While loop that stops when the position is null which signals the end of the list
    while(position!=null) {
  	  //In the case where the the phone of one node is not equal to the phone object of the other node, return false
  	  if ((!(position.phone.equals(otherPosition.phone))))
  		  return false;
  	  
  	  //Move the current position of both lists to the next node
  	  position = position.next;
  	  otherPosition = otherPosition.next;
    } 
     return true; 
	
	
  }
	
}
	


