package step1;

import java.util.Scanner;

public class Prompt {
	
	
	public void executePrompt() {
		int inputCount = 0;
		String inputDir = "";
		String answer = "";

		Scanner scanner = new Scanner(System.in);
		System.out.println("  �ܾ�, ȸ����ų ������ ��, ȸ�� ���� ������ �Է��Ͻʽÿ�. (exit: -1) ");
		
		while (true) {
			System.out.print("  > ");

			String input = scanner.nextLine();
			// -1 �Է� �� ��ȸ�� Ż��
			if( input.equals("-1")) break;
			
			// �Է°��� ���� ���鹮�ڸ� �������� ����
			String[] inputSplit = input.split(" ");
			
			char[] inputCharArray = inputSplit[0].toCharArray();
			inputCount = Integer.parseInt(inputSplit[1]);
			// ȸ�� ���� �Է°��� �빮�ڷ� ��ȯ
			inputDir = inputSplit[2].toUpperCase();;

			PushOutWords pushWords = new PushOutWords();
			// ���������� ���ڸ� ȸ����Ű�� ���
			if ((inputCount >= 0 && inputDir.equals("R")) || (inputCount < 0 && inputDir.equals("L"))) {
				inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
				answer = pushWords.getRightpushedString(inputCharArray, inputCount, inputCharArray.length);
			// �������� ���ڸ� ȸ����Ű�� ���
			} else if ((inputCount >= 0 && inputDir.equals("L")) || (inputCount < 0 && inputDir.equals("R"))) {
				inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
				answer = pushWords.getLeftpushedString(inputCharArray, inputCount, inputCharArray.length);
			} else {
				System.out.println("��ȿ�� ��ɾ �Է��Ͻʽÿ�");
			}
			
			// ȸ�� ��� ���
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
