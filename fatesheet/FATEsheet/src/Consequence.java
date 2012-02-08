

public class Consequence {
	protected String type = "";
	protected String pms = "";
	protected int stress = 0;
	protected boolean used = false;
	
	public Consequence(String t, String p, int s) {	
		type =t;
		pms = p;
		stress = s;
		used = false;
	}

	public String getType() {
		return type;
	}
	
	public String getPMS() {
		return pms;
	}
	public int getStress() {
		return stress;
	}
	public boolean used() {
		return used;
	}
}
