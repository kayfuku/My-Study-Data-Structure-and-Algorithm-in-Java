// Facebook Hacker Cup 2016 Qualification Round, High Security. 
// By Joseph.
// Commented by Kei Fukutani.

import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/B.in"))));

		String output = "";
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			sc.nextLine();
			// Upper line.
			String str1 = "X"+sc.nextLine()+"X";
			// Lower line.
			String str2 = "X"+sc.nextLine()+"X";
			
			int answer = 0;
			
			for (int j = 1; j <= n; j++) {
				if (str1.substring(j-1, j+2).equals("X.X") && str2.charAt(j) == '.') {
					answer++;
					// Put "Z" in the j position on upper line.
					str1 = str1.substring(0, j) + "Z" + str1.substring(j+1);
					// Put "G" in the j position on lower line.
					str2 = str2.substring(0, j) + "G" + str2.substring(j+1);
					int m = j-1;
					while (str2.charAt(m)=='.') {
						// Put "Z" in the m position on lower line.
						str2 = str2.substring(0, m) + "Z" + str2.substring(m+1);
						m--;
					}
				}
				if (str2.substring(j-1, j+2).equals("X.X") && str1.charAt(j) == '.') {
					answer++;
					// I guess X should be Z.
					str2 = str2.substring(0, j) + "X" + str2.substring(j+1);
					str1 = str1.substring(0, j) + "G" + str1.substring(j+1);
					int m = j-1;
					while (str1.charAt(m)=='.') {
						str1 = str1.substring(0, m) + "Z" + str1.substring(m+1);
						m--;
					}
				}
			}
			
			for (int j = 1; j <= n+1; j++) {
				if (str1.substring(j-1, j+1).equals("X."))
					answer++;
				if (str2.substring(j-1, j+1).equals("X."))
					answer++;
			}
			
			output += "Case #" + i + ": " + answer + "\n";
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/B.out"), "utf-8"));
		bw.write(output);
		bw.close();
	}
}