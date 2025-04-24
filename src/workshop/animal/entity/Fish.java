package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	private String name;
	
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
	
	public Fish() {
		super(0);
	}
	
	@Override
	public void eat() {
		System.out.println("¹°°í±â´Â »ç·á¸¦ ¸Ô½À´Ï´Ù.");
	}
	
	@Override
	public void walk() {
		super.walk();
	}
	
}
