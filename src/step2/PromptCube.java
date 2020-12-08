package step2;

import java.util.Scanner;

public class PromptCube {

	public void printResult(char[][] twoDimensionalCube) {
		for (char[] oneDimensionalCube : twoDimensionalCube) {
			System.out.print("  ");
			for (char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// 초기값 선언
		char[][] twoDimensionalCube = { { 'R', 'R', 'W' }, { 'R', 'R', 'W' }, { 'R', 'R', 'W' } };
		final int SIZE_OF_CUBE = twoDimensionalCube[0].length;
		Scanner scanner = new Scanner(System.in);

		PromptCube prompt = new PromptCube();
		PushTwoDimensionalCube pushCube = new PushTwoDimensionalCube();

		// 초기값 출력
		prompt.printResult(twoDimensionalCube);

		while (true) {

			// 사용자 입력
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();
			if(input.equals("Q")) break;
			
			String[] inputSplit = input.split("");

			System.out.println("");

			// 각각의 명령 수행
			for (String inputDir : inputSplit) {
				// 명령 실행 메소드
				pushCube.getPushedCube(twoDimensionalCube, inputDir, SIZE_OF_CUBE);

				// 출력: 각각의 명령 및 명령에 따른 결과물
				System.out.println("  " + inputDir);
				prompt.printResult(twoDimensionalCube);
			}
		}
		scanner.close();
		System.out.println("  Bye~");

	}

}
