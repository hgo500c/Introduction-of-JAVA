package fruit;

public class Apple extends Fruit{
	
	private String taste;
	private String texture;
	public  Apple() {
	}
	public  Apple(String taste,String texture, String color, boolean rotten) {
		super(color,rotten);
		this.taste=taste;
		this.texture= texture;
	}
	public String gettaste() {
		return this.taste;
	}
	public void Settaste(String taste) {
		this.taste= taste;
	}
	public String getTexture() {
		return this.texture;
	}
	public void SetColor(String texture) {
		this.texture= texture;
	}
	
	@Override
	public String toString() {
			return "Apple[" + super.toString() + 
					",taste=" + this.taste + ",texture=" + this.texture + "]";
		}

	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
		if(obj instanceof Apple) {
			Apple temp = (Apple)obj;
			if(((this.taste==null)&&(temp.taste==null))||
					(((this.taste!=null)&&(temp.taste!=null))&&
					(this.taste.equals(temp.taste)))) {
				if(((this.texture==null)&&(temp.texture==null))||
							(((this.texture!=null)&&(temp.texture!=null))&&
									(this.texture.equals(temp.texture)))) {
					return true;
				}
				
			}
		}
		}
		return false;
	}
		
	
	
	}
	
	
	

