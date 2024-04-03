

/**
 * This class is created for basket that will collect apples
 * @author Rustam Talibzade - Date: 17 May 2018
 */

import acm.graphics.GImage;

public class Basket extends GImage{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Initializes Basket data
	 * @param arg0 - image of Basket
	 */
	public Basket(String arg0) {
		super(arg0);
		setSize(SIZE + 50, SIZE);
	}

	/**
	 * The size of the basket
	 */
	private final static double SIZE = 100;
}
