import java.io.*;
public class FindString {
	/**
	 * Find a target string from a file.
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("instruction: java FindString targetString targetFile");
			System.out.println("e.g. java FindString System FindString.java");
			System.exit(0);
		}
		String findstring = args[0];
		String filename = args[1];
		
		System.out.println("The target string is '" + findstring + "'");
		
		try {
			String line;
			int linenum = 1;
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));

			while ((line = reader.readLine()) != null) {
				int n = line.indexOf(findstring);
				if (n >= 0) {
					System.out.println(linenum + "ÅF" + line);				
				}
				linenum++;			
			} 
			
			reader.close(); // for releasing memory.
			
		} catch (FileNotFoundException e) {
			System.out.println(filename + " is not found.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
