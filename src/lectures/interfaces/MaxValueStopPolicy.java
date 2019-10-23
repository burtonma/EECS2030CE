package lectures.interfaces;

/**
 * A policy that stops the counter from advancing when the maximum value of
 * the counter is reached.
 *
 */
public class MaxValueStopPolicy implements MaxValuePolicy {

	/**
	 * Returns {@code Integer.MAX_VALUE}. 
	 * 
	 * @return Integer.MAX_VALUE
	 * 
	 */
	@Override
	public int advance() {
		return Integer.MAX_VALUE;
	}

}
