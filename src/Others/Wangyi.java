package Others;

import java.util.Scanner;

public class Wangyi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        while (c > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            while (m > 0) {
                int row = in.nextInt();
                int col = in.nextInt();
                int[][] snake = generate(n);
                System.out.println(snake[row + 1][col + 1]);
                m--;
            }
            c--;
        }
    }

    // generate a n-dimensional snack array
    public static int[][] generate(int n) {
        int[][] snake = new int[n + 1][n + 1];
        int i, j, temp = 0;
        boolean clockwise = true;
        for (int t = 1; ; t++) {
            if (clockwise) {
                for (i = t; i <= n - t + 1 && temp < n * n; i++) {
                    snake[t][i] = ++temp;
                }
                for (j = t + 1; j <= n - t + 1 && temp < n * n; j++) {
                    snake[j][n - t + 1] = ++temp;
                }
                for (i = n - t; i >= t && temp < n * n; i--) {
                    snake[n - t + 1][i] = ++temp;
                }
                for (j = n - t; j >= t + 1 && temp < n * n; j--) {
                    snake[j][t] = ++temp;
                }
                if (temp >= n * n) {
                    return snake;
                }
                clockwise = false;
            } else {
                for (i = t; i <= n - t + 1 && temp < n * n; i++) {
                    snake[i][t] = ++temp;
                }
                for (j = t + 1; j <= n - t + 1 && temp < n * n; j++) {
                    snake[n - t + 1][j] = ++temp;
                }
                for (i = n - t; i >= t && temp < n * n; i--) {
                    snake[i][n - t + 1] = ++temp;
                }
                for (j = n - t; j >= t + 1 && temp < n * n; j--) {
                    snake[t][j] = ++temp;
                }
                if (temp >= n * n) {
                    return snake;
                }
                clockwise = true;
            }
        }
    }

}
