package zookeeper1;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		energyLevel = energyLevel - 5;
		System.out.println("Gorilla has thrown something");
		
	}
	public void eatBananas() {
		energyLevel = energyLevel + 10;
		System.out.println("Gorilla is happy");
	}
	public void climb() {
		energyLevel = energyLevel - 10;
		System.out.println("Gorilla has climbed a tree");
		
	}

}
