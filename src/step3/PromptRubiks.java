package step3;

import step2.*;
import java.util.Scanner;

public class PromptRubiks {
	// 메소드: Rubiks Cube 전체 출력
	public void printResult(char[][][] threeDimensionalCube) {
		
		final int LENGTH_OF_CUBE = threeDimensionalCube[0][0].length;
		
		// frontCube 출력
		for (char[] oneDimensionalCube : threeDimensionalCube[0]) {
			System.out.print("                  ");
			for (char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		for (int i = 0; i < LENGTH_OF_CUBE; i++) {
			System.out.print("  ");
			
			// rightCube 출력
			for (char elementOfCube : threeDimensionalCube[1][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");
			
			// upCube 출력
			for (char elementOfCube : threeDimensionalCube[2][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");
			
			// backCube 출력
			for (char elementOfCube : threeDimensionalCube[3][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");
			
			// leftCube 출력
			for (char elementOfCube : threeDimensionalCube[4][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		// downCube 출력
		for (char[] oneDimensionalCube : threeDimensionalCube[5]) {
			System.out.print("                  ");
			for (char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void executePrompt(char[][][] rubiksCube) {
		Scanner scanner = new Scanner(System.in);
		PromptCube prompt = new PromptCube();
		PushTwoDimensionalCube pushCube = new PushTwoDimensionalCube();

		// 초기값 출력
		printResult(rubiksCube);

		while (true) {
			// 사용자 입력
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();
			// 실행 중단 로직
			if (input.equals("Q"))
				break;

			// inputSplit에 대해 공백문자 기준으로 분할하여 모든 명령어를 String array에 할당
			String[] splitStringArray = prompt.splitInputString(input);
			for(String eachInput : splitStringArray) System.out.println("input test " + eachInput);
		}
		scanner.close();
	}

	public static void main(String[] args) {
		char[][] frontCube = {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}};
		char[][] rightCube = {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}};
		char[][] upCube = {{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}};
		char[][] backCube = {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}};
		char[][] leftCube = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
		char[][] downCube = {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}};
		
		char[][][] rubiksCube = {frontCube, rightCube, upCube, backCube, leftCube, downCube};
		
		PromptRubiks prompt = new PromptRubiks();
		
		prompt.executePrompt(rubiksCube);

	}

}
