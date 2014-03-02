/**
 * 
 */
package info.dreamingfish123.poj.p1007;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author hui
 * 
 */
public class P1007 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n, m;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		String[] strs = new String[m];
		int[] inversions = new int[m];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < m; i++) {
			strs[i] = in.next();
			inversions[i] = calcInversion(strs[i]);
			map.put(i, inversions[i]);
		}

		SortedSet<Entry<Integer, Integer>> set = new TreeSet<Entry<Integer, Integer>>(
				new Comparator<Entry<Integer, Integer>>() {
					public int compare(Entry<Integer, Integer> e1,
							Entry<Integer, Integer> e2) {
						if (e1.getValue() == e2.getValue()) {
							return e1.getKey() - e2.getKey();
						} else {
							return e1.getValue() - e2.getValue();
						}
					}
				});
		set.addAll(map.entrySet());

		Iterator<Entry<Integer, Integer>> iter = set.iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();
			System.out.println(strs[entry.getKey()]);
		}
	}

	public static int calcInversion(String str) {
		byte[] bytes = str.getBytes();
		int Acount = 0, Ccount = 0, Tcount = 0, Gcount = 0;
		int ret = 0;
		for (int i = bytes.length - 1; i >= 0; i--) {
			switch (bytes[i]) {
			case 0x41:
				Acount++;
				break;
			case 0x43:
				ret += Acount;
				Ccount++;
				break;
			case 0x47:
				ret += Acount;
				ret += Ccount;
				Gcount++;
				break;
			case 0x54:
				ret += Acount;
				ret += Ccount;
				ret += Gcount;
				Tcount++;
				break;
			default:
				break;
			}
		}
		return ret;
	}
}
