package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	private String name;
	
	@Override
	public void eat() {
		System.out.println("°í¾çÀÌ´Â »ç·á¿Í Ãò¸£¸¦ ¸Ô½À´Ï´Ù.");
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void play() {
		System.out.println(name + "(ÀÌ)¶û ³î±â");
	}
	@Override
	public void setName(String name) {
		this.name = name;		
	}
	public Cat() {
		super(4);
	}
	public Cat(String name) {
		super(4);
		setName(name);
	}
	@Override
	public void walk() {
		super.walk();
	}
}
