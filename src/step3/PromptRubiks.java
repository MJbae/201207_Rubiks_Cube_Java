package step3;

import step2.*;
import java.util.Scanner;

public class PromptRubiks {
	// �޼ҵ�: Rubiks Cube ��ü ���
	public void printResult(char[][][] threeDimensionalCube) {

		final int LENGTH_OF_CUBE = threeDimensionalCube[0][0].length;

		// frontCube ���
		for (char[] oneDimensionalCube : threeDimensionalCube[0]) {
			System.out.print("                  ");
			for (char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");

		for (int i = 0; i < LENGTH_OF_CUBE; i++) {
			System.out.print("  ");

			// rightCube ���
			for (char elementOfCube : threeDimensionalCube[1][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");

			// upCube ���
			for (char elementOfCube : threeDimensionalCube[2][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");

			// backCube ���
			for (char elementOfCube : threeDimensionalCube[3][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");

			// leftCube ���
			for (char elementOfCube : threeDimensionalCube[4][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");

		// downCube ���
		for (char[] oneDimensionalCube : threeDimensionalCube[5]) {
			System.out.print("                  ");
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
			// ��������ǥ or '2' or '3'�� �ִ� ���, �ش� ���� ���� ������ ���� ���� ����
			if (input.charAt(i + 1) == 39 || input.charAt(i + 1) == 50 || input.charAt(i + 1) == 51) {
				indexOfSplit += 1;
				inputSplit.insert(indexOfSplit, " ");
				i++;
				indexOfSplit += 2;
				// �Ϲ� ������ ���, ���� ���ڿ� ���� ����ǥ�� ���ٸ� ���� ���� ������ ���� ���� ����
			} else {
				inputSplit.insert(indexOfSplit, " ");
				indexOfSplit += 2;
			}
		}

		return new String(inputSplit).split(" ");
	}

	public void executePrompt(char[][][] rubiksCube) {
		Scanner scanner = new Scanner(System.in);
		PromptCube prompt = new PromptCube();
		PushTwoDimensionalCube pushCube = new PushTwoDimensionalCube();

		// �ʱⰪ ���
		printResult(rubiksCube);

		while (true) {
			// ����� �Է�
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();
			// ���� �ߴ� ����
			if (input.equals("Q"))
				break;

			// inputSplit�� ���� ���鹮�� �������� �����Ͽ� ��� ��ɾ String array�� �Ҵ�
			String[] splitStringArray = splitInputString(input);
			for (String eachInput : splitStringArray)
				System.out.println("input test " + eachInput);
		}
		scanner.close();
	}

	public static void main(String[] args) {
		char[][] frontCube = { { 'G', 'G', 'G' }, { 'G', 'G', 'G' }, { 'G', 'G', 'G' } };
		char[][] rightCube = { { 'R', 'R', 'R' }, { 'R', 'R', 'R' }, { 'R', 'R', 'R' } };
		char[][] upCube = { { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, { 'W', 'W', 'W' } };
		char[][] backCube = { { 'B', 'B', 'B' }, { 'B', 'B', 'B' }, { 'B', 'B', 'B' } };
		char[][] leftCube = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		char[][] downCube = { { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' } };

		char[][][] rubiksCube = { frontCube, rightCube, upCube, backCube, leftCube, downCube };

		PromptRubiks prompt = new PromptRubiks();

		prompt.executePrompt(rubiksCube);

	}

}
