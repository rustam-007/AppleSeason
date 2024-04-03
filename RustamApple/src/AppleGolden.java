

/**
 * This class is for Golden Apple
 * @author Rustam Talibzade - Date: 17 May 2018
 */

public class AppleGolden extends Apple {
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes AppleGolden data
	 */
	public AppleGolden() {
		super();
		b.setImage("goldenapple.gif");
		b.setSize(Apple.SIZE, Apple.SIZE);
	}

	/**
	 * Method for moving AppleRed
	 */
	@Override
	public void move() {
		pause(PAUSE_TIME);
		move(0, STEP);
	}

	/**
	 * If collision appears, this stuff is done
	 */
	@Override
	public void doOnCollision() {
		Music sound = new Music("gold.mp3");
		setLocation(0, 1000);							// after collision changes its location. Is needed for removing apples
		Game.basket.setImage("basmini.png");			// basket becomes red after collision
		if (Game.i >= 10) Game.i -= 10;					// if user takes golden apple he gets 10 extra apples
		else Game.i = 0;								// but user cannot more than 100 apples left
		miss = false;
		sound.playmusic();							// sound is played
		pause(50);
	}

	/**
	 * Speed of moving
	 */
	private static double STEP = 11.5;
}
