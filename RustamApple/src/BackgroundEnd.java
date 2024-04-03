

/**
 * This class is for displaying number of total, missed, saved apples and highscore
 * @author Rustam Talibzade - Date: 17 May 2018
 */

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;

public class BackgroundEnd extends GCompound {
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes BackgroundEnd data
	 */
	public BackgroundEnd() {
		GImage gameOver = new GImage("gameover.png");
		add(gameOver);

		// Total number of apples
		GLabel total = new GLabel("TOTAL : " + (Game.missed + Game.score));
		total.setFont("SERIF-BOLD-24");
		add(total, getWidth() / 2 - 40, getHeight() / 2 + 30);

		// Number of missed apples
		GLabel missedLabel = new GLabel("MISSED : " + Game.missed);
		missedLabel.setFont("SERIF-BOLD-24");
		add(missedLabel, getWidth() / 2 - 53, getHeight() / 2 + 60);

		GLine line = new GLine(getWidth() / 2 - 60, getHeight() / 2 + 76,
							   getWidth() / 2 + 100, getHeight() / 2 + 76);
		add(line);

		// Number of saved apples
		GLabel savedLabel = new GLabel("SAVED : " + Game.score);
		savedLabel.setFont("SERIF-BOLD-24");
		add(savedLabel, getWidth() / 2 - 42, getHeight() / 2 + 110);

		// Highscore
		Highscore highscore = new Highscore(Game.score);
		GLabel highscoreLabel = new GLabel("HIGHSCORE : " + highscore.highscore);
		highscoreLabel.setFont("SERIF-BOLD-24");
		add(highscoreLabel, getWidth() / 2 - 80, getHeight() / 2 + 140);
	}
}
