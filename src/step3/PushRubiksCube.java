package step3;

public class PushRubiksCube {

	public static final int BACK_SIDE = 0;
	public static final int UP_SIDE = 1;
	public static final int LEFT_SIDE = 2;
	public static final int DOWN_SIDE = 3;
	public static final int RIGHT_SIDE = 4;
	public static final int FRONT_SIDE = 5;
	public static final int NUM_OF_ROTATION = 4;
	public static final int LENGTH_OF_ROW = 3;

	// 메소드: 사용자 입력값 중 주요 키워드의 포함여부를 기준으로 세부 호출메소드 호출
	public char[][][] getPushedRubiks(char[][][] rubiksCube, String inputDir) {
		char[][] tempCube = new char[NUM_OF_ROTATION][LENGTH_OF_ROW];

		if (inputDir.contains("2")) {
			return rubiksCube = getDoubleRotated(rubiksCube, tempCube, inputDir);
		} else if (inputDir.contains("R")) {
			return rubiksCube = (inputDir.equals("R")) ? getRightsideRotated(rubiksCube, tempCube, "R")
					: getRightsideRotated(rubiksCube, tempCube, "R'");

		} else if (inputDir.contains("L")) {
			return rubiksCube = (inputDir.equals("L")) ? getLeftsideRotated(rubiksCube, tempCube, "L")
					: getLeftsideRotated(rubiksCube, tempCube, "L'");

		} else if (inputDir.contains("F")) {
			return rubiksCube = (inputDir.equals("F")) ? getFrontsideRotated(rubiksCube, tempCube, "F")
					: getFrontsideRotated(rubiksCube, tempCube, "F'");

		} else if (inputDir.contains("B")) {
			return rubiksCube = (inputDir.equals("B")) ? getBacksideRotated(rubiksCube, tempCube, "B")
					: getBacksideRotated(rubiksCube, tempCube, "B'");

		} else if (inputDir.contains("U")) {
			return rubiksCube = (inputDir.equals("U")) ? getUpsideRotated(rubiksCube, tempCube, "U")
					: getUpsideRotated(rubiksCube, tempCube, "U'");

		} else if (inputDir.contains("D")) {
			return rubiksCube = (inputDir.equals("D")) ? getDownsideRotated(rubiksCube, tempCube, "D")
					: getDownsideRotated(rubiksCube, tempCube, "D'");
		} else {
			return rubiksCube;
		}
	}

