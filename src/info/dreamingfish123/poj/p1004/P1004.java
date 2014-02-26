/**
 * 
 */
package info.dreamingfish123.poj.p1004;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author hui
 * 
 */
public class P1004 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigDecimal sum = new BigDecimal(0);
		for (int i = 0; i < 12; i++) {
			sum = sum.add(in.nextBigDecimal());
		}
		sum = sum.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_UP);
		sum.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("$" + sum.doubleValue());
	}
}
