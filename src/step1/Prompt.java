package step1;

import java.util.Scanner;

public class Prompt {
	// �޼ҵ�: �Է� ���� ������ ��ȿ���� üũ
	public boolean checkValidInt(int inputNum) {
		if (inputNum < -100 || inputNum >= 100) {
			System.out.println("  �Է� ���� ���� " + inputNum + "��(��) ��ȿ���� �ʽ��ϴ�.");
			return false;
		}
		return true;
	}

	// �޼ҵ�: ��ü����(����� �Էº��� ����� ��±���)�� ���� ����
	public void executePrompt() {
		int inputCount = 0;
		String inputDir = "";

		Scanner scanner = new Scanner(System.in);
		System.out.println("  �ܾ�, ȸ����ų ������ ��, ȸ�� ���� ������ �Է��Ͻʽÿ�. (exit: -1) ");

		while (true) {
			System.out.print("  > ");
			String input = scanner.nextLine();

			if (input.equals("-1"))
				break;

			// �Է°��� ���� ���鹮�ڸ� �������� ����
			String[] inputSplit = input.split(" ");

			// �ι�° �Է°�(����)�� ��ȿ���� �ʴٸ� ���� �޼��� ��� �� �ݺ��� Ż��
			if (!checkValidInt(inputCount))
				break;

			// ù��° �Է°�(�ܾ�)�� ���� char Array ���·� ��ȯ
			char[] inputCharArray = inputSplit[0].toCharArray();
			// �ι�° �Է°�(����)�� ���� ���� ���·� ��ȯ
			inputCount = Integer.parseInt(inputSplit[1]);
			// ����° �Է°�(�̵�����)�� ���� �빮�ڷ� ��ȯ
			inputDir = inputSplit[2].toUpperCase();

			PushOutWords pushWords = new PushOutWords();
			// ����� �Է°��� ���� ���ڸ� �о ����� ��ȯ
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
