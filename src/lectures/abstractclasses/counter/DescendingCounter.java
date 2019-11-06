package lectures.abstractclasses.counter;

public class DescendingCounter extends AbstractCounter {

	/**
	 * Initializes this counter so that its current value is 0.
	 */
	public DescendingCounter() {
		super(Direction.DESCENDING);
	}

	/**
	 * Initializes this counter to the specified non-negative value.
	 * 
	 * @param value
	 *            the starting value of this counter
	 * @throws IllegalArgumentException
	 *             if value is negative
	 */
	public DescendingCounter(int value) {
		super(value, Direction.DESCENDING);
	}

	/**
	 * Initializes this counter so that its current value is equal to the
	 * current value of {@code other}.
	 * 
	 * @param other
	 *            the counter to copy the value from
	 */
	public DescendingCounter(AbstractCounter other) {
		super(other);
	}

	/**
	 * Decrement the value of this counter downwards by 1. If this method is
	 * called when the current value of this counter is equal to 0 then
	 * then the value of this counter is set to {@code Integer.MAX_VALUE}
	 * (i.e., the counter wraps around to {@code Integer.MAX_VALUE}).
	 */
	@Override
	public void advance() {
		if (this.value > 0) {
			this.value--;
		} else {
			this.value = Integer.MAX_VALUE;
		}
	}

}
