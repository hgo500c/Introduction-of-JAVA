package arraylists;
import java.util.ArrayList;

import fruit.*;

public class FruitArraylist {

	public static void main(String[] args) {
		
		// this ArrayList MUST be parameterized
		ArrayList <Fruit>fruitArrayList = new ArrayList <Fruit>();
		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		//=========================first question=======================
		Apple nonrottenGreenApple1 = new Apple("sweet"," crisp","green",false);
		Apple rottenGreenApple1 = new Apple("tart"," soft","green",true);
		Apple rottenGreenApple2 = new Apple("tart"," soft","green",true);
		Lemon nonrottenlemon1 = new Lemon(10,"sour",false);
		Lemon nonrottenlemon2 = new Lemon(50,"sour",false);
		Lemon nonrottenlemon3 = new Lemon(80,"sour",false);
		Orange rottenorange1 = new Orange("sweet","mandarin",true);
		Orange rottenorange2 = new Orange("sweet","mandarin",true);
		
		fruitArrayList.add(nonrottenGreenApple1);
		fruitArrayList.add(rottenGreenApple1);
		fruitArrayList.add(rottenGreenApple2);
		fruitArrayList.add(nonrottenlemon1);
		fruitArrayList.add(nonrottenlemon2);
		fruitArrayList.add(nonrottenlemon3);
		fruitArrayList.add(rottenorange1);
		fruitArrayList.add(rottenorange2);
		//=====================second question=====================
		int length = fruitArrayList.size();
		int sum = 0;
		int number = 0;
		for(int i = 0; i<length;i++) {
			if(fruitArrayList.get(i) instanceof Lemon) {
				Lemon temp = (Lemon)fruitArrayList.get(i);
				System.out.println(temp.toString());
				sum = sum +temp.getSourness();
				number ++;
			}
		}
		int average = sum/number;
		System.out.println("we get the average of them is " + average);
		
		
		//=======================third question=====================
		int n = 0;
		for(int i = 0; i<length;i++) {
			if(fruitArrayList.get(i) instanceof Apple) {
				n++;
				Apple temp = (Apple)fruitArrayList.get(i);
				if(temp.isRotten()==true && temp.getColor()=="green") {
					System.out.println("the id is"+fruitArrayList.get(i).getId());
					break;
				}
			}
		}  // how to find that apple we need
		Apple example = (Apple)fruitArrayList.get(n);
		for(int i = 0; i<fruitArrayList.size();i++) {
			if(fruitArrayList.get(i).getId()== 2) {
				System.out.println("this is the same one: "+fruitArrayList.get(i).toString());
				fruitArrayList.remove(i);
			}// print that same one
			if((fruitArrayList.get(i).equals(example))){
				System.out.println("these are the equal one: "+fruitArrayList.get(i).toString());
				fruitArrayList.remove(i);
			}// print the delted one which is equal to the first one
		}
		//========================part4 ==============
		for(int i = 0; i<fruitArrayList.size();i++) {
			System.out.println("these are the remining: "+fruitArrayList.get(i).toString());
	
	}
}
}
