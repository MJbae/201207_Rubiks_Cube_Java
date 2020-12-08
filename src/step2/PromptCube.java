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

		// 출력: 초기값 출력
		prompt.printResult(twoDimensionalCube);

		while (true) {

			// 입력: ex) UUR
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();
			if(input.equals("Q")) break;
			
			String[] inputSplit = input.split("");

			System.out.println("");

			for (String inputDir : inputSplit) {
				// 반복: 각각의 명령 수행
				// 명령 실행 로직
				pushCube.getPushedCube(twoDimensionalCube, inputDir, SIZE_OF_CUBE);

				// 출력: 각각의 명령
				// 출력: 명령을 수행한 결과물
				System.out.println("  " + inputDir);
				prompt.printResult(twoDimensionalCube);
			}
		}
		scanner.close();
		System.out.println("  Bye~");

	}

}
