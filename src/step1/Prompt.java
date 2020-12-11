package step1;

import java.util.Scanner;

public class Prompt {
	// 메소드: 입력 받은 정수의 유효범위 체크
	public boolean checkValidInt(int inputNum) {
		if (inputNum < -100 || inputNum >= 100) {
			System.out.println("  입력 받은 정수 " + inputNum + "은(는) 유효하지 않습니다.");
			return false;
		}
		return true;
	}

	// 메소드: 전체로직(사용자 입력부터 결과물 출력까지)에 대해 실행
	public void executePrompt() {
		int inputCount = 0;
		String inputDir = "";

		Scanner scanner = new Scanner(System.in);
		System.out.println("  단어, 회전시킬 문자의 수, 회전 방향 순으로 입력하십시오. (exit: -1) ");

		while (true) {
			System.out.print("  > ");
			String input = scanner.nextLine();

			if (input.equals("-1"))
				break;

			// 입력값에 대해 공백문자를 기준으로 분할
			String[] inputSplit = input.split(" ");

			// 두번째 입력값(정수)이 유효하지 않다면 관련 메세지 출력 후 반복문 탈출
			if (!checkValidInt(inputCount))
				break;

			// 첫번째 입력값(단어)에 대해 char Array 형태로 변환
			char[] inputCharArray = inputSplit[0].toCharArray();
			// 두번째 입력값(정수)에 대해 정수 형태로 변환
			inputCount = Integer.parseInt(inputSplit[1]);
			// 세번째 입력값(이동방향)에 대해 대문자로 변환
			inputDir = inputSplit[2].toUpperCase();

			PushOutWords pushWords = new PushOutWords();
			// 사용자 입력값을 토대로 문자를 밀어낸 결과를 반환
			char[] resultOfPushed = pushWords.getPushed(inputCharArray, inputCount, inputDir);

			System.out.println("  " + String.valueOf(resultOfPushed));
			System.out.println("");
		}
		System.out.println("");
		System.out.println("  Done");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt prompt = new Prompt();
		prompt.executePrompt();
	}

}
