package step1;

import java.util.Scanner;

public class Prompt {

	public void executePrompt() {
		String inputString = "";
		int inputCount = 0;
		String inputDir = "";

		Scanner scanner = new Scanner(System.in);
		System.out.println("  �ܾ�, ȸ����ų ������ ��, ȸ�� ���� ������ �Է��Ͻʽÿ�. (exit: -1) ");
		
		while (true) {
			System.out.print("  > ");

			String input = scanner.nextLine();
			// -1 �Է� �� ��ȸ�� Ż��
			if( input.equals("-1")) break;
			
			// �Է°��� ���� ���鹮�ڸ� �������� ����
			String[] inputSplit = input.split(" ");
			inputString = inputSplit[0];
			inputCount = Integer.parseInt(inputSplit[1]);
			inputDir = inputSplit[2];
			
			char[] answer = new char[inputString.length()];

			int lengthOfinputString = inputString.length();
			PushOutWords pushWords = new PushOutWords();

			char[] inputCharArray = inputString.toCharArray();
			// ȸ�� ���� �Է°��� �빮�ڷ� ��ȯ
			inputDir = inputDir.toUpperCase();

			// ���������� ���ڸ� ȸ����Ű�� ���
			if ((inputCount >= 0 && inputDir.equals("R")) || (inputCount < 0 && inputDir.equals("L"))) {
				inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
				answer = pushWords.getRightpushedString(inputCharArray, inputCount, lengthOfinputString);
			// �������� ���ڸ� ȸ����Ű�� ���
			} else if ((inputCount >= 0 && inputDir.equals("L")) || (inputCount < 0 && inputDir.equals("R"))) {
				inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
				answer = pushWords.getLeftpushedString(inputCharArray, inputCount, lengthOfinputString);
			} else {
				System.out.println("��ȿ�� ��ɾ �Է��Ͻʽÿ�");
			}
			
			// ȸ�� ��� ���
			System.out.println("  " + String.valueOf(answer));
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
