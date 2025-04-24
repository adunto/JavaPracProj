package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	private String name;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void play() {
		System.out.println(name + "(��)�� ���");
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public Fish() {
		super(0);
	}
	
	@Override
	public void eat() {
		System.out.println("������ ��Ḧ �Խ��ϴ�.");
	}
	
	@Override
	public void walk() {
		super.walk();
	}
	
}
