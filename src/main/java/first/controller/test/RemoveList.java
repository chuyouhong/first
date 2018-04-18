package first.controller.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

public class RemoveList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("shanghai");
		list.add("beijing");
		list.add("tianjing");
		list.add("chongqin");
		list.add("anhui");
		list.add("shuzhou");
		list.add("anhui");
		list.add("shuzhou");
		list.add("shuzhou");
		System.out.println(JSONObject.valueToString(list));
		Iterator<String> ll=list.iterator();
		if(null!=ll){
			while(ll.hasNext()){
				String a=ll.next();
				if(a.equals("shuzhou")){
					ll.remove();
				}
			}
		}
		System.out.println(JSONObject.valueToString(list));
	}

}
