/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Resources;

/**
 *
 * @author SaiKrishna
 */
   import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class ResourceBuilder {
	public static ArrayList<String> a = new ArrayList<>();

	public static void main(String[] args) {
		String resoucePath = "C:\\Users\\SaiKrishna\\Documents\\NetBeansProjects\\Wingman\\src\\Resources";
		File folder = new File(resoucePath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().endsWith("png"))
					a.add(listOfFiles[i].getName());
				// System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				// System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		// System.out.println(a);
		// stick in new java file

		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("src//Resources.java"), "utf-8"));
			writer.write("import javax.imageio.ImageIO; import java.awt.Image; import java.io.File; import java.io.IOException;");
			writer.write(" public class Resources { private static Resources instance;  public Image ");
			// add images here
			// sea;
			String preFixed = "";
			for (int i = 0; i < a.size(); i++) {
				String prefix = a.get(i);
				prefix = prefix.substring(0, prefix.length() - 4);
				preFixed += prefix + ",";
				// System.out.print(prefix + ",");
			}
			writer.write(preFixed.substring(0, preFixed.length() - 1));
			writer.write("; private Resources() { try { ");

			// add refs here
			for (int i = 0; i < a.size(); i++) {
				// sea = ImageIO.read(new File("Resources/water.png"));
				// explosion2_4 = ImageIO.read(new
				// File("Resources/explosion2_4.png"));
				String prefix = a.get(i);// get prefix filename
				prefix = prefix.substring(0, prefix.length() - 4);// get prefix
																	// filename
				// get = stuff
				writer.write(" " + prefix
						+ " = ImageIO.read(new File(\"Resources/" + a.get(i)
						+ "\"));");
			}
			// add prefix hereF
			writer.write(" } catch (IOException e) { e.printStackTrace(); } }  public static Resources getInstance() { if (instance == null) { instance = new Resources();} return instance; } } ");
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}
		}

	}
}

    

