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
		// tempCube에 각 side Cube의 마지막 행을 할당함
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[UP_SIDE][2];
		tempCube[2] = rubiksCube[RIGHT_SIDE][2];
		tempCube[3] = rubiksCube[DOWN_SIDE][2];

		// left 마지막행 -> up 마지막행
		// up 마지막행 -> right 마지막행
		// right 마지막행 -> down 마지막행
		// down 마지막행 -> left 마지막행
		rubiksCube[LEFT_SIDE][2] = tempCube[3];
		rubiksCube[UP_SIDE][2] = tempCube[0];
		rubiksCube[RIGHT_SIDE][2] = tempCube[1];
		rubiksCube[DOWN_SIDE][2] = tempCube[2];

		return rubiksCube;
	}

	public char[][][] getFrontCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube에 각 side Cube의 마지막 행을 할당함
		tempCube[0] = rubiksCube[LEFT_SIDE][2];
		tempCube[1] = rubiksCube[UP_SIDE][2];
		tempCube[2] = rubiksCube[RIGHT_SIDE][2];
		tempCube[3] = rubiksCube[DOWN_SIDE][2];

		// left 마지막행 -> down 마지막행
		// down 마지막행 -> right 마지막행
		// right 마지막행 -> up 마지막행
		// up 마지막행 -> left 마지막행
		rubiksCube[DOWN_SIDE][2] = tempCube[0];
		rubiksCube[RIGHT_SIDE][2] = tempCube[3];
		rubiksCube[UP_SIDE][2] = tempCube[2];
		rubiksCube[LEFT_SIDE][2] = tempCube[1];
		return rubiksCube;
	}

	public char[][][] getRightClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube에 각 side Cube의 마지막 열을 할당함
		for(int i = 0; i < 3; i++) tempCube[0][i] = rubiksCube[FRONT_SIDE][i][2];
		for(int i = 0; i < 3; i++) tempCube[1][i] = rubiksCube[UP_SIDE][i][2];
		for(int i = 0; i < 3; i++) tempCube[2][i] = rubiksCube[BACK_SIDE][i][2];
		for(int i = 0; i < 3; i++) tempCube[3][i] = rubiksCube[DOWN_SIDE][i][2];

		// front 마지막열 -> up 마지막 열
		// up 마지막열 -> back 마지막 열
		// back 마지막열 -> down 마지막 열
		// down 마지막열 -> front 마지막 열
		for(int i = 0; i < 3; i++) rubiksCube[UP_SIDE][i][2] = tempCube[0][i];
		for(int i = 0; i < 3; i++) rubiksCube[BACK_SIDE][i][2] = tempCube[1][i];
		for(int i = 0; i < 3; i++) rubiksCube[DOWN_SIDE][i][2] = tempCube[2][i];
		for(int i = 0; i < 3; i++) rubiksCube[FRONT_SIDE][i][2] = tempCube[3][i];

		return rubiksCube;
	}

	public char[][][] getRightCounterClockwise(char[][][] rubiksCube, char[][] tempCube) {
		// tempCube에 각 side Cube의 마지막 열을 할당함
		for(int i = 0; i < 3; i++) tempCube[0][i] = rubiksCube[FRONT_SIDE][i][2];
		for(int i = 0; i < 3; i++) tempCube[1][i] = rubiksCube[UP_SIDE][i][2];
		for(int i = 0; i < 3; i++) tempCube[2][i] = rubiksCube[BACK_SIDE][i][2];
		for(int i = 0; i < 3; i++) tempCube[3][i] = rubiksCube[DOWN_SIDE][i][2];

		// front 마지막열 -> down 마지막열
		// down 마지막 열 -> back 마지막 열
		// back 마지막열 -> up 마지막열
		// up 마지막 열 -> front 마지막 열
		for(int i = 0; i < 3; i++) rubiksCube[DOWN_SIDE][i][2] = tempCube[0][i];
		for(int i = 0; i < 3; i++) rubiksCube[BACK_SIDE][i][2] = tempCube[3][i];
		for(int i = 0; i < 3; i++) rubiksCube[UP_SIDE][i][2] = tempCube[2][i];
		for(int i = 0; i < 3; i++) rubiksCube[FRONT_SIDE][i][2] = tempCube[1][i];
		
		return rubiksCube;
	}

	// TODO: 자바에서 메소드를 매개변수로 전달하는 방법 학습 후 R,R',L,L' 중복코드 제거하기
	public char[][][] getPushedRubiks(char[][][] rubiksCube, String inputDir) {
		char[][] tempCube = new char[4][3];

		switch (inputDir) {
		// font-side Cube 시계방향 회전
		case "F":
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			break;
		case "F2":
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			rubiksCube = getFrontClockwise(rubiksCube, tempCube);
			break;
		// font-side Cube 반시계방향 회전
		case "F'":
			rubiksCube = getFrontCounterClockwise(rubiksCube, tempCube);
			break;
		// right-side Cube 시계방향 회전
		case "R":
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			break;
		case "R2":
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			rubiksCube = getRightClockwise(rubiksCube, tempCube);
			break;
		// right-side Cube 반시계방향 회전
		case "R'":
			rubiksCube = getRightCounterClockwise(rubiksCube, tempCube);
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
