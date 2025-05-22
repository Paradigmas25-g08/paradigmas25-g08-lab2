package subscription;

public final class Counter{
	private int value;
	private String name;

	public Counter(String name){
		this.value = 0;
		this.name = name;
	} 
	
	public String getName() {
		return name;
	}
	
	public void increment(){
		value = value + 1;
	}
	public void printValue(){
		System.out.println(value);
	}

	public static void main(String[] args) {
	Counter c1 = new Counter();
	Counter c2 = new Counter();
	
	c1.increment();
	c2.printValue();
	}	
}
