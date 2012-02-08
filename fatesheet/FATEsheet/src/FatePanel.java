import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FatePanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	public SimpleEntry cr1,cr2,cr3,cr4,cr5,cr6,cr7,cr8;
	public JButton plus,minus,ref;
	
	public FatePanel() {
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(g);
			
		c.gridwidth = 2;
		c.gridx =0;
		c.gridy = 0;
		c.ipadx = 5;
		c.ipady = 10;
		c.fill= GridBagConstraints.HORIZONTAL;
		setBackground(TopSheet.settings.color2);
		
		JLabel title = new JLabel("Other Stats");
		//title.setFont(new Font("Courier New", Font.BOLD, 18));
		title.setFont(TopSheet.headerFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title,c);
			
		//=================
		c.gridwidth = 1;
		
		c.gridy++;
		
		c. gridx= 0;
		cr1 = new SimpleEntry("Power Level",15,false);
		cr1.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr1,c);
		
		
		c.gridwidth = 1;
		c.gridx=1;
		c.anchor=GridBagConstraints.EAST;
		
		cr2 = new SimpleEntry("Skill Cap",5,false);
		cr2.setFont(new Font("Courier New",Font.BOLD,12));

		add (cr2,c);
		
		c.ipady=0;
		c.gridy++;
		c.gridx=0;
		cr3 = new SimpleEntry("Skill Points Spent",5,false);
		cr2.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr3,c);
		
		c.gridx=1; 
		cr4 = new SimpleEntry("Total Skill Points",5,false);
		cr4.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr4,c);
		
		c.gridy++; c.gridx=0;
		cr5 = new SimpleEntry("Base Refresh",5,false);
		cr2.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr5,c);
		
		c.gridx=1; 
		cr6 = new SimpleEntry("Adjusted Refresh",5,false);
		cr6.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr6,c);
		
		c.gridy++; c.gridx=0;
		cr7 = new SimpleEntry("Last Session FP",5,false);
		cr7.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr7,c);
		
		c.gridx=1; 
		cr8 = new SimpleEntry("Current FP",5,false);
		cr8.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr8,c);
		
		c.gridx=0;
		c.gridy++;
		c.gridwidth=2;
		JPanel bf = new JPanel();
		bf.setBackground(TopSheet.settings.color2);
		JLabel l = new JLabel("Adjust FP:");
		plus = new JButton(" + ");
		plus.setBackground(TopSheet.settings.color1);
		plus.setBorder(BorderFactory.createRaisedBevelBorder());
		minus = new JButton(" - ");
		minus.setBackground(TopSheet.settings.color1);
		minus.setBorder(BorderFactory.createRaisedBevelBorder());
		ref = new JButton("Refresh");
		ref.setBackground(TopSheet.settings.color1);
		ref.setBorder(BorderFactory.createRaisedBevelBorder());
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		ref.addActionListener(this);
		
		bf.add(l);
		bf.add(plus);
		bf.add(minus);
		bf.add(ref);
		bf.setVisible(true);
		add(bf,c);
		
		setVisible(true);
	}
	
	public ArrayList<Stat> get() {
			
		ArrayList<Stat> al = new ArrayList<Stat>();
			
		al.add(new Stat("Power Level",cr1.get()));
		al.add(new Stat("Skill Cap",cr2.getInt()));
		al.add(new Stat("Skill Points",cr3.getInt()));
		al.add(new Stat("Total Skill",cr4.getInt()));
		al.add(new Stat("Base Refresh",cr5.getInt()));
		al.add(new Stat("Adj Refresh",cr6.getInt()));
		al.add(new Stat("Last FP",cr7.getInt()));
		al.add(new Stat("Current FP",cr8.getInt()));
			
		return al;
		
	}
	
	public void set(ArrayList<Stat> al) {
		
		if (al == null) return;
		
		Iterator<Stat> it = al.iterator();
		if (it.hasNext()) cr1.set(((Stat)(it.next())).getstr()); else cr1.clear();
		if (it.hasNext()) cr2.set(((Stat)(it.next())).get()); else cr2.clear();
		if (it.hasNext()) cr3.set(((Stat)(it.next())).get()); else cr3.clear();
		if (it.hasNext()) cr4.set(((Stat)(it.next())).get()); else cr4.clear();
		if (it.hasNext()) cr5.set(((Stat)(it.next())).get()); else cr5.clear();
		if (it.hasNext()) cr6.set(((Stat)(it.next())).get()); else cr6.clear();
		if (it.hasNext()) cr7.set(((Stat)(it.next())).get()); else cr7.clear();
		if (it.hasNext()) cr8.set(((Stat)(it.next())).get()); else cr8.clear();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == plus) {
			adjustFP(1);
		} else if (e.getSource() == minus) {
			adjustFP(-1);
		} else if (e.getSource() == ref) {
			refreshFP();
		}
	}
	
	public void adjustFP(int val) {
		int curFP = cr8.getInt();
		curFP += val;
		
		if (curFP >= 0)
			cr8.set(curFP);
	}
	
	public void refreshFP() {
		int newFP = cr6.getInt();
		cr8.set(newFP);
	}
	
}