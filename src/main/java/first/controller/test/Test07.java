package first.controller.test;

public class Test07 {
	public static void main(String[] args) {

		for (int i = 0; i < 7; i++) {
			for (int k = 0; i+k < 7 ; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
				if (j == i) {
					System.out.println("");
				}
			}
		}

//		for (int i = 7; i >= 0; i--) {
//			for (int k = 0; i+k < 7; k++) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j <= i; j++) {
//				System.out.print(" *");
//				if (j == i) {
//					System.out.println("");
//				}
//			}
//
//		}

	}
}
