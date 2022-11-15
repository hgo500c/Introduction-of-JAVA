package PartII;

import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2) {
           Set<E> output= new MathSet<E>();
	        output.addAll (this);
	        output.retainAll (s2);
	        return output;
	}
	
	public Set<E> union(Set<E> s2) {
		Set<E> output= new MathSet<E>();
        output.addAll (this);
        output.addAll (s2);
        return output;
	}
	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
		  Set<Pair<E,T>> output = new MathSet<>();  
		  int elen = this.size();
	        for (E temp : this)
	            for (T temp2 : s2) {
	                Pair<E,T> newpair = new Pair (temp, temp2);
	                output.add (newpair);
	            }
	        return output;

	}
	
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		MathSet<Integer> firstone = new MathSet<Integer>();
	       firstone.add (3); 
	       firstone.add (4); 
	       firstone.add (5);
	       firstone.add (0);
	       firstone.add (12);
	       firstone.add (17);
	       MathSet<Integer> secondone = new MathSet<Integer>();
	       secondone.add (0); 
	       secondone.add (12); 
	       secondone.add (17); 
	       secondone.add (25);
	       secondone.add (125);
	       secondone.add (225);
	       
	       System.out.println (firstone.union (secondone));
	       System.out.println (firstone.intersection (secondone));
	      
	       // create another MathSet object of a different type
	       // calculate the cartesian product of this set with one of the
	       // above sets
	       MathSet<Character> output = new MathSet<>();
	       output.add ('O');
	       output.add ('P'); 
	     
	       System.out.println (firstone.cartesianProduct (output));
	       MathSet<Character> output2 = new MathSet<>();
	       output2.add ('O');
	       System.out.println (secondone.cartesianProduct (output2));
	   }
	}
	

