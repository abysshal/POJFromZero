/**
 * 
 */
package info.dreamingfish123.poj.p1005;

import java.util.Scanner;

/**
 * @author hui
 * 
 */
public class P1005 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			int ret = (int) Math.floor((x * x + y * y) * Math.PI / 100) + 1;
			System.out
					.println("Property " + String.valueOf(i + 1)
							+ ": This property will begin eroding in year "
							+ ret + ".");
		}
		System.out.println("END OF OUTPUT.");
	}
}
