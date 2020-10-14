package zookeeper1;

public class Bat extends Mammal {
	

	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("Whoosh *flying sounds*");
		this.energyLevel -= 50;
		this.displayEnergy();
	}
	public void eatHumans() {
		System.out.println("(Human screams in terror)");
		this.energyLevel += 25;
		this.displayEnergy();
	}
	public void attackTown() {
		System.out.println("(More screams of terror) Crackle, pop, sizzle");
		this.energyLevel -= 100;
		this.displayEnergy();
	}

}
