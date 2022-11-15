package fruit;
public class Fruit {
	private String color;
	private boolean rotten= false;
	private static int nextId = 1;
	private int id;
	public Fruit() {
		this.id= Fruit.nextId;
		Fruit.nextId++;
	}
	public Fruit(String color,boolean rotten) {
		this();
		this.color= color;
		this.rotten= rotten;	
	}
	public String getColor() {
		return this.color;
	}
	public void SetColor(String color) {
		this.color= color;
	}
	public boolean isRotten() {
	return rotten;
	}
	public void SetRotten(Boolean rotten) {
		this.rotten= rotten;
	}
	public int getId() {
		return this.id;
	}
	public String toString() {
		return "Fruit[color=" + this.color + ", rotten=" + this.rotten + ", id=" + this.id +"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else {
			if(obj instanceof Fruit) {
				Fruit temp = (Fruit)obj;
				if(((this.color==null)&&(temp.color==null))||
				(((this.color!=null)&&(temp.color!=null))&&
				(this.color.equals(temp.color)))) {
					if(this.rotten==temp.rotten) {
						return true;
					}
				}
			}
		} return false;
	}
	
}

