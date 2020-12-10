package step3;

public class PushRubiksCube {

	public static final int BACK_SIDE = 0;
	public static final int UP_SIDE = 1;
	public static final int LEFT_SIDE = 2;
	public static final int DOWN_SIDE = 3;
	public static final int RIGHT_SIDE = 4;
	public static final int FRONT_SIDE = 5;

	public static final int INDEX_OF_LAST = 2;
	public static final int INDEX_OF_FIRST = 0;

	public static final int LENGTH_OF_ROW = 3;
	public static final int LENGTH_OF_COLUMN = 3;

	public static final int NUM_OF_ROTATION = 4;

	// �޼ҵ�: ����� �Է°� �� �ֿ� Ű������ ���Կ��θ� �������� ���� ȣ��޼ҵ� ȣ��
	public char[][][] getPushedRubiks(char[][][] rubiksCube, String inputDir) {
		char[][] tempCube = new char[NUM_OF_ROTATION][LENGTH_OF_ROW];

		if (inputDir.contains("2")) {
			return rubiksCube = getDoubleRotated(rubiksCube, tempCube, inputDir);

		} else if (inputDir.contains("R")) {
			return rubiksCube = getRightLeftRotated(rubiksCube, tempCube, inputDir);

		} else if (inputDir.contains("L")) {
			return rubiksCube = getRightLeftRotated(rubiksCube, tempCube, inputDir);

		} else if (inputDir.contains("F") || inputDir.contains("B")) {
			return rubiksCube = getFrontBackRotated(rubiksCube, tempCube, inputDir);

		} else if (inputDir.contains("U") || inputDir.contains("D")) {
			return rubiksCube = getUpDownRotated(rubiksCube, tempCube, inputDir);

		} else {
			return rubiksCube;
		}
	}

	// �޼ҵ�: Up/Down Side�� Cube�� ��ü���� ȸ�������� �������� Ư�� �޼ҵ� ȣ��
	public char[][][] getDoubleRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		switch (inputDir) {
		case "U2":
			rubiksCube = getUpDownRotated(rubiksCube, tempCube, "U");
			return rubiksCube = getUpDownRotated(rubiksCube, tempCube, "U");
		case "D2":
			rubiksCube = getUpDownRotated(rubiksCube, tempCube, "D");
			return rubiksCube = getUpDownRotated(rubiksCube, tempCube, "D");
		case "L2":
			rubiksCube = getRightLeftRotated(rubiksCube, tempCube, "L");
			return rubiksCube = getRightLeftRotated(rubiksCube, tempCube, "L");
		case "R2":
			rubiksCube = getRightLeftRotated(rubiksCube, tempCube, "R");
			return rubiksCube = getRightLeftRotated(rubiksCube, tempCube, "R");
		case "F2":
			rubiksCube = getFrontBackRotated(rubiksCube, tempCube, "F");
			return rubiksCube = getFrontBackRotated(rubiksCube, tempCube, "F");
		case "B2":
			rubiksCube = getFrontBackRotated(rubiksCube, tempCube, "B");
			return rubiksCube = getFrontBackRotated(rubiksCube, tempCube, "B");
		default:
			return rubiksCube;
		}
	}

	public char[][][] getUpDownRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {

		int[] sidesOfRotation = { LEFT_SIDE, RIGHT_SIDE, BACK_SIDE, FRONT_SIDE };

		int indexOfColumn = (inputDir.equals("U") || inputDir.equals("U'")) ? INDEX_OF_FIRST : INDEX_OF_LAST;
		// tempCube�� �� side Cube�� ù��°���� �Ҵ���
		for (int i = 0; i < sidesOfRotation.length; i++)
			tempCube[i] = rubiksCube[sidesOfRotation[i]][indexOfColumn];

		// Upside �ð�������� ȸ��
		if (inputDir.equals("U") || inputDir.equals("D'")) {
			int[] UpsideOfRotation = { BACK_SIDE, FRONT_SIDE, RIGHT_SIDE, LEFT_SIDE };

			for (int i = 0; i < UpsideOfRotation.length; i++)
				rubiksCube[UpsideOfRotation[i]][indexOfColumn] = tempCube[i];

			// Upside �ݽð�������� ȸ��
		} else if (inputDir.equals("U'") || inputDir.equals("D")) {
			int[] UpsideOfCounterRotation = { FRONT_SIDE, BACK_SIDE, LEFT_SIDE, RIGHT_SIDE };

			for (int i = 0; i < UpsideOfCounterRotation.length; i++)
				rubiksCube[UpsideOfCounterRotation[i]][indexOfColumn] = tempCube[i];
		}

		return rubiksCube;
	}

	public char[][][] getFrontBackRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {

		int[] sidesOfRotation = { LEFT_SIDE, UP_SIDE, RIGHT_SIDE, DOWN_SIDE };

		int indexOfColumn = (inputDir.equals("F") || inputDir.equals("F'")) ? INDEX_OF_LAST : INDEX_OF_FIRST;

		// tempCube�� �� side Cube�� ���������� �Ҵ���
		for (int i = 0; i < sidesOfRotation.length; i++)
			tempCube[i] = rubiksCube[sidesOfRotation[i]][indexOfColumn];

		// Upside �ð�������� ȸ��
		if (inputDir.equals("F") || inputDir.equals("B'")) {
			int[] UpsideOfRotation = { UP_SIDE, RIGHT_SIDE, DOWN_SIDE, LEFT_SIDE };

			for (int i = 0; i < UpsideOfRotation.length; i++)
				rubiksCube[UpsideOfRotation[i]][indexOfColumn] = tempCube[i];

			// Upside �ݽð�������� ȸ��
		} else if (inputDir.equals("F'") || inputDir.equals("B")) {
			int[] UpsideOfCounterRotation = { DOWN_SIDE, LEFT_SIDE, UP_SIDE, RIGHT_SIDE };

			for (int i = 0; i < UpsideOfCounterRotation.length; i++)
				rubiksCube[UpsideOfCounterRotation[i]][indexOfColumn] = tempCube[i];
		}

		return rubiksCube;
	}

	public char[][][] getRightLeftRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		int[] sidesOfRotation = { FRONT_SIDE, UP_SIDE, BACK_SIDE, DOWN_SIDE };

		int indexOfColumn = (inputDir.equals("R") || inputDir.equals("R'")) ? INDEX_OF_LAST : INDEX_OF_FIRST;

		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++)
				tempCube[j][i] = rubiksCube[sidesOfRotation[j]][i][indexOfColumn];
		}

		if (inputDir.equals("R") || inputDir.equals("L'")) {
			int[] UpsideOfRotation = { UP_SIDE, BACK_SIDE, DOWN_SIDE, FRONT_SIDE };
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 3; i++)
					rubiksCube[UpsideOfRotation[j]][i][indexOfColumn] = tempCube[j][i];
			}
		} else if (inputDir.equals("R'") || inputDir.equals("L")) {
			int[] UpsideOfCounterRotation = { DOWN_SIDE, FRONT_SIDE, UP_SIDE, BACK_SIDE };
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 3; i++)
					rubiksCube[UpsideOfCounterRotation[j]][i][indexOfColumn] = tempCube[j][i];
			}
		}

		return rubiksCube;
	}
}
