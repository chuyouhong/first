package first.controller.test;

public class Test08 {
	public static void main(String[] args) {
		for (int i = 0, s = 14; i < 7; i++, s = s - 2) {
			for (int k = 0; k < s / 2; k++) {
				System.out.print("   ");
			}
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					System.out.print("   *  ");
				} else {
					System.out.print("      ");
				}

				if (j == i) {
					System.out.println("");
				}
			}
		}

		for (int i = 7, s = 0; i >= 0; i--, s = s + 2) {
			for (int k = 0; k < s / 2; k++) {
				System.out.print("   ");
			}
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i || i==7) {
					System.out.print("   *  ");
				} else {
					System.out.print("      ");
				}
				if (j == i) {
					System.out.println("");
				}
			}

		}

	}
}
