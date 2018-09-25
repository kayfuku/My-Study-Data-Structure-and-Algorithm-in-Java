import java.io.*;
public class Lib22_ReplaceString {
	/**
	 * Replace A in a string with B. 
	 * If you want to quit, press ctrl + z. 
	 */
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				String s = line.replace('A', 'B'); 
				System.out.println(s);		
			} 
		} catch (IOException e) {
				System.out.println(e);
		}
	}
}