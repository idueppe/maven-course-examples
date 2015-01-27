package net.gfu.seminar.maven;
/**
 * 
 * @author tf
 *
 */
public final class MathUtils {
	/**
	 * 
	 * @param number
	 * @return
	 */
	public static long checksum(long number) {
		long sum = 0;
		final String numberAsString = Long.valueOf(number).toString();

		for (int i = 0; i < numberAsString.length(); i++) {
			sum += Integer
					.parseInt(Character.toString(numberAsString.charAt(i)));
		}
		return sum;
	}
	/**
	 * 
	 * @param value
	 * @param modulo
	 * @return
	 */
	public static long modulo(long value, int modulo) {
		return value % modulo;
	}
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static long modulo10(long value) {
		return modulo(value,10);
	}
	
	/**
	 * 
	 * @param digitsAsString
	 * @return
	 */
	public static int[] toArray(final String digitsAsString) {
		final String trimedDigits = digitsAsString.trim();
		final int len = trimedDigits.length();

		final int digits[] = new int[len];
		for (int i = 0; i < len; i++) {
			digits[i] = Integer.parseInt(Character.toString(trimedDigits.charAt(i)));
		}

		return digits;
	}

	/**
	 * 
	 * @param digits
	 * @return
	 * @see <a href="http://en.wikipedia.org/wiki/Luhn_algorithm">Luhn
	 *      algorithm<a>
	 */
	public static boolean checkLuhn(String digits) {
		final int[][] sumTable = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 } };
		int sum = 0, flip = 0;

		for (int i = digits.length() - 1; i >= 0; i--)
			sum += sumTable[flip++ & 0x1][Character.digit(digits.charAt(i), 10)];
		return sum % 10 == 0;
	}

	private MathUtils() {
	}

}
