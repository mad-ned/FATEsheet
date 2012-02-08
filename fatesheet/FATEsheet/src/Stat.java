


// numeric stats
public class Stat {
	protected int value = 0;
	protected String strvalue = "";
	protected String name = "";
	
	public Stat(String n, int v) {	
		value = v;
		name = n;
	}

	public Stat(String n, String v) {
		strvalue = v;
		name = n;
	}

	public int get() {
		return value;
	}
	
	public String getstr() {
		return strvalue;
	}
	
	public String getType() {
		return name;
	}
}
