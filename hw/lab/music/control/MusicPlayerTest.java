package lab.music.control;

import lab.music.entity.*;

public class MusicPlayerTest {
	
	public static void main(String[] args) {
		MP3 mp3 = new MP3("Dynamite", "BTS", 5);
		
		System.out.println("--- MP3 �׽�Ʈ ---");
		mp3.displayInfo();
		mp3.play();
		mp3.setVolume(8);
		mp3.stop();
		
		
		Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
		
		System.out.println("\n--- Vinyl �׽�Ʈ ---");
		vinyl.displayInfo();
		vinyl.play();
		vinyl.clean();
		
		
		System.out.println("\n--- ������ �׽�Ʈ ---");
		DigitalMedia m1 = new MP3("Butter", "BTS", 4);
		m1.displayInfo();
		m1.play();
		
		
		System.out.println("\n--- ĳ���� �׽�Ʈ ---");
		((MP3)m1).setVolume(3);
		((MP3)m1).setVolume(7);
		((MP3)m1).stop();
		
		
		
	}
}
