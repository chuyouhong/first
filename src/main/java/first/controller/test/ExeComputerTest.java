package first.controller.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExeComputerTest {

	public static void main(String[] args) {
		try {
			Process pr=Runtime.getRuntime().exec("IPCONFIG");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(pr.getInputStream(),"GBK"));
			while(true){
				String s=br.readLine();
				if(s==null){
					break;
				}
				System.out.println(s);
			}
			br.close();
			pr.waitFor();
			if(pr.exitValue()==0){
				System.out.println("运行成功！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
