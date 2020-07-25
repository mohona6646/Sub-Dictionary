import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

public class CellListUtilization {
    public static void main(String[] args) {
    	//the sc is the scanner object to read from the file
        Scanner sc = new Scanner(System.in);
        //keyIn in to read the user's inputs
        Scanner keyIn = new Scanner(System.in);
        //l1 is the first list which is the one created from the .txt file
        CellList l1 = new CellList();

        //display a welcome message
		System.out.println("\t*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n\t*\t\t\t\t\t\t*" + "\n\t*\tWelcome to Marita and Mohona's program\t*"+"\n\t*\t\t\t\t\t\t*"+ "\n\t*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n");
        //show the contents of the empty list
		System.out.println("\n\nThe contents of the empty list l2:'n");
		l1.showContents();

		//open the input file to read from it
        try{
            sc = new Scanner(new FileInputStream("Cell_Info.txt"));
        }
        //in case the file could not be opened, display an error message, close the scanner object and exist the program
        catch (FileNotFoundException e){
            System.out.println("Error! File could not be opened for reading.\nPlease check if the file exists.\nExisting the program...");
            sc.close();
            System.exit(0);
        }
        
        //variables that would be needed in order to create the CellPhone object
        String brand;
        double price;
        long serialNum;
        int year;
        //enter a loop that iterates as long as the file has another line
        while(sc.hasNextLine()){
        	//read the serial number, the brand, the price and the year in their respective order and type
            serialNum = sc.nextLong();
            brand = sc.next();
            price = sc.nextDouble();
            year = sc.nextInt();
            //create a CellPhone object with the values that were just extracted
            CellPhone cellPhone = new CellPhone(serialNum, brand, year, price);
            //if this object is not already in the l1 list, then add it with addToStart
            if(!(l1.contains(serialNum))){
                l1.addToStart(cellPhone);
            }
        }
        //close the sc scanner
        sc.close();
        //Display a message indicating that the first list has been created
        System.out.println("\n\n---------------------------------------The first list is now created-------------------------------------\n\n");
        //show the contents of l1
        l1.showContents();
        System.out.println("\n");
        
        //type is an unused varibale that would just ask the user to type anything in order to continue to avoid having the whole program all running at once
        @SuppressWarnings("unused")
		String type;
        
        //ask the user to type anything in order to continue
        System.out.println("Type anything to continue:");
        type = keyIn.next();
        
        //create a second list l2
        CellList l2 = new CellList();
        
        //create multiple CellPhone objects and put then in the liked list l2
        CellPhone c1 = new CellPhone(12345,"Samsung",2015,900);
        l2.addToStart(c1);
        CellPhone c2 = new CellPhone(85674,"Apple",2020,1800);
        l2.addToStart(c2);
        CellPhone c3 = new CellPhone(76534,"GL",2016,300);
        l2.addToStart(c3);
        CellPhone c4 = new CellPhone(13455,"Huwawei",2013,500);
        l2.addToStart(c4);
        CellPhone c5 = new CellPhone(76465,"Google",2019,1200);
        l2.addToStart(c5);
        CellPhone c6 = new CellPhone(64334,"Glaxy",2014,500);
        l2.addToStart(c6);
        CellPhone c7 = new CellPhone(63565,"Pixel",2016,1100);
        l2.addToStart(c7);
        CellPhone c8 = new CellPhone(35656,"Apple",2017,1000);
        l2.addToStart(c8);
        CellPhone c9 = new CellPhone(635763,"Asus",2016,700);
        l2.addToStart(c9);
        CellPhone c10 = new CellPhone(52345,"Acer",2020,600);
        l2.addToStart(c10);
        CellPhone c11 = new CellPhone(65345,"BlackBerry",2011,550);
        l2.addToStart(c11);
        
        //once all of the above is done, display a message indicating that the list was created
        System.out.println("\n\n---------------------------------------The second list is now created-------------------------------------\n\n");
        //show the list's contents
        l2.showContents();
  
        //Display a message telling the user what we're doing now
        System.out.println("\n\n---------------------------------------SEARCH FOR CELLPHONE-------------------------------------\n\n");
        //search is a boolean that stays false as long as the user wants to search a cellphone with a certain serial number
        boolean search = false;
        //enter a loop that iterates as long as the user wants
        while(!search){
        	//ask the user to type what's needed and give him the optionto skip to the next step
            System.out.println("\nPlease enter the serial number of the cellphone that you wish to search for, or enter 0 to skip to the next step");
            //choice is the user's choice on what to do next
            long choice = keyIn.nextLong();
            //if the user types 0, then he wants to get out of the search loop
            if(choice == 0) {
            	search = true;
            	break;
            }
            //otherwise, search for a cellphone with the demanded serial number using the find() method
            else {
            	l1.find(choice);
            }
        }
        
        //Display a message insicating what we're doing to the user
        System.out.println("\n\n---------------------------------------TESTING-------------------------------------\n\n");
        
        //create 3 CellPhone objects in order to test with
        CellPhone test1 = new CellPhone(56784,"Apple",2018,968);
        CellPhone test2 = new CellPhone(67456,"Samsung",2019,909);
        CellPhone test3 = new CellPhone(758645,"Google",2013,654);
        
        //ask the user to type anything in order to continue
        System.out.println("Type anything to continue:");
        type = keyIn.next();
        //tell the user what we're testing
        System.out.println("Testing the replaceAtIndex() method with the second list:\n");
        //use the replaceAtIndex() method
        l2.replaceAtIndex(test1, 0);
        l2.replaceAtIndex(test2, 3);
        l2.replaceAtIndex(test3, 8);
        //display the list's contents
        l2.showContents();
        
        //ask the user to type anything in order to continue
        System.out.println("Type anything to continue:");
        type = keyIn.next();        
        //tell the user what we're testing
        System.out.println("\n\nTesting the insertAtIndex() method with the second list:\n");
        //use the insertAtIndex() method
        l2.insertAtIndex(test2, 9);
        //display the list's contents
        l2.showContents();
        
        //ask the user to type anything in order to continue
        System.out.println("Type anything to continue:");
        type = keyIn.next();
        //tell the user what we're testing
        System.out.println("\n\nTesting the deleteFromStart() method with the second list:\n");
        //use the deleteFromStart() method
        l2.deleteFromStart();
        //display the list's contents
        l2.showContents();
        
        //ask the user to type anything in order to continue
        System.out.println("Type anything to continue:");
        type = keyIn.next();
        //tell the user what we're testing
        System.out.println("\n\nTesting the setter method with the second list:\n");
        //use the setter methods
        test1.setBrand("LG");
        test2.setPrice(543); 
        test3.setYear(2012);
        test1.setSerialNum(75643);
        l2.showContents();
        
        //ask the user to type anything in order to continue
        System.out.println("Type anything to continue:");
        type = keyIn.next();
        //tell the user what we're testing
        System.out.println("\n\nTesting the deleteFromIndex() method with the second list:\n");
        l2.deletefromIndex(5);
        //display the list's contents
        l2.showContents();
        
        //display a goodbye message
        System.out.println("\n\nEnd of the program. Thank you for using it!");
        
        //close the keyIn scanner
        keyIn.close();
        
    }
}