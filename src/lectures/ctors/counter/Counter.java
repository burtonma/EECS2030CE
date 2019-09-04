package lectures.ctors.counter;

/**
 * The {@code Counter} class represents a device used to incrementally count
 * upwards from zero up to {@link java.lang.Integer#MAX_VALUE}.
 *
 */
public class Counter {

	/**
	 * The current value of this counter.
	 */
	private int value;

	/**
	 * Initializes this counter so that its current value is 0.
	 */
	public Counter() {
		this(0);
	}

	/**
	 * Initializes this counter to the specified non-negative value.
	 * 
	 * @param value the starting value of this counter
	 * @throws IllegalArgumentException if value is negative
	 */
	public Counter(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("value must be non-negative");
		}
		this.value = value;
	}

	/**
	 * Initializes this counter so that its current value is equal to the current
	 * value of {@code other}.
	 * 
	 * @param other the counter to copy the value from
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
	 * Increment the value of this counter upwards by 1. If this method is called
	 * when the current value of this counter is equal to {@code Integer.MAX_VALUE}
	 * then the value of this counter is set to 0 (i.e., the counter wraps around to
	 * 0).
	 */
	public void advance() {
		if (this.value != Integer.MAX_VALUE) {
			this.value++;
		} else {
			this.value = 0;
		}
	}

	/**
	 * Returns a string representation of this counter. The string representation is
	 * the string {@code "count: "} followed by the current value of this counter.
	 * 
	 * @return a string representation of this counter
	 */
	@Override
	public String toString() {
		return "count: " + this.value;
	}
}
