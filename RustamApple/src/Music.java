

/**
 * This 
 * @author Rustam Talibzade - Date: 17 May 2018
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music {
	
	/**
	 * Initializes Music data
	 * @param sound - for selecting spesific sound
	 */
	public Music(String sound) {
		this.music = sound;
	}
	
	/**
	 * This method is for playing music
	 */
	public void playmusic() {
		try {
			FileInputStream fis = new FileInputStream(music);
			Player sound = new Player(fis);
			sound.play();
		} catch (FileNotFoundException e) {
		} catch (JavaLayerException e) {}
	}

	/**
	 * String for searching mp3 documents
	 */
	private String music;
}
