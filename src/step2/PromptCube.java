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
		// �ʱⰪ ����
		char[][] twoDimensionalCube = { { 'R', 'R', 'W' }, { 'R', 'R', 'W' }, { 'R', 'R', 'W' } };
		final int SIZE_OF_CUBE = twoDimensionalCube[0].length;
		
		Scanner scanner = new Scanner(System.in);
		PromptCube prompt = new PromptCube();
		PushTwoDimensionalCube pushCube = new PushTwoDimensionalCube();

		// �ʱⰪ ���
		prompt.printResult(twoDimensionalCube);

		while (true) {
			// ����� �Է�
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();
			StringBuffer inputSplit = new StringBuffer(input);
			// ���� �ߴ� ����
			if(input.equals("Q")) break;
			
			// String input�� �� ���ڿ� ���� ��ȸ
			// ��������ǥ�� �ִ� ���, ���� ����ǥ ���� ������ ���� ���� ����
			// �Ϲ� ����(��������ǥ�� ����)�� ���, ���� ���ڿ� ���� ����ǥ�� ���ٸ� ���� ���� ������ ���� ���� ����
			// ���鹮�� �������� String[]�� ��ɾ� �Ҵ�
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

			// ������ ��� ����
			for (String inputDir : splitStringArray) {
				// ��� ���� �޼ҵ�
				pushCube.getPushedCube(twoDimensionalCube, inputDir, SIZE_OF_CUBE);

				// ���: ������ ��� �� ��ɿ� ���� �����
				System.out.println("  " + inputDir);
				prompt.printResult(twoDimensionalCube);
			}
		}
		scanner.close();
		System.out.println("  Bye~");

	}

}
