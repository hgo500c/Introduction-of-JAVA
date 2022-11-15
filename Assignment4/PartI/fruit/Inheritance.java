package fruit;


public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
      Fruit temp1 = new Fruit();
      Fruit temp2 = new Fruit("blue",true);
      Apple apple1 = new Apple();
      Apple apple2 = new Apple("sweet","smooth","red",false);
      Apple apple3 = new Apple("sweet","smooth","red",false);
      Orange orange1 = new Orange("sweet","smooth",false); //I set red in here but it will not work
      Orange orange2 = new Orange();
      Orange orange3 = new Orange();
      Lemon lemon1 = new Lemon(3,"sweet",false); //the green cannot be not worked
  	System.out.println(temp1.toString());
	System.out.println("temp2 color = "+ temp2.getColor());
	System.out.println("temp2 id = "+ temp2.getId());
	System.out.println("apple2 texture = "+ apple2.getTexture());
	System.out.println("apple2 id = "+ apple2.getId());
	System.out.println("apple 2 and apple3 equal or not is " + apple2.equals(apple3));
	System.out.println("apple 2 and apple1 equal or not is " + apple2.equals(apple1));
	System.out.println(apple3.toString());
	System.out.println(orange1.toString());
	System.out.println("orange2 and orange3 equal or not is " + orange2.equals(orange3));
	System.out.println("orange2 and lemon1 equal or not is " + orange2.equals(lemon1));
	System.out.println(lemon1.toString());
	}

}
