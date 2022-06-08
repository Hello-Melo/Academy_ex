package test_jsp;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[][] array = new int[3][4];

		double avg;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print((i + 1) + " 번 학생의 " + (j + 1) + " 번 째 점수 입력 >>>");
				array[i][j] = scan.nextInt();
			}
			System.out.println();
		}

		for (int i = 0; i < array.length; i++) {
			int tot = 0;
				for (int j = 0; j < array[i].length; j++) {
					tot += array[i][j];
				}
				avg =(double) tot/4.0;
				System.out.println((i + 1) + " 번 학생의 총점은 : " + tot + " 이고");
				System.out.println((i + 1) + " 번 학생의 평균은 : " + avg + " 이다.");
				System.out.println("-----------------------------");
		}

	}

}
