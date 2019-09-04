package lectures.ctors;

import lectures.ctors.geometry.Point2;

public class CopyPoint {

	public static void main(String[] args) {
		// create a point
		Point2 p = new Point2(-1.0, 1.5);
		
		// print p
		System.out.println("p: " + p.toString());
		
		// copy p
		Point2 q = new Point2(p);
		
		// print q
		System.out.println("q: " + q.toString());
		
		// mutate p
		p.set(99.0, 44.0);
		
		// print p and q
		System.out.println("p: " + p.toString());
		System.out.println("q: " + q.toString());
	}

}
