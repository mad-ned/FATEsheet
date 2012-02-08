

public class Skill {
	protected String name = "";
	protected int cost = 0;
	
	public Skill(String n, int c) {	
		name = n;
		cost = c;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String getName() {
		return name;
	}
}
