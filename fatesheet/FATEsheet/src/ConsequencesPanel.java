import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Iterator;



import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class ConsequencesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ConsequencesPanel() {
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(g);
		
		
		c.gridwidth = 4;
		c.gridx =0;
		c.gridy = 0;
		c.ipadx = 5;
		c.ipady = 10;
		setBackground(TopSheet.settings.color2);
		
		JLabel title = new JLabel("Consequences");
		//title.setFont(new Font("Courier New", Font.BOLD, 18));
		title.setFont(TopSheet.headerFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title,c);
		
		
		//=================
		c.gridwidth = 1;
		
		c.gridy++;
		
		c. gridx= 0;
		JLabel cr1 = new JLabel(" TYPE     ");
		cr1.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr1,c);
		
		c.ipady=0;
		c.gridx=1;
		JLabel cr2 = new JLabel(" P/M/S ");
		cr2.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr2,c);
		
		c.gridx=2;
		JLabel cr3 = new JLabel(" STRESS ");
		cr3.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr3,c);
		
		c.gridx=3;
		JLabel cr4 = new JLabel(" USED? ");
		cr4.setFont(new Font("Courier New",Font.BOLD,12));
		add (cr4,c);
		
		
		
		
		
		c.gridy++;
		conRow(c,"Mild","ANY","-2");
		c.gridy++;
		conRow(c,"Moderate","ANY","-4");
		c.gridy++;
		conRow(c,"Severe","ANY","-6");
		c.gridy++;
		conRow(c," "," "," ");
		c.gridy++;
		conRow(c," "," "," ");
		c.gridy++;
		conRow(c," "," "," ");
		c.gridy++;
		conRow(c,"Extreme"," ","-8");
		
		
		setVisible(true);
	}
	void conRow(GridBagConstraints c, String type,String pms,String stress) {
		c. gridx= 0;
		JLabel cr1 = new JLabel(type);
		c.anchor=GridBagConstraints.WEST;
		cr1.setHorizontalAlignment(JLabel.LEFT);
		add (cr1,c);
		
		c.anchor=GridBagConstraints.CENTER;
		c.gridx=1;
		JLabel cr2 = new JLabel(pms);
		add (cr2,c);
		
		c.gridx=2;
		JLabel cr3 = new JLabel(stress);
		add (cr3,c);
		
		c.gridx=3;
		JRadioButton b = new JRadioButton();
		add (b,c);
	}
	
public ArrayList<Consequence> get() {
		
		ArrayList<Consequence> al = new ArrayList<Consequence>();
		
		
		return al;
		
	}
	
	public void set(ArrayList<Consequence> al) {
		
		if (al == null) return;
		//Iterator<Consequence> it = al.iterator();		

	}
	
}