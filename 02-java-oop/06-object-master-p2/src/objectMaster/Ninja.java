package objectMaster;

public class Ninja extends Human {
	
	public Ninja() {
		this.stealth = 10;
	}
	public void steal(Human victim) {
		System.out.println("the victim's starting health is " + victim.getHealth());
		System.out.println("Ninja's starting health is " + this.getHealth());
		int attack = this.stealth;
		victim.health -= attack;
		System.out.println("Victim's health reduced by " + attack);
		System.out.println(victim.getHealth());
		this.health += attack;
		System.out.println("Ninja's health increased by " + attack);
		System.out.println(this.getHealth());
		
	}
	public void runAway() {
		this.health -= 10;
	}

}
