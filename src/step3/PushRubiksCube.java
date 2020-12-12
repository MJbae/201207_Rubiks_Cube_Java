package step3;

public class PushRubiksCube {

	// 주요 상수 정의
	public static final int BACK_SIDE = 0;
	public static final int UP_SIDE = 1;
	public static final int LEFT_SIDE = 2;
	public static final int DOWN_SIDE = 3;
	public static final int RIGHT_SIDE = 4;
	public static final int FRONT_SIDE = 5;

	private static final int INDEX_OF_LAST = 2;
	private static final int INDEX_OF_FIRST = 0;

	private static final int LENGTH_OF_ROW_COLUMN = 3;

	private static final int NUM_OF_ROTATION = 4;

	// 메소드: 사용자 입력값 중 주요 키워드의 포함여부를 기준으로 세부 메소드 호출
	public char[][][] getPushedRubiks(char[][][] rubiksCube, String inputDir) {
		char[][] tempCube = new char[NUM_OF_ROTATION][LENGTH_OF_ROW_COLUMN];

		if (inputDir.contains("2")) {
			return rubiksCube = getDoubleRotated(rubiksCube, tempCube, inputDir);

		} else if (inputDir.contains("R") || inputDir.contains("L")) {
			return rubiksCube = getRightLeftRotated(rubiksCube, tempCube, inputDir);

		} else if (inputDir.contains("F") || inputDir.contains("B")) {
			return rubiksCube = getFrontBackRotated(rubiksCube, tempCube, inputDir);

		} else if (inputDir.contains("U") || inputDir.contains("D")) {
			return rubiksCube = getUpDownRotated(rubiksCube, tempCube, inputDir);

		} else {
			return rubiksCube;
		}
	}

	// 메소드: 두번 회전하는 경우, 특정 메소드를 두 번 실행
	public char[][][] getDoubleRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {

		if (inputDir.equals("R2") || inputDir.equals("L2")) {
			rubiksCube = getRightLeftRotated(rubiksCube, tempCube, inputDir.substring(0, 1));
			return rubiksCube = getRightLeftRotated(rubiksCube, tempCube, inputDir.substring(0, 1));

		} else if (inputDir.equals("F2") || inputDir.equals("B2")) {
			rubiksCube = getFrontBackRotated(rubiksCube, tempCube, inputDir.substring(0, 1));
			return rubiksCube = getFrontBackRotated(rubiksCube, tempCube, inputDir.substring(0, 1));

		} else if (inputDir.equals("U2") || inputDir.equals("D2")) {
			rubiksCube = getUpDownRotated(rubiksCube, tempCube, inputDir.substring(0, 1));
			return rubiksCube = getUpDownRotated(rubiksCube, tempCube, inputDir.substring(0, 1));

		} else {
			return rubiksCube;
		}
	}

	// 메소드: Up or Down side 회전
	public char[][][] getUpDownRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {

		int[] sidesOfRotation = { LEFT_SIDE, RIGHT_SIDE, BACK_SIDE, FRONT_SIDE };

		int indexOfColumn = (inputDir.equals("U") || inputDir.equals("U'")) ? INDEX_OF_FIRST : INDEX_OF_LAST;
		// tempCube에 각 side Cube의 첫번째행을 할당함
		for (int i = 0; i < sidesOfRotation.length; i++)
			tempCube[i] = rubiksCube[sidesOfRotation[i]][indexOfColumn];

		// Up side 시계방향으로 회전 or Down side 반시계방향 회전
		if (inputDir.equals("U") || inputDir.equals("D'")) {
			int[] UpsideOfRotation = { BACK_SIDE, FRONT_SIDE, RIGHT_SIDE, LEFT_SIDE };

			for (int i = 0; i < UpsideOfRotation.length; i++)
				rubiksCube[UpsideOfRotation[i]][indexOfColumn] = tempCube[i];

		// Up side 반시계방향으로 회전 or Down side 시계방향 회전
		} else if (inputDir.equals("U'") || inputDir.equals("D")) {
			int[] UpsideOfCounterRotation = { FRONT_SIDE, BACK_SIDE, LEFT_SIDE, RIGHT_SIDE };

			for (int i = 0; i < UpsideOfCounterRotation.length; i++)
				rubiksCube[UpsideOfCounterRotation[i]][indexOfColumn] = tempCube[i];
		}

		return rubiksCube;
	}
	
	// 메소드: Front or Back side 회전
	public char[][][] getFrontBackRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {

		int[] sidesOfRotation = { LEFT_SIDE, UP_SIDE, RIGHT_SIDE, DOWN_SIDE };

		int indexOfColumn = (inputDir.equals("F") || inputDir.equals("F'")) ? INDEX_OF_LAST : INDEX_OF_FIRST;

		// tempCube에 각 side Cube의 마지막행 또는 첫번째행을 할당함
		for (int i = 0; i < sidesOfRotation.length; i++)
			tempCube[i] = rubiksCube[sidesOfRotation[i]][indexOfColumn];

		// Front side 시계방향으로 회전 or Back side 반시계방향으로 회전
		if (inputDir.equals("F") || inputDir.equals("B'")) {
			int[] UpsideOfRotation = { UP_SIDE, RIGHT_SIDE, DOWN_SIDE, LEFT_SIDE };

			for (int i = 0; i < UpsideOfRotation.length; i++)
				rubiksCube[UpsideOfRotation[i]][indexOfColumn] = tempCube[i];

		// Front side 반시계방향으로 회전 or Back side 시계방향으로 회전
		} else if (inputDir.equals("F'") || inputDir.equals("B")) {
			int[] UpsideOfCounterRotation = { DOWN_SIDE, LEFT_SIDE, UP_SIDE, RIGHT_SIDE };

			for (int i = 0; i < UpsideOfCounterRotation.length; i++)
				rubiksCube[UpsideOfCounterRotation[i]][indexOfColumn] = tempCube[i];
		}

		return rubiksCube;
	}
	
	// 메소드: Right or Left side 회전
	public char[][][] getRightLeftRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		int[] sidesOfRotation = { FRONT_SIDE, UP_SIDE, BACK_SIDE, DOWN_SIDE };

		int indexOfColumn = (inputDir.equals("R") || inputDir.equals("R'")) ? INDEX_OF_LAST : INDEX_OF_FIRST;

		// tempCube에 각 side Cube의 마지막열 또는 첫번째열을 할당함
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++)
				tempCube[j][i] = rubiksCube[sidesOfRotation[j]][i][indexOfColumn];
		}
		
		// Right side 시계방향으로 회전 or Left side 반시계방향으로 회전
		if (inputDir.equals("R") || inputDir.equals("L'")) {
			int[] UpsideOfRotation = { UP_SIDE, BACK_SIDE, DOWN_SIDE, FRONT_SIDE };
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 3; i++)
					rubiksCube[UpsideOfRotation[j]][i][indexOfColumn] = tempCube[j][i];
			}
		// Right side 반시계방향으로 회전 or Left side 시계방향으로 회전
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