/**
 * 
 */
package info.dreamingfish123.poj.p1003;

import java.util.Scanner;

/**
 * @author hui
 * 
 */
public class P1003 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] tabledoubles = calcTable();
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String line = in.next();
			if (line.equals("0.00")) {
				return;
			} else {
				System.out.println(String.valueOf(search(tabledoubles,
						Double.parseDouble(line)) + 1)
						+ " card(s)");
			}
		}
	}

	public static double[] calcTable() {
		double[] table = new double[280];
		table[0] = 0.5;
		for (int i = 1; i < 280; i++) {
			table[i] = (1.0 / (i + 2)) + (table[i - 1]);
		}
		return table;
	}

	public static int search(double[] array, double value) {
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			double midVal = array[mid];

			if (midVal < value) {
				low = mid;
			} else if (midVal >= value) {
				high = mid;
			}

			if ((high - low) == 1) {
				if (array[low] >= value) {
					return low;
				} else {
					return high;
				}
			}
		}
		return -(low + 1);
	}
}
