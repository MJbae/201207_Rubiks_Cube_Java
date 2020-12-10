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

	// �޼ҵ�: ����� �Է°� �� �ֿ� Ű������ ���Կ��θ� �������� ���� ȣ��޼ҵ� ȣ��
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

	// �޼ҵ�: Up/Down Side�� Cube�� ��ü���� ȸ�������� �������� Ư�� �޼ҵ� ȣ��
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

		// tempCube�� �� side Cube�� ù��°���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[RIGHT_SIDE][0];
		tempCube[2] = rubiksCube[BACK_SIDE][0];
		tempCube[3] = rubiksCube[FRONT_SIDE][0];

		if (inputDir.equals("U")) {
			// front ù��°�� -> left ù��°��
			// left ù��°�� -> back ù��°��
			// back ù��°�� -> right ù��°��
			// right ù��°�� -> front ù��°��
			rubiksCube[LEFT_SIDE][0] = tempCube[3];
			rubiksCube[RIGHT_SIDE][0] = tempCube[2];
			rubiksCube[BACK_SIDE][0] = tempCube[0];
			rubiksCube[FRONT_SIDE][0] = tempCube[1];
		} else if (inputDir.equals("U'")) {
			// front ù��°�� -> right ù��°��
			// right ù��°�� -> back ù��°��
			// back ù��°�� -> left ù��°��
			// left ù��°�� -> front ù��°��
			rubiksCube[LEFT_SIDE][0] = tempCube[2];
			rubiksCube[RIGHT_SIDE][0] = tempCube[3];
			rubiksCube[BACK_SIDE][0] = tempCube[1];
			rubiksCube[FRONT_SIDE][0] = tempCube[0];
		}

		return rubiksCube;
	}

	public char[][][] getDownsideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube�� �� side Cube�� �������� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[RIGHT_SIDE][2];
		tempCube[2] = rubiksCube[BACK_SIDE][2];
		tempCube[3] = rubiksCube[FRONT_SIDE][2];

		if (inputDir.equals("D")) {
			// front �������� -> right ��������
			// right �������� -> back ��������
			// back �������� -> left ��������
			// left �������� -> front ��������
			rubiksCube[LEFT_SIDE][2] = tempCube[2];
			rubiksCube[RIGHT_SIDE][2] = tempCube[3];
			rubiksCube[BACK_SIDE][2] = tempCube[1];
			rubiksCube[FRONT_SIDE][2] = tempCube[0];
		} else if (inputDir.equals("D'")) {
			// front �������� -> right ��������
			// right �������� -> back ��������
			// back �������� -> left ��������
			// left �������� -> front ��������
			rubiksCube[LEFT_SIDE][2] = tempCube[3];
			rubiksCube[RIGHT_SIDE][2] = tempCube[2];
			rubiksCube[BACK_SIDE][2] = tempCube[0];
			rubiksCube[FRONT_SIDE][2] = tempCube[1];
		}

		return rubiksCube;
	}

	public char[][][] getFrontsideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube�� �� side Cube�� ���������� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[UP_SIDE][2];
		tempCube[2] = rubiksCube[RIGHT_SIDE][2];
		tempCube[3] = rubiksCube[DOWN_SIDE][2];

		if (inputDir.equals("F")) {
			// left �������� -> up ��������
			// up �������� -> right ��������
			// right �������� -> down ��������
			// down �������� -> left ��������
			rubiksCube[UP_SIDE][2] = tempCube[0];
			rubiksCube[RIGHT_SIDE][2] = tempCube[1];
			rubiksCube[DOWN_SIDE][2] = tempCube[2];
			rubiksCube[LEFT_SIDE][2] = tempCube[3];

		} else if (inputDir.equals("F'")) {
			// left �������� -> down ��������
			// down �������� -> right ��������
			// right �������� -> up ��������
			// up �������� -> left ��������
			rubiksCube[DOWN_SIDE][2] = tempCube[0];
			rubiksCube[LEFT_SIDE][2] = tempCube[1];
			rubiksCube[UP_SIDE][2] = tempCube[2];
			rubiksCube[RIGHT_SIDE][2] = tempCube[3];
		}

		return rubiksCube;
	}

	public char[][][] getBacksideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube�� �� side Cube�� ù��°���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[UP_SIDE][0];
		tempCube[2] = rubiksCube[RIGHT_SIDE][0];
		tempCube[3] = rubiksCube[DOWN_SIDE][0];

		if (inputDir.equals("B")) {
			// left ù��°�� -> down ù��°��
			// down ù��°�� -> right ù��°��
			// right ù��°�� -> up ù��°��
			// up ù��°�� -> left ù��°��
			rubiksCube[DOWN_SIDE][0] = tempCube[0];
			rubiksCube[LEFT_SIDE][0] = tempCube[1];
			rubiksCube[RIGHT_SIDE][0] = tempCube[3];
			rubiksCube[UP_SIDE][0] = tempCube[2];
		} else if (inputDir.equals("B'")) {
			// left ù��°�� -> up ù��°��
			// up ù��°�� -> right ù��°��
			// right ù��°�� -> down ù��°��
			// down ù��°�� -> left ù��°��
			rubiksCube[UP_SIDE][0] = tempCube[0];
			rubiksCube[RIGHT_SIDE][0] = tempCube[1];
			rubiksCube[DOWN_SIDE][0] = tempCube[2];
			rubiksCube[LEFT_SIDE][0] = tempCube[3];
		}

		return rubiksCube;
	}

	public char[][][] getRightsideRotated(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		for (int i = 0; i < 3; i++)
			tempCube[0][i] = rubiksCube[FRONT_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[1][i] = rubiksCube[UP_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[2][i] = rubiksCube[BACK_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[3][i] = rubiksCube[DOWN_SIDE][i][2];

		if (inputDir.equals("R")) {
			// front �������� -> up ������ ��
			// up �������� -> back ������ ��
			// back �������� -> down ������ ��
			// down �������� -> front ������ ��
			for (int i = 0; i < 3; i++)
				rubiksCube[UP_SIDE][i][2] = tempCube[0][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[BACK_SIDE][i][2] = tempCube[1][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[DOWN_SIDE][i][2] = tempCube[2][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[FRONT_SIDE][i][2] = tempCube[3][i];
		} else if (inputDir.equals("R'")) {
			// front �������� -> down ��������
			// down ������ �� -> back ������ ��
			// back �������� -> up ��������
			// up ������ �� -> front ������ ��
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
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		for (int i = 0; i < 3; i++)
			tempCube[0][i] = rubiksCube[FRONT_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[1][i] = rubiksCube[UP_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[2][i] = rubiksCube[BACK_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[3][i] = rubiksCube[DOWN_SIDE][i][0];

		if (inputDir.equals("L")) {
			// front �������� -> down ������ ��
			// up �������� -> front ������ ��
			// back �������� -> up ������ ��
			// down �������� -> back ������ ��
			for (int i = 0; i < 3; i++)
				rubiksCube[UP_SIDE][i][0] = tempCube[2][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[BACK_SIDE][i][0] = tempCube[3][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[DOWN_SIDE][i][0] = tempCube[0][i];
			for (int i = 0; i < 3; i++)
				rubiksCube[FRONT_SIDE][i][0] = tempCube[1][i];
		} else if (inputDir.equals("L'")) {
			// front �������� -> up ������ ��
			// up �������� -> back ������ ��
			// back �������� -> down ������ ��
			// down �������� -> front ������ ��
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
