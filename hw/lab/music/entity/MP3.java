package lab.music.entity;

public class MP3 extends DigitalMedia implements Playable {
	private int fileSize;
	private int volume;

	public MP3(String title) {
		super(title, "MP3");
		this.fileSize = 0;
		this.volume = 5;
	}

	public MP3(String title, String artist, int fileSize) {
		super(title, artist, "MP3");
		this.fileSize = fileSize;
		this.volume = 5;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		super.play();
		System.out.println("���� ����: " + volume);
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("���� ũ��: " + fileSize + "MB");
		
	}

	@Override
	public void setVolume(int level) {
		if (level >= 0 && level <= 10) {
			System.out.println("������ " + level + "�� �����Ǿ����ϴ�.");
			this.volume = level;
			play();
		}
		else {
			System.out.println("������ ����");
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("MP3 ����� �����Ǿ����ϴ�.");
	}
}
