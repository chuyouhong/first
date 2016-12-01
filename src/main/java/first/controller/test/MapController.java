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
		
	}

}
