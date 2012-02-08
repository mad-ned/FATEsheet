import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SimpleEntry extends JPanel  {
	
	public JTextField e;
	public String value = "";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleEntry() {
		System.out.println("running default constructor");
		//e = new JTextField();
		//super();
	}
	
	public SimpleEntry(String name, int size, boolean rightJustify) {
		
		JLabel l = new JLabel(name);
		l.setForeground(Color.BLACK);
		
		if (rightJustify)
			add(l,BorderLayout.EAST);
		else
			add(l,BorderLayout.CENTER);
		e = new JTextField(size);
		e.setText(value);
		e.setHorizontalAlignment(JTextField.CENTER);
		
		add(e,BorderLayout.EAST);
		setBackground(TopSheet.settings.color2);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		setVisible(true);
	}
	
	public void sete(JTextField newe) {
		e = newe;
	}
	
	public String get() {
		if (e != null)
			return e.getText();
		else
			return "";
	}
	
	public int getInt() {
		int ret = 0;
		if (e != null) {
			try {
				ret = Integer.parseInt(e.getText());
			} catch (Exception ie) {
			}
		}
		return ret;
	}
	
	public void clear() {
		e.setText("");
		value = "";
	}
	
	public void set(String val) {
		if (e != null)
			e.setText(val);
	}
	
	public void set(int val) {
		if (e != null)
			e.setText(String.valueOf(val));
	}
	
	public void refresh() {
		e.setText(value);
	}
	public void commit() {
		value = e.getText();
	}
}
