package first.controller.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test12 {

	public static void main(String[] args) {
		StringBuffer category =new StringBuffer();
		StringBuffer global =new StringBuffer();
		StringBuffer a =new StringBuffer();
		String ids="3,4,2,1,6,5";
		String[] arr = ids.split(",");
		System.out.println(getMap("adsfs"));
		Collections.sort(Arrays.asList(arr));
		for(String s:arr){
			int[] ar=getMap(s);
			if(null!=ar&&ar.length>0&&Integer.valueOf(s)<=3){
				for(int i=0;i<ar.length;i++){
					category.append(ar[i]);
					category.append(",");
				}
			}else if(null!=ar&&ar.length>0&&Integer.valueOf(s)>3){
				for(int i=0;i<ar.length;i++){
					global.append(ar[i]);
					global.append(",");
				}
			}
		}
		String c = category.toString();
		String g = global.toString();
		String ss = a.toString();
		System.out.println(c.substring(0, c.length()-1));
		System.out.println(g.substring(0, g.length()-1));
	}
	
	public static int[] getMap(String key){
		Map<String,int[]> map=new HashMap<String,int[]>();
		
		map.put("1", new int[]{34,35});

		map.put("2", new int[]{36,32});

		map.put("3", new int[]{31,33});

		map.put("4", new int[]{100001});

		map.put("5", new int[]{100002});

		map.put("6", new int[]{100003});

		return map.get(key);
	}

}
