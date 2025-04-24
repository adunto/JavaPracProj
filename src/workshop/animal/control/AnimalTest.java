package workshop.animal.control;
import workshop.animal.entity.*;

public class AnimalTest {
	
	public static void main(String[] args) {
		Fish d = new Fish();
		Cat c = new Cat("Fluffy");
		d.setName("´Ï¸ð");
		
		System.out.println(d.getName());
		System.out.println(c.getName());
		d.eat();
		c.eat();
		c.play();
		
		Animal a = new Fish();
		Animal e = new Spider();
		
		a.eat();
		e.walk();
	}
}
