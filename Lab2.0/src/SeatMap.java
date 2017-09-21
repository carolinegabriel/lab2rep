import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * CS 2003 - Lab 2
 * @version 1.0
 * @author caroline
 * @since 9/7/17
 * 
 */
public class SeatMap {
	File inputFile = new File("names.dat");

	public String[][] readFile() {// reads in data and makes array
		
		try {
			//File inputFile = new File("names.dat");

			Scanner input = new Scanner(inputFile);// throwing an exception here uh oh													

			String s;

			int count = 0, row, col;

			while (input.hasNextLine()) {
				count++;
			}

			row = (int) (Math.sqrt(count));
			col = count / row;
			String[][] map = new String[row][col];
			while (input.hasNextLine()) {
				for (int r = 0; r < row; r++) {
					for (int c = 0; c < col; c++) {
						s = input.nextLine();
						map[r][c] = s;
					}
				}
			}
			input.close();
			return map;
		} catch (IOException e) {
			System.out.println(e);
			System.err.println("IOException in reading input file!!!");
		}
		String[][] n = new String[1][1];
		return n;
	}

	public String getSeat(String[][] map, int a, int b) {
		return map[a][b];
	}

	public static void main(String args[]) {
		SeatMap sm = new SeatMap();
		String[][] map = sm.readFile();

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter in a seat number");
		int a = reader.nextInt();
		int b = reader.nextInt();

		System.out.println(sm.getSeat(map, a, b));
		
		reader.close();

	}

}
