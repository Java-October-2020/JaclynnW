package zookeeper1;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla g = new Gorilla();
		Gorilla f = new Gorilla();
		
		g.displayEnergy();
		
		g.throwSomething();
		g.displayEnergy();
		g.throwSomething();
		g.displayEnergy();
		g.eatBananas();
		g.throwSomething();
		g.climb();
		

		System.out.println("G energy level is " + g.displayEnergy());
		System.out.println("F energy level is " + f.displayEnergy());
		

	}

}
