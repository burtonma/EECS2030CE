package lectures.abstractclasses.geometry;

import java.util.Objects;

/**
 * An implementation of the {@link Coordinate2} interface that provides
 * methods for accessing and mutating the elements of a coordinate.
 *
 */
public abstract class AbstractCoordinate2 implements Coordinate2 {

	/**
	 * The first element of the pair.
	 */
	protected double x;
	
	/**
	 * The second element of the pair. 
	 */
	protected double y;
	
	/**
	 * Initializes the elements of this coordinate to {@code (0.0, 0.0)}.
	 */
	public AbstractCoordinate2() {
		this(0.0, 0.0);
	}
	
	/**
	 * Initializes the elements of this coordinate to {@code (x, y)} where
	 * {@code x} and {@code y} are specified by the caller.
	 * 
	 * @param x the x value of this coordinate
	 * @param y the y value of this coordinate
	 */
	public AbstractCoordinate2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Initializes the elements of this coordinate by copying the elements
	 * from {@code other}.
	 * 
	 * @param other the coordinate to copy
	 */
	public AbstractCoordinate2(AbstractCoordinate2 other) {
		this(other.x, other.y);
	}
	
	/**
	 * Returns the x coordinate.
	 * 
	 * @return the x coordinate
	 */
	public double x() {
		return this.x;
	}
	
	/**
	 * Returns the y coordinate.
	 * 
	 * @return the y coordinate
	 */
	public double y() {
		return this.y;
	}
	
	/**
	 * Sets the x coordinate to the specified value.
	 * 
	 * @param newX the new x coordinate
	 * @return a reference to this coordinate
	 */
	public Coordinate2 x(double newX) {
		this.x = newX;
		return this;
	}
	
	/**
	 * Sets the y coordinate to the specified value.
	 * 
	 * @param newY the new y coordinate
	 * @return a reference to this coordinate
	 */
	public Coordinate2 y(double newY) {
		this.y = newY;
		return this;
	}
	
	/**
	 * Sets the x and y coordinate to the specified values.
	 * 
	 * @param newX the new x coordinate
	 * @param newY the new y coordinate
	 * @return a reference to this coordinate
	 */
	public Coordinate2 set(double newX, double newY) {
		this.x = newX;
		this.y = newY;
		return this;
	}
	
	/**
	 * Add the elements of another coordinate to the elements of this
	 * coordinate.
	 * 
	 * @param other the coordinate to add
	 * @return a reference to this coordinate
	 */
	protected Coordinate2 add(Coordinate2 other) {
		this.x += other.x();
		this.y += other.y();
		return this;
	}
	
	/**
	 * Subtract the elements of another coordinate from the elements of this
	 * coordinate.
	 * 
	 * @param other the coordinate to add
	 * @return a reference to this coordinate
	 */
	protected Coordinate2 subtract(Coordinate2 other) {
		this.x -= other.x();
		this.y -= other.y();
		return this;
	}
	
	/**
	 * Multiply the elements of this coordinate by a scalar value.
	 * 
	 * @param s the scalar value to multiply this coordinate by
	 * @return a reference to this coordinate
	 */
	protected Coordinate2 multiply(double s) {
		this.x *= s;
		this.y *= s;
		return this;
	}
	
	/**
	 * Negate the elements of this coordinate.
	 * 
	 * @return a reference to this coordinate
	 */
	public Coordinate2 negate() {
		return this.multiply(-1.0);
	}
	
	/**
	 * 
	 * 
	 * @param obj
	 * @return 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}
		AbstractCoordinate2 other = (AbstractCoordinate2) obj;
		return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(other.x) &&
				Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
	}
	
	/**
	 * Returns a hash code for this coordinate.
	 * 
	 * @return a hash code for this coordinate
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.y);
	}
	
	/**
	 * Returns a string representation of this coordinate. The string
	 * representation are the elements of the coordinate separated by
	 * a comma and space all inside a pair of parentheses.
	 * 
	 * @return a string representation of this coordinate
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("(");
		s.append(this.x).
			append(", ").
			append(this.y).
			append(")");
		return s.toString();
	}
}
