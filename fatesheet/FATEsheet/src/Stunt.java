

public class Stunt {
	protected String name = "";
	protected int cost = 0;
	
	public Stunt(String n, int c) {	
		name = n;
		cost = c;
	}

	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
}
