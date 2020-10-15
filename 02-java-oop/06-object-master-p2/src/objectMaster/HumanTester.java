package objectMaster;

public class HumanTester {

	public static void main(String[] args) {
		Human lady = new Human();
		Human man = new Human();
		Wizard merlin = new Wizard();
		Ninja jackie = new Ninja();
		Samurai tomCruise = new Samurai();
		Samurai oldMan = new Samurai();
		
		
		man.attack(lady);
		lady.getHealth();
		
		merlin.fireball(man);
		System.out.println(man.health);
		
		jackie.steal(lady);
		System.out.println(jackie.stealth);
		
		tomCruise.deathBlow(merlin);
		tomCruise.meditate();
		
		oldMan.howMany();

	}

}
