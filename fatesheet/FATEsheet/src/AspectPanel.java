import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;



public class AspectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int TEXT_LEN = 25;
	private final int NUM_OTHERS =5;
	protected JTextField highConcept,trouble,otherAspects[];
	public AspectPanel() {
	
		//setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(TopSheet.settings.color2);
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.gridx =0;
		c.gridy =0;
		setLayout(g);
		
		JLabel title = new JLabel("Aspects");
		//title.setFont(new Font("Courier New", Font.BOLD, 18));
		title.setFont(TopSheet.headerFont);
		title.setBackground(Color.WHITE);
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title,c);
		c.gridy++;
		
		JLabel hcLabel = new JLabel("High Concept");
		hcLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		hcLabel.setHorizontalAlignment(JLabel.CENTER);
		add(hcLabel,c);
		c.gridy++;
		
		highConcept = new JTextField(TEXT_LEN);
		highConcept.setHorizontalAlignment(JTextField.CENTER);
		add(highConcept,c);
		c.gridy++;
		
		JLabel trLabel = new JLabel("Trouble");
		trLabel.setHorizontalAlignment(JLabel.CENTER);
		trLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		add(trLabel,c);
		c.gridy++;
		
		trouble = new JTextField(TEXT_LEN);
		trouble.setHorizontalAlignment(JTextField.CENTER);
		add(trouble,c);
		c.gridy++;
		
		JLabel otLabel = new JLabel("Other Aspects");
		otLabel.setHorizontalAlignment(JLabel.CENTER);
		otLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		add(otLabel,c);
		c.gridy++;
		
		otherAspects = new JTextField[NUM_OTHERS];
		for (int i=0; i<NUM_OTHERS; i++) {
			otherAspects[i] = new JTextField(TEXT_LEN);
			otherAspects[i].setHorizontalAlignment(JLabel.CENTER);
			add(otherAspects[i],c);
			c.gridy++;
		}
		
		setVisible(true);
	}
	
	public ArrayList<Aspect> get() {
		
		ArrayList<Aspect> al = new ArrayList<Aspect>();
		
		al.add(new Aspect(highConcept.getText()));
		al.add(new Aspect(trouble.getText()));
		
		for (int i=0; i<NUM_OTHERS; i++) {
			al.add(new Aspect(otherAspects[i].getText()));
		}
		
		return al;
		
	}
	
	public void set(ArrayList<Aspect> al) {
		
		if (al == null) return;
		
		Iterator<Aspect> it = al.iterator();
		if (it.hasNext()) highConcept.setText(((Aspect)(it.next())).getName()); else highConcept.setText("");
		if (it.hasNext()) trouble.setText(((Aspect)(it.next())).getName()); else trouble.setText("");
		
		for (int i=0; i<NUM_OTHERS; i++) {
			if (it.hasNext()) otherAspects[i].setText(((Aspect)(it.next())).getName()); else otherAspects[i].setText("");
		}
	}
}
