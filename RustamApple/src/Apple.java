

/**
 * This class is for creating apples
 * @author Rustam Talibzade - Date: 17 May 2018
 */

import acm.graphics.*;

public abstract class Apple extends GCompound implements Runnable {
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes Apple data
	 */
	public Apple() {
		super();
		b = new GImage("apple.gif");
		b.setSize(SIZE, SIZE);
		add(b);
	}

	@Override
	public void run() {
		
		sendToFront();
		for (int i = 0; i < 100; i++) {
			move();
			if(collision()) {
				doOnCollision();
			}
		}
		if (miss) Game.missed++;
		else Game.score++;
	}
	
	/**
	 * Method for moving apples. It is abstract because every type of apples moves with different speed
	 */
	public abstract void move();
	
	/**
	 * Method for doing different stuff like adding score and etc. Depends on type of apple
	 */
	public abstract void doOnCollision();

	/**
	 * Checks for collision of apples and basket
	 * @return if apple and basket intersect or not
	 */
	public boolean collision() {
		// score is counted if it enters basket from the top
		// So if apple is lower that basket, it means apple will not be able to enter the basket
		
		if (getY() <= Game.basket.getY())
			return getBounds().intersects(Game.basket.getBounds());
		return false;
	}
	
	/**
	 * Declares size of Apple
	 */
	final static double SIZE = 50;
	/**
	 * Array of apples that drops into the basket
	 */
	static Apple[] apples = new Apple[100];
	/**
	 * Image of Apples
	 */
	static GImage b;
	/**
	 * This parameter is for defining if apple missed the basket
	 */
	boolean miss = true;
	/**
	 * Time of pause
	 */
	int PAUSE_TIME = 10;
}