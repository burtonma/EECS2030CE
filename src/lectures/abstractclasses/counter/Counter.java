package lectures.abstractclasses.counter;

public class Counter extends AbstractCounter {

	/**
	 * Initializes this counter so that its current value is 0.
	 */
	public Counter() {
		super(Direction.ASCENDING);
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
		super(value, Direction.ASCENDING);
	}

	/**
	 * Initializes this counter so that its current value is equal to the
	 * current value of {@code other}.
	 * 
	 * @param other
	 *            the counter to copy the value from
	 */
	public Counter(AbstractCounter other) {
		super(other);
	}

	/**
	 * Increment the value of this counter upwards by 1. If this method is
	 * called when the current value of this counter is equal to
	 * {@code Integer.MAX_VALUE} then the value of this counter is set to 0
	 * (i.e., the counter wraps around to 0).
	 */
	@Override
	public void advance() {
		if (this.value < Integer.MAX_VALUE) {
			this.value++;
		} else {
			this.value = 0;
		}
	}

}
