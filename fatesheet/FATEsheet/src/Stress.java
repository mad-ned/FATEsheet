

public class Stress {
	protected String value = "";
	protected String type = "";
	
	public Stress(String t, String v) {	
		value = v;
		type = t;
	}

	public String get() {
		return value;
	}
	
	public String getType() {
		return type;
	}
}
