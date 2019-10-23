package lectures.interfaces;

public class MaxValueExceptionPolicy implements MaxValuePolicy {

	@Override
	public int advance() {
		throw new IllegalArgumentException();
	}

}
