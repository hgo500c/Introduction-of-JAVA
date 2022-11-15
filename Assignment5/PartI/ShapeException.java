

public class ShapeException extends Exception{
	public ShapeException() {
		super();
	}
	public ShapeException(String wrongShape) {
		System.out.println("Throw ShapeException, wrong shape name:" + wrongShape);
	}
}
