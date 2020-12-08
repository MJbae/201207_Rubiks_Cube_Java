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
			StringBuffer inputSplit = new StringBuffer(input);
			// 실행 중단 로직
			if(input.equals("Q")) break;
			
			// String input의 각 문자에 대해 순회
			// 작은따옴표가 있는 경우, 작은 따옴표 기준 우측에 공백 문자 삽입
			// 일반 문자(작은따옴표가 없는)일 경우, 다음 문자에 작은 따옴표가 없다면 문자 기준 우측에 공백 문자 삽입
			// 공백문자 기준으로 String[]에 명령어 할당
			int indexOfSplit = 1;
			for(int i = 0; i < input.length() - 1; i++) {
				if(input.charAt(i + 1) == 39) {
					indexOfSplit += 1;
					inputSplit.insert(indexOfSplit, " ");
					i++;
					indexOfSplit += 2;
				} else {
					inputSplit.insert(indexOfSplit, " ");
					indexOfSplit += 2;
				}
			}
			
			String[] splitStringArray = new String(inputSplit).split(" ");

			System.out.println("");

			// 각각의 명령 수행
			for (String inputDir : splitStringArray) {
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
