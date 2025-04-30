package lab.music.entity;

public class DigitalMedia extends MusicMedia {
	private String format;
	
	public DigitalMedia(String title, String format) {
		super(title, "");
		this.format = format;
	}
	
	public DigitalMedia(String title, String artist, String format) {
		super(title, artist);
		this.format = format;		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(format + "������ " + super.getTitle() + "��(��) �����з� ����˴ϴ�.");
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("����: " + format);
	}
}
