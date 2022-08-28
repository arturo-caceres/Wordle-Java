package Main;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello Player, Good luck!");

		List<String> list = new ArrayList<String>();
		try {
			File myObj = new File("words.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				list.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		final String word = list.get((int) (Math.random() * list.size()));
		Scanner userInput = new Scanner(System.in);

		int guesses = 6;

		String guess = "";
		String socialResult = "#Wordle\n\n";

		while (!guess.equals(word) && guesses > 0) {
			System.out.println("\nYou have " + guesses + " guesses remaining.");
			guess = userInput.nextLine();
			if (guess.length() != 5) {
				System.out.println("You must type 5 letters");
				continue;
			}

			for (int i = 0; i < word.length(); i++) {
				boolean didBreak = false;
				for (int j = 0; j < word.length(); j++) {
					if (guess.charAt(i) == word.charAt(i)) {
						System.out.print(ConsoleColors.GREEN_BOLD + word.charAt(i) + ConsoleColors.RESET);
						socialResult += "🟩";
						didBreak = true;
						break;
					}

					if (guess.charAt(i) == word.charAt(j)) {
						System.out.print(ConsoleColors.YELLOW_BOLD + guess.charAt(i) + ConsoleColors.RESET);
						socialResult += "🟨";
						didBreak = true;
						break;
					}
				}

				if (!didBreak) {
					System.out.print(ConsoleColors.WHITE + guess.charAt(i) + ConsoleColors.RESET);
					socialResult += "⬜️";
				}
			}

			System.out.println("");
			socialResult += "\n";

			guesses--;

		}
		if (guess.equals(word)) {
			System.out.println("\nYou guessed the word! Great Job");
			socialResult += "\nYou did it";

		} else {
			System.out.println(" \nYou failed! The word was: " + word);
			socialResult += "\nBetter luck tomorrow!";
		}

		System.out.println(socialResult);
		System.out.println("\nResults are already on your clipboard, go share it on social media! 🤩🏆");

		StringSelection selection = new StringSelection(socialResult);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		
		userInput.close();

	}

}
