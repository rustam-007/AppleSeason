

/**
 * This is class is for keeping highscore of the game
 * @author Rustam Talibzade - Date: 17 May 2018
 */

import java.io.*;

public class Highscore {

	/**
	 * Initializes Highscore data
	 * @param score - score of the game
	 */
	public Highscore(int score) {
		this.score = score;

		try {
			BufferedReader br = new BufferedReader(new FileReader("highscore.txt"));		// reads text document
			String l;
			l = br.readLine();																// reads first line of the txt (I keep here the highscore)
			
			highscore = Integer.parseInt(l);
			pw = new PrintWriter(new FileWriter("highscore.txt", false));

			if(score > highscore) {															// if score is higher than highscore
				pw.println(score);															// print the new highscore in the txt
				highscore = score;
			}
			else
				pw.println(highscore);														// if not print the old one
			pw.close();
			br.close();
		} catch (FileNotFoundException e1) {
		} catch (IOException e1) {}
	}

	/**
	 * score of the game
	 */
	int score;
	/**
	 * highscore of the game
	 */
	int highscore;
	/**
	 * PrintWriter for reading txt
	 */
	PrintWriter pw;
}
