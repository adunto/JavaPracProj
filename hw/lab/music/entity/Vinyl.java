package lab.music.entity;

public class Vinyl extends MusicMedia {
	
	private int rpm;
	
	public Vinyl(String title, String artist, int rpm) {
		super(title, artist);
		this.rpm = rpm;
	}
	
	@Override
	public void play() {
		System.out.println("���̴� ���ڵ� '"+ super.getTitle() + "'��(��) " + rpm + "rpm���� ����˴ϴ�.");
	}
	
	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		super.displayInfo();
		System.out.println("ȸ�� �ӵ�: " + rpm + "rpm");
	}
	
	public void clean() {
		System.out.println("���̴� ���ڵ带 û���մϴ�.");
	}
}
