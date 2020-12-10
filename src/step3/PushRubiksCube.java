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

		if (inputDir.contains("R") || inputDir.contains("L")) {
			rubiksCube = getRotatedRightLeft(rubiksCube, tempCube, inputDir);
		} else if (inputDir.contains("F") || inputDir.contains("B")) {
			rubiksCube = getRotatedFrontBack(rubiksCube, tempCube, inputDir);
		} else if (inputDir.contains("U") || inputDir.contains("D")) {
			rubiksCube = getRotatedUpDown(rubiksCube, tempCube, inputDir);
		}

		return rubiksCube;
	}

	// �޼ҵ�: Right/Left Side�� Cube�� ��ü���� ȸ�������� �������� Ư�� �޼ҵ� ȣ��
	public char[][][] getRotatedRightLeft(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		switch (inputDir) {
		// right-side Cube �ð���� ȸ��
		case "R":
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			break;
		// right-side Cube �ݽð���� ȸ��
		case "R'":
			rubiksCube = getRightCounterClockwise(rubiksCube, tempCube);
			break;
		case "L":
			rubiksCube = getLeftClockwise(rubiksCube, tempCube);
			break;
		case "L'":
			rubiksCube = getLeftCounterClockwise(rubiksCube, tempCube);
			break;
		case "R2":
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			break;
		case "L2":
			rubiksCube = getLeftClockwise(rubiksCube, tempCube);
			rubiksCube = getLeftClockwise(rubiksCube, tempCube);
			break;
		default:
			break;
		}

		return rubiksCube;
	}

	// �޼ҵ�: Front/Back Side�� Cube�� ��ü���� ȸ�������� �������� Ư�� �޼ҵ� ȣ��
	public char[][][] getRotatedFrontBack(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		switch (inputDir) {
		// font-side Cube �ð���� ȸ��
		case "F":
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			break;
		// font-side Cube �ݽð���� ȸ��
		case "F'":
			rubiksCube = getFrontCounterClockwise(rubiksCube, tempCube);
			break;
		case "B":
			rubiksCube = getBackClockwise(rubiksCube, tempCube);
			break;
		case "B'":
			rubiksCube = getBackCounterClockwise(rubiksCube, tempCube);
			break;
		case "F2":
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			break;
		case "B2":
			rubiksCube = getBackClockwise(rubiksCube, tempCube);
			rubiksCube = getBackClockwise(rubiksCube, tempCube);
			break;
		default:
			break;
		}

		return rubiksCube;
	}

	// �޼ҵ�: Up/Down Side�� Cube�� ��ü���� ȸ�������� �������� Ư�� �޼ҵ� ȣ��
	public char[][][] getRotatedUpDown(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		switch (inputDir) {
		// Up-side Cube �ð���� ȸ��
		case "U":
			rubiksCube = getUpClockwise(rubiksCube, tempCube);
			break;
		case "U'":
			rubiksCube = getUpCounterClockwise(rubiksCube, tempCube);
			break;
		case "D":
			rubiksCube = getDownClockwise(rubiksCube, tempCube);
			break;
		case "D'":
			rubiksCube = getDownCounterClockwise(rubiksCube, tempCube);
			break;
		case "U2":
			rubiksCube = getUpClockwise(rubiksCube, tempCube);
			rubiksCube = getUpClockwise(rubiksCube, tempCube);
			break;
		case "D2":
			rubiksCube = getDownClockwise(rubiksCube, tempCube);
			rubiksCube = getDownClockwise(rubiksCube, tempCube);
			break;
		default:
			break;
		}

		return rubiksCube;
	}

	public char[][][] getUpClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ù��°���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[RIGHT_SIDE][0];
		tempCube[2] = rubiksCube[BACK_SIDE][0];
		tempCube[3] = rubiksCube[FRONT_SIDE][0];

		// front ù��°�� -> left ù��°��
		// left ù��°�� -> back ù��°��
		// back ù��°�� -> right ù��°��
		// right ù��°�� -> front ù��°��
		rubiksCube[LEFT_SIDE][0] = tempCube[3];
		rubiksCube[RIGHT_SIDE][0] = tempCube[2];
		rubiksCube[BACK_SIDE][0] = tempCube[0];
		rubiksCube[FRONT_SIDE][0] = tempCube[1];

		return rubiksCube;
	}

	public char[][][] getUpCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ù��°���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[RIGHT_SIDE][0];
		tempCube[2] = rubiksCube[BACK_SIDE][0];
		tempCube[3] = rubiksCube[FRONT_SIDE][0];

		// front ù��°�� -> right ù��°��
		// right ù��°�� -> back ù��°��
		// back ù��°�� -> left ù��°��
		// left ù��°�� -> front ù��°��
		rubiksCube[LEFT_SIDE][0] = tempCube[2];
		rubiksCube[RIGHT_SIDE][0] = tempCube[3];
		rubiksCube[BACK_SIDE][0] = tempCube[1];
		rubiksCube[FRONT_SIDE][0] = tempCube[0];

		return rubiksCube;
	}

	public char[][][] getDownCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ���������� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[RIGHT_SIDE][2];
		tempCube[2] = rubiksCube[BACK_SIDE][2];
		tempCube[3] = rubiksCube[FRONT_SIDE][2];

		// front �������� -> left ��������
		// left �������� -> back ��������
		// back �������� -> right ��������
		// right �������� -> front ��������
		rubiksCube[LEFT_SIDE][2] = tempCube[3];
		rubiksCube[RIGHT_SIDE][2] = tempCube[2];
		rubiksCube[BACK_SIDE][2] = tempCube[0];
		rubiksCube[FRONT_SIDE][2] = tempCube[1];

		return rubiksCube;
	}

	public char[][][] getDownClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� �������� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[RIGHT_SIDE][2];
		tempCube[2] = rubiksCube[BACK_SIDE][2];
		tempCube[3] = rubiksCube[FRONT_SIDE][2];

		// front �������� -> right ��������
		// right �������� -> back ��������
		// back �������� -> left ��������
		// left �������� -> front ��������
		rubiksCube[LEFT_SIDE][2] = tempCube[2];
		rubiksCube[RIGHT_SIDE][2] = tempCube[3];
		rubiksCube[BACK_SIDE][2] = tempCube[1];
		rubiksCube[FRONT_SIDE][2] = tempCube[0];

		return rubiksCube;
	}

	public char[][][] getFrontClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ���������� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[UP_SIDE][2];
		tempCube[2] = rubiksCube[RIGHT_SIDE][2];
		tempCube[3] = rubiksCube[DOWN_SIDE][2];

		// left �������� -> up ��������
		// up �������� -> right ��������
		// right �������� -> down ��������
		// down �������� -> left ��������
		rubiksCube[UP_SIDE][2] = tempCube[0];
		rubiksCube[RIGHT_SIDE][2] = tempCube[1];
		rubiksCube[DOWN_SIDE][2] = tempCube[2];
		rubiksCube[LEFT_SIDE][2] = tempCube[3];

		return rubiksCube;
	}

	public char[][][] getFrontCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[UP_SIDE][2];
		tempCube[2] = rubiksCube[RIGHT_SIDE][2];
		tempCube[3] = rubiksCube[DOWN_SIDE][2];

		// left �������� -> down ��������
		// down �������� -> right ��������
		// right �������� -> up ��������
		// up �������� -> left ��������
		rubiksCube[DOWN_SIDE][2] = tempCube[0];
		rubiksCube[LEFT_SIDE][2] = tempCube[1];
		rubiksCube[UP_SIDE][2] = tempCube[2];
		rubiksCube[RIGHT_SIDE][2] = tempCube[3];
		return rubiksCube;
	}

	public char[][][] getBackClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ù��°���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[UP_SIDE][0];
		tempCube[2] = rubiksCube[RIGHT_SIDE][0];
		tempCube[3] = rubiksCube[DOWN_SIDE][0];

		// left ù��°�� -> down ù��°��
		// down ù��°�� -> right ù��°��
		// right ù��°�� -> up ù��°��
		// up ù��°�� -> left ù��°��
		rubiksCube[DOWN_SIDE][0] = tempCube[0];
		rubiksCube[LEFT_SIDE][0] = tempCube[1];
		rubiksCube[RIGHT_SIDE][0] = tempCube[3];
		rubiksCube[UP_SIDE][0] = tempCube[2];

		return rubiksCube;
	}

	public char[][][] getBackCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ù��°���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[UP_SIDE][0];
		tempCube[2] = rubiksCube[RIGHT_SIDE][0];
		tempCube[3] = rubiksCube[DOWN_SIDE][0];

		// left ù��°�� -> up ù��°��
		// up ù��°�� -> right ù��°��
		// right ù��°�� -> down ù��°��
		// down ù��°�� -> left ù��°��
		rubiksCube[UP_SIDE][0] = tempCube[0];
		rubiksCube[RIGHT_SIDE][0] = tempCube[1];
		rubiksCube[DOWN_SIDE][0] = tempCube[2];
		rubiksCube[LEFT_SIDE][0] = tempCube[3];

		return rubiksCube;
	}

	public char[][][] getRightClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		for (int i = 0; i < 3; i++)
			tempCube[0][i] = rubiksCube[FRONT_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[1][i] = rubiksCube[UP_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[2][i] = rubiksCube[BACK_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[3][i] = rubiksCube[DOWN_SIDE][i][2];

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

		return rubiksCube;
	}

	public char[][][] getRightCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		for (int i = 0; i < 3; i++)
			tempCube[0][i] = rubiksCube[FRONT_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[1][i] = rubiksCube[UP_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[2][i] = rubiksCube[BACK_SIDE][i][2];
		for (int i = 0; i < 3; i++)
			tempCube[3][i] = rubiksCube[DOWN_SIDE][i][2];

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

		return rubiksCube;
	}

	public char[][][] getLeftClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		for (int i = 0; i < 3; i++)
			tempCube[0][i] = rubiksCube[FRONT_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[1][i] = rubiksCube[UP_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[2][i] = rubiksCube[BACK_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[3][i] = rubiksCube[DOWN_SIDE][i][0];

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

		return rubiksCube;
	}

	public char[][][] getLeftCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		for (int i = 0; i < 3; i++)
			tempCube[0][i] = rubiksCube[FRONT_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[1][i] = rubiksCube[UP_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[2][i] = rubiksCube[BACK_SIDE][i][0];
		for (int i = 0; i < 3; i++)
			tempCube[3][i] = rubiksCube[DOWN_SIDE][i][0];

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

		return rubiksCube;
	}
}
