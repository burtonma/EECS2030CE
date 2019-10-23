package lectures.interfaces;

/**
 * A policy that wraps the counter value to zero when the maximum value of
 * the counter is reached.
 *
 */
public class MaxValueWrapPolicy implements MaxValuePolicy {

	/**
	 * Returns zero causing the counter to wrap its value to zero.
	 * 
	 * @return the value 0
	 */
	@Override
	public int advance() {
		return 0;
	}

}
