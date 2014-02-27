/**
 * 
 */
package info.dreamingfish123.poj.p1006;

import java.util.Scanner;

/**
 * @author hui
 * 
 */
public class P1006 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int p = 0, e = 0, i = 0, d = 0, r = -1;
		int p2, e2, i2;
		int[] ia = new int[650];
		int[] ea = new int[650];
		int count = 0;
		Scanner in = new Scanner(System.in);
		while (true) {
			count++;
			p = in.nextInt();
			e = in.nextInt();
			i = in.nextInt();
			d = in.nextInt();
			if (p == -1 && e == -1 && i == -1 && d == -1) {
				break;
			}

			p2 = p % 23;
			e2 = e % 28;
			i2 = i % 33;

			int t = i2;
			int j = 0;
			while (t <= 21252) {
				ia[j++] = t;
				t += 33;
			}

			int j2 = 0;
			for (int n = 0; n < j; n++) {
				if ((ia[n] % 28) == e2) {
					ea[j2++] = ia[n];
				}
			}

			for (int n = 0; n < j2; n++) {
				if ((ea[n] % 23 == p2)) {
					r = ea[n] - d;
					break;
				}
			}

			if (r <=0) {
				r += 21252;
			}

			System.out.println("Case " + count
					+ ": the next triple peak occurs in " + String.valueOf(r)
					+ " days.");
		}
	}
}
