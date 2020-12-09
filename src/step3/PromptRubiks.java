package step3;

import step2.*;
import java.util.Scanner;

public class PromptRubiks {
	
	public void executePrompt(char[][][] rubiksCube) {
		Scanner scanner = new Scanner(System.in);
		PromptCube prompt = new PromptCube();
		PushTwoDimensionalCube pushCube = new PushTwoDimensionalCube();

		// 초기값 출력
		for(char[][] eachCube : rubiksCube) prompt.printResult(eachCube);

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
