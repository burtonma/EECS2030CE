package lectures.simpleinheritance.counter;

public class StoppingCounter extends Counter {

	/**
	 * Initializes this counter so that its current value is 0.
	 */
	public StoppingCounter() {
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
	public StoppingCounter(int value) {
		super(value);
	}
	
	/**
	 * Increment the value of this counter upwards by 1. If this method is
	 * called when the current value of this counter is equal to
	 * {@code Integer.MAX_VALUE} then the value of this counter remains
	 * {@code Integer.MAX_VALUE} (i.e., the counter stops counting
	 * at {@code Integer.MAX_VALUE}).
	 */
	@Override
	public void advance() {
		if (this.value != Integer.MAX_VALUE) {
			this.value++;
		}
	}
	
	public static void main(String[] args) {
		Counter sc = new StoppingCounter(Integer.MAX_VALUE - 5);
		for (int i = 0; i < 10; i++) {
			System.out.println("start of loop: " + sc);
			sc.advance();
			System.out.println("end of loop  : " + sc);
			System.out.println();
		}
	}
}
