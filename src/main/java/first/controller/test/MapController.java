package first.controller.test;

import java.util.HashMap;
import java.util.Map;

public class MapController {

	
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);  
		}
		System.out.println(map);
		
		map.forEach((key,val)->System.out.println(key+val));
	
		map.computeIfPresent(4, (num, val) -> num+ val + num);
		System.out.println(map.get(4));            // val33
		String s = map.getOrDefault(11, "not found");
		System.out.println(s);
		
		map.merge(91, "val9", (value,newValue)->value.concat(newValue));
		System.out.println(map.get(91));
		map.merge(91, "val4", (value,newValue)->value.concat(newValue));
		System.out.println(map.get(91));
		
	}

}
