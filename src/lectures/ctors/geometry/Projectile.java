package lectures.ctors.geometry;

import lectures.basics.geometry.Point2;
import lectures.basics.geometry.Vector2;

/**
 * A particle moving with approximate projectile motion in two 
 * dimensions. It is assumed that the only force acting on 
 * the projectile is gravity.
 * 
 */
public class Projectile {

	/**
	 * The current position of the projectile.
	 */
	private Point2 pos;
	
	/**
	 * The current velocity of the projectile.
	 */
	private Vector2 vel;
	
	/**
	 * Initialize this projectile to have the specified
	 * starting position and velocity.
	 *  
	 * @param p the initial position of this projectile
	 * @param v the initial velocity of this projectile
	 */
	public Projectile(Point2 p, Vector2 v) {
		this.pos = p;
		this.vel = v;
	}
	
	/**
	 * Returns a reference to the position of this projectile.
	 * 
	 * @return a reference to the position of this projectile
	 */
	public Point2 getPosition() {
		return this.pos;
	}
	
	/**
	 * Returns a reference to the velocity of this projectile.
	 * 
	 * @return a reference to the velocity of this projectile
	 */
	public Vector2 getVelocity() {
		return this.vel;
	}
	
	/**
	 * Set the position of this projectile to the specified position.
	 * Returns the old position of this projectile.
	 * 
	 * @param p the new position of this projectile
	 * @return the old position of this projectile
	 */
	public Point2 setPosition(Point2 p) {
		Point2 oldPos = this.pos;
		this.pos = p;
		return oldPos;
	}
	
	/**
	 * Set the position of this projectile to the specified velocity.
	 * Returns the old velocity of this projectile.
	 * 
	 * @param p the new velocity of this projectile
	 * @return the old velocity of this projectile
	 */
	public Vector2 setVelocity(Vector2 v) {
		Vector2 oldVel = this.vel;
		this.vel = v;
		return oldVel;
	}
	
	/**
	 * Updates the position and velocity of this projectile after
	 * the projectile has moved {@code dt} seconds from its previous
	 * position.
	 * 
	 * @param dt the time period over which the projectile has moved
	 */
	public void move(double dt) {
		// acceleration due to gravity
		Vector2 g = new Vector2();
		g.set(0.0, -9.81);
		
		this.pos.add(this.vel.multiply(dt)).
				 add(Vector2.multiply(0.5 * dt * dt, g));
		this.vel.add(Vector2.multiply(dt, g));
	}
}
