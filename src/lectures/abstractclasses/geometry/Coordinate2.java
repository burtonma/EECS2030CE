package lectures.abstractclasses.geometry;

/**
 * A 2-tuple, or pair, representing a real coordinate in 2D. The
 * two elements of the pair are called {@code x} and {@code y}. 
 *
 */
public interface Coordinate2 {

	/**
	 * Returns the x coordinate.
	 * 
	 * @return the x coordinate
	 */
	public double x();
	
	/**
	 * Returns the y coordinate.
	 * 
	 * @return the y coordinate
	 */
	public double y();
	
	/**
	 * Sets the x coordinate to the specified value.
	 * 
	 * @param newX the new x coordinate
	 * @return a reference to this coordinate
	 */
	public Coordinate2 x(double newX);
	
	/**
	 * Sets the y coordinate to the specified value.
	 * 
	 * @param newY the new y coordinate
	 * @return a reference to this coordinate
	 */
	public Coordinate2 y(double newY);
	
	/**
	 * Sets the x and y coordinate to the specified values.
	 * 
	 * @param newX the new x coordinate
	 * @param newY the new y coordinate
	 * @return a reference to this coordinate
	 */
	public Coordinate2 set(double newX, double newY);
}
