/**
 * 
 */
package info.dreamingfish123.poj.p1002;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author hui
 * 
 */
public class P1002 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inputCount = 0;
		Map<String, Integer> book = new HashMap<String, Integer>();
		if (in.hasNext()) {
			inputCount = in.nextInt();
		}
		for (int i = 0; i < inputCount; i++) {
			String callNumOri = in.next();
			String callNum = decodePhoneNumber(callNumOri);
			if (book.containsKey(callNum)) {
				book.put(callNum, book.get(callNum) + 1);
			} else {
				book.put(callNum, 1);
			}
		}
		Map<String, Integer> bookTree = new TreeMap<String, Integer>(book);
		Iterator<Entry<String, Integer>> iter = bookTree.entrySet().iterator();
		boolean flag = true;
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " " + entry.getValue());
				flag = false;
			}
		}
		if (flag) {
			System.out.println("No duplicates.");
		}
	}

	private static String decodePhoneNumber(String numOri) {
		byte[] bytes = new byte[8];
		int offset = 0;
		byte[] src = numOri.getBytes();
		for (int i = 0; i < src.length; i++) {
			if (src[i] >= 48 && src[i] <= 57) {
				bytes[offset++] = src[i];
			} else {
				switch (src[i]) {
				case 0x41:
				case 0x42:
				case 0x43:
					bytes[offset++] = 0x32;
					break;
				case 0x44:
				case 0x45:
				case 0x46:
					bytes[offset++] = 0x33;
					break;
				case 0x47:
				case 0x48:
				case 0x49:
					bytes[offset++] = 0x34;
					break;
				case 0x4a:
				case 0x4b:
				case 0x4c:
					bytes[offset++] = 0x35;
					break;
				case 0x4d:
				case 0x4e:
				case 0x4f:
					bytes[offset++] = 0x36;
					break;
				case 0x50:
				case 0x52:
				case 0x53:
					bytes[offset++] = 0x37;
					break;
				case 0x54:
				case 0x55:
				case 0x56:
					bytes[offset++] = 0x38;
					break;
				case 0x57:
				case 0x58:
				case 0x59:
					bytes[offset++] = 0x39;
					break;
				default:
					break;
				}
			}
			if (offset == 3) {
				bytes[offset++] = (byte) '-';
			}
		}
		return new String(bytes);
	}
}
