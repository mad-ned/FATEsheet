import java.io.File;

import javax.swing.filechooser.FileFilter;


public class FateFileFilter extends FileFilter {
	
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		String name = f.getName();
		int pos = name.lastIndexOf('.');
		String ext = name.substring(pos+1);
		
		if (ext != null) {
			if (ext.equals("xml")) {
				return true;
			}
		}
		return false;
	}
	public String getDescription() {
		return "XML Character Sheet";
	}
}
