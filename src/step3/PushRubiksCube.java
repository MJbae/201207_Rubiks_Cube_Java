package step3;

import step1.PushOutWords;
import step2.*;

public class PushRubiksCube {

	private static final int BACK_SIDE = 0;
	private static final int UP_SIDE = 1;
	private static final int LEFT_SIDE = 2;
	private static final int DOWN_SIDE = 3;
	private static final int RIGHT_SIDE = 4;
	private static final int FRONT_SIDE = 5;

	public char[][][] getFrontClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
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
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[UP_SIDE][0];
		tempCube[2] = rubiksCube[RIGHT_SIDE][0];
		tempCube[3] = rubiksCube[DOWN_SIDE][0];

		// left �������� -> down ��������
		// down �������� -> right ��������
		// right �������� -> up ��������
		// up �������� -> left ��������
		rubiksCube[DOWN_SIDE][0] = tempCube[0];
		rubiksCube[LEFT_SIDE][0] = tempCube[1];
		rubiksCube[RIGHT_SIDE][0] = tempCube[3];
		rubiksCube[UP_SIDE][0] = tempCube[2];

		return rubiksCube;
	}

	public char[][][] getBackCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube�� �� side Cube�� ������ ���� �Ҵ���
		tempCube[0] = rubiksCube[LEFT_SIDE][0];
		tempCube[1] = rubiksCube[UP_SIDE][0];
		tempCube[2] = rubiksCube[RIGHT_SIDE][0];
		tempCube[3] = rubiksCube[DOWN_SIDE][0];

		// left �������� -> up ��������
		// up �������� -> right ��������
		// right �������� -> down ��������
		// down �������� -> left ��������
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

	public char[][][] getRotatedRightLeft(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		switch (inputDir) {
		// right-side Cube �ð���� ȸ��
		case "R":
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			break;
		case "R2":
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			break;
		// right-side Cube �ݽð���� ȸ��
		case "R'":
			rubiksCube = getRightCounterClockwise(rubiksCube, tempCube);
			break;
		case "L":
			break;
		case "L2":
			break;
		case "L'":
			break;
		default:
			break;
		}

		return rubiksCube;
	}

	public char[][][] getRotatedFrontBack(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		switch (inputDir) {
		// font-side Cube �ð���� ȸ��
		case "F":
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			break;
		case "F2":
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			break;
		// font-side Cube �ݽð���� ȸ��
		case "F'":
			rubiksCube = getFrontCounterClockwise(rubiksCube, tempCube);
			break;
		case "B":
			rubiksCube = getBackClockwise(rubiksCube, tempCube);
			break;
		case "B2":
			rubiksCube = getBackClockwise(rubiksCube, tempCube);
			rubiksCube = getBackClockwise(rubiksCube, tempCube);
			break;
		case "B'":
			rubiksCube = getBackCounterClockwise(rubiksCube, tempCube);
			break;
		default:
			break;
		}

		return rubiksCube;
	}

	public char[][][] getRotatedUpDown(char[][][] rubiksCube, char[][] tempCube, String inputDir) {
		switch (inputDir) {
		// Up-side Cube �ð���� ȸ��
		case "U":
			break;
		case "U'":
			break;
		case "U2":
			break;
		case "D":
			break;
		case "D'":
			break;
		case "D2":
			break;
		default:
			break;
		}

		return rubiksCube;
	}

	public char[][][] getPushedRubiks(char[][][] rubiksCube, String inputDir) {
		char[][] tempCube = new char[4][3];

		if (inputDir.contains("R") || inputDir.contains("L")) {
			rubiksCube = getRotatedRightLeft(rubiksCube, tempCube, inputDir);
		} else if (inputDir.contains("F") || inputDir.contains("B")) {
			rubiksCube = getRotatedFrontBack(rubiksCube, tempCube, inputDir);
		} else if(inputDir.contains("U") || inputDir.contains("D")) {
			rubiksCube = getRotatedUpDown(rubiksCube, tempCube, inputDir);
		}

		return rubiksCube;
	}
}
