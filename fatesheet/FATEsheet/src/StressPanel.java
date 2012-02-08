import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class StressPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup phys,ment,soc;
	
	public StressPanel() {
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(g);
		
		
		c.gridwidth = 2;
		c.gridx =0;
		c.gridy = 0;
		c.ipadx = 5;
		c.ipady = 10;
		setBackground(TopSheet.settings.color2);
		
		JLabel title = new JLabel("Stress");
		//title.setFont(new Font("Courier New", Font.BOLD, 18));
		title.setFont(TopSheet.headerFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		//title.setVerticalAlignment(JLabel.TOP);
		add(title,c);
		
		//=================
	
		c.gridy =1; c.gridx=1;
		c.fill= GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		JPanel header = new JPanel();
		header.setVisible(true);
		header.setBackground(Color.WHITE);
		JLabel[] hd = new JLabel[9];
		for (int i=0; i<9; i++) {
			hd[i]= new JLabel(" "+String.valueOf(i)+" ");
			hd[i].setFont(new Font("Courier New",Font.BOLD,12));
			hd[i].setForeground(Color.BLACK);
			header.add(hd[i]);
		}
		add(header,c);
		//=================
		c.ipady=0;
		c.gridx =0;
		c.gridy =2;
		JLabel s5 = new JLabel("Physical");
		s5.setHorizontalAlignment(JLabel.CENTER);
		
		add(s5,c);
		
		c.gridx =1;
		JRadioButton[] jb = new JRadioButton[9];
		phys = new ButtonGroup();
		JPanel bp = new JPanel();
		bp.setVisible(true);
		bp.setBackground(Color.WHITE);
		for (int i=0; i<9; i++) {
			jb[i] = new JRadioButton();
			jb[i].setName(String.valueOf(i));
			jb[i].setBackground(Color.WHITE);
			phys.add(jb[i]);
			bp.add(jb[i]);		
		}
		add(bp,c);
			
		// ================
		
		c.gridy = 3; 
		c.gridx = 0;
		JLabel s4 = new JLabel("Mental");
		s4.setHorizontalAlignment(JLabel.CENTER);
		add(s4,c);
		
		c.gridx =1;
		JRadioButton[] jb2 = new JRadioButton[9];
		ment = new ButtonGroup();
		JPanel bp2 = new JPanel();
		bp2.setVisible(true);
		bp2.setBackground(Color.WHITE);
		for (int i=0; i<9; i++) {
			jb2[i] = new JRadioButton();
			jb2[i].setName(String.valueOf(i));
			jb2[i].setBackground(Color.WHITE);
			ment.add(jb2[i]);
			bp2.add(jb2[i]);		
		}
		add(bp2,c);
		
		//=================
		
		c.gridy = 4; c.gridx = 0;
		JLabel s3 = new JLabel("Social");
		s3.setHorizontalAlignment(JLabel.CENTER);
		add(s3,c);
		
		c.gridx =1;
		JRadioButton[] jb3 = new JRadioButton[9];
		soc = new ButtonGroup();
		JPanel bp3 = new JPanel();
		bp3.setVisible(true);
		bp3.setBackground(Color.WHITE);
		for (int i=0; i<9; i++) {
			jb3[i] = new JRadioButton();
			jb3[i].setName(String.valueOf(i));
			jb3[i].setBackground(Color.WHITE);
			soc.add(jb3[i]);
			bp3.add(jb3[i]);		
		}
		add(bp3,c);
		
		setVisible(true);
	}
	
	public ArrayList<Stress> get() {
		
		ArrayList<Stress> al = new ArrayList<Stress>();
		
		
		
		JRadioButton tmp = getSelection(phys);
		if (tmp != null) al.add(new Stress("physical",tmp.getName()));
		
		tmp = getSelection(ment);
		if (tmp != null) al.add(new Stress("mental",tmp.getName()));
		
		tmp = getSelection(soc);
		if (tmp != null) al.add(new Stress("social",tmp.getName()));
			
		return al;
		
	}
	
	public void set(ArrayList<Stress> al) {
		
		if (al == null) return;
		Iterator<Stress> it = al.iterator();		
		if (it.hasNext()) setSelection(phys,((Stress)(it.next())).get()); else setSelection(phys,"0");
		if (it.hasNext()) setSelection(ment,((Stress)(it.next())).get()); else setSelection(ment,"0");
		if (it.hasNext()) setSelection(soc,((Stress)(it.next())).get()); else setSelection(soc,"0");

	}
	
	
	// utility to get the current radio button from a group.
	// move to a utility class when there is one.
	public JRadioButton getSelection(ButtonGroup g) {
		for (Enumeration<AbstractButton> e=g.getElements(); e.hasMoreElements(); ) {
			JRadioButton b = (JRadioButton)e.nextElement();
			if(b.getModel() == g.getSelection()) {
				return b;
			}
		}
		return null;
	}
	
	public JRadioButton setSelection(ButtonGroup g, String val) {
		
		for (Enumeration<AbstractButton> e=g.getElements(); e.hasMoreElements(); ) {
			JRadioButton b = (JRadioButton)e.nextElement();
			if(b != null && b.getName().equals(val)) {
				b.setSelected(true);
				break;
			}
		}
		return null;
	}
}