package first.controller.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAAndMD5 {
	
	public String digestString(String str,String digestType){
		MessageDigest md;
		String message="";
		try {
			md=MessageDigest.getInstance(digestType);
			md.update(str.getBytes());
			message=byteToHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	
	private String byteToHex(byte[] bytes){
		StringBuffer sb=new StringBuffer();
		for(int i=0,len=bytes.length;i<len;i++){
			int num=0xFF & bytes[i];
			if(num<0x10){
				sb.append("a"+Integer.toHexString(num));
			}else{
				sb.append(Integer.toHexString(num));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SHAAndMD5 md1=new SHAAndMD5();
		System.out.println(md1.digestString("abcd123456", "MD5"));
		System.out.println(md1.digestString("abcd123456", "SHA-1"));
	}
	
	
}
