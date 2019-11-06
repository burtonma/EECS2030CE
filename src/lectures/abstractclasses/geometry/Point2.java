package lectures.abstractclasses.geometry;

/**
 * A Cartesian point in 2-dimensions having real coordinates.
 *
 */
public class Point2 extends AbstractCoordinate2 {

	/**
	 * Initializes the elements of this point to {@code (0.0, 0.0)}.
	 */
	public Point2() {
		this(0.0, 0.0);
	}
	
	/**
	 * Initializes the elements of this point to {@code (x, y)} where
	 * {@code x} and {@code y} are specified by the caller.
	 * 
	 * @param x the x value of this point
	 * @param y the y value of this point
	 */
	public Point2(double x, double y) {
		super(x, y);
	}

	/**
	 * Initializes the elements of this point by copying the elements
	 * from {@code other}.
	 * 
	 * @param other the coordinate to copy
	 */
	public Point2(Coordinate2 other) {
		super(other.x(), other.y());
	}
	
	/**
	 * Sets the x coordinate to the specified value.
	 * 
	 * @param newX the new x coordinate
	 * @return a reference to this coordinate
	 */
	@Override
	public Point2 x(double newX) {
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
	public Point2 y(double newY) {
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
	public Point2 set(double newX, double newY) {
		super.set(newX, newY);
		return this;
	}
	
	/**
	 * Add a vector to this point changing the coordinates of this point.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code p = p + v} where {@code p} is a point and {@code v}
	 * is a vector.
	 * 
	 * @param v the vector to add
	 * @return a reference to this point
	 */
	public Point2 add(Vector2 v) {
		super.add(v);
		return this;
	}
	
	/**
	 * Subtract a vector from this point changing the coordinates of this point.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code p = p - v} where {@code p} is a point and {@code v}
	 * is a vector.
	 * 
	 * @param v the vector to subtract
	 * @return a reference to this point
	 */
	public Point2 subtract(Vector2 v) {
		super.subtract(v);
		return this;
	}
	
	
	/**
	 * Returns the vector pointing from the specified point
	 * {@code q} to this point.
	 * 
	 * <p>
	 * {@code p.from(q)} is equal to the vector {@code p - q}.
	 * 
	 * @param q a point
	 * @return the vector pointing from {@code q} to this point
	 */
	public Vector2 from(Point2 q) {
		return new Vector2(this.x() - q.x(), this.y() - q.y());
	}
	
	/**
	 * Returns the vector pointing from this point to the 
	 * specified point {@code q}.
	 * 
	 * <p>
	 * {@code p.to(q)} is equal to the vector {@code q - p}.
	 * 
	 * @param q a point
	 * @return the vector pointing from this point to {@code q}
	 */
	public Vector2 to(Point2 q) {
		return new Vector2(q.x() - this.x(), q.y() - this.y());
	}
	
	/**
	 * Multiply this point by a scalar value changing the coordinates of this point.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code p = s * p} where {@code p} is a point and {@code s}
	 * is a scalar.
	 * 
	 * @param s the scalar value to multiply this point by
	 * @return a reference to this point
	 */
	public Point2 multiply(double s) {
		super.multiply(s);
		return this;
	}
	
	/**
	 * Negate the coordinates of this point changing the coordinates of this point.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code p = -p} where {@code p} is a point.
	 * 
	 * @return a reference to this point
	 */
	public Point2 negate() {
		super.negate();
		return this;
	}
	
	/**
	 * Returns a new point equal to {@code p + v}.
	 * 
	 * @param p a point
	 * @param v a vector
	 * @return a new point equal to {@code p + v}
	 */
	public static Point2 add(Point2 p, Vector2 v) {
		return new Point2(p).add(v);
	}
	
	/**
	 * Returns a new point equal to {@code p - v}.
	 * 
	 * @param p a point
	 * @param v a vector
	 * @return a new point equal to {@code p - v}
	 */
	public static Point2 subtract(Point2 p, Vector2 v) {
		return new Point2(p).subtract(v);
	}
	
	/**
	 * Returns a new point equal to {@code s * p}.
	 * 
	 * @param s a scalar
	 * @param p a point 
	 * @return a new point equal to {@code s * p}
	 */
	public static Point2 multiply(double s, Point2 p) {
		return new Point2(p).multiply(s);
	}
	
	/**
	 * Returns a new point equal to {@code -p}.
	 * 
	 * @param p a point 
	 * @return a new point equal to {@code -p}
	 */
	public static Point2 negate(Point2 p) {
		return new Point2(p).negate();
	}
	
	
	public static void main(String[] args) {
		Point2 p = new Point2();
		System.out.println(p.set(1, 1).multiply(2));
	}
}