	// 메소드: Up/Down Side의 Cube의 구체적인 회전동작을 기준으로 특정 메소드 호출
	public char[][][] getDoubleRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		switch (inputDir) {
		case "U2":
			rubiksCube = getUpsideRotated(rubiksCube, tempCube, "U");
			return rubiksCube = getUpsideRotated(rubiksCube, tempCube, "U");
		case "D2":
			rubiksCube = getDownsideRotated(rubiksCube, tempCube, "D");
			return rubiksCube = getDownsideRotated(rubiksCube, tempCube, "D");
		case "L2":
			rubiksCube = getLeftsideRotated(rubiksCube, tempCube, "L");
			return rubiksCube = getLeftsideRotated(rubiksCube, tempCube, "L");
		case "R2":
			rubiksCube = getRightsideRotated(rubiksCube, tempCube, "R");
			return rubiksCube = getRightsideRotated(rubiksCube, tempCube, "R");
		case "F2":
			rubiksCube = getFrontsideRotated(rubiksCube, tempCube, "F");
			return rubiksCube = getFrontsideRotated(rubiksCube, tempCube, "F");
		case "B2":
			rubiksCube = getBacksideRotated(rubiksCube, tempCube, "B");
			return rubiksCube = getBacksideRotated(rubiksCube, tempCube, "B");
		default:
			return rubiksCube;
		}
	}

	public char[][][] getUpsideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {

		// tempCube에 각 side Cube의 첫번째행을 할당함
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[RIGHT_SIDE][0];
		tempCube[2] = rubiksCube[BACK_SIDE][0];
		tempCube[3] = rubiksCube[FRONT_SIDE][0];

		if (inputDir.equals("U")) {
			// front 첫번째행 -> left 첫번째행
			// left 첫번째행 -> back 첫번째행
			// back 첫번째행 -> right 첫번째행
			// right 첫번째행 -> front 첫번째행
			rubiksCube[LEFT_SIDE][0] = tempCube[3];
			rubiksCube[RIGHT_SIDE][0] = tempCube[2];
			rubiksCube[BACK_SIDE][0] = tempCube[0];
			rubiksCube[FRONT_SIDE][0] = tempCube[1];
		} else if (inputDir.equals("U'")) {
			// front 첫번째행 -> right 첫번째행
			// right 첫번째행 -> back 첫번째행
			// back 첫번째행 -> left 첫번째행
			// left 첫번째행 -> front 첫번째행
			rubiksCube[LEFT_SIDE][0] = tempCube[2];
			rubiksCube[RIGHT_SIDE][0] = tempCube[3];
			rubiksCube[BACK_SIDE][0] = tempCube[1];
			rubiksCube[FRONT_SIDE][0] = tempCube[0];
		}

		return rubiksCube;
	}

	public char[][][] getDownsideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube에 각 side Cube의 마지막행 할당함
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[RIGHT_SIDE][2];
		tempCube[2] = rubiksCube[BACK_SIDE][2];
		tempCube[3] = rubiksCube[FRONT_SIDE][2];

		if (inputDir.equals("D")) {
			// front 마지막행 -> right 마지막행
			// right 마지막행 -> back 마지막행
			// back 마지막행 -> left 마지막행
			// left 마지막행 -> front 마지막행
			rubiksCube[LEFT_SIDE][2] = tempCube[2];
			rubiksCube[RIGHT_SIDE][2] = tempCube[3];
			rubiksCube[BACK_SIDE][2] = tempCube[1];
			rubiksCube[FRONT_SIDE][2] = tempCube[0];
		} else if (inputDir.equals("D'")) {
			// front 마지막행 -> right 마지막행
			// right 마지막행 -> back 마지막행
			// back 마지막행 -> left 마지막행
			// left 마지막행 -> front 마지막행
			rubiksCube[LEFT_SIDE][2] = tempCube[3];
			rubiksCube[RIGHT_SIDE][2] = tempCube[2];
			rubiksCube[BACK_SIDE][2] = tempCube[0];
			rubiksCube[FRONT_SIDE][2] = tempCube[1];
		}

		return rubiksCube;
	}

	public char[][][] getFrontsideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube에 각 side Cube의 마지막행을 할당함
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[UP_SIDE][2];
		tempCube[2] = rubiksCube[RIGHT_SIDE][2];
		tempCube[3] = rubiksCube[DOWN_SIDE][2];

		if (inputDir.equals("F")) {
			// left 마지막행 -> up 마지막행
			// up 마지막행 -> right 마지막행
			// right 마지막행 -> down 마지막행
			// down 마지막행 -> left 마지막행
			rubiksCube[UP_SIDE][2] = tempCube[0];
			rubiksCube[RIGHT_SIDE][2] = tempCube[1];
			rubiksCube[DOWN_SIDE][2] = tempCube[2];
			rubiksCube[LEFT_SIDE][2] = tempCube[3];

		} else if (inputDir.equals("F'")) {
			// left 마지막행 -> down 마지막행
			// down 마지막행 -> right 마지막행
			// right 마지막행 -> up 마지막행
			// up 마지막행 -> left 마지막행
			rubiksCube[DOWN_SIDE][2] = tempCube[0];
			rubiksCube[LEFT_SIDE][2] = tempCube[1];
			rubiksCube[UP_SIDE][2] = tempCube[2];
			rubiksCube[RIGHT_SIDE][2] = tempCube[3];
		}

		return rubiksCube;
	}

	public char[][][] getBacksideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube에 각 side Cube의 첫번째행을 할당함
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[UP_SIDE][0];
		tempCube[2] = rubiksCube[RIGHT_SIDE][0];
		tempCube[3] = rubiksCube[DOWN_SIDE][0];

		if (inputDir.equals("B")) {
			// left 첫번째행 -> down 첫번째행
			// down 첫번째행 -> right 첫번째행
			// right 첫번째행 -> up 첫번째행
			// up 첫번째행 -> left 첫번째행
			rubiksCube[DOWN_SIDE][0] = tempCube[0];
			rubiksCube[LEFT_SIDE][0] = tempCube[1];
			rubiksCube[RIGHT_SIDE][0] = tempCube[3];
			rubiksCube[UP_SIDE][0] = tempCube[2];
		} else if (inputDir.equals("B'")) {
			// left 첫번째행 -> up 첫번째행
			// up 첫번째행 -> right 첫번째행
			// right 첫번째행 -> down 첫번째행
			// down 첫번째행 -> left 첫번째행
			rubiksCube[UP_SIDE][0] = tempCube[0];
			rubiksCube[RIGHT_SIDE][0] = tempCube[1];
			rubiksCube[DOWN_SIDE][0] = tempCube[2];
			rubiksCube[LEFT_SIDE][0] = tempCube[3];
		}

		return rubiksCube;
	}

	public char[][][] getRightsideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube에 각 side Cube의 마지막 열을 할당함
		for (int i = 0; i < 3; i++)
			tempCube[0][i] = rubiksCube[FRONT_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[1][i] = rubiksCube[UP_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[2][i] = rubiksCube[BACK_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[3][i] = rubiksCube[DOWN_SIDE][i][2];

		if (inputDir.equals("R")) {
			// front 마지막열 -> up 마지막 열
			// up 마지막열 -> back 마지막 열
			// back 마지막열 -> down 마지막 열
			// down 마지막열 -> front 마지막 열
			for (int i = 0; i < 3; i++)
				rubiksCube[UP_SIDE][i][2] = tempCube[0][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[BACK_SIDE][i][2] = tempCube[1][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[DOWN_SIDE][i][2] = tempCube[2][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[FRONT_SIDE][i][2] = tempCube[3][i];
		} else if (inputDir.equals("R'")) {
			// front 마지막열 -> down 마지막열
			// down 마지막 열 -> back 마지막 열
			// back 마지막열 -> up 마지막열
			// up 마지막 열 -> front 마지막 열
			for (int i = 0; i < 3; i++)
				rubiksCube[DOWN_SIDE][i][2] = tempCube[0][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[BACK_SIDE][i][2] = tempCube[3][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[UP_SIDE][i][2] = tempCube[2][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[FRONT_SIDE][i][2] = tempCube[1][i];
		}

		return rubiksCube;
	}

	public char[][][] getLeftsideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube에 각 side Cube의 마지막 열을 할당함
		for (int i = 0; i < 3; i++)
			tempCube[0][i] = rubiksCube[FRONT_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[1][i] = rubiksCube[UP_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[2][i] = rubiksCube[BACK_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[3][i] = rubiksCube[DOWN_SIDE][i][0];

		if (inputDir.equals("L")) {
			// front 마지막열 -> down 마지막 열
			// up 마지막열 -> front 마지막 열
			// back 마지막열 -> up 마지막 열
			// down 마지막열 -> back 마지막 열
			for (int i = 0; i < 3; i++)
				rubiksCube[UP_SIDE][i][0] = tempCube[2][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[BACK_SIDE][i][0] = tempCube[3][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[DOWN_SIDE][i][0] = tempCube[0][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[FRONT_SIDE][i][0] = tempCube[1][i];
		} else if (inputDir.equals("L'")) {
			// front 마지막열 -> up 마지막 열
			// up 마지막열 -> back 마지막 열
			// back 마지막열 -> down 마지막 열
			// down 마지막열 -> front 마지막 열
			for (int i = 0; i < 3; i++)
				rubiksCube[UP_SIDE][i][0] = tempCube[0][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[BACK_SIDE][i][0] = tempCube[1][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[DOWN_SIDE][i][0] = tempCube[2][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[FRONT_SIDE][i][0] = tempCube[3][i];
		}

		return rubiksCube;
	}
}
