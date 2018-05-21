package first.controller.test;

public class Test11 {
	public static void main(String[] args) {

		solution(15);
	}

	public static void solution(int n) {
		int[][] nine = new int[n][n];
		if (n % 2 == 0) {
			System.out.println("偶数格无法求解！");
			return;
		}

		int i, j;
		i = 0;
		j = n / 2;

		int step;
		for (step = 1; step <= n * n; ++step) {
			nine[i][j] = step;
			// System.out.println(i+" "+j+" step: "+step+" nine:"+nine[i][j]);
			i = i - 1;
			j = j + 1;
			if (i == -1 && j == n) {
				i = i + 2;
				j = j - 1;
			}
			if (i == -1) {
				i = n - 1;
			}
			if (j == n) {
				j = 0;
			}
			if (nine[i][j] != 0) {
				i = i + 2;
				j = j - 1;
			}
		}

		for (int ii = 0; ii < n; ++ii) {
			for (int jj = 0; jj < n; ++jj) {
				System.out.print(nine[ii][jj] + " ");
			}
			System.out.println();
		}

	}

}
