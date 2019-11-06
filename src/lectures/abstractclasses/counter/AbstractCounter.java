package lectures.abstractclasses.counter;

import java.util.Objects;

/**
 * The {@code AbstractCounter} class is the base class used to represent devices
 * used to incrementally count between zero and
 * {@link java.lang.Integer#MAX_VALUE}. Different types of counters behave
 * differently when the counter value reaches the limits of the range of the
 * counter (i.e., zero and {@link java.lang.Integer#MAX_VALUE}). Counters
 * can be ascending (count upwards), descending (count downwards), or
 * bidirectional.
 *
 */
public abstract class AbstractCounter implements Comparable<AbstractCounter> {

	public enum Direction {
		ASCENDING,
		DESCENDING;
	}
	
	/**
	 * The current value of this counter.
	 */
	protected int value;

	/**
	 * The current direction of this counter.
	 */
	protected Direction direction;
	
	/**
	 * Initializes this counter so that its current value is 0.
	 */
	public AbstractCounter(Direction direction) {
		this(0, direction);
	}

	/**
	 * Initializes this counter to the specified non-negative value. 
	 * 
	 * @param value
	 *            the starting value of this counter
	 * @throws IllegalArgumentException
	 *             if value is negative
	 */
	public AbstractCounter(int value, Direction direction) {
		if (value < 0) {
			throw new IllegalArgumentException("value must be non-negative");
		}
		this.value = value;
		this.direction = direction;
	}

	/**
	 * Initializes this counter so that its current value is equal to the
	 * current value of {@code other}.
	 * 
	 * @param other
	 *            the counter to copy the value from
	 */
	public AbstractCounter(AbstractCounter other) {
		this(other.value, other.direction);
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
	 * Returns the current direction that this counter is counting in.
	 * 
	 * @return the current direction that this counter is counting in
	 */
	public Direction dir() {
		return this.direction;
	}
	
	/**
	 * Advance the counter in the current direction of travel. Ascending-type
	 * counters will increase the count by 1, descending-type counters will
	 * decrease the count by 1, and bidirectional-type counters will change
	 * the value by 1 in the current direction of travel.
	 */
	public abstract void advance();

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
		AbstractCounter other = (AbstractCounter) obj;
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
	public int compareTo(AbstractCounter other) {
		return Integer.compare(this.value, other.value);
	}

}
