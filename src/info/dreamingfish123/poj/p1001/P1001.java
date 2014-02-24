/**
 * 
 */
package info.dreamingfish123.poj.p1001;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author hui
 * 
 */
public class P1001 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		BigDecimal R;
		int n;
		Scanner in = new Scanner(System.in);
		try {
			while (in.hasNext()) {
				R = in.nextBigDecimal();
				n = in.nextInt();
				R = R.pow(n);
				String out = R.stripTrailingZeros().toPlainString();
				if (out.startsWith("0")) {
					System.out.println(out.substring(1));
				} else {
					System.out.println(out);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
