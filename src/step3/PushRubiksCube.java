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

	// TODO: �ڹٿ��� �޼ҵ带 �Ű������� �����ϴ� ��� �н� �� R,R',L,L' �ߺ��ڵ� �����ϱ�
	public char[][][] getPushedRubiks(char[][][] rubiksCube, String inputDir) {

		PushOutWords pushWords = new PushOutWords();
		PromptCube promptCube = new PromptCube();
		char[][] tempCube = new char[4][3];

		switch (inputDir) {
		// 1. font-side Cube �ð���� ȸ��
		// a. left �������� -> up ��������
		// b. up �������� -> right ��������
		// c. right �������� -> down ��������
		// d. down �������� -> left ��������
		case "F":
			// tempCube�� �� side Cube�� ������ ���� �Ҵ���
			tempCube[0] = rubiksCube[LEFT_SIDE][2];
			tempCube[1] = rubiksCube[UP_SIDE][2];
			tempCube[2] = rubiksCube[RIGHT_SIDE][2];
			tempCube[3] = rubiksCube[DOWN_SIDE][2];

			// pushWords �޼ҵ� Ȱ���ؼ� ���� ������ ���� �̵�
			// ������� ���� ���� ���� ����
			rubiksCube[LEFT_SIDE][2] = tempCube[3];
			rubiksCube[UP_SIDE][2] = tempCube[0];
			rubiksCube[RIGHT_SIDE][2] = tempCube[1];
			rubiksCube[DOWN_SIDE][2] = tempCube[2];
			

			break;
		case "F2":
			break;
		// 2. font-side Cube �ݽð���� ȸ��
		// a. left �������� -> down ��������
		// b. down �������� -> right ��������
		// c. right �������� -> up ��������
		// d. up �������� -> left ��������
		case "F'":
			break;
		// 3. right-side Cube �ð���� ȸ��
		// a. front �������� -> up ������ ��
		// b. up �������� -> back ������ ��
		// c. back �������� -> down ������ ��
		// d. down �������� -> front ������ ��
		case "R":
			break;
		case "R2":
			break;
		// 4. right-side Cube �ݽð���� ȸ��
		// a. front �������� -> down ��������
		// b. down ������ �� -> back ������ ��
		// c. back �������� -> up ��������
		// d. up ������ �� -> front ������ ��
		case "R'":
			break;
		case "U":
			break;
		case "U2":
			break;
		case "U'":
			break;
		case "B":
			break;
		case "B2":
			break;
		case "B'":
			break;
		case "L":
			break;
		case "L2":
			break;
		case "L'":
			break;
		case "D":
			break;
		case "D2":
			break;
		case "D'":
			break;
		default:
			break;
		}

		return rubiksCube;
	}
}
