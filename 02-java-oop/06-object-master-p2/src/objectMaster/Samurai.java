package objectMaster;

public class Samurai extends Human {
	
	public static int numOfSamurai = 0;
	
	public Samurai() {
		this.health = 200;
		numOfSamurai++;
	}
	public void deathBlow(Human victim) {
		System.out.println("Samurai's health is " + this.health + " before attack");
		System.out.println("Victim's health is " + victim.health + " before attack");
		this.health = this.health / 2;
		System.out.println("Samurai's health has decreased by half and is now " + this.health);
		victim.health = 0;
		System.out.println("Victim's health is now " + victim.health + " RIP");
	}
	public void meditate() {
		System.out.println("Samurai's health is " + this.health + " before meditating");
		int heal = this.health / 2;
		this.health += heal;
		System.out.println("Samurai's health is now " + this.health + " after meditating");
	}
	public int howMany() {
		System.out.println("There are " + numOfSamurai + " Samurai lurking about");
		return numOfSamurai;
		
	}

}
