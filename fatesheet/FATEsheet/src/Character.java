

import java.util.ArrayList;




public class Character {

	public String name = "";
	public String player = "";
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	public ArrayList<Aspect> aspects = new ArrayList<Aspect>();
	public ArrayList<Stress> stresses = new ArrayList<Stress>();
	public ArrayList<Stunt> stunts = new ArrayList<Stunt>();
	public ArrayList<Stat> stats = new ArrayList<Stat>();
	public Character () {
		
	}
	
	// construct a character from a supplied char sheet.
	public Character (TopSheet s) {
		if (s.charName != null)      name = s.charName.get();
		if (s.playerName != null)	 player = s.playerName.get();
		if (s.skills != null)        skills = s.skills.get();
		if (s.aspect != null)        aspects = s.aspect.get();
		if (s.stress != null)		 stresses = s.stress.get();
		if (s.stunts != null)		 stunts = s.stunts.get();
		if (s.fate != null)          stats = s.fate.get();
	}
	
	// populate a character sheet fields from this character object
	public void populateSheet(TopSheet s) {
		s.charName.set(name);
		s.playerName.set(player);
		s.skills.set(skills);
		s.aspect.set(aspects);
		s.stress.set(stresses);
		s.stunts.set(stunts);
		s.fate.set(stats);
	}
}
