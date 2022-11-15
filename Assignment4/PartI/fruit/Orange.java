package fruit;

public class Orange extends Citrus{
private String type;

public Orange() {
	this.SetColor("Orange");
}

public Orange(String type,String taste, boolean rotten) {
	super(taste, "orange", rotten);
    this.type = type;
}


public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

@Override
public String toString() {
	return "Orange ["+ super.toString() +" type=" + type + "]";
}
@Override
public boolean equals(Object obj) {
	if(super.equals(obj)) {
	if(obj instanceof Orange) {
		Orange temp = (Orange)obj;
		if(((this.type==null)&&(temp.type==null))||
				(((this.type!=null)&&(temp.type!=null))&&
				(this.type.equals(temp.type)))) {
				return true;
			}
	}
	}
	return false;
}


}
