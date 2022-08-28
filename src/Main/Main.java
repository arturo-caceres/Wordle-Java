package Main;

import java.util.Scanner;

public class Main {
	
	
//	String list = wordleList[(int)(Math.random()*wordleList.length)];
	
	

	public static void main(String[] args) {
		
		
		String[] words = {"hello", "money", "share"};
		
//		String word = "hello"; 
		String word = words[(int)(Math.random()*words.length)];
		
		Scanner userInput = new Scanner(System.in);
		
		int guesses = 6;
		
	
		
		String guess = "";
		
		while (!guess.equals(word) && guesses>0) {
			System.out.println("\nYou have " +guesses+ " guesses remaining." );
			guess = userInput.nextLine();
			if(guess.length()!=5) {
				System.out.println("You must type 5 letters");
				continue;
			}
			
			
			 for(int i=0; i<word.length(); i++) {
				 boolean didBreak = false;
				 for (int j=0; j< word.length(); j++) {
					 if(guess.charAt(i)==word.charAt(i)) {
						 System.out.println(ConsoleColors.GREEN_BOLD + "Y" + ConsoleColors.RESET);
						 didBreak = true;
						 break;
					 }
					 
					 
					 if(guess.charAt(i)==word.charAt(j)) {
						 System.out.println(ConsoleColors.YELLOW_BOLD + "C" + ConsoleColors.RESET );
						 didBreak = true;
						 break;
					 }
				 }
				 
				 if(!didBreak ) {
					 System.out.println(ConsoleColors.WHITE + "X" + ConsoleColors.RESET);
				 }
			 }
			
			 guesses--;
			 
			
		}
		if (guess.equals(word)) {
			System.out.println("\nYou guessed the word! Great Job");
		} else {
			System.out.println(" \nYou failed! The word was: " +word);
		}
		
		

	}

}
