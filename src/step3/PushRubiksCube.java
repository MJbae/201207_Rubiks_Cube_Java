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

	// 메소드: 사용자 입력값 중 주요 키워드의 포함여부를 기준으로 세부 호출메소드 호출
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

	// 메소드: Up/Down Side의 Cube의 구체적인 회전동작을 기준으로 특정 메소드 호출
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
		// tempCube에 각 side Cube의 첫번째행을 할당함
		for (int i = 0; i < sidesOfRotation.length; i++)
			tempCube[i] = rubiksCube[sidesOfRotation[i]][indexOfColumn];

		// Upside 시계방향으로 회전
		if (inputDir.equals("U") || inputDir.equals("D'")) {
			int[] UpsideOfRotation = { BACK_SIDE, FRONT_SIDE, RIGHT_SIDE, LEFT_SIDE };

			for (int i = 0; i < UpsideOfRotation.length; i++)
				rubiksCube[UpsideOfRotation[i]][indexOfColumn] = tempCube[i];

			// Upside 반시계방향으로 회전
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

		// tempCube에 각 side Cube의 마지막행을 할당함
		for (int i = 0; i < sidesOfRotation.length; i++)
			tempCube[i] = rubiksCube[sidesOfRotation[i]][indexOfColumn];

		// Upside 시계방향으로 회전
		if (inputDir.equals("F") || inputDir.equals("B'")) {
			int[] UpsideOfRotation = { UP_SIDE, RIGHT_SIDE, DOWN_SIDE, LEFT_SIDE };

			for (int i = 0; i < UpsideOfRotation.length; i++)
				rubiksCube[UpsideOfRotation[i]][indexOfColumn] = tempCube[i];

			// Upside 반시계방향으로 회전
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

		// tempCube에 각 side Cube의 마지막 열을 할당함
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
