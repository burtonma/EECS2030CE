package lectures.arrays;

import java.util.Arrays;

/**
 * A class that represents an unsigned binary (base-2) number. A binary 
 * number is made up of one or more binary digits called bits. A bit has 
 * a value that is equal to either 0 or 1. An 8-bit binary number is shown
 * below.
 * 
 * <p>
 * <img src="./binary1.png" alt="">
 * 
 * <p>
 * To convert a binary number to its decimal (base-10) equivalent,
 * each bit is multiplied by an increasing power of 2 starting from
 * the right-most bit. For example, the decimal equivalent of the
 * 8-bit binary number can be calculated as 
 * (1 * 128) + (0 * 64) + (0 * 32) + (1 * 16) + (0 * 8) + (1 * 4) + 
 * (1 * 2) + (1 * 1) = 151:
 * 
 * <p>
 * <img src="./binary2.png" alt="">
 *  
 * <p>
 * The decimal equivalent of the 3-bit binary number can be calculated as 
 * (1 * 4) + (1 * 2) + (1 * 1) = 7:
 * 
 * <p>
 * <img src="./binary3.png" alt="">
 *
 */
public class Binary {

	/**
	 * The bits of this binary number.
	 */
	private int[] bits;

	
	/**
	 * Checks if the specified value is a binary digit (0 or 1).
	 * 
	 * @param value the value to check
	 * @throws IllegalArgumentException 
	 *            if value is not a 0 or 1
	 */
	private void checkValue(int value) {
		if (value != 0 && value != 1) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Checks if the specified index is a valid index for this binary number.
	 * 
	 * @param index the index to check
	 * @throws IllegalArgumentException 
	 *            if index is out of bounds for this binary number
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= this.numberOfBits()) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Initializes this binary number to have the specified bits. The
	 * constructor copies the individual bits into this binary number.
	 * 
	 * @param bits
	 *            the bits of the binary number
	 * @throws IllegalArgumentException
	 *             if any value in bits is not a 0 and not a 1
	 * @throws IllegalArgumentException
	 *             if bits.length is less than 1
	 */
	public Binary(int[] bits) {
		int n = bits.length;
		if (n == 0) {
			throw new IllegalArgumentException();
		}
		int[] tmp = new int[n];
		for (int i = 0; i < n; i++) {
			int b = bits[i];
			this.checkValue(b);
			tmp[i] = b;
		}
		this.bits = tmp;
	}

	/**
	 * Initializes this binary number by copying the bits from another binary
	 * number.
	 * 
	 * @param other
	 *            the binary number to copy
	 */
	public Binary(Binary other) {
		this(other.bits);
	}

	/**
	 * Returns the number of bits in this binary number.
	 * 
	 * @return the number of bits in this binary number
	 */
	public int numberOfBits() {
		return this.bits.length;
	}

	/**
	 * Returns the left-most bit of this binary number.
	 * 
	 * @return the left-most bit of this binary number
	 */
	public int getLeftMostBit() {
		return this.bits[0];
	}

	/**
	 * Returns the right-most bit of this binary number.
	 * 
	 * @return the right-most bit of this binary number
	 */
	public int getRightMostBit() {
		return this.bits[this.numberOfBits() - 1];
	}
	
	/**
	 * Returns the bit at the specified index.
	 * 
	 * <p>
	 * Index 0 is the index of the left-most bit.
	 * 
	 * @param index
	 *            the index of the bit to set
	 * @return the bit at the specified index
	 * @throws IllegalArgumentException 
	 *            if index is out of bounds for this binary number
	 */
	public int getBit(int index) {
		this.checkIndex(index);
		return this.bits[index]; 
	}

	/**
	 * Sets a bit at the given index.
	 * 
	 * <p>
	 * Index 0 is the index of the left-most bit.
	 * 
	 * @param index
	 *            the index of the bit to set
	 * @param value
	 *            the value of the bit to set
	 * @throws IllegalArgumentException 
	 *            if index is out of bounds for this binary number
	 * @throws IllegalArgumentException 
	 *            if value is not a 0 or 1
	 */
	public void setBit(int index, int value) {
		this.checkIndex(index);
		this.checkValue(value);
		this.bits[index] = value;
	}

	/**
	 * Shifts all of the bits of this binary number one position to the left.
	 * The original left-most bit is discarded (that is, it does not wrap
	 * around to the right-most bit). The right-most bit is set to 0.
	 * 
	 * <p>
	 * This is equivalent to multiplying the number by 2 as long as the
	 * original left-most bit is not equal to 1.
	 */
	public void shiftLeft() {
		for (int i = 1; i < this.numberOfBits(); i++) {
			this.bits[i - 1] = this.bits[i];
		}
		this.bits[this.numberOfBits() - 1] = 0;
	}

	/**
	 * Returns the decimal (base-10) representation of this binary number
	 * as an {@code int} value. The result will overflow if the binary
	 * number has a decimal value that cannot be represented as an
	 * {@code int}.
	 * 
	 * @return the decimal (base-10) representation of this binary number
	 */
	public int toDecimal() {
		int sum = 0;
		for (int i = 0; i < this.numberOfBits(); i++) {
			sum += Math.pow(2, i) * this.bits[this.numberOfBits() - 1 - i];
		}
		return sum;
	}

	/**
	 * Returns a string representation of this binary number. The returned
	 * string is made up of the bit values (0 or 1) of the number from
	 * the left-most bit to the right-most bit.
	 * 
	 * @return a string representation of this binary number
	 */
	@Override
	public String toString() {
		String s = Arrays.toString(this.bits);
		s = s.replaceAll(", ", "");
		s = s.replaceAll("\\[", "");
		s = s.replaceAll("\\]", "");
		return s;
	}

	/**
	 * A simple test method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		int[] bits = { 1, 0, 0, 1 };
		Binary b = new Binary(bits);
		System.out.println("b                   : " + b.toString());
		System.out.println("b.numberOfBits()    : " + b.numberOfBits());
		System.out.println("b.getLeftMostBit()  : " + b.getLeftMostBit());
		System.out.println("b.getRightMostBit() : " + b.getRightMostBit());
		System.out.println("b.toDecimal()       : " + b.toDecimal());
		b.setBit(1, 1);
		System.out.println("b.setBit(1, 1)      : " + b.toString());
		System.out.println("b.toDecimal()       : " + b.toDecimal());
		b.setBit(0, 0);
		System.out.println("b.setBit(0, 0)      : " + b.toString());
		System.out.println("b.toDecimal()       : " + b.toDecimal());
		b.shiftLeft();
		System.out.println("b.shiftLeft()       : " + b.toString());
		System.out.println("b.toDecimal()       : " + b.toDecimal());
		System.out.println();
		
		Binary b2 = new Binary(bits);
		Binary b3 = new Binary(b2);
		b3.setBit(0, 0);
		
		System.out.println("b2                  : " + b2.toString());
		System.out.println("b3                  : " + b3.toString());
	}
}
