

/**
 * This class is for running the game
 * @author Rustam Talibzade - Date: 17 May 2018
 */

import java.awt.event.MouseEvent;
import java.util.*;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Game extends GraphicsProgram {
	private static final long serialVersionUID = 1L;

	/**
	 * Start background
	 * Add MouseListeners
	 */
	public void init() {
		setSize(528, 604);
		GImage background = new GImage("gamestart.png");
		background.setSize(getWidth(), getHeight());
		add(background);
		background.sendToBack();
		
		addMouseListeners();
		addKeyListeners();
		pause(10);
		waitForClick();
		removeAll();
	}

	public void run() {
		Random rg = new Random();
		
		

		BackgroundInGame ingame = new BackgroundInGame();
		add(ingame);
		
		basket.setImage("basket4.png");
		add(basket, 0, getHeight() - 77);

		for (i = 0; i < Apple.apples.length; i++) {
			// after catching an apple basket becomes red, after this code it turns to original color
			Game.basket.setImage("basket4.png");					

			// Adds thread of apples with different percentage
			try {
				if (rg.nextInt(50) % 50 == 0) {					// 2%
					Apple.apples[i] = new AppleGolden();
				} else {
					if(rg.nextInt(33) % 33 == 0)				// 3%
						Apple.apples[i] = new Bomb();
					else 
						Apple.apples[i] = new AppleRed();		
				}

				add(Apple.apples[i], rg.nextInt((int) (getWidth() - Apple.apples[i].getWidth())), 0);
			
				basket.sendToFront();
				Thread t = new Thread(Apple.apples[i]);
				threads.add(t);
				t.start();
			} catch (IndexOutOfBoundsException e) {}
			
			// Changes score, number of apples left, missed apples
			BackgroundInGame.scoreLabel.setLabel("SAVED : " + Integer.toString(score));
			BackgroundInGame.left.setLabel("Apples left: " + Integer.toString(AppleRed.apples.length - i));
			BackgroundInGame.missedLabel.setLabel("MISSED : " + (missed));

			removeApples(); 								// remove apples
			pause(125 + rg.nextInt(600));
		}

		// Animation of explosion if user catches bombs
		explosion.setSize(getWidth(), getHeight());
		if (Bomb.exploded) add(explosion);
		
		pause(2000);
		removeAll();

		// Ending background
		BackgroundEnd end = new BackgroundEnd();
		add(end);

		waitForClick();
		restart();						// restarts the game
	}

	public static void main(String[] args) {
		new Game().start();
	}
	/**
	 * Method for moving basket
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		try {
			last = new GPoint(basket.getLocation());
			obj = getElementAt(last);
		} catch (Exception e1) {}
		
		if (obj != null && obj == basket && (e.getX() < getWidth() - basket.getWidth() / 2
											&& e.getX() > basket.getWidth() / 2)) {
			obj.move(e.getX() - last.getX() - (basket.getWidth() / 2), 0);
			last = new GPoint(e.getPoint());
		}
	}

	/**
	 * Method for restarting the game
	 * Changes all needed variables to starting values
	 */
	public void restart() {
		removeAll();
		score = 0;
		missed = 0;
		Bomb.exploded = false;
		init();
		run();
	}

	/**
	 * Method for removing apples
	 * 
	 */
	public void removeApples() {
		if(i != 100 && Apple.apples[i].getY() > getHeight()) {
			remove(Apple.apples[i]);
			if (i > 1) remove(Apple.apples[i - 1]);
			if (i > 2) remove(Apple.apples[i - 2]);
			if (i > 3) remove(Apple.apples[i - 3]);
			if (i > 4) remove(Apple.apples[i - 4]);
		}
	}
	
	/**
	 * ArrayList of thread of falling apples
	 * Is needed so that apples can fall together
	 */
	private ArrayList<Thread> threads = new ArrayList<Thread>();
	/**
	 * Basket that we catch apples with
	 */
	static Basket basket = new Basket("basket4.png");
	/**
	 * Variables for moving the object
	 */
	private GPoint last;
	private GObject obj;
	/**
	 * Variables for game
	 */
	static int score = 0, i = 0, missed = 0;
	/**
	 * GIF of explosion when user catches the Bomb
	 */
	GImage explosion = new GImage("explosion.gif");
}