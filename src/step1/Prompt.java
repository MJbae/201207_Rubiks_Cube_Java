package step1;

import java.util.Scanner;

public class Prompt {

	public void executePrompt() {
		String inputString = "";
		int inputCount = 0;
		String inputDir = "";
		String answer = "";

		Scanner scanner = new Scanner(System.in);
		System.out.println("단어, 회전시킬 문자의 수, 회전 방향 순으로 입력하십시오. (exit: -1) ");
		
		while (true) {
			System.out.print("> ");

			String input = scanner.nextLine();
			if( input.equals("-1")) break;
			
			String[] inputSplit = input.split(" ");
			inputString = inputSplit[0];
			inputCount = Integer.parseInt(inputSplit[1]);
			inputDir = inputSplit[2];

			int lengthOfinputString = inputString.length();
			PushOutWords pushWords = new PushOutWords();

			char[] inputCharArray = inputString.toCharArray();
			inputDir = inputDir.toUpperCase();

			if ((inputCount >= 0 && inputDir.equals("R")) || (inputCount < 0 && inputDir.equals("L"))) {
				inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
				answer = pushWords.getRightpushedString(inputCharArray, inputCount, lengthOfinputString);
				System.out.println(answer);
			} else if ((inputCount >= 0 && inputDir.equals("L")) || (inputCount < 0 && inputDir.equals("R"))) {
				inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
				answer = pushWords.getLeftpushedString(inputCharArray, inputCount, lengthOfinputString);
				System.out.println(answer);
			} else {
				System.out.println("유효한 명령어를 입력하십시오");
			}
		}
		System.out.println("Done");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt prompt = new Prompt();
		prompt.executePrompt();
	}

}
