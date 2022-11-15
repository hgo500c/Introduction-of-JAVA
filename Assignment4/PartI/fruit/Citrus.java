package fruit;

public class Citrus extends Fruit {
private String taste;

public Citrus() {
}

public Citrus(String taste,String color, boolean rotten) {
	super(color, rotten);
	this.taste = taste;
}

public String getTaste() {
	return taste;
}

public void setTaste(String taste) {
	this.taste = taste;
}

@Override
public String toString() {
	return "citrus ["+ super.toString() +" taste=" + taste + "]";
}

@Override
public boolean equals(Object obj) {
	if(super.equals(obj)) {
	if(obj instanceof Citrus) {
		Citrus temp = (Citrus)obj;
		if(((this.taste==null)&&(temp.taste==null))||
				(((this.taste!=null)&&(temp.taste!=null))&&
				(this.taste.equals(temp.taste)))) {
				return true;
			}
	}
	}
	return false;
}
}
