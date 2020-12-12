package step2;

import java.util.Scanner;

public class PromptCube {

	// 메소드: 평면큐브 모든 요소 출력
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

	// 메소드: 사용자 입력값을 유효한 명령으로 나누어 반환
	public String[] splitInputString(String input) {

		StringBuffer inputSplit = new StringBuffer(input);
		int indexOfSplit = 1;

		// String input의 각 문자에 대해 순회
		for (int i = 0; i < input.length() - 1; i++) {
			// 작은따옴표가 있는 경우, 작은 따옴표 기준 우측에 공백 문자 삽입
			if (input.charAt(i + 1) == 39) {
				indexOfSplit += 1;
				inputSplit.insert(indexOfSplit, " ");
				i++;
				indexOfSplit += 2;
				// 일반 문자(작은따옴표가 없는)일 경우, 다음 문자에 작은 따옴표가 없다면 문자 기준 우측에 공백 문자 삽입
			} else {
				inputSplit.insert(indexOfSplit, " ");
				indexOfSplit += 2;
			}
		}

		return new String(inputSplit).split(" ");
	}

	public void executePrompt(char[][] twoDimensionalCube, int SIZE_OF_CUBE) {
		Scanner scanner = new Scanner(System.in);
		PromptCube prompt = new PromptCube();
		PushTwoDimensionalCube pushCube = new PushTwoDimensionalCube();

		// 초기값 출력
		prompt.printResult(twoDimensionalCube);

		while (true) {
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();
			
			if (input.equals("Q"))
				break;

			// inputSplit에 대해 공백문자 기준으로 분할하여 모든 명령어를 String array에 할당
			String[] splitStringArray = splitInputString(input);
			System.out.println("");
			
			for (String inputDir : splitStringArray) {
				// 각각의 명령 따라 큐브 이동
				twoDimensionalCube = pushCube.getPushedCube(twoDimensionalCube, inputDir, SIZE_OF_CUBE);

				// 큐브의 이동 결과 출력
				System.out.println("  " + inputDir);
				prompt.printResult(twoDimensionalCube);
			}
		}
		scanner.close();
		System.out.println("  Bye~");
	}

	public static void main(String[] args) {
		// 초기값 정의
		char[][] twoDimensionalCube = { { 'R', 'R', 'W' }, { 'G', 'C', 'W' }, { 'G', 'B', 'B' } };
		final int SIZE_OF_CUBE = twoDimensionalCube[0].length;

		// prompt 실행
		PromptCube prompt = new PromptCube();
		prompt.executePrompt(twoDimensionalCube, SIZE_OF_CUBE);
	}
}