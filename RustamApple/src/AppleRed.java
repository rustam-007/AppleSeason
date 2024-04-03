

/**
 * This class is for Red Apple
 * @author Rustam Talibzade - Date: 17 May 2018
 */

public class AppleRed extends Apple {
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes AppleRed data
	 */
	public AppleRed() {}

	/**
	 * Method for moving AppleRed
	 */
	@Override
	public void move() {
		pause(PAUSE_TIME);
		move(0, STEP);
		STEP += 0.4;
	}

	/**
	 * If collision appears, this stuff is done
	 */
	@Override
	public void doOnCollision() {
		Music sound = new Music("collision.mp3");
		setLocation(0, 1000);							// after collision changes its location. Is needed for removing apples
		Game.basket.setImage("basmini.png");			// basket becomes red after collision
		miss = false;
		sound.playmusic();								// sound is played
	}

	/**
	 * Speed of moving
	 */
	private static int STEP = 8;
}