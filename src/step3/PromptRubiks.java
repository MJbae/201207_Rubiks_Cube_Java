package step3;

import java.util.Scanner;

public class PromptRubiks {
	public static int numOfRotation = 0;

	// �޼ҵ�: Rubiks Cube ��ü ���
	public void printResult(char[][][] threeDimensionalCube) {
		int BACK_SIDE = PushRubiksCube.BACK_SIDE;
		int UP_SIDE = PushRubiksCube.UP_SIDE;
		int LEFT_SIDE = PushRubiksCube.LEFT_SIDE;
		int DOWN_SIDE = PushRubiksCube.DOWN_SIDE;
		int RIGHT_SIDE = PushRubiksCube.RIGHT_SIDE;
		int FRONT_SIDE = PushRubiksCube.FRONT_SIDE;

		final int LENGTH_OF_CUBE = threeDimensionalCube[BACK_SIDE][0].length;

		// back side cube ���
		for (char[] oneDimensionalCube : threeDimensionalCube[BACK_SIDE]) {
			System.out.print("                  ");
			for (char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");

		for (int i = 0; i < LENGTH_OF_CUBE; i++) {
			System.out.print("  ");

			// up side cube ���
			for (char elementOfCube : threeDimensionalCube[UP_SIDE][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");

			// left side cube ���
			for (char elementOfCube : threeDimensionalCube[LEFT_SIDE][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");

			// down side cube ���
			for (char elementOfCube : threeDimensionalCube[DOWN_SIDE][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.print("  ");

			// right side cube ���
			for (char elementOfCube : threeDimensionalCube[RIGHT_SIDE][i]) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");

		// front side cube ���
		for (char[] oneDimensionalCube : threeDimensionalCube[FRONT_SIDE]) {
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

	// �޼ҵ�: ���� ���� ī��Ʈ
	public void countRotation(String input) {
		if (input.contains("2")) {
			numOfRotation += 2;
		} else if (input.contains("3")) {
			numOfRotation += 3;
		} else {
			numOfRotation += 1;
		}
	}

	public boolean isValidInput(String input) {
		boolean isValid = false;

		String[] validInputs = { "R", "R'", "L", "L'", "U", "U'", "D", "D'", "F", "F'", "B", "B'", "R2", "L2", "U2",
				"D2", "F2", "B2" };

		for (String eachInput : validInputs) {
			if (input.equals(eachInput)) {
				isValid = true;
				break;
			}
		}

		return isValid;
	}

	public char[][][] runRotation(char[][][] rubiksCube, String[] splitStringArray, int numOfRotation) {

		PushRubiksCube pushRubiks = new PushRubiksCube();

		for (String inputDir : splitStringArray) {
			// �� �Է°��� ��ȿ�� üũ
			if (!isValidInput(inputDir)) {
				System.out.println("  " + inputDir + ": ��ȿ���� ���� �Է°��Դϴ�");
				break;
			}

			// �Է°��� ī����
			countRotation(inputDir);

			System.out.println("");
			System.out.println("  " + inputDir);

			// ��ȿ �Է¿� ���� Rubiks Cube ȸ��
			rubiksCube = pushRubiks.getPushedRubiks(rubiksCube, inputDir);

			printResult(rubiksCube);
		}

		return rubiksCube;
	}

	// �޼ҵ�: ����� �Է°� �ް� ����� ���
	public void executePrompt(char[][][] rubiksCube) {
		Scanner scanner = new Scanner(System.in);
		
		// �ʱⰪ ���
		printResult(rubiksCube);

		while (true) {
			// ����� �Է�
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();

			// ���� �ߴ�
			if (input.equals("Q"))
				break;

			// �Է°��� �����Ͽ� String array�� �Ҵ�
			String[] splitStringArray = splitInputString(input);
			
			// ������ �Է¿� ���� �ݺ�����
			rubiksCube = runRotation(rubiksCube, splitStringArray, numOfRotation);

		}
		// ���۰��� ���
		System.out.println("  ���۰���: " + numOfRotation);
		System.out.println("  ��~ ");
		scanner.close();
	}

	public static void main(String[] args) {
		char[][] frontCube = { { 'G', 'G', 'G' }, { 'G', 'G', 'G' }, { 'G', 'G', 'G' } };
		char[][] upCube = { { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, { 'W', 'W', 'W' } };
		char[][] leftCube = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		char[][] downCube = { { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' } };
		char[][] rightCube = { { 'R', 'R', 'R' }, { 'R', 'R', 'R' }, { 'R', 'R', 'R' } };
		char[][] backCube = { { 'B', 'B', 'B' }, { 'B', 'B', 'B' }, { 'B', 'B', 'B' } };

		char[][][] rubiksCube = { backCube, upCube, leftCube, downCube, rightCube, frontCube };

		PromptRubiks prompt = new PromptRubiks();

		prompt.executePrompt(rubiksCube);

	}

}
