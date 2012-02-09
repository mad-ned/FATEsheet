import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;



import com.thoughtworks.xstream.XStream;


public class TopSheet extends JFrame implements ActionListener,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem newsheet, fastsave,save,load,color1, color2, exit;
	public SimpleEntry charName = null;
	public SimpleEntry playerName = null;
	public SkillsPanel skills;
	public AspectPanel aspect;
	public StressPanel stress;
	public StuntsPanel stunts;
	public FatePanel fate;
	static public Settings settings;
	
	public static int COLOR1 = 0xFFF37D;
	public static int COLOR2 = 0xFFF9B8;
	public static int COLOR3 = 0xfff69e;
	
	private String titleFontName="TopSecret.ttf";
	public static Font titleFont;
	private String headerFontName="ImpactLabel.ttf";
	public static Font headerFont;
	
	private Character character;
	private String saveFile = "";
	/**
	 * @param args
	 */
	
	public TopSheet(String name) {
		super(name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TopSheet t = new TopSheet("Dresden Files Character Sheet");
		t.createMenu();
		t.init();	
		t.addWindowListener(new WindowAdapter(){	
			public void windowClosing(WindowEvent e){		
				System.exit(0);
			}
		});
	}
	// initialize the sheet
	public void init() {
		
		loadFonts();
		loadSettings();
		buildForm();
		
		if (settings.lastFileName != "") {
			loadCharacter(settings.lastFileName);
			saveFile = settings.lastFileName;
			settings.lastFileName = settings.lastFileName;
			setTitle("Dresden Files Character Sheet - "+saveFile);
			fastsave.setEnabled(true);
		}
	}
	
	private void buildForm() {
		int row = 0;
		Container f = this.getContentPane();
	
		setLayout(new GridBagLayout());
		f.setBackground(settings.color1);

		GridBagConstraints c = new GridBagConstraints();
		
		c.ipadx = 15;
		c.ipady = 15;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5,10,5,10);
		//  TITLE		
		c.gridx = 0;
		c.gridy = row++;
		c.gridwidth = 2;
		
		JLabel title = new JLabel("Dresden Files Character Sheet");
		//title.setFont(new Font("Lucida Sans Regular", Font.BOLD, 25));
		title.setFont(titleFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		f.add(title,c);
		
		// NAME AND CHAR
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = row;
		charName = new SimpleEntry("Name",20,true);
		f.add(charName,c);
		
		c.gridx = 1;
		c.gridy = row++;
		playerName = new SimpleEntry("Player",20,true);
		f.add(playerName,c);
		
		// ASPECT PANEL
		c.gridx = 0;
		c.gridy = row;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 10;
		
		aspect = new AspectPanel();
		f.add(aspect,c);
		
		
		// SKILLS PANEL
		c.gridx =1;
		c.gridy = row;
		c.gridheight = 5;
		skills = new SkillsPanel();
		f.add(skills,c);
		
		// STRESS PANEL
		c.gridx = 0; c.gridy = row+10;
		stress = new StressPanel();
		f.add(stress,c);
			
		//CONSEQUENCES PANEL
		c.gridx = 0; c.gridy=row+15;
		ConsequencesPanel consequences = new ConsequencesPanel();
		f.add(consequences,c);
		
		// STUNTS PANEL
		c.gridx = 1;
		c.gridy = 7;
		c.gridheight = 10;
		stunts = new StuntsPanel();
		f.add(stunts,c);
		
		//FATE PANEL
		c.gridy = 18;
		fate = new FatePanel();
		f.add(fate,c);
		
		//setBackground(new Color(0,0,0,Color.TRANSLUCENT));
		// ==========================
		pack();
		setVisible(true);
	}
	
	public void oldpaint(Graphics g) {
		
		Image img= null;
		try {
			img = ImageIO.read(new File("background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (img != null)
			g.drawImage(img,0,0,null);
		charName.repaint();
		//super.paint(g);
	}
	
	// create a top menu
	void createMenu() {
		JMenuBar m = new JMenuBar();
		JMenu f = new JMenu("File");
		newsheet = new JMenuItem("New");
		newsheet.addActionListener(this);
		newsheet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		f.add(newsheet);
		
		load = new JMenuItem("Load...");
		load.addActionListener(this);
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		f.add(load);
		
		fastsave = new JMenuItem("Save");
		fastsave.setEnabled(false);
		fastsave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fastsave.addActionListener(this);
		f.add(fastsave);
		
		save = new JMenuItem("Save As...");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		f.add(save);
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		f.add(exit);
		m.add(f);
		
		JMenu s = new JMenu("Settings");
		color1 = new JMenuItem("Set Background Color");
		color1.addActionListener(this);
		s.add(color1);
		
		color2 = new JMenuItem("Set Panel Color");
		color2.addActionListener(this);
		s.add(color2);
		
		m.add(s);
		
		
		setJMenuBar(m);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == newsheet) {
			character = new Character();
			character.populateSheet(this);
			fastsave.setEnabled(false);
			saveFile = "";
			setTitle("Dresden Files Character Sheet");
			
		} else if (e.getSource() == save) {
			FateFileFilter ff = new FateFileFilter();
			final JFileChooser fc = new JFileChooser();
			fc.setFileFilter(ff);
			int fcStat = fc.showSaveDialog(this);
			
			if (fcStat == JFileChooser.APPROVE_OPTION) {
				String fname = fc.getSelectedFile().getAbsolutePath();
				saveFile = fname;
				setTitle("Dresden Files Character Sheet - "+saveFile);
				fastsave.setEnabled(true);
				saveCharacter(fname);
				settings.lastFileName = fname;
			}
			System.out.println("Saved!");
			
		} else if (e.getSource() == fastsave) {
			saveCharacter(saveFile);
			System.out.println("Saved!");
			
		} else if (e.getSource() == load) {
			FateFileFilter ff = new FateFileFilter();
			final JFileChooser fc = new JFileChooser();
			fc.setFileFilter(ff);
			int fcStat = fc.showOpenDialog(this);
			
			if (fcStat == JFileChooser.APPROVE_OPTION) {
				String fname = fc.getSelectedFile().getAbsolutePath();
				loadCharacter(fname);
				saveFile = fname;
				settings.lastFileName = fname;
				setTitle("Dresden Files Character Sheet - "+saveFile);
				fastsave.setEnabled(true);
			}
		} else if (e.getSource() == color1 ) {
			//System.out.println("color chooser");
			Color newColor = JColorChooser.showDialog(
                    this,
                    "Choose Background Color 1",
                    settings.color1);
			settings.color1 = new Color(newColor.getRGB());
			saveSettings();
			this.getContentPane().removeAll();
			init();
			this.getContentPane().repaint();
			
		} else if (e.getSource() == color2 ) {	
			Color newColor2 = JColorChooser.showDialog(
                    this,
                    "Choose Background Color 2",
                    settings.color2);
			settings.color2 = new Color(newColor2.getRGB());
			saveSettings();
			this.getContentPane().removeAll();
			init();
			this.getContentPane().repaint();
			
		} else if (e.getSource() == exit) {
			saveSettings();
			System.out.println("exit");
			System.exit(0);
		}
	}
	
	public void loadSettings() {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));	  
		XStream x = new XStream();
			  
		try {
			BufferedInputStream s =
			        new BufferedInputStream(
			            new FileInputStream("fatesheet.settings"));
				 
			settings = (Settings)x.fromXML(s);
			s.close();
		
		} catch (IOException ie) {
			//ie.printStackTrace();
			settings = new Settings();
		}
		 setCursor(Cursor.getDefaultCursor());
	}
	
	public void saveSettings() {
		XStream x = new XStream();
	
		try {
			BufferedOutputStream s = 
					new BufferedOutputStream(
		            new FileOutputStream("fatesheet.settings"));
	
			x.toXML(settings,s);
			s.close();
		} catch (IOException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
	}
	
	public void loadCharacter(String fname) {
		// Setting cursor for any Component:
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));	  
		XStream x = new XStream();
			  
		try {
			BufferedInputStream s =
			        new BufferedInputStream(
			            new FileInputStream(fname));
				 
			character = (Character)x.fromXML(s);
			character.populateSheet(this);
			
			s.close();
		
		} catch (IOException ie) {
			//ie.printStackTrace();
			System.out.println("Character sheet not found: "+fname);
		}
		 setCursor(Cursor.getDefaultCursor());
	}
	
	public void saveCharacter(String fname) {
		
		XStream x = new XStream();
		character = new Character(this);
	
		try {
			BufferedOutputStream s = 
					new BufferedOutputStream(
		            new FileOutputStream(fname));
	
			x.toXML(character,s);
			s.close();
		} catch (IOException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
	}
	
	private void loadFonts() {
		try
        {
            titleFont = Font.createFont(Font.TRUETYPE_FONT, new File(titleFontName)).deriveFont(Font.BOLD, 40);
            headerFont = Font.createFont(Font.TRUETYPE_FONT, new File(headerFontName)).deriveFont(Font.BOLD, 22);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            titleFont = new Font("serif", Font.BOLD, 24);
            headerFont = new Font("serif", Font.BOLD, 12);
        }

	}
}
