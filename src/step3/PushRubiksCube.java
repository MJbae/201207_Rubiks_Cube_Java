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

	// TODO: 자바에서 메소드를 매개변수로 전달하는 방법 학습 후 R,R',L,L' 중복코드 제거하기
	public char[][][] getPushedRubiks(char[][][] rubiksCube, String inputDir) {

		PushOutWords pushWords = new PushOutWords();
		PromptCube promptCube = new PromptCube();
		char[][] tempCube = new char[4][3];

		switch (inputDir) {
		// 1. font-side Cube 시계방향 회전
		// a. left 마지막행 -> up 마지막행
		// b. up 마지막행 -> right 마지막행
		// c. right 마지막행 -> down 마지막행
		// d. down 마지막행 -> left 마지막행
		case "F":
			// tempCube에 각 side Cube의 마지막 행을 할당함
			tempCube[0] = rubiksCube[LEFT_SIDE][2];
			tempCube[1] = rubiksCube[UP_SIDE][2];
			tempCube[2] = rubiksCube[RIGHT_SIDE][2];
			tempCube[3] = rubiksCube[DOWN_SIDE][2];

			// pushWords 메소드 활용해서 위의 로직에 따라 이동
			// 결과물에 대해 기존 값에 삽입
			rubiksCube[LEFT_SIDE][2] = tempCube[3];
			rubiksCube[UP_SIDE][2] = tempCube[0];
			rubiksCube[RIGHT_SIDE][2] = tempCube[1];
			rubiksCube[DOWN_SIDE][2] = tempCube[2];
			

			break;
		case "F2":
			break;
		// 2. font-side Cube 반시계방향 회전
		// a. left 마지막행 -> down 마지막행
		// b. down 마지막행 -> right 마지막행
		// c. right 마지막행 -> up 마지막행
		// d. up 마지막행 -> left 마지막행
		case "F'":
			break;
		// 3. right-side Cube 시계방향 회전
		// a. front 마지막열 -> up 마지막 열
		// b. up 마지막열 -> back 마지막 열
		// c. back 마지막열 -> down 마지막 열
		// d. down 마지막열 -> front 마지막 열
		case "R":
			break;
		case "R2":
			break;
		// 4. right-side Cube 반시계방향 회전
		// a. front 마지막열 -> down 마지막열
		// b. down 마지막 열 -> back 마지막 열
		// c. back 마지막열 -> up 마지막열
		// d. up 마지막 열 -> front 마지막 열
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
