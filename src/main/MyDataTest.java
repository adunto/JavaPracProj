package main;

class MyData {
	int day;
	int month;
	int year;

	public MyData() {
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}

	public MyData(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// getter
	public void getData() {
		System.out.println(this.year + " / " + this.month + " / " + this.day);
	}
	
	// day setter
	public boolean setDay(int day) {
		if (day > 0 && day < 32) {
			this.day = day;
			return true;
		}
		else {
			return false;
		}
	}
}

public class MyDataTest {
	public static void main(String[] args) {
		MyData data1 = new MyData();
		data1.setDay(12);
		MyData data2 = new MyData(29, 10, 1999);

		data1.getData();
		data2.getData();
	}
}
