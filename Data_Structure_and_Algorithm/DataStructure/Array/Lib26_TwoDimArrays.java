/**
   a two dimension array
*/

public class Lib026_TwoDimArrays {
	public static void main(String[] args) {
		int[][] tens = {
				{63, 90, 75, 45},
				{85, 20, 19, 78},
				{49, 33, 63, 22}, 				
		};
		
		for (int i = 0; i < tens.length; i++) { // number of rows is tens.length
			int sum = 0;
			for (int j = 0; j < tens[i].length; j++) { // number of columns is tens[i].length
				System.out.print("\t" + tens[i][j]);
				sum += tens[i][j];
			}
			System.out.println("\t| " + (double)sum / tens[i].length);
		}
	}
}