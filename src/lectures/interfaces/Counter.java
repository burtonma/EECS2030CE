package lectures.interfaces;

import java.util.Objects;

/**
 * The {@code Counter} class represents a device used to incrementally count
 * upwards from zero up to {@link java.lang.Integer#MAX_VALUE}.
 *
 */
public class Counter implements Comparable<Counter> {

	/**
	 * The current value of this counter.
	 */
	private int value;

	private MaxValuePolicy maxPolicy;

	/**
	 * Initializes this counter so that its current value is 0. The counter
	 * wraps around to zero if it is advanced when its current value is
	 * {@code Integer.MAX_VALUE}.
	 */
	public Counter() {
		this(0, new MaxValueWrapPolicy());
	}

	/**
	 * Initializes this counter so that its current value is 0. The counter uses
	 * {@code maxPolicy} to determine what happens if the counter is advanced
	 * when its current value is {@code Integer.MAX_VALUE}.
	 * 
	 * @param maxPolicy
	 *            the policy used to determine what happens if the counter is
	 *            advanced when its current value is Integer.MAX_VALUE
	 */
	public Counter(MaxValuePolicy maxPolicy) {
		this.value = 0;
		this.maxPolicy = maxPolicy;
	}

	/**
	 * Initializes this counter to the specified non-negative value. The counter
	 * wraps around to zero if it is advanced when its current value is
	 * {@code Integer.MAX_VALUE}.
	 * 
	 * @param value
	 *            the starting value of this counter
	 * @throws IllegalArgumentException
	 *             if value is negative
	 */
	public Counter(int value) {
		this(value, new MaxValueWrapPolicy());
	}

	/**
	 * Initializes this counter to the specified non-negative value. The counter uses
	 * {@code maxPolicy} to determine what happens if the counter is advanced
	 * when its current value is {@code Integer.MAX_VALUE}.
	 * 
	 * @param value
	 *            the starting value of this counter
	 * @param maxPolicy
	 *            the policy used to determine what happens if the counter is
	 *            advanced when its current value is Integer.MAX_VALUE
	 * @throws IllegalArgumentException
	 *             if value is negative
	 */
	public Counter(int value, MaxValuePolicy maxPolicy) {
		if (value < 0) {
			throw new IllegalArgumentException("value must be non-negative");
		}
		this.value = value;
		this.maxPolicy = maxPolicy;
	}

	/**
	 * Initializes this counter so that its current value is equal to the
	 * current value of {@code other}.
	 * 
	 * @param other
	 *            the counter to copy the value from
	 */
	public Counter(Counter other) {
		this(other.value);
	}

	/**
	 * Returns the current value of this counter.
	 * 
	 * @return the current value of this counter
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Increment the value of this counter upwards by 1. If this method is
	 * called when the current value of this counter is equal to
	 * {@code Integer.MAX_VALUE} then the value of this counter is set to 0
	 * (i.e., the counter wraps around to 0).
	 */
	public void advance() {
		if (this.value != Integer.MAX_VALUE) {
			this.value++;
		} else {
			this.value = this.maxPolicy.advance();
		}
	}

	/**
	 * Returns a string representation of this counter. The string
	 * representation is the string {@code "count: "} followed by the current
	 * value of this counter.
	 * 
	 * @return a string representation of this counter
	 */
	@Override
	public String toString() {
		return "count: " + this.value;
	}

	/**
	 * Returns a hash code for this counter.
	 * 
	 * @return a hash code for this counter
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}

	/**
	 * Compares this counter to the specified object. The result is {@code true}
	 * if and only if the argument is not {@code null} and is a {@code Counter}
	 * object that has the same current value as this object.
	 * 
	 * @param obj
	 *            the object to compare this counter against
	 * @return true if the given object represents a Counter with the same
	 *         current value to this counter, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Counter other = (Counter) obj;
		return this.value == other.value;
	}

	/**
	 * Compares the value of this counter to the value of another counter.
	 * 
	 * @param other
	 *            the other counter to compare to
	 * @return a positive value if the value of this counter is greater than the
	 *         value of the other counter; zero if the value of this counter is
	 *         equal to the value of the other counter; a negative value if the
	 *         value of this counter is less than the value of the other counter
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Counter other) {
		return Integer.compare(this.value, other.value);
	}

	public static void main(String[] args) {
		Counter c = new Counter(Integer.MAX_VALUE - 5, new MaxValueStopPolicy());
		for (int i = 0; i < 10; i++) {
			System.out.println("start of loop: " + c);
			c.advance();
			System.out.println("end of loop  : " + c);
			System.out.println();
		}
	}
}
