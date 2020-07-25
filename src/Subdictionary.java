
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;

public class Subdictionary {

	public static void main(String[] args) {
		
		//sc is the scanner object that would help us read from the input files
		Scanner sc = new Scanner(System.in);
		//keyIn is the scanner object that would help us read the user's inputs
		Scanner keyIn = new Scanner(System.in);
		//This arrlist is an array list that would store all the words and cread a dictionary out of it
		ArrayList<String> arrlist = new ArrayList<String>(447); 
		//word is a string that takes the value of the word that the program is currently reading in the input file
		String word="";
		//Print a welcome message and ask the user to type in the name of the input file
		System.out.println("Welcome to the Subdictionary program!\nEnter the name of the file of which you would like the disctionary to be formed of:");
		//file is the name of the input file that the user wants to open to read and create the disctionary out of
		String file = keyIn.next();
		//enter a try/catch method to open the file in case it was not found
		try {
			//open the input file for reading
			sc = new Scanner(new FileInputStream(file));
		}
		//in case the file could not be opened because it does not exist or any other reason
		catch(FileNotFoundException e) {
			//rint an error message saying what's wrong and that the program is going to quit
			System.out.println("Could not open input file\""+ file +"\" for reading.\nPlease check if it exists! Program will terminate after closing the opened files.");
			//close the scanner object
			sc.close();
			//exit the program
			System.exit(0);
		}
		//enter a loop that iterates as long as the file has another word to read
		while(sc.hasNext()){
			//take the value of the word we're at and firectly cast it into upper case
			word=sc.next().toUpperCase();
			//if the word contains any numbers, then skip to the next word
			if(word.matches(".*\\d+.*")) {
				continue;
			}
			//if the word contains a " ' ", then write everything that comes before it
			else if(word.contains("\'")) {
				word=word.substring(0,word.indexOf("\'"));
			}
			//if the word contains a " ' ", then write everything that comes before it
			else if(word.contains("’")) {
				word=word.substring(0,word.indexOf("’"));
			}
			//if the word contains a "?", then write the word without the "?"
			else if(word.endsWith("?")) {
				word=word.substring(0,word.length()-1);
			}
			//if the word contains a ":", then write the word without the ":"
			else if(word.endsWith(":")) {
				word=word.substring(0,word.length()-1);
			}
			//if the word contains a "=", then skip to the next word
			else if(word.contains("=")) {
				continue;
			}
			//if the word contains a ",", then write the word without the ","
			else if(word.endsWith(",")) {
				word=word.substring(0,word.length()-1);
			}
			//if the word contains a ";", then write the word without the ";"
			else if(word.endsWith(";")) {
				word=word.substring(0,word.length()-1);
			}
			//if the word contains a "!", then write the word without the "!"
			else if(word.endsWith("!")) {
				word=word.substring(0,word.length()-1);
			}
			//if the word is of length of one character and it's not an "a" or an "i", then skip to the next word
			else if(word.length()==1&&!word.equalsIgnoreCase("a")&&!word.equalsIgnoreCase("i")) {
				continue;
			}
			//if the word contains a ".", then write the word without the "."
			else if(word.endsWith(".")) {
				word=word.substring(0,word.length()-1);
			}
			//if the arrlist contains the word, then skip to the next
			if(arrlist.contains(word)) {
				continue;
			}
			//if the arrlist does not contain any other words like the one we have, then add it to the arrlist
			else {
				arrlist.add(word);
			}
		}
		// copy all the words from the list into the arrlist3
		// Since arrlist2 has a smaller size than the arrlist,it will return a array with the correct size
		// If the size of the passed was good, then the object would have been copied into that array, then the method would return that array and not another one. 
		String[] arrlist2 = new String[arrlist.size()-2];
		String[] arrlist3 = arrlist.toArray(arrlist2);
		//temp is a temporary String to store the word in order to organize the arrlist3 alphabetically
		String temp;
		//enter a loop the iterates through all the words and compares each words to all the other words and organize them depending on the value of compareTo() method
        for (int i = 0; i < arrlist3.length; i++) 
        {
            for (int j = i + 1; j < arrlist3.length; j++) 
            {
                if (arrlist3[i].compareTo(arrlist3[j])>0) 
                {
                    temp = arrlist3[i];
                    arrlist3[i] = arrlist3[j];
                    arrlist3[j] = temp;
                }
            }
        }
        //open the printwriter in order to print what's needed into the documen, all while creating it
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
			//c takes the value of the first character every time it changes
	        char c = arrlist3[0].charAt(0);
	        //print the header message into the file with the number of entries the dictionary required
	        pw.println("The document produced this sub-dictionary, which includes " + arrlist.size() + " entries.");
	        //print the first character into the file
	        pw.println("\n"+c+"\n==");
	        //enter a loop to write everything into the file
			for(int i = 0; i<arrlist3.length;i++) {
				//if the first character changed, then add it to the dictionary to indicate that we're in a new character
				if(c!=arrlist3[i].charAt(0)) {
					//change the value of c
			        c = arrlist3[i].charAt(0);
			        //print it to the file
					pw.println("\n"+c+"\n==");
				}
				//print the word to the file
				pw.println(arrlist3[i]);
			}
			//close the printwriter
			pw.close();
		} 
		//in case the file could not be created
		catch (FileNotFoundException e) {
			//print an error message
			System.out.println("Error! File coule not be created.\n program will be terminated...");
			//exit the program
			System.exit(0);
		}
		//print a goodbye message
		System.out.println("The subdictionary have been created, please go check the file under the name \"SubDictionary.txt\" to see it.\nThank you for using our program!");
		//close the scanner object
		keyIn.close();

		
		
	}

}
