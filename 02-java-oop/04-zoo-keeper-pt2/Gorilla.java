package zookeeper1;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		this.energyLevel -=5;
		this.displayEnergy();
		System.out.println("Gorilla has thrown something");
		
	}
	public void eatBananas() {
		this.energyLevel += 10;
		this.displayEnergy();
		System.out.println("Gorilla is happy");
	}
	public void climb() {
		this.energyLevel -=10;
		this.displayEnergy();
		System.out.println("Gorilla has climbed a tree");
		
	}

}
