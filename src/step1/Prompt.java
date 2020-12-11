package step1;

import java.util.Scanner;

public class Prompt {
	
	
	public void executePrompt() {
		int inputCount = 0;
		String inputDir = "";
		String answer = "";

		Scanner scanner = new Scanner(System.in);
		System.out.println("  단어, 회전시킬 문자의 수, 회전 방향 순으로 입력하십시오. (exit: -1) ");
		
		while (true) {
			System.out.print("  > ");

			String input = scanner.nextLine();
			// -1 입력 시 순회문 탈출
			if( input.equals("-1")) break;
			
			// 입력값에 대해 공백문자를 기준으로 나눔
			String[] inputSplit = input.split(" ");
			
			char[] inputCharArray = inputSplit[0].toCharArray();
			inputCount = Integer.parseInt(inputSplit[1]);
			// 회전 방향 입력값을 대문자로 변환
			inputDir = inputSplit[2].toUpperCase();;

			PushOutWords pushWords = new PushOutWords();
			// 오른쪽으로 문자를 회전시키는 경우
			if ((inputCount >= 0 && inputDir.equals("R")) || (inputCount < 0 && inputDir.equals("L"))) {
				inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
				answer = pushWords.getRightpushedString(inputCharArray, inputCount, inputCharArray.length);
			// 왼쪽으로 문자를 회전시키는 경우
			} else if ((inputCount >= 0 && inputDir.equals("L")) || (inputCount < 0 && inputDir.equals("R"))) {
				inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
				answer = pushWords.getLeftpushedString(inputCharArray, inputCount, inputCharArray.length);
			} else {
				System.out.println("유효한 명령어를 입력하십시오");
			}
			
			// 회전 결과 출력
			System.out.println("  " + answer);
			System.out.println("");
		}
		System.out.println("  Done");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt prompt = new Prompt();
		prompt.executePrompt();
	}

}
