package first.controller.test;

public class Test13 {
	public static void main(String[] args) {
		System.out.println(-10 >>> 3);// 0000 1010 ----> 1111 0101 ---->
										// 11110110
		System.out.println(-10 >> 3);
		int d = -33;//补码 1101 1111  
		int e = 33; //补码 0010 0001
		System.out.println("a >> 5  = " + (d >> 5));//1111 1110 -2
		System.out.println("a >>> 5 = " + (d >>> 5));// 00001000 00000000 00000000 00000000
		System.out.println("a >> 5  = " + (e >> 5));//0000 0001   1
		System.out.println("a >>> 5 = " + (e >>> 5));//0000 0001   1

		int a = -2; /* -2 = 1111 1110 */
		int b = 13; /* 13 = 0000 1101 */
		int c = 0;
		c = a & b; /* 12 = 0000 1100 */
		System.out.println("a & b = " + c);

		c = a | b; /* -1= 1111 1110 */
		System.out.println("a | b = " + c);

		c = a ^ b; /* -13 = 1111 0010 */
		System.out.println("a ^ b = " + c);

		c = ~a; /* 1 = 0000 0001 */
		System.out.println("~a = " + c);

		c = a << 4; /* -32 = 1110 0000 --> 1101 1111 ---> 0010 0000 */
		System.out.println("a << 2 = " + c);

		c = a >> 2; /* -1 = 1111 1111 ---> 1111 1110 -->0000 0001 */
		System.out.println("a >> 2  = " + c);

		c = a >>> 2; /* 0 = 1111 1111 */
		System.out.println("a >>> 2 = " + c);
	}

}
