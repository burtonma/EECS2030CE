package lectures.simpleinheritance.counter;

public class ThrowingCounter extends Counter {

	/**
	 * Initializes this counter so that its current value is 0.
	 */
	public ThrowingCounter() {
		super(0);
	}

	/**
	 * Initializes this counter to the specified non-negative value.
	 * 
	 * @param value
	 *            the starting value of this counter
	 * @throws IllegalArgumentException
	 *             if value is negative
	 */
	public ThrowingCounter(int value) {
		super(value);
	}

	/**
	 * Increment the value of this counter upwards by 1. If this method is
	 * called when the current value of this counter is equal to
	 * {@code Integer.MAX_VALUE} then a {@code RuntimeException} is thrown.
	 * 
	 * @throws RuntimeException
	 *             if this method is called when the counter is at its maximum
	 *             value
	 */
	@Override
	public void advance() {
		if (this.value != Integer.MAX_VALUE) {
			this.value++;
		} else {
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) {
		Counter tc = new ThrowingCounter(Integer.MAX_VALUE - 5);
		for (int i = 0; i < 10; i++) {
			System.out.println("start of loop: " + tc);
			tc.advance();
			System.out.println("end of loop  : " + tc);
			System.out.println();
		}
	}
}
