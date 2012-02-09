import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;



public class StuntsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int NUM_STUNTS = 8;
	
	private JTextField[] stunts = new JTextField[NUM_STUNTS];
	private JTextField[] costs = new JTextField[NUM_STUNTS];
	public StuntsPanel() {
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(g);
		
		c.gridwidth = 2;
		c.gridx =0;
		c.gridy = 0;
		c.ipadx = 5;
		c.ipady = 0;
		c.insets = new Insets(5,1,5,1);
		setBackground(TopSheet.settings.color2);
		
		JLabel title = new JLabel("Stunts and Powers");
		//title.setFont(new Font("Courier New", Font.BOLD, 18));
		title.setFont(TopSheet.headerFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title,c);
		
		//=================
		
		c.gridwidth = 1;
		c.gridy =1;
		c.anchor=GridBagConstraints.WEST;
		JLabel s5 = new JLabel("Cost");
		s5.setHorizontalAlignment(JLabel.CENTER);
		add(s5,c);
		
		c.gridx =1;
		c.anchor=GridBagConstraints.CENTER;
		JLabel s6 = new JLabel("Ability");
		s6.setHorizontalAlignment(JLabel.CENTER);
		add(s6,c);
		
		c.gridy++;
		for (int i=0; i<NUM_STUNTS; i++){
			c.gridx=0;
			c.anchor=GridBagConstraints.WEST;
			costs[i] = new JTextField(2);
			costs[i].setHorizontalAlignment(JTextField.CENTER);
			add(costs[i],c);
			
			c.gridx=1;
			c.anchor=GridBagConstraints.CENTER;
			stunts[i] = new JTextField(25);
			stunts[i].setHorizontalAlignment(JTextField.CENTER);
			add(stunts[i],c);
			c.gridy++;
		}
		
		setVisible(true);
	}
	
	public ArrayList<Stunt> get() {
		
		ArrayList<Stunt> al = new ArrayList<Stunt>();
		int cost = 0;
		for (int i=0; i<NUM_STUNTS; i++) {
			String name = stunts[i].getText();
			try {
				cost = Integer.parseInt(costs[i].getText());
			} catch (Exception e) {
				cost = 0;
			}
			al.add(new Stunt(name,cost));
		}
		return al;
	}
	
	public void set(ArrayList<Stunt> al) {
		
		if (al == null) return;
 		Iterator<Stunt> it = al.iterator();
		for (int i=0; i<NUM_STUNTS; i++) {
			if (it.hasNext()) {
				Stunt tmp = (Stunt)it.next();
				int cost = tmp.getCost();			
				stunts[i].setText(tmp.getName());
				if (cost != 0) 
					costs[i].setText(String.valueOf(tmp.getCost()));
				
			} else {
				stunts[i].setText("");
				costs[i].setText("");
			}
		}
		
	}
}