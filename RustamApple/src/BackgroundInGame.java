

/**
 * This class is for creating of bakground while you play
 * Shows score, number of apples left and missed apples
 * @author Rustam Talibzade - Date: 17 May 2018
 */

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLabel;

public class BackgroundInGame extends GCompound {
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes BackgroundInGame data
	 */
	public BackgroundInGame() {
		GImage gameBackground = new GImage("ingame.png");
		add(gameBackground);

		scoreLabel.setFont("ARIAL-BOLD-16");
		left.setFont("ARIAL-BOLD-16");
		missedLabel.setFont("ARIAL-BOLD-16");
		add(scoreLabel, 30, getHeight() - 15);
		add(left, 180, getHeight() - 15);
		add(missedLabel, 360, getHeight() - 15);
	}
	
	/**
	 * GLabels for showing score, number of apples left and missed apples
	 */
	static GLabel left = new GLabel(Integer.toString(100 - Game.i));
	static GLabel scoreLabel = new GLabel(Integer.toString(Game.score));
	static GLabel missedLabel = new GLabel(Integer.toString(Game.missed));
}
