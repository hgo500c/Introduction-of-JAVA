package PartI;

public class Pair <Double, Double1>{
	private double first;
	private double second;
	
	public Pair(double d, double e){
		this.first=d;
		this.second=e;
	}

	public double getLeft() {
		return first;
	}
	public void setLeft(double first) {
		this.first = first;
	}
	public double getRight() {
		return second;
	}
	public void setRight(double second) {
		this.second = second;
	}

}
