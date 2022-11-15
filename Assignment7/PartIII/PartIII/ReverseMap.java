package PartIII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ReverseMap {

	public static Map<Object, Set<Object>> getInverted(Map<Object, Object> mp) {
		 Map<Object,Set<Object>> output= new HashMap<Object,Set<Object>>();// we will take it in the return

	        for (Map.Entry<Object,Object> temp : mp.entrySet())
	        {
	            Object key = temp.getKey();
	            Object value = temp.getValue();
	            Set<Object> KeySet = new HashSet<Object>(); //give the set to the Key
	            if(output.containsKey(value))
	            {
	             output.get(value).add(key);// from the map we get the set cause we already have it in the 
	            }else {
	            KeySet.add(key);
	            output.put(value,KeySet);//add in here if this is new 
	        }
	        }
	        return output;
	        
	}
	public static void main(String[] args) {
		Map<Object,Object> m = new HashMap<Object,Object>();
		m.put("Key1", new Integer(2));
		m.put("Key2", new Integer(5));
		m.put("Key4", new Integer(2));
		m.put("Key5", new Integer(8));
		m.put("Key6", new Integer(18));
		m.put("Key7", new Integer(24));
		System.out.println("hashmap is " + m);
		
		System.out.println("inverted: " + ReverseMap.getInverted(m));
		

	}

}
