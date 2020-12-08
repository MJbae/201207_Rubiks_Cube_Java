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

		// ���: �ʱⰪ ���
		prompt.printResult(twoDimensionalCube);

		while (true) {

			// �Է�: ex) UUR
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();
			if(input.equals("Q")) break;
			
			String[] inputSplit = input.split("");

			System.out.println("");

			for (String inputDir : inputSplit) {
				// �ݺ�: ������ ��� ����
				// ��� ���� ����
				pushCube.getPushedCube(twoDimensionalCube, inputDir, SIZE_OF_CUBE);

				// ���: ������ ���
				// ���: ����� ������ �����
				System.out.println("  " + inputDir);
				prompt.printResult(twoDimensionalCube);
			}
		}
		scanner.close();
		System.out.println("  Bye~");

	}

}
