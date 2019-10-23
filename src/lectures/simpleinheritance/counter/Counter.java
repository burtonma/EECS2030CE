package lectures.simpleinheritance.counter;

import java.util.Objects;

/**
 * The {@code Counter} class represents a device used to incrementally count
 * upwards from zero up to {@link java.lang.Integer#MAX_VALUE}. The counter
 * wraps around to zero if it is advanced when its current value is
 * {@code Integer.MAX_VALUE}, but subclasses can override this behaviour.
 *
 */
public class Counter implements Comparable<Counter> {

	/**
	 * The current value of this counter.
	 */
	protected int value;

	/**
	 * Initializes this counter so that its current value is 0.
	 */
	public Counter() {
		this(0);
	}

	/**
	 * Initializes this counter to the specified non-negative value. 
	 * 
	 * @param value
	 *            the starting value of this counter
	 * @throws IllegalArgumentException
	 *             if value is negative
	 */
	public Counter(int value) {
		this.value = value;
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
	 * (i.e., the counter wraps around to 0), but subclasses can override
	 * this behaviour.
	 */
	public void advance() {
		if (this.value != Integer.MAX_VALUE) {
			this.value++;
		} else {
			this.value = 0;
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

}
