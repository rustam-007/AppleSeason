

/**
 * This class is for Bomb
 * @author Rustam Talibzade 
 */

public class Bomb extends Apple implements Runnable {
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes Bomb data
	 */
	public Bomb() {
		super();
		b.setImage("bomb2.gif");
		b.setSize(40, 50);
	}

	/**
	 * Method for moving Bomb
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
		Music sound = new Music("bomb.mp3");
		setLocation(0, 1000);
		Game.i = 100;						// If user catches bomb, games end (i becomes 100 and for loop in Game class stops)
		miss = true;
		exploded = true;					// need for explosion
		sound.playmusic();					// sound is played
	}
	
	/**
	 * Speed of moving
	 */
	private final static int STEP = 10;
	/**
	 * Is needed for animation of explosion
	 */
	static boolean exploded = false;
}