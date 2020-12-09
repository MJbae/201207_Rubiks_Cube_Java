package step2;

import java.util.Scanner;

public class PromptCube {
	
	// �޼ҵ�: ���ť�� ��� ��� ���
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

	// �޼ҵ�: ����� �Է°��� ��ȿ�� ������� ������ ��ȯ
	public String[] splitInputString(String input) {

		StringBuffer inputSplit = new StringBuffer(input);
		int indexOfSplit = 1;
		
		// String input�� �� ���ڿ� ���� ��ȸ
		for (int i = 0; i < input.length() - 1; i++) {
			// ��������ǥ�� �ִ� ���, ���� ����ǥ ���� ������ ���� ���� ����
			if (input.charAt(i + 1) == 39) {
				indexOfSplit += 1;
				inputSplit.insert(indexOfSplit, " ");
				i++;
				indexOfSplit += 2;
				// �Ϲ� ����(��������ǥ�� ����)�� ���, ���� ���ڿ� ���� ����ǥ�� ���ٸ� ���� ���� ������ ���� ���� ����
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

		// �ʱⰪ ���
		prompt.printResult(twoDimensionalCube);

		while (true) {
			// ����� �Է�
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();
			// ���� �ߴ� ����
			if (input.equals("Q"))
				break;

			// inputSplit�� ���� ���鹮�� �������� �����Ͽ� ��� ��ɾ String array�� �Ҵ�
			String[] splitStringArray = splitInputString(input);

			System.out.println("");
			// ������ ��� ����
			for (String inputDir : splitStringArray) {
				// ��� ���� �޼ҵ�
				pushCube.getPushedCube(twoDimensionalCube, inputDir, SIZE_OF_CUBE);

				// ������ ��� �� ��ɿ� ���� ����� ���
				System.out.println("  " + inputDir);
				prompt.printResult(twoDimensionalCube);
			}
		}
		scanner.close();
		System.out.println("  Bye~");
	}

	public static void main(String[] args) {
		// �ʱⰪ ����
		char[][] twoDimensionalCube = { { 'R', 'R', 'W' }, { 'R', 'R', 'W' }, { 'R', 'R', 'W' } };
		final int SIZE_OF_CUBE = twoDimensionalCube[0].length;

		// prompt ����
		PromptCube prompt = new PromptCube();
		prompt.executePrompt(twoDimensionalCube, SIZE_OF_CUBE);
	}
}
