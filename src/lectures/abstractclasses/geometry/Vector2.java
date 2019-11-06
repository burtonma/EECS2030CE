package lectures.abstractclasses.geometry;

/**
 * A vector in 2-dimensional Cartesian space having real coordinates.
 *
 */
public class Vector2 extends AbstractCoordinate2 {

	/**
	 * Initializes the elements of this vector to {@code (0.0, 0.0)}.
	 */
	public Vector2() {
		this(0.0, 0.0);
	}
	
	/**
	 * Initializes the elements of this vector to {@code (x, y)} where
	 * {@code x} and {@code y} are specified by the caller.
	 * 
	 * @param x the x value of this vector
	 * @param y the y value of this vector
	 */
	public Vector2(double x, double y) {
		super(x, y);
	}

	/**
	 * Initializes the elements of this vector by copying the elements
	 * from {@code other}.
	 * 
	 * @param other the coordinate to copy
	 */
	public Vector2(Coordinate2 other) {
		super(other.x(), other.y());
	}
	
	/**
	 * Sets the x coordinate to the specified value.
	 * 
	 * @param newX the new x coordinate
	 * @return a reference to this coordinate
	 */
	@Override
	public Vector2 x(double newX) {
		super.x(newX);
		return this;
	}
	
	/**
	 * Sets the y coordinate to the specified value.
	 * 
	 * @param newY the new y coordinate
	 * @return a reference to this coordinate
	 */
	@Override
	public Vector2 y(double newY) {
		super.y(newY);
		return this;
	}
	
	/**
	 * Sets the x and y coordinate to the specified values.
	 * 
	 * @param newX the new x coordinate
	 * @param newY the new y coordinate
	 * @return a reference to this coordinate
	 */
	@Override
	public Vector2 set(double newX, double newY) {
		super.set(newX, newY);
		return this;
	}
	
	/**
	 * Add a vector to this vector changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = v + w} where {@code v} is this vector and {@code w}
	 * is a second vector.
	 * 
	 * @param w the vector to add
	 * @return a reference to this vector
	 */
	public Vector2 add(Vector2 w) {
		super.add(w);
		return this;
	}
	
	/**
	 * Subtract a vector from this vector changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = v - w} where {@code v} is this vector and {@code w}
	 * is a second vector.
	 * 
	 * @param w the vector to subtract
	 * @return a reference to this vector
	 */
	public Vector2 subtract(Vector2 w) {
		super.add(w);
		return this;
	}
	
	/**
	 * Multiply this vector by a scalar value changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = s * v} where {@code v} is a point and {@code s}
	 * is a scalar.
	 * 
	 * @param s the scalar value to multiply this vector by
	 * @return a reference to this vector
	 */
	public Vector2 multiply(double s) {
		super.multiply(s);
		return this;
	}
	
	/**
	 * Negate the coordinates of this vector changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = -v} where {@code v} is this vector.
	 * 
	 * @return a reference to this vector
	 */
	public Vector2 negate() {
		super.negate();
		return this;
	}
	
	/**
	 * Returns the dot product of this vector and the specified vector.
	 * 
	 * @param w a vector
	 * @return the dot product of this vector and {@code w}
	 */
	public double dot(Vector2 w) {
		return this.x() * w.x() + this.y() * w.y();
	}
	
	/**
	 * Returns the magnitude (length) of this vector without intermediate
	 * overflow or underflow.
	 * 
	 * @return the magnitude (length) of this vector without intermediate
	 * overflow or underflow
	 */
	public double mag() {
		return Math.hypot(this.x(), this.y());
	}
	
	/**
	 * Returns a new vector equal to {@code v + w}.
	 * 
	 * @param v a vector
	 * @param w a vector
	 * @return a new vector equal to {@code v + w}
	 */
	public static Vector2 add(Vector2 v, Vector2 w) {
		return new Vector2(v).add(w);
	}
	
	/**
	 * Returns a new vector equal to {@code v - w}.
	 * 
	 * @param v a vector
	 * @param w a vector
	 * @return a new vector equal to {@code v - w}
	 */
	public static Vector2 subtract(Vector2 v, Vector2 w) {
		return new Vector2(v).subtract(w);
	}
	
	/**
	 * Returns a new vector equal to {@code s * v}.
	 * 
	 * @param s a scalar
	 * @param v a vector
	 * @return a new vector equal to {@code s * v}
	 */
	public static Vector2 multiply(double s, Vector2 v) {
		return new Vector2(v).multiply(s);
	}
	
	/**
	 * Returns a new vector equal to {@code -v}.
	 * 
	 * @param v a vector 
	 * @return a new vector equal to {@code -v}
	 */
	public static Vector2 negate(Vector2 v) {
		return new Vector2(v).negate();
	}
}
