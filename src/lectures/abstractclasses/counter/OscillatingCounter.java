package lectures.abstractclasses.counter;


public class OscillatingCounter extends BidirectionalCounter {

	/**
	 * Initializes this counter so that its current value is 0 and the current
	 * counting direction is ascending.
	 */
	public OscillatingCounter() {
		super();
	}

	/**
	 * Initializes this counter to the specified non-negative value and the
	 * current counting direction is ascending.
	 * 
	 * @param value
	 *            the starting value of this counter
	 * @throws IllegalArgumentException
	 *             if value is negative
	 */
	public OscillatingCounter(int value) {
		super(value);
	}

	/**
	 * Initializes this counter to the specified non-negative value and
	 * direction.
	 * 
	 * @param value
	 *            the starting value of this counter
	 * @param direction
	 *            the direction of this counter
	 * @throws IllegalArgumentException
	 *             if value is negative
	 */
	public OscillatingCounter(int value, Direction direction) {
		super(value, direction);
	}

	/**
	 * Initializes this counter so that its current value is equal to the
	 * current value of {@code other}.
	 * 
	 * @param other
	 *            the counter to copy the value from
	 */
	public OscillatingCounter(OscillatingCounter other) {
		super(other.value, other.direction);
	}

	/**
	 * Increment the value of this counter by {@code 1} in the direction that
	 * the counter is currently traveling (i.e., the counter value increases by
	 * {@code 1} for an ascending counter and decreases by {@code 1} for a
	 * descending counter).
	 * 
	 * <p>
	 * The behaviour of this method is to reverse the direction of travel of
	 * this counter at the limits of the counting range (i.e., advancing an
	 * ascending counter whose current value is {@code Integer.MAX_VALUE} causes
	 * the counter to become a descending counter and the value decreases by
	 * {@code 1}; advancing a descending counter whose current value is
	 * {@code 0} causes the counter to become an ascending counter and the value
	 * increases by {@code 1}).
	 */
	@Override
	public void advance() {
		if (this.direction.equals(Direction.ASCENDING)) {
			if (this.value < Integer.MAX_VALUE) {
				this.value++;
			} else {
				this.direction = Direction.DESCENDING;
				this.value--;
			}
		} else {
			if (this.value > 0) {
				this.value--;
			} else {
				this.direction = Direction.ASCENDING;
				this.value++;
			}
		}
	}

	/**
	 * Increment the value of this counter by {@code 1} in the direction
	 * opposite to that the counter is currently traveling (i.e., the counter
	 * value decreases by {@code 1} for an ascending counter and increases by
	 * {@code 1} for a descending counter).
	 * 
	 * <p>
	 * The behaviour of this method is to reverse the direction of travel of
	 * this counter at the limits of the counting range (i.e., stepping back an
	 * ascending counter whose current value is {@code 0} causes the counter to
	 * become a descending counter and the value increases by {@code 1};
	 * stepping back a descending counter whose current value is
	 * {@code Integer.MAX_VALUE} causes the counter to become an ascending
	 * counter and the value decreases by {@code 1}).
	 */
	public void back() {
		if (this.direction.equals(Direction.ASCENDING)) {
			if (this.value > 0) {
				this.value--;
			} else {
				this.direction = Direction.DESCENDING;
				this.value++;
			}
		} else {
			if (this.value < Integer.MAX_VALUE) {
				this.value++;
			} else {
				this.direction = Direction.ASCENDING;
				this.value--;
			}
		}
	}
}
