package fruit;

public class Lemon extends Citrus {
private int sourness;

public Lemon() {
}

public Lemon(int sourness,String taste, boolean rotten) {
	super(taste, "yellow", rotten);
	this.sourness=sourness;
}

public int getSourness() {
	return sourness;
}

public void setSourness(int sourness) {
	this.sourness = sourness;
}

@Override
public String toString() {
	return "Lemon ["+ super.toString() +" sourness=" + sourness + "]";
}
@Override
public boolean equals(Object obj) {
	if(super.equals(obj)) {
	if(obj instanceof Lemon) {
		Lemon temp = (Lemon)obj;
		if(this.sourness==temp.sourness) {
				return true;
			}
	}
	}
	return false;
}



}
