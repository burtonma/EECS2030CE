package lectures.interfaces;

/**
 * Interface for defining the behaviour of a counter when the maximum value of
 * the counter is reached.
 *
 */
public interface MaxValuePolicy {

	/**
	 * Returns the new value of a counter when the counter is advanced past its
	 * maximum value. 
	 * 
	 * @return the new value of a counter when the counter is advanced past its
	 *         maximum value
	 * @throws RuntimeException if the counter cannot be advanced past its maximum
	 *                          value and the implementing class chooses to throw
	 *                          and exception
	 */
	public int advance();
}
