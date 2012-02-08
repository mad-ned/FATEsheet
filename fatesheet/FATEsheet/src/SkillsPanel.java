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


public class SkillsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField s5val,s4val,s3val,s2val,s1val;
	private final int TEXT_LEN = 25;
	public SkillsPanel() {
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(g);
		
		
		c.gridwidth = 2;
		c.gridx =0;
		c.gridy = 0;
		c.ipadx = 5;
		c.insets = new Insets(5,5,5,5);
		setBackground(TopSheet.settings.color2);
		
		JLabel title = new JLabel("Skills");
		//title.setFont(new Font("Courier New", Font.BOLD, 18));
		title.setFont(TopSheet.headerFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title,c);
		
		//=================
		
		c.gridwidth = 1;
		c.gridy =1;
		c.anchor=GridBagConstraints.EAST;
		JLabel s5 = new JLabel("Superb (+5)");
		s5.setHorizontalAlignment(JLabel.CENTER);
		add(s5,c);
		
		c.gridx =1;
		c.anchor=GridBagConstraints.CENTER;
		s5val = new JTextField(TEXT_LEN);
		//s5val.setSize(s5val.getSize().width, 200);
		
		s5val.setHorizontalAlignment(JTextField.CENTER);
		add(s5val,c);
		
		// ================
		
		c.gridy = 2; c.gridx = 0;
		JLabel s4 = new JLabel("Great (+4)");
		c.anchor=GridBagConstraints.EAST;
		s4.setHorizontalAlignment(JLabel.CENTER);
		add(s4,c);
		
		c.gridx=1;
		c.anchor=GridBagConstraints.CENTER;
		s4val = new JTextField(TEXT_LEN);
		s4val.setHorizontalAlignment(JTextField.CENTER);
		add(s4val,c);
		
		//=================
		
		c.gridy = 3; c.gridx = 0;
		c.anchor=GridBagConstraints.EAST;
		JLabel s3 = new JLabel("Good (+3)");
		s3.setHorizontalAlignment(JLabel.CENTER);
		add(s3,c);
		
		c.gridx=1;
		c.anchor=GridBagConstraints.CENTER;
		s3val = new JTextField(TEXT_LEN);
		s3val.setHorizontalAlignment(JTextField.CENTER);
		add(s3val,c);
		//=================
		c.gridy = 4; c.gridx = 0;
		c.anchor=GridBagConstraints.EAST;
		JLabel s2 = new JLabel("Fair (+2)");
		s2.setHorizontalAlignment(JLabel.CENTER);
		add(s2,c);
		
		c.gridx=1;
		c.anchor=GridBagConstraints.CENTER;
		s2val = new JTextField(TEXT_LEN);
		s2val.setHorizontalAlignment(JTextField.CENTER);
		add(s2val,c);
		//=================
		c.gridy = 5; c.gridx = 0;
		c.anchor=GridBagConstraints.EAST;
		JLabel s1 = new JLabel("Average (+1)");
		s1.setHorizontalAlignment(JLabel.CENTER);
		add(s1,c);
		
		c.gridx=1;
		c.anchor=GridBagConstraints.CENTER;
		s1val = new JTextField(TEXT_LEN);
		s1val.setHorizontalAlignment(JTextField.CENTER);
		add(s1val,c);
		
		setVisible(true);
	}
	
	public ArrayList<Skill> get() {
		
		ArrayList<Skill> al = new ArrayList<Skill>();
		al.add(new Skill(s5val.getText(),5));
		al.add(new Skill(s4val.getText(),4));
		al.add(new Skill(s3val.getText(),3));
		al.add(new Skill(s2val.getText(),2));
		al.add(new Skill(s1val.getText(),1));
		return al;
		
	}
	
	public void set(ArrayList<Skill> al) {
		
		if (al == null) return;
		
		Iterator<Skill> it = al.iterator();
		
		if (it.hasNext()) s5val.setText(((Skill)(it.next())).getName()); else s5val.setText("");
		if (it.hasNext()) s4val.setText(((Skill)(it.next())).getName()); else s4val.setText("");
		if (it.hasNext()) s3val.setText(((Skill)(it.next())).getName()); else s3val.setText("");
		if (it.hasNext()) s2val.setText(((Skill)(it.next())).getName()); else s2val.setText("");
		if (it.hasNext()) s1val.setText(((Skill)(it.next())).getName()); else s1val.setText("");
		
	}
}